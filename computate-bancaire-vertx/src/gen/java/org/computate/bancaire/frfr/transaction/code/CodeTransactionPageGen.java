package org.computate.bancaire.frfr.transaction.code;

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
import org.computate.bancaire.frfr.transaction.code.CodeTransactionGenPage;

/**	
 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.transaction.code.CodeTransactionPage&fq=classeEtendGen_indexed_boolean:true">Trouver la classe  dans Solr</a>
 * <br/>
 **/
public abstract class CodeTransactionPageGen<DEV> extends CodeTransactionGenPage {

	//////////////
	// initLoin //
	//////////////

	protected boolean dejaInitialiseCodeTransactionPage = false;

	public CodeTransactionPage initLoinCodeTransactionPage(RequeteSiteFrFR requeteSite_) {
		setRequeteSite_(requeteSite_);
		if(!dejaInitialiseCodeTransactionPage) {
			dejaInitialiseCodeTransactionPage = true;
			initLoinCodeTransactionPage();
		}
		return (CodeTransactionPage)this;
	}

	public void initLoinCodeTransactionPage() {
		initCodeTransactionPage();
		super.initLoinCodeTransactionGenPage(requeteSite_);
	}

	public void initCodeTransactionPage() {
	}

	@Override public void initLoinPourClasse(RequeteSiteFrFR requeteSite_) {
		initLoinCodeTransactionPage(requeteSite_);
	}

	/////////////////
	// requeteSite //
	/////////////////

	public void requeteSiteCodeTransactionPage(RequeteSiteFrFR requeteSite_) {
			super.requeteSiteCodeTransactionGenPage(requeteSite_);
	}

	public void requeteSitePourClasse(RequeteSiteFrFR requeteSite_) {
		requeteSiteCodeTransactionPage(requeteSite_);
	}

	/////////////
	// obtenir //
	/////////////

	@Override public Object obtenirPourClasse(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtenirCodeTransactionPage(v);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.obtenirPourClasse(v);
			}
		}
		return o;
	}
	public Object obtenirCodeTransactionPage(String var) {
		CodeTransactionPage oCodeTransactionPage = (CodeTransactionPage)this;
		switch(var) {
			default:
				return super.obtenirCodeTransactionGenPage(var);
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
				o = attribuerCodeTransactionPage(v, val);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.attribuerPourClasse(v, val);
			}
		}
		return o != null;
	}
	public Object attribuerCodeTransactionPage(String var, Object val) {
		CodeTransactionPage oCodeTransactionPage = (CodeTransactionPage)this;
		switch(var) {
			default:
				return super.attribuerCodeTransactionGenPage(var, val);
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
					o = definirCodeTransactionPage(v, val);
				else if(o instanceof Cluster) {
					Cluster cluster = (Cluster)o;
					o = cluster.definirPourClasse(v, val);
				}
			}
		}
		return o != null;
	}
	public Object definirCodeTransactionPage(String var, String val) {
		switch(var) {
			default:
				return super.definirCodeTransactionGenPage(var, val);
		}
	}

	/////////////////
	// htmlScripts //
	/////////////////

	@Override public void htmlScripts() {
		htmlScriptsCodeTransactionPage();
		super.htmlScripts();
	}

	public void htmlScriptsCodeTransactionPage() {
	}

	////////////////
	// htmlScript //
	////////////////

	@Override public void htmlScript() {
		htmlScriptCodeTransactionPage();
		super.htmlScript();
	}

	public void htmlScriptCodeTransactionPage() {
	}

	//////////////
	// htmlBody //
	//////////////

	@Override public void htmlBody() {
		htmlBodyCodeTransactionPage();
		super.htmlBody();
	}

	public void htmlBodyCodeTransactionPage() {
	}

	//////////
	// html //
	//////////

	@Override public void html() {
		htmlCodeTransactionPage();
		super.html();
	}

	public void htmlCodeTransactionPage() {
	}

	//////////////
	// htmlMeta //
	//////////////

	@Override public void htmlMeta() {
		htmlMetaCodeTransactionPage();
		super.htmlMeta();
	}

	public void htmlMetaCodeTransactionPage() {
	}

	////////////////
	// htmlStyles //
	////////////////

	@Override public void htmlStyles() {
		htmlStylesCodeTransactionPage();
		super.htmlStyles();
	}

	public void htmlStylesCodeTransactionPage() {
	}

	///////////////
	// htmlStyle //
	///////////////

	@Override public void htmlStyle() {
		htmlStyleCodeTransactionPage();
		super.htmlStyle();
	}

	public void htmlStyleCodeTransactionPage() {
	}

	//////////////////
	// requetePatch //
	//////////////////

	public void requetePatchCodeTransactionPage() {
		RequetePatch requetePatch = Optional.ofNullable(requeteSite_).map(RequeteSiteFrFR::getRequetePatch_).orElse(null);
		CodeTransactionPage original = (CodeTransactionPage)Optional.ofNullable(requetePatch).map(RequetePatch::getOriginal).orElse(null);
		if(original != null) {
			super.requetePatchCodeTransactionGenPage();
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
		if(!(o instanceof CodeTransactionPage))
			return false;
		CodeTransactionPage that = (CodeTransactionPage)o;
		return super.equals(o);
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString() + "\n");
		sb.append("CodeTransactionPage { ");
		sb.append(" }");
		return sb.toString();
	}
}
