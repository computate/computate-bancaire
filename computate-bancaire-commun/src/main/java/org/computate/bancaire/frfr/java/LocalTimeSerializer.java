package org.computate.bancaire.frfr.java;

import java.io.IOException;
import java.time.LocalTime;

import org.computate.bancaire.frfr.page.MiseEnPage;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class LocalTimeSerializer extends JsonSerializer<LocalTime> {

	/**
	 * r: MiseEnPage
	 * r.enUS: PageLayout
	 * r: FORMATHeureAffichage
	 * r.enUS: FORMATTimeDisplay
	 */
	@Override
	public void serialize(LocalTime o, JsonGenerator generator, SerializerProvider provider) throws IOException {
		generator.writeString(MiseEnPage.FORMATHeureAffichage.format(o));
	}
}
