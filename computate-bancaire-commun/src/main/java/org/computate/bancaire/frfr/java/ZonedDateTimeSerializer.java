package org.computate.bancaire.frfr.java; 

import java.io.IOException;
import java.time.ZonedDateTime;

import org.computate.bancaire.frfr.page.MiseEnPage;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class ZonedDateTimeSerializer extends JsonSerializer<ZonedDateTime> {

	/**
	 * r: MiseEnPage
	 * r.enUS: PageLayout
	 * r: FORMATDateHeureZoneeAffichage
	 * r.enUS: FORMATZonedDateTimeDisplay
	 */
	@Override
	public void serialize(ZonedDateTime o, JsonGenerator generator, SerializerProvider provider) throws IOException {
		generator.writeString(MiseEnPage.FORMATDateHeureZoneeAffichage.format(o));
	}
}
