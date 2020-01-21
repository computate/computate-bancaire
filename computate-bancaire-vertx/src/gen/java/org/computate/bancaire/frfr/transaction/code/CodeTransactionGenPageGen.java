package org.computate.bancaire.frfr.transaction.code;

import org.computate.bancaire.frfr.requete.patch.RequetePatch;
import org.computate.bancaire.frfr.transaction.code.CodeTransaction;
import org.computate.bancaire.frfr.cluster.Cluster;
import java.math.MathContext;
import org.apache.commons.text.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.computate.bancaire.frfr.requete.RequeteSiteFrFR;
import java.text.NumberFormat;
import java.util.Objects;
import io.vertx.core.json.JsonArray;
import org.computate.bancaire.frfr.couverture.Couverture;
import org.computate.bancaire.frfr.recherche.ListeRecherche;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.math.NumberUtils;
import java.util.Optional;
import org.computate.bancaire.frfr.ecrivain.ToutEcrivain;
import org.computate.bancaire.frfr.cluster.ClusterPage;

/**	
 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.transaction.code.CodeTransactionGenPage&fq=classeEtendGen_indexed_boolean:true">Trouver la classe  dans Solr</a>
 * <br/>
 **/
public abstract class CodeTransactionGenPageGen<DEV> extends ClusterPage {

	//////////////////////////
	// listeCodeTransaction //
	//////////////////////////

	/**	L'entité « listeCodeTransaction »
	 *	 is defined as null before being initialized. 
	 */
	protected ListeRecherche<CodeTransaction> listeCodeTransaction;
	@JsonIgnore
	public Couverture<ListeRecherche<CodeTransaction>> listeCodeTransactionCouverture = new Couverture<ListeRecherche<CodeTransaction>>().p(this).c(ListeRecherche.class).var("listeCodeTransaction").o(listeCodeTransaction);

	/**	<br/>L'entité « listeCodeTransaction »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.transaction.code.CodeTransactionGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:listeCodeTransaction">Trouver l'entité listeCodeTransaction dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _listeCodeTransaction(Couverture<ListeRecherche<CodeTransaction>> c);

	public ListeRecherche<CodeTransaction> getListeCodeTransaction() {
		return listeCodeTransaction;
	}

	public void setListeCodeTransaction(ListeRecherche<CodeTransaction> listeCodeTransaction) {
		this.listeCodeTransaction = listeCodeTransaction;
		this.listeCodeTransactionCouverture.dejaInitialise = true;
	}
	protected CodeTransactionGenPage listeCodeTransactionInit() {
		if(!listeCodeTransactionCouverture.dejaInitialise) {
			_listeCodeTransaction(listeCodeTransactionCouverture);
			if(listeCodeTransaction == null)
				setListeCodeTransaction(listeCodeTransactionCouverture.o);
		}
		if(listeCodeTransaction != null)
			listeCodeTransaction.initLoinPourClasse(requeteSite_);
		listeCodeTransactionCouverture.dejaInitialise(true);
		return (CodeTransactionGenPage)this;
	}

	/////////////////////
	// codeTransaction //
	/////////////////////

	/**	L'entité « codeTransaction »
	 *	 is defined as null before being initialized. 
	 */
	protected CodeTransaction codeTransaction;
	@JsonIgnore
	public Couverture<CodeTransaction> codeTransactionCouverture = new Couverture<CodeTransaction>().p(this).c(CodeTransaction.class).var("codeTransaction").o(codeTransaction);

	/**	<br/>L'entité « codeTransaction »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.transaction.code.CodeTransactionGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:codeTransaction">Trouver l'entité codeTransaction dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _codeTransaction(Couverture<CodeTransaction> c);

	public CodeTransaction getCodeTransaction() {
		return codeTransaction;
	}

	public void setCodeTransaction(CodeTransaction codeTransaction) {
		this.codeTransaction = codeTransaction;
		this.codeTransactionCouverture.dejaInitialise = true;
	}
	protected CodeTransactionGenPage codeTransactionInit() {
		if(!codeTransactionCouverture.dejaInitialise) {
			_codeTransaction(codeTransactionCouverture);
			if(codeTransaction == null)
				setCodeTransaction(codeTransactionCouverture.o);
		}
		if(codeTransaction != null)
			codeTransaction.initLoinPourClasse(requeteSite_);
		codeTransactionCouverture.dejaInitialise(true);
		return (CodeTransactionGenPage)this;
	}

	//////////////
	// initLoin //
	//////////////

	protected boolean dejaInitialiseCodeTransactionGenPage = false;

	public CodeTransactionGenPage initLoinCodeTransactionGenPage(RequeteSiteFrFR requeteSite_) {
		setRequeteSite_(requeteSite_);
		if(!dejaInitialiseCodeTransactionGenPage) {
			dejaInitialiseCodeTransactionGenPage = true;
			initLoinCodeTransactionGenPage();
		}
		return (CodeTransactionGenPage)this;
	}

	public void initLoinCodeTransactionGenPage() {
		initCodeTransactionGenPage();
		super.initLoinClusterPage(requeteSite_);
	}

	public void initCodeTransactionGenPage() {
		listeCodeTransactionInit();
		codeTransactionInit();
	}

	@Override public void initLoinPourClasse(RequeteSiteFrFR requeteSite_) {
		initLoinCodeTransactionGenPage(requeteSite_);
	}

	/////////////////
	// requeteSite //
	/////////////////

	public void requeteSiteCodeTransactionGenPage(RequeteSiteFrFR requeteSite_) {
			super.requeteSiteClusterPage(requeteSite_);
		if(listeCodeTransaction != null)
			listeCodeTransaction.setRequeteSite_(requeteSite_);
		if(codeTransaction != null)
			codeTransaction.setRequeteSite_(requeteSite_);
	}

	public void requeteSitePourClasse(RequeteSiteFrFR requeteSite_) {
		requeteSiteCodeTransactionGenPage(requeteSite_);
	}

	/////////////
	// obtenir //
	/////////////

	@Override public Object obtenirPourClasse(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtenirCodeTransactionGenPage(v);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.obtenirPourClasse(v);
			}
		}
		return o;
	}
	public Object obtenirCodeTransactionGenPage(String var) {
		CodeTransactionGenPage oCodeTransactionGenPage = (CodeTransactionGenPage)this;
		switch(var) {
			case "listeCodeTransaction":
				return oCodeTransactionGenPage.listeCodeTransaction;
			case "codeTransaction":
				return oCodeTransactionGenPage.codeTransaction;
			default:
				return super.obtenirClusterPage(var);
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
				o = attribuerCodeTransactionGenPage(v, val);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.attribuerPourClasse(v, val);
			}
		}
		return o != null;
	}
	public Object attribuerCodeTransactionGenPage(String var, Object val) {
		CodeTransactionGenPage oCodeTransactionGenPage = (CodeTransactionGenPage)this;
		switch(var) {
			default:
				return super.attribuerClusterPage(var, val);
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
					o = definirCodeTransactionGenPage(v, val);
				else if(o instanceof Cluster) {
					Cluster cluster = (Cluster)o;
					o = cluster.definirPourClasse(v, val);
				}
			}
		}
		return o != null;
	}
	public Object definirCodeTransactionGenPage(String var, String val) {
		switch(var) {
			default:
				return super.definirClusterPage(var, val);
		}
	}

	/////////////////
	// htmlScripts //
	/////////////////

	@Override public void htmlScripts() {
		htmlScriptsCodeTransactionGenPage();
		super.htmlScripts();
	}

	public void htmlScriptsCodeTransactionGenPage() {
	}

	////////////////
	// htmlScript //
	////////////////

	@Override public void htmlScript() {
		htmlScriptCodeTransactionGenPage();
		super.htmlScript();
	}

	public void htmlScriptCodeTransactionGenPage() {
	}

	//////////////
	// htmlBody //
	//////////////

	@Override public void htmlBody() {
		htmlBodyCodeTransactionGenPage();
		super.htmlBody();
	}

	public void htmlBodyCodeTransactionGenPage() {
	}

	//////////
	// html //
	//////////

	@Override public void html() {
		htmlCodeTransactionGenPage();
		super.html();
	}

	public void htmlCodeTransactionGenPage() {
	}

	//////////////
	// htmlMeta //
	//////////////

	@Override public void htmlMeta() {
		htmlMetaCodeTransactionGenPage();
		super.htmlMeta();
	}

	public void htmlMetaCodeTransactionGenPage() {
	}

	////////////////
	// htmlStyles //
	////////////////

	@Override public void htmlStyles() {
		htmlStylesCodeTransactionGenPage();
		super.htmlStyles();
	}

	public void htmlStylesCodeTransactionGenPage() {
	}

	///////////////
	// htmlStyle //
	///////////////

	@Override public void htmlStyle() {
		htmlStyleCodeTransactionGenPage();
		super.htmlStyle();
	}

	public void htmlStyleCodeTransactionGenPage() {
	}

	//////////////////
	// requetePatch //
	//////////////////

	public void requetePatchCodeTransactionGenPage() {
		RequetePatch requetePatch = Optional.ofNullable(requeteSite_).map(RequeteSiteFrFR::getRequetePatch_).orElse(null);
		CodeTransactionGenPage original = (CodeTransactionGenPage)Optional.ofNullable(requetePatch).map(RequetePatch::getOriginal).orElse(null);
		if(original != null) {
			super.requetePatchClusterPage();
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
		if(!(o instanceof CodeTransactionGenPage))
			return false;
		CodeTransactionGenPage that = (CodeTransactionGenPage)o;
		return super.equals(o);
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString() + "\n");
		sb.append("CodeTransactionGenPage { ");
		sb.append(" }");
		return sb.toString();
	}
}
