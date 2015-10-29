package com.email.server.mail;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.email.server.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class UrlResourceTest {

	@Test
	public void testGetInputStream() throws IOException {
		// given
		Object expected = "Test file";
		URL url = new URL(
				"http://www.****.az.pl/mtx/test/test_file.txt");
		UrlResource urlResource = new UrlResource(url);
		// when
		InputStream inputStream = urlResource.getInputStream();
		BufferedReader in = new BufferedReader(new InputStreamReader(
				inputStream));
		String inputLine;
		while ((inputLine = in.readLine()) != null)
			System.out.println(inputLine);
		String actual = toString();
		in.close();
		// than
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testGetFile() throws IOException {
		// given
		UrlResource urlResource = new UrlResource(
				"http://www.****.az.pl/mtx/test/test_file.txt");
		// when
		File file = new File("/resources/newfile.txt");
		if (file.createNewFile()) {
			System.out.println("File is created!");
		} else {
			System.out.println("File already exists.");
		}
		file = urlResource.getFile();
		// than
		Assert.assertNotNull(file);
	}

	@Ignore
	@Test
	public void testGetFileForLastModifiedCheck() {
	}

}
