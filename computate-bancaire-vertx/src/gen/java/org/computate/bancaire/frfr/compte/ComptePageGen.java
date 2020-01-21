package org.computate.bancaire.frfr.compte;

import org.computate.bancaire.frfr.requete.patch.RequetePatch;
import org.computate.bancaire.frfr.cluster.Cluster;
import java.math.MathContext;
import org.apache.commons.text.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.computate.bancaire.frfr.requete.RequeteSiteFrFR;
import java.text.NumberFormat;
import java.util.Objects;
import io.vertx.core.json.JsonArray;
import org.computate.bancaire.frfr.couverture.Couverture;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.math.NumberUtils;
import java.util.Optional;
import org.computate.bancaire.frfr.ecrivain.ToutEcrivain;
import org.computate.bancaire.frfr.compte.CompteGenPage;

/**	
 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.compte.ComptePage&fq=classeEtendGen_indexed_boolean:true">Trouver la classe  dans Solr</a>
 * <br/>
 **/
public abstract class ComptePageGen<DEV> extends CompteGenPage {

	//////////////
	// initLoin //
	//////////////

	protected boolean dejaInitialiseComptePage = false;

	public ComptePage initLoinComptePage(RequeteSiteFrFR requeteSite_) {
		setRequeteSite_(requeteSite_);
		if(!dejaInitialiseComptePage) {
			dejaInitialiseComptePage = true;
			initLoinComptePage();
		}
		return (ComptePage)this;
	}

	public void initLoinComptePage() {
		initComptePage();
		super.initLoinCompteGenPage(requeteSite_);
	}

	public void initComptePage() {
	}

	@Override public void initLoinPourClasse(RequeteSiteFrFR requeteSite_) {
		initLoinComptePage(requeteSite_);
	}

	/////////////////
	// requeteSite //
	/////////////////

	public void requeteSiteComptePage(RequeteSiteFrFR requeteSite_) {
			super.requeteSiteCompteGenPage(requeteSite_);
	}

	public void requeteSitePourClasse(RequeteSiteFrFR requeteSite_) {
		requeteSiteComptePage(requeteSite_);
	}

	/////////////
	// obtenir //
	/////////////

	@Override public Object obtenirPourClasse(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtenirComptePage(v);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.obtenirPourClasse(v);
			}
		}
		return o;
	}
	public Object obtenirComptePage(String var) {
		ComptePage oComptePage = (ComptePage)this;
		switch(var) {
			default:
				return super.obtenirCompteGenPage(var);
		}
	}

	///////////////
	// attribuer //
	///////////////

	@Override public boolean attribuerPourClasse(String var, Object val) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = attribuerComptePage(v, val);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.attribuerPourClasse(v, val);
			}
		}
		return o != null;
	}
	public Object attribuerComptePage(String var, Object val) {
		ComptePage oComptePage = (ComptePage)this;
		switch(var) {
			default:
				return super.attribuerCompteGenPage(var, val);
		}
	}

	/////////////
	// definir //
	/////////////

	@Override public boolean definirPourClasse(String var, String val) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		if(val != null) {
			for(String v : vars) {
				if(o == null)
					o = definirComptePage(v, val);
				else if(o instanceof Cluster) {
					Cluster cluster = (Cluster)o;
					o = cluster.definirPourClasse(v, val);
				}
			}
		}
		return o != null;
	}
	public Object definirComptePage(String var, String val) {
		switch(var) {
			default:
				return super.definirCompteGenPage(var, val);
		}
	}

	/////////////////
	// htmlScripts //
	/////////////////

	@Override public void htmlScripts() {
		htmlScriptsComptePage();
		super.htmlScripts();
	}

	public void htmlScriptsComptePage() {
	}

	////////////////
	// htmlScript //
	////////////////

	@Override public void htmlScript() {
		htmlScriptComptePage();
		super.htmlScript();
	}

	public void htmlScriptComptePage() {
	}

	//////////////
	// htmlBody //
	//////////////

	@Override public void htmlBody() {
		htmlBodyComptePage();
		super.htmlBody();
	}

	public void htmlBodyComptePage() {
	}

	//////////
	// html //
	//////////

	@Override public void html() {
		htmlComptePage();
		super.html();
	}

	public void htmlComptePage() {
	}

	//////////////
	// htmlMeta //
	//////////////

	@Override public void htmlMeta() {
		htmlMetaComptePage();
		super.htmlMeta();
	}

	public void htmlMetaComptePage() {
	}

	////////////////
	// htmlStyles //
	////////////////

	@Override public void htmlStyles() {
		htmlStylesComptePage();
		super.htmlStyles();
	}

	public void htmlStylesComptePage() {
	}

	///////////////
	// htmlStyle //
	///////////////

	@Override public void htmlStyle() {
		htmlStyleComptePage();
		super.htmlStyle();
	}

	public void htmlStyleComptePage() {
	}

	//////////////////
	// requetePatch //
	//////////////////

	public void requetePatchComptePage() {
		RequetePatch requetePatch = Optional.ofNullable(requeteSite_).map(RequeteSiteFrFR::getRequetePatch_).orElse(null);
		ComptePage original = (ComptePage)Optional.ofNullable(requetePatch).map(RequetePatch::getOriginal).orElse(null);
		if(original != null) {
			super.requetePatchCompteGenPage();
		}
	}

	//////////////
	// hashCode //
	//////////////

	@Override public int hashCode() {
		return Objects.hash(super.hashCode());
	}

	////////////
	// equals //
	////////////

	@Override public boolean equals(Object o) {
		if(this == o)
			return true;
		if(!(o instanceof ComptePage))
			return false;
		ComptePage that = (ComptePage)o;
		return super.equals(o);
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString() + "\n");
		sb.append("ComptePage { ");
		sb.append(" }");
		return sb.toString();
	}
}
