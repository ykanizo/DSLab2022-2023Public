import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;

@RunWith(Parameterized.class)
public class TimerTest {

	@Parameterized.Parameters
	public static Iterable<String> classNames() {
		try {
			Scanner scanner = new Scanner(new File("TimersClassesToTest.csv"));
			List<String> values = new ArrayList<String>();
			scanner.useDelimiter(",");
			while (scanner.hasNext()) {
				values.add(scanner.next());
			}
			return values;
		} catch (FileNotFoundException e) {
			return Arrays.asList("Timer");
		}
	}

	@Parameter
	public String timerClaseName;
	private Timer t;

	@Before
	public void setUp() throws Exception {
		t = (Timer) Class.forName(timerClaseName).newInstance();
	}
}
