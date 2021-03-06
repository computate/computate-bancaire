package org.computate.bancaire.frfr.html.part;

import org.computate.bancaire.frfr.requete.patch.RequetePatch;
import org.computate.bancaire.frfr.cluster.Cluster;
import java.math.MathContext;
import org.apache.commons.text.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.computate.bancaire.frfr.requete.RequeteSiteFrFR;
import java.text.NumberFormat;
import java.util.Objects;
import org.computate.bancaire.frfr.html.part.PartHtml;
import io.vertx.core.json.JsonArray;
import org.computate.bancaire.frfr.couverture.Couverture;
import org.computate.bancaire.frfr.recherche.ListeRecherche;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.math.NumberUtils;
import java.util.Optional;
import org.computate.bancaire.frfr.ecrivain.ToutEcrivain;
import org.computate.bancaire.frfr.cluster.ClusterPage;

/**	
 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.html.part.PartHtmlGenPage&fq=classeEtendGen_indexed_boolean:true">Trouver la classe  dans Solr</a>
 * <br/>
 **/
public abstract class PartHtmlGenPageGen<DEV> extends ClusterPage {

	///////////////////
	// listePartHtml //
	///////////////////

	/**	L'entité « listePartHtml »
	 *	 is defined as null before being initialized. 
	 */
	protected ListeRecherche<PartHtml> listePartHtml;
	@JsonIgnore
	public Couverture<ListeRecherche<PartHtml>> listePartHtmlCouverture = new Couverture<ListeRecherche<PartHtml>>().p(this).c(ListeRecherche.class).var("listePartHtml").o(listePartHtml);

	/**	<br/>L'entité « listePartHtml »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.html.part.PartHtmlGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:listePartHtml">Trouver l'entité listePartHtml dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _listePartHtml(Couverture<ListeRecherche<PartHtml>> c);

	public ListeRecherche<PartHtml> getListePartHtml() {
		return listePartHtml;
	}

	public void setListePartHtml(ListeRecherche<PartHtml> listePartHtml) {
		this.listePartHtml = listePartHtml;
		this.listePartHtmlCouverture.dejaInitialise = true;
	}
	protected PartHtmlGenPage listePartHtmlInit() {
		if(!listePartHtmlCouverture.dejaInitialise) {
			_listePartHtml(listePartHtmlCouverture);
			if(listePartHtml == null)
				setListePartHtml(listePartHtmlCouverture.o);
		}
		if(listePartHtml != null)
			listePartHtml.initLoinPourClasse(requeteSite_);
		listePartHtmlCouverture.dejaInitialise(true);
		return (PartHtmlGenPage)this;
	}

	//////////////
	// partHtml //
	//////////////

	/**	L'entité « partHtml »
	 *	 is defined as null before being initialized. 
	 */
	protected PartHtml partHtml;
	@JsonIgnore
	public Couverture<PartHtml> partHtmlCouverture = new Couverture<PartHtml>().p(this).c(PartHtml.class).var("partHtml").o(partHtml);

	/**	<br/>L'entité « partHtml »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.html.part.PartHtmlGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:partHtml">Trouver l'entité partHtml dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _partHtml(Couverture<PartHtml> c);

	public PartHtml getPartHtml() {
		return partHtml;
	}

	public void setPartHtml(PartHtml partHtml) {
		this.partHtml = partHtml;
		this.partHtmlCouverture.dejaInitialise = true;
	}
	protected PartHtmlGenPage partHtmlInit() {
		if(!partHtmlCouverture.dejaInitialise) {
			_partHtml(partHtmlCouverture);
			if(partHtml == null)
				setPartHtml(partHtmlCouverture.o);
		}
		if(partHtml != null)
			partHtml.initLoinPourClasse(requeteSite_);
		partHtmlCouverture.dejaInitialise(true);
		return (PartHtmlGenPage)this;
	}

	//////////////
	// initLoin //
	//////////////

	protected boolean dejaInitialisePartHtmlGenPage = false;

	public PartHtmlGenPage initLoinPartHtmlGenPage(RequeteSiteFrFR requeteSite_) {
		setRequeteSite_(requeteSite_);
		if(!dejaInitialisePartHtmlGenPage) {
			dejaInitialisePartHtmlGenPage = true;
			initLoinPartHtmlGenPage();
		}
		return (PartHtmlGenPage)this;
	}

	public void initLoinPartHtmlGenPage() {
		initPartHtmlGenPage();
		super.initLoinClusterPage(requeteSite_);
	}

	public void initPartHtmlGenPage() {
		listePartHtmlInit();
		partHtmlInit();
	}

	@Override public void initLoinPourClasse(RequeteSiteFrFR requeteSite_) {
		initLoinPartHtmlGenPage(requeteSite_);
	}

	/////////////////
	// requeteSite //
	/////////////////

	public void requeteSitePartHtmlGenPage(RequeteSiteFrFR requeteSite_) {
			super.requeteSiteClusterPage(requeteSite_);
		if(listePartHtml != null)
			listePartHtml.setRequeteSite_(requeteSite_);
		if(partHtml != null)
			partHtml.setRequeteSite_(requeteSite_);
	}

	public void requeteSitePourClasse(RequeteSiteFrFR requeteSite_) {
		requeteSitePartHtmlGenPage(requeteSite_);
	}

	/////////////
	// obtenir //
	/////////////

	@Override public Object obtenirPourClasse(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtenirPartHtmlGenPage(v);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.obtenirPourClasse(v);
			}
		}
		return o;
	}
	public Object obtenirPartHtmlGenPage(String var) {
		PartHtmlGenPage oPartHtmlGenPage = (PartHtmlGenPage)this;
		switch(var) {
			case "listePartHtml":
				return oPartHtmlGenPage.listePartHtml;
			case "partHtml":
				return oPartHtmlGenPage.partHtml;
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
				o = attribuerPartHtmlGenPage(v, val);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.attribuerPourClasse(v, val);
			}
		}
		return o != null;
	}
	public Object attribuerPartHtmlGenPage(String var, Object val) {
		PartHtmlGenPage oPartHtmlGenPage = (PartHtmlGenPage)this;
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
					o = definirPartHtmlGenPage(v, val);
				else if(o instanceof Cluster) {
					Cluster cluster = (Cluster)o;
					o = cluster.definirPourClasse(v, val);
				}
			}
		}
		return o != null;
	}
	public Object definirPartHtmlGenPage(String var, String val) {
		switch(var) {
			default:
				return super.definirClusterPage(var, val);
		}
	}

	/////////////////
	// htmlScripts //
	/////////////////

	@Override public void htmlScripts() {
		htmlScriptsPartHtmlGenPage();
		super.htmlScripts();
	}

	public void htmlScriptsPartHtmlGenPage() {
	}

	////////////////
	// htmlScript //
	////////////////

	@Override public void htmlScript() {
		htmlScriptPartHtmlGenPage();
		super.htmlScript();
	}

	public void htmlScriptPartHtmlGenPage() {
	}

	//////////////
	// htmlBody //
	//////////////

	@Override public void htmlBody() {
		htmlBodyPartHtmlGenPage();
		super.htmlBody();
	}

	public void htmlBodyPartHtmlGenPage() {
	}

	//////////
	// html //
	//////////

	@Override public void html() {
		htmlPartHtmlGenPage();
		super.html();
	}

	public void htmlPartHtmlGenPage() {
	}

	//////////////
	// htmlMeta //
	//////////////

	@Override public void htmlMeta() {
		htmlMetaPartHtmlGenPage();
		super.htmlMeta();
	}

	public void htmlMetaPartHtmlGenPage() {
	}

	////////////////
	// htmlStyles //
	////////////////

	@Override public void htmlStyles() {
		htmlStylesPartHtmlGenPage();
		super.htmlStyles();
	}

	public void htmlStylesPartHtmlGenPage() {
	}

	///////////////
	// htmlStyle //
	///////////////

	@Override public void htmlStyle() {
		htmlStylePartHtmlGenPage();
		super.htmlStyle();
	}

	public void htmlStylePartHtmlGenPage() {
	}

	//////////////////
	// requetePatch //
	//////////////////

	public void requetePatchPartHtmlGenPage() {
		RequetePatch requetePatch = Optional.ofNullable(requeteSite_).map(RequeteSiteFrFR::getRequetePatch_).orElse(null);
		PartHtmlGenPage original = (PartHtmlGenPage)Optional.ofNullable(requetePatch).map(RequetePatch::getOriginal).orElse(null);
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
		if(!(o instanceof PartHtmlGenPage))
			return false;
		PartHtmlGenPage that = (PartHtmlGenPage)o;
		return super.equals(o);
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString() + "\n");
		sb.append("PartHtmlGenPage { ");
		sb.append(" }");
		return sb.toString();
	}
}
