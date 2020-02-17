package mortageplan.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import mortageplan.Constants;

public class FileUtil {
	public List<String> readFile() {
		ClassLoader classLoader = getClass().getClassLoader();
		List<String> lines = new ArrayList<>();
		try (InputStream inputStream = classLoader.getResourceAsStream(Constants.RESOURCE_FILENAME);
				BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream,
						Charset.forName(StandardCharsets.UTF_8.name())))) {
			String line;
			while ((line = reader.readLine()) != null) {
				lines.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lines;
	}
}
