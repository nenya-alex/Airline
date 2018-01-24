package ua.nenya.main;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InOrder;
import ua.nenya.consoleIO.ConsoleIO;
import ua.nenya.domain.Aircraft;
import ua.nenya.domain.AircraftType;
import ua.nenya.domain.Airline;
import ua.nenya.service.Service;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class ServiceTest {
	
	private Service service = new Service();
    private Airline airline = new Airline();
	private ConsoleIO mockIO;
    private BufferedReader mockBr;

	@Before
	public void init() {
        List<Aircraft> aircrafts = new ArrayList<>();

        aircrafts.add(new Aircraft(1000, 1000, 5000, 1000, new AircraftType("Airliner")));
        aircrafts.add(new Aircraft(2000, 2000, 4000, 2000, new AircraftType("Airliner")));
        aircrafts.add(new Aircraft(3000, 3000, 3000, 3000, new AircraftType("Cargo Aircraft")));
        aircrafts.add(new Aircraft(4000, 4000, 2000, 4000, new AircraftType("Cargo Aircraft")));
        aircrafts.add(new Aircraft(5000, 6000, 1000, 5000, new AircraftType("Cargo Aircraft")));

        airline.setAirCrafts(aircrafts);

		mockIO = mock(ConsoleIO.class);
        mockBr = mock(BufferedReader.class);
	}


	@Test
	public void isCommandEqualsRegexTest1() {
		assertThat(service.isCommandEqualsRegex("q", "^[q,S_Q]$"), is(true));
        assertThat(service.isCommandEqualsRegex("Q", "^[q,S_Q]$"), is(true));
        assertThat(service.isCommandEqualsRegex("a", "^[q,S_Q]$"), is(false));
	}

    @Test
    public void showCommandsTest() {
        service.showCommands(mockIO);

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mockIO, times(5)).writeln(captor.capture());
        assertEquals(
                "[Chose one command entering the number after command or quit., " +
                        "Calculate the total capacity and carrying capacity of all the aircraft in the airline: 1, " +
                        "Display the list of aircraft of the company sorted by flight range: 2, " +
                        "Find airplanes corresponding to a given range of fuel consumption parameters: 3, " +
                        "Quit: q]"
                , captor.getAllValues().toString());
    }

	@Test
	public void calculateTotalCapacityTest() {
		assertThat(service.calculateTotalCapacity(airline.getAirCrafts()), is(15000.0));
	}

	@Test
	public void showResultTest() {
        service.showResult(mockIO, "qwerty");

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mockIO, times(1)).writeln(captor.capture());
        assertEquals(
                "[qwerty]"
                , captor.getAllValues().toString());
	}

	@Test
	public void calculateCarryingCapacityTest() {
        assertThat(service.calculateCarryingCapacity(airline.getAirCrafts()), is(16000.0));
	}

	@Test
	public void showResultAircraftsListTest() {
        service.showResultAircraftsList(mockIO, airline.getAirCrafts());

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mockIO, times(5)).writeln(captor.capture());
        assertEquals(
                "[Aircraft{capacity=1000.0, carryingCapacity=1000.0, flightRange=5000.0, fuelConsumption=1000.0, aircraftType=Airliner}, " +
                        "Aircraft{capacity=2000.0, carryingCapacity=2000.0, flightRange=4000.0, fuelConsumption=2000.0, aircraftType=Airliner}, " +
                        "Aircraft{capacity=3000.0, carryingCapacity=3000.0, flightRange=3000.0, fuelConsumption=3000.0, aircraftType=Cargo Aircraft}, " +
                        "Aircraft{capacity=4000.0, carryingCapacity=4000.0, flightRange=2000.0, fuelConsumption=4000.0, aircraftType=Cargo Aircraft}, " +
                        "Aircraft{capacity=5000.0, carryingCapacity=6000.0, flightRange=1000.0, fuelConsumption=5000.0, aircraftType=Cargo Aircraft}]"
                , captor.getAllValues().toString());
	}

    @Test
    public void showResultAircraftsEmptyListTest() {
        service.showResultAircraftsList(mockIO, new ArrayList<>());

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mockIO, times(1)).writeln(captor.capture());
        assertEquals(
                "[Result is absent.]"
                , captor.getAllValues().toString());
    }

	@Test
	public void sortAircraftsByFlightRangeTest() {

        List<Aircraft> result = service.sortAircraftsByFlightRange(airline.getAirCrafts());

        assertThat(result.size(), is(airline.getAirCrafts().size()));

        assertThat(result.get(0), is(new Aircraft(5000, 6000, 1000, 5000, new AircraftType("Cargo Aircraft"))));
        assertThat(result.get(result.size()-1), is(new Aircraft(1000, 1000, 5000, 1000, new AircraftType("Airliner"))));
	}

	@Test
	public void findAircraftByFuelConsumptionShortTest() {
        when(mockIO.read(mockBr)).thenReturn("1000").thenReturn("3000");

        service.findAircraftByFuelConsumption(mockBr, mockIO, airline.getAirCrafts());

		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mockIO, times(2)).writeln(captor.capture());
        assertEquals(
                "[Enter starting fuel consumption amount., " +
                        "Enter finishing fuel consumption amount.]"
                , captor.getAllValues().toString());
	}

    @Test
    public void findAircraftByFuelConsumptionTest() {
        when(mockIO.read(mockBr)).thenReturn("5000").thenReturn("6000");

        List<Aircraft> result = service.findAircraftByFuelConsumption(mockBr, mockIO, airline.getAirCrafts());

        assertThat(result.size(), is(1));

        assertThat(result.get(0), is(new Aircraft(5000, 6000, 1000, 5000, new AircraftType("Cargo Aircraft"))));

    }

}
