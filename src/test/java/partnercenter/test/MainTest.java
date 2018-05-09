package partnercenter.test;

import static java.time.ZoneId.of;
import static java.time.ZoneId.systemDefault;
import static java.time.ZoneOffset.UTC;
import static java.time.ZoneOffset.ofHours;
import static org.junit.Assert.*;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.junit.Test;

public class MainTest {

	@Test
	public void test(){

		DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy MM dd HH:mm:ssX");
		ZonedDateTime utc = LocalDateTime.now(systemDefault()).atZone(ZoneId.of("UTC"));
		System.out.println(Instant.now().atZone(of("UTC")).format(f));
		System.out.println(utc);
		System.out.println(utc.format(f));
		System.out.println(LocalDateTime.now(systemDefault()).atZone(ZoneId.of("UTC")).format(f));
		System.out.println(ZonedDateTime.now(UTC).format(f));

		System.out.println(new Date().toInstant().atZone(systemDefault()).format(DateTimeFormatter.ISO_INSTANT));
		System.out.println(LocalDateTime.now().atZone(systemDefault()).format(DateTimeFormatter.ISO_INSTANT).replace("T", " "));
	}
}
