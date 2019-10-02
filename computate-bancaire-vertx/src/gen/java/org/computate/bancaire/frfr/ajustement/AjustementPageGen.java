package org.computate.bancaire.frfr.ajustement;

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
import org.computate.bancaire.frfr.ecrivain.ToutEcrivain;
import org.computate.bancaire.frfr.ajustement.AjustementGenPage;

/**	
 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.ajustement.AjustementPage&fq=classeEtendGen_indexed_boolean:true">Trouver la classe  dans Solr</a>
 * <br/>
 **/
public abstract class AjustementPageGen<DEV> extends AjustementGenPage {

	//////////////
	// initLoin //
	//////////////

	protected boolean dejaInitialiseAjustementPage = false;

	public AjustementPage initLoinAjustementPage(RequeteSiteFrFR requeteSite_) {
		setRequeteSite_(requeteSite_);
		if(!dejaInitialiseAjustementPage) {
			dejaInitialiseAjustementPage = true;
			initLoinAjustementPage();
		}
		return (AjustementPage)this;
	}

	public void initLoinAjustementPage() {
		super.initLoinAjustementGenPage(requeteSite_);
		initAjustementPage();
	}

	public void initAjustementPage() {
	}

	@Override public void initLoinPourClasse(RequeteSiteFrFR requeteSite_) {
		initLoinAjustementPage(requeteSite_);
	}

	/////////////////
	// requeteSite //
	/////////////////

	public void requeteSiteAjustementPage(RequeteSiteFrFR requeteSite_) {
			super.requeteSiteAjustementGenPage(requeteSite_);
	}

	public void requeteSitePourClasse(RequeteSiteFrFR requeteSite_) {
		requeteSiteAjustementPage(requeteSite_);
	}

	/////////////
	// obtenir //
	/////////////

	@Override public Object obtenirPourClasse(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtenirAjustementPage(v);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.obtenirPourClasse(v);
			}
		}
		return o;
	}
	public Object obtenirAjustementPage(String var) {
		AjustementPage oAjustementPage = (AjustementPage)this;
		switch(var) {
			default:
				return super.obtenirAjustementGenPage(var);
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
				o = attribuerAjustementPage(v, val);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.attribuerPourClasse(v, val);
			}
		}
		return o != null;
	}
	public Object attribuerAjustementPage(String var, Object val) {
		AjustementPage oAjustementPage = (AjustementPage)this;
		switch(var) {
			default:
				return super.attribuerAjustementGenPage(var, val);
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
					o = definirAjustementPage(v, val);
				else if(o instanceof Cluster) {
					Cluster cluster = (Cluster)o;
					o = cluster.definirPourClasse(v, val);
				}
			}
		}
		return o != null;
	}
	public Object definirAjustementPage(String var, String val) {
		switch(var) {
			default:
				return super.definirAjustementGenPage(var, val);
		}
	}

	/////////////////
	// htmlScripts //
	/////////////////

	@Override public void htmlScripts() {
		htmlScriptsAjustementPage();
		super.htmlScripts();
	}

	public void htmlScriptsAjustementPage() {
	}

	////////////////
	// htmlScript //
	////////////////

	@Override public void htmlScript() {
		htmlScriptAjustementPage();
		super.htmlScript();
	}

	public void htmlScriptAjustementPage() {
	}

	//////////////
	// htmlBody //
	//////////////

	@Override public void htmlBody() {
		htmlBodyAjustementPage();
		super.htmlBody();
	}

	public void htmlBodyAjustementPage() {
	}

	//////////
	// html //
	//////////

	@Override public void html() {
		htmlAjustementPage();
		super.html();
	}

	public void htmlAjustementPage() {
	}

	//////////////
	// htmlMeta //
	//////////////

	@Override public void htmlMeta() {
		htmlMetaAjustementPage();
		super.htmlMeta();
	}

	public void htmlMetaAjustementPage() {
	}

	////////////////
	// htmlStyles //
	////////////////

	@Override public void htmlStyles() {
		htmlStylesAjustementPage();
		super.htmlStyles();
	}

	public void htmlStylesAjustementPage() {
	}

	///////////////
	// htmlStyle //
	///////////////

	@Override public void htmlStyle() {
		htmlStyleAjustementPage();
		super.htmlStyle();
	}

	public void htmlStyleAjustementPage() {
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
		if(!(o instanceof AjustementPage))
			return false;
		AjustementPage that = (AjustementPage)o;
		return super.equals(o);
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString() + "\n");
		sb.append("AjustementPage { ");
		sb.append(" }");
		return sb.toString();
	}
}
