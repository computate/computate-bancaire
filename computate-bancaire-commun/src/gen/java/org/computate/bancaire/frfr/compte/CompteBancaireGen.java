package org.computate.bancaire.frfr.compte;

import java.lang.Double;
import java.util.Date;
import org.apache.commons.lang3.StringUtils;
import org.computate.bancaire.frfr.requete.RequeteSiteFrFR;
import io.vertx.core.logging.LoggerFactory;
import java.text.NumberFormat;
import org.computate.bancaire.frfr.contexte.SiteContexteFrFR;
import java.util.ArrayList;
import java.lang.Long;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.vertx.core.json.JsonObject;
import org.computate.bancaire.frfr.ecrivain.ToutEcrivain;
import java.lang.String;
import io.vertx.core.logging.Logger;
import org.computate.bancaire.frfr.cluster.Cluster;
import java.math.MathContext;
import org.apache.solr.client.solrj.response.QueryResponse;
import java.util.Set;
import org.apache.commons.text.StringEscapeUtils;
import org.apache.solr.client.solrj.SolrClient;
import java.util.Objects;
import io.vertx.core.json.JsonArray;
import org.apache.solr.common.SolrDocument;
import java.util.List;
import org.computate.bancaire.frfr.couverture.Couverture;
import org.apache.solr.client.solrj.SolrQuery;
import io.vertx.ext.sql.SQLConnection;
import org.apache.commons.lang3.math.NumberUtils;
import io.vertx.ext.sql.SQLClient;
import org.apache.solr.client.solrj.util.ClientUtils;
import org.apache.solr.common.SolrInputDocument;
import org.apache.commons.lang3.exception.ExceptionUtils;

/**	
 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.compte.CompteBancaire&fq=classeEtendGen_indexed_boolean:true">Trouver la classe pageH1 dans Solr</a>
 * <br/>
 **/
public abstract class CompteBancaireGen<DEV> extends Cluster {
	private static final Logger LOGGER = LoggerFactory.getLogger(CompteBancaire.class);

	public static final String CompteBancaire_UnNom = "un compte";
	public static final String CompteBancaire_Ce = "ce ";
	public static final String CompteBancaire_CeNom = "ce compte";
	public static final String CompteBancaire_Un = "un ";
	public static final String CompteBancaire_LeNom = "le compte";
	public static final String CompteBancaire_NomSingulier = "compte";
	public static final String CompteBancaire_NomPluriel = "comptes";
	public static final String CompteBancaire_NomActuel = "compte actuel";
	public static final String CompteBancaire_Tous = "all ";
	public static final String CompteBancaire_TousNom = "tous les comptes";
	public static final String CompteBancaire_RechercherTousNomPar = "rechercher comptes par ";
	public static final String CompteBancaire_RechercherTousNom = "rechercher comptes";
	public static final String CompteBancaire_LesNoms = "les comptes";
	public static final String CompteBancaire_AucunNomTrouve = "aucun compte trouvé";
	public static final String CompteBancaire_NomVar = "compte";
	public static final String CompteBancaire_DeNom = "de compte";
	public static final String CompteBancaire_NomAdjectifSingulier = "compte";
	public static final String CompteBancaire_NomAdjectifPluriel = "comptes";
	public static final String CompteBancaire_Couleur = "gray";
	public static final String CompteBancaire_IconeGroupe = "duotone";
	public static final String CompteBancaire_IconeNom = "money-check";

	///////////////
	// compteCle //
	///////////////

	/**	L'entité « compteCle »
	 *	 is defined as null before being initialized. 
	 */
	protected Long compteCle;
	@JsonIgnore
	public Couverture<Long> compteCleCouverture = new Couverture<Long>().p(this).c(Long.class).var("compteCle").o(compteCle);

	/**	<br/>L'entité « compteCle »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.compte.CompteBancaire&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:compteCle">Trouver l'entité compteCle dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _compteCle(Couverture<Long> c);

	public Long getCompteCle() {
		return compteCle;
	}

	public void setCompteCle(Long compteCle) {
		this.compteCle = compteCle;
		this.compteCleCouverture.dejaInitialise = true;
	}
	public CompteBancaire setCompteCle(String o) {
		if(NumberUtils.isParsable(o))
			this.compteCle = Long.parseLong(o);
		this.compteCleCouverture.dejaInitialise = true;
		return (CompteBancaire)this;
	}
	protected CompteBancaire compteCleInit() {
		if(!compteCleCouverture.dejaInitialise) {
			_compteCle(compteCleCouverture);
			if(compteCle == null)
				setCompteCle(compteCleCouverture.o);
		}
		compteCleCouverture.dejaInitialise(true);
		return (CompteBancaire)this;
	}

	public Long solrCompteCle() {
		return compteCle;
	}

	public String strCompteCle() {
		return compteCle == null ? "" : compteCle.toString();
	}

	public String jsonCompteCle() {
		return compteCle == null ? "" : compteCle.toString();
	}

	public String nomAffichageCompteCle() {
		return "clé";
	}

	public String htmTooltipCompteCle() {
		return null;
	}

	public String htmCompteCle() {
		return compteCle == null ? "" : StringEscapeUtils.escapeHtml4(strCompteCle());
	}

	public void htmCompteCle(ToutEcrivain r, Boolean patchDroits) {
		if(pk!= null) {
			r.s("<div id=\"patchCompteBancaire", strPk(), "CompteCle\">");
			if(patchDroits) {
				r.l();
				r.l("	<script>//<![CDATA[");
				r.l("		function patchCompteBancaire", strPk(), "CompteCle() {");
				r.l("			$.ajax({");
				r.l("				url: '?fq=pk:", strPk(), "',");
				r.l("				dataType: 'json',");
				r.l("				type: 'patch',");
				r.l("				contentType: 'application/json',");
				r.l("				processData: false,");
				r.l("				success: function( data, textStatus, jQxhr ) {");
				r.l("					");
				r.l("				},");
				r.l("				error: function( jqXhr, textStatus, errorThrown ) {");
				r.l("					");
				r.l("				},");
				r.l("				data: {\"setCompteCle\": this.value },");
				r.l("				");
				r.l("			});");
				r.l("		}");
				r.l("	//]]></script>");
				r.l("	<div class=\"\">");
				r.l("		<label class=\"w3-tooltip \">");
				r.l("			<span>", StringEscapeUtils.escapeHtml4(nomAffichageCompteCle()), "</span>");
				r.s("			<input");
							r.s(" name=\"compteCle\"");
							r.s(" value=\"", htmCompteCle(), "\");");
							r.s(" onchange=\"\"");
							r.l("/>");
				r.l("		</label>");
				r.l("	</div>");
			} else {
				r.s(htmCompteCle());
			}
			r.l("</div>");
		}
	}

	/////////////////////
	// transactionCles //
	/////////////////////

	/**	L'entité « transactionCles »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut List<Long>(). 
	 */
	protected List<Long> transactionCles = new java.util.ArrayList<java.lang.Long>();
	@JsonIgnore
	public Couverture<List<Long>> transactionClesCouverture = new Couverture<List<Long>>().p(this).c(List.class).var("transactionCles").o(transactionCles);

	/**	<br/>L'entité « transactionCles »
	 * Il est construit avant d'être initialisé avec le constructeur par défaut List<Long>(). 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.compte.CompteBancaire&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:transactionCles">Trouver l'entité transactionCles dans Solr</a>
	 * <br/>
	 * @param transactionCles est l'entité déjà construit. 
	 **/
	protected abstract void _transactionCles(List<Long> o);

	public List<Long> getTransactionCles() {
		return transactionCles;
	}

	public void setTransactionCles(List<Long> transactionCles) {
		this.transactionCles = transactionCles;
		this.transactionClesCouverture.dejaInitialise = true;
	}
	public CompteBancaire addTransactionCles(Long...objets) {
		for(Long o : objets) {
			addTransactionCles(o);
		}
		return (CompteBancaire)this;
	}
	public CompteBancaire addTransactionCles(Long o) {
		if(o != null && !transactionCles.contains(o))
			this.transactionCles.add(o);
		return (CompteBancaire)this;
	}
	public CompteBancaire setTransactionCles(JsonArray objets) {
		transactionCles.clear();
		for(int i = 0; i < objets.size(); i++) {
			Long o = objets.getLong(i);
			addTransactionCles(o);
		}
		return (CompteBancaire)this;
	}
	public CompteBancaire addTransactionCles(String o) {
		if(NumberUtils.isParsable(o)) {
			Long p = Long.parseLong(o);
			addTransactionCles(p);
		}
		return (CompteBancaire)this;
	}
	protected CompteBancaire transactionClesInit() {
		if(!transactionClesCouverture.dejaInitialise) {
			_transactionCles(transactionCles);
		}
		transactionClesCouverture.dejaInitialise(true);
		return (CompteBancaire)this;
	}

	public List<Long> solrTransactionCles() {
		return transactionCles;
	}

	public String strTransactionCles() {
		return transactionCles == null ? "" : transactionCles.toString();
	}

	public String jsonTransactionCles() {
		return transactionCles == null ? "" : transactionCles.toString();
	}

	public String nomAffichageTransactionCles() {
		return "transactions";
	}

	public String htmTooltipTransactionCles() {
		return null;
	}

	public String htmTransactionCles() {
		return transactionCles == null ? "" : StringEscapeUtils.escapeHtml4(strTransactionCles());
	}

	public void htmTransactionCles(ToutEcrivain r, Boolean patchDroits) {
		if(pk!= null) {
			r.s("<div id=\"patchCompteBancaire", strPk(), "TransactionCles\">");
			if(patchDroits) {
				r.l();
				r.l("	<script>//<![CDATA[");
				r.l("		function patchCompteBancaire", strPk(), "TransactionCles() {");
				r.l("			$.ajax({");
				r.l("				url: '?fq=pk:", strPk(), "',");
				r.l("				dataType: 'json',");
				r.l("				type: 'patch',");
				r.l("				contentType: 'application/json',");
				r.l("				processData: false,");
				r.l("				success: function( data, textStatus, jQxhr ) {");
				r.l("					");
				r.l("				},");
				r.l("				error: function( jqXhr, textStatus, errorThrown ) {");
				r.l("					");
				r.l("				},");
				r.l("				data: {\"setTransactionCles\": this.value },");
				r.l("				");
				r.l("			});");
				r.l("		}");
				r.l("	//]]></script>");
				r.l("	<div class=\"\">");
				r.l("		<label class=\"w3-tooltip \">");
				r.l("			<span>", StringEscapeUtils.escapeHtml4(nomAffichageTransactionCles()), "</span>");
				r.s("			<input");
							r.s(" name=\"transactionCles\"");
							r.s(" value=\"", htmTransactionCles(), "\");");
							r.s(" onchange=\"\"");
							r.l("/>");
				r.l("		</label>");
				r.l("	</div>");
			} else {
				r.s(htmTransactionCles());
			}
			r.l("</div>");
		}
	}

	//////////////////
	// compteNumero //
	//////////////////

	/**	L'entité « compteNumero »
	 *	 is defined as null before being initialized. 
	 */
	protected String compteNumero;
	@JsonIgnore
	public Couverture<String> compteNumeroCouverture = new Couverture<String>().p(this).c(String.class).var("compteNumero").o(compteNumero);

	/**	<br/>L'entité « compteNumero »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.compte.CompteBancaire&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:compteNumero">Trouver l'entité compteNumero dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _compteNumero(Couverture<String> c);

	public String getCompteNumero() {
		return compteNumero;
	}

	public void setCompteNumero(String compteNumero) {
		this.compteNumero = compteNumero;
		this.compteNumeroCouverture.dejaInitialise = true;
	}
	protected CompteBancaire compteNumeroInit() {
		if(!compteNumeroCouverture.dejaInitialise) {
			_compteNumero(compteNumeroCouverture);
			if(compteNumero == null)
				setCompteNumero(compteNumeroCouverture.o);
		}
		compteNumeroCouverture.dejaInitialise(true);
		return (CompteBancaire)this;
	}

	public String solrCompteNumero() {
		return compteNumero;
	}

	public String strCompteNumero() {
		return compteNumero == null ? "" : compteNumero;
	}

	public String jsonCompteNumero() {
		return compteNumero == null ? "" : compteNumero;
	}

	public String nomAffichageCompteNumero() {
		return "numéro de compte";
	}

	public String htmTooltipCompteNumero() {
		return null;
	}

	public String htmCompteNumero() {
		return compteNumero == null ? "" : StringEscapeUtils.escapeHtml4(strCompteNumero());
	}

	public void htmCompteNumero(ToutEcrivain r, Boolean patchDroits) {
		if(pk!= null) {
			r.s("<div id=\"patchCompteBancaire", strPk(), "CompteNumero\">");
			if(patchDroits) {
				r.l();
				r.l("	<script>//<![CDATA[");
				r.l("		function patchCompteBancaire", strPk(), "CompteNumero() {");
				r.l("			$.ajax({");
				r.l("				url: '?fq=pk:", strPk(), "',");
				r.l("				dataType: 'json',");
				r.l("				type: 'patch',");
				r.l("				contentType: 'application/json',");
				r.l("				processData: false,");
				r.l("				success: function( data, textStatus, jQxhr ) {");
				r.l("					");
				r.l("				},");
				r.l("				error: function( jqXhr, textStatus, errorThrown ) {");
				r.l("					");
				r.l("				},");
				r.l("				data: {\"setCompteNumero\": this.value },");
				r.l("				");
				r.l("			});");
				r.l("		}");
				r.l("	//]]></script>");
				r.l("	<div class=\"\">");
				r.l("		<label class=\"w3-tooltip \">");
				r.l("			<span>", StringEscapeUtils.escapeHtml4(nomAffichageCompteNumero()), "</span>");
				r.s("			<input");
							r.s(" name=\"compteNumero\"");
							r.s(" value=\"", htmCompteNumero(), "\");");
							r.s(" onchange=\"\"");
							r.l("/>");
				r.l("		</label>");
				r.l("	</div>");
			} else {
				r.s(htmCompteNumero());
			}
			r.l("</div>");
		}
	}

	///////////////////////////
	// compteNumeroTelephone //
	///////////////////////////

	/**	L'entité « compteNumeroTelephone »
	 *	 is defined as null before being initialized. 
	 */
	protected String compteNumeroTelephone;
	@JsonIgnore
	public Couverture<String> compteNumeroTelephoneCouverture = new Couverture<String>().p(this).c(String.class).var("compteNumeroTelephone").o(compteNumeroTelephone);

	/**	<br/>L'entité « compteNumeroTelephone »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.compte.CompteBancaire&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:compteNumeroTelephone">Trouver l'entité compteNumeroTelephone dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _compteNumeroTelephone(Couverture<String> c);

	public String getCompteNumeroTelephone() {
		return compteNumeroTelephone;
	}

	public void setCompteNumeroTelephone(String compteNumeroTelephone) {
		this.compteNumeroTelephone = compteNumeroTelephone;
		this.compteNumeroTelephoneCouverture.dejaInitialise = true;
	}
	protected CompteBancaire compteNumeroTelephoneInit() {
		if(!compteNumeroTelephoneCouverture.dejaInitialise) {
			_compteNumeroTelephone(compteNumeroTelephoneCouverture);
			if(compteNumeroTelephone == null)
				setCompteNumeroTelephone(compteNumeroTelephoneCouverture.o);
		}
		compteNumeroTelephoneCouverture.dejaInitialise(true);
		return (CompteBancaire)this;
	}

	public String solrCompteNumeroTelephone() {
		return compteNumeroTelephone;
	}

	public String strCompteNumeroTelephone() {
		return compteNumeroTelephone == null ? "" : compteNumeroTelephone;
	}

	public String jsonCompteNumeroTelephone() {
		return compteNumeroTelephone == null ? "" : compteNumeroTelephone;
	}

	public String nomAffichageCompteNumeroTelephone() {
		return "numéro de téléphone";
	}

	public String htmTooltipCompteNumeroTelephone() {
		return null;
	}

	public String htmCompteNumeroTelephone() {
		return compteNumeroTelephone == null ? "" : StringEscapeUtils.escapeHtml4(strCompteNumeroTelephone());
	}

	public void htmCompteNumeroTelephone(ToutEcrivain r, Boolean patchDroits) {
		if(pk!= null) {
			r.s("<div id=\"patchCompteBancaire", strPk(), "CompteNumeroTelephone\">");
			if(patchDroits) {
				r.l();
				r.l("	<script>//<![CDATA[");
				r.l("		function patchCompteBancaire", strPk(), "CompteNumeroTelephone() {");
				r.l("			$.ajax({");
				r.l("				url: '?fq=pk:", strPk(), "',");
				r.l("				dataType: 'json',");
				r.l("				type: 'patch',");
				r.l("				contentType: 'application/json',");
				r.l("				processData: false,");
				r.l("				success: function( data, textStatus, jQxhr ) {");
				r.l("					");
				r.l("				},");
				r.l("				error: function( jqXhr, textStatus, errorThrown ) {");
				r.l("					");
				r.l("				},");
				r.l("				data: {\"setCompteNumeroTelephone\": this.value },");
				r.l("				");
				r.l("			});");
				r.l("		}");
				r.l("	//]]></script>");
				r.l("	<div class=\"\">");
				r.l("		<label class=\"w3-tooltip \">");
				r.l("			<span>", StringEscapeUtils.escapeHtml4(nomAffichageCompteNumeroTelephone()), "</span>");
				r.s("			<input");
							r.s(" name=\"compteNumeroTelephone\"");
							r.s(" value=\"", htmCompteNumeroTelephone(), "\");");
							r.s(" onchange=\"\"");
							r.l("/>");
				r.l("		</label>");
				r.l("	</div>");
			} else {
				r.s(htmCompteNumeroTelephone());
			}
			r.l("</div>");
		}
	}

	/////////////////////////////
	// compteAdministrateurNom //
	/////////////////////////////

	/**	L'entité « compteAdministrateurNom »
	 *	 is defined as null before being initialized. 
	 */
	protected String compteAdministrateurNom;
	@JsonIgnore
	public Couverture<String> compteAdministrateurNomCouverture = new Couverture<String>().p(this).c(String.class).var("compteAdministrateurNom").o(compteAdministrateurNom);

	/**	<br/>L'entité « compteAdministrateurNom »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.compte.CompteBancaire&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:compteAdministrateurNom">Trouver l'entité compteAdministrateurNom dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _compteAdministrateurNom(Couverture<String> c);

	public String getCompteAdministrateurNom() {
		return compteAdministrateurNom;
	}

	public void setCompteAdministrateurNom(String compteAdministrateurNom) {
		this.compteAdministrateurNom = compteAdministrateurNom;
		this.compteAdministrateurNomCouverture.dejaInitialise = true;
	}
	protected CompteBancaire compteAdministrateurNomInit() {
		if(!compteAdministrateurNomCouverture.dejaInitialise) {
			_compteAdministrateurNom(compteAdministrateurNomCouverture);
			if(compteAdministrateurNom == null)
				setCompteAdministrateurNom(compteAdministrateurNomCouverture.o);
		}
		compteAdministrateurNomCouverture.dejaInitialise(true);
		return (CompteBancaire)this;
	}

	public String solrCompteAdministrateurNom() {
		return compteAdministrateurNom;
	}

	public String strCompteAdministrateurNom() {
		return compteAdministrateurNom == null ? "" : compteAdministrateurNom;
	}

	public String jsonCompteAdministrateurNom() {
		return compteAdministrateurNom == null ? "" : compteAdministrateurNom;
	}

	public String nomAffichageCompteAdministrateurNom() {
		return "administrateur de l'école";
	}

	public String htmTooltipCompteAdministrateurNom() {
		return null;
	}

	public String htmCompteAdministrateurNom() {
		return compteAdministrateurNom == null ? "" : StringEscapeUtils.escapeHtml4(strCompteAdministrateurNom());
	}

	public void htmCompteAdministrateurNom(ToutEcrivain r, Boolean patchDroits) {
		if(pk!= null) {
			r.s("<div id=\"patchCompteBancaire", strPk(), "CompteAdministrateurNom\">");
			if(patchDroits) {
				r.l();
				r.l("	<script>//<![CDATA[");
				r.l("		function patchCompteBancaire", strPk(), "CompteAdministrateurNom() {");
				r.l("			$.ajax({");
				r.l("				url: '?fq=pk:", strPk(), "',");
				r.l("				dataType: 'json',");
				r.l("				type: 'patch',");
				r.l("				contentType: 'application/json',");
				r.l("				processData: false,");
				r.l("				success: function( data, textStatus, jQxhr ) {");
				r.l("					");
				r.l("				},");
				r.l("				error: function( jqXhr, textStatus, errorThrown ) {");
				r.l("					");
				r.l("				},");
				r.l("				data: {\"setCompteAdministrateurNom\": this.value },");
				r.l("				");
				r.l("			});");
				r.l("		}");
				r.l("	//]]></script>");
				r.l("	<div class=\"\">");
				r.l("		<label class=\"w3-tooltip \">");
				r.l("			<span>", StringEscapeUtils.escapeHtml4(nomAffichageCompteAdministrateurNom()), "</span>");
				r.s("			<input");
							r.s(" name=\"compteAdministrateurNom\"");
							r.s(" value=\"", htmCompteAdministrateurNom(), "\");");
							r.s(" onchange=\"\"");
							r.l("/>");
				r.l("		</label>");
				r.l("	</div>");
			} else {
				r.s(htmCompteAdministrateurNom());
			}
			r.l("</div>");
		}
	}

	///////////////////////
	// compteEmplacement //
	///////////////////////

	/**	L'entité « compteEmplacement »
	 *	 is defined as null before being initialized. 
	 */
	protected String compteEmplacement;
	@JsonIgnore
	public Couverture<String> compteEmplacementCouverture = new Couverture<String>().p(this).c(String.class).var("compteEmplacement").o(compteEmplacement);

	/**	<br/>L'entité « compteEmplacement »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.compte.CompteBancaire&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:compteEmplacement">Trouver l'entité compteEmplacement dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _compteEmplacement(Couverture<String> c);

	public String getCompteEmplacement() {
		return compteEmplacement;
	}

	public void setCompteEmplacement(String compteEmplacement) {
		this.compteEmplacement = compteEmplacement;
		this.compteEmplacementCouverture.dejaInitialise = true;
	}
	protected CompteBancaire compteEmplacementInit() {
		if(!compteEmplacementCouverture.dejaInitialise) {
			_compteEmplacement(compteEmplacementCouverture);
			if(compteEmplacement == null)
				setCompteEmplacement(compteEmplacementCouverture.o);
		}
		compteEmplacementCouverture.dejaInitialise(true);
		return (CompteBancaire)this;
	}

	public String solrCompteEmplacement() {
		return compteEmplacement;
	}

	public String strCompteEmplacement() {
		return compteEmplacement == null ? "" : compteEmplacement;
	}

	public String jsonCompteEmplacement() {
		return compteEmplacement == null ? "" : compteEmplacement;
	}

	public String nomAffichageCompteEmplacement() {
		return "l'emplacement";
	}

	public String htmTooltipCompteEmplacement() {
		return null;
	}

	public String htmCompteEmplacement() {
		return compteEmplacement == null ? "" : StringEscapeUtils.escapeHtml4(strCompteEmplacement());
	}

	public void htmCompteEmplacement(ToutEcrivain r, Boolean patchDroits) {
		if(pk!= null) {
			r.s("<div id=\"patchCompteBancaire", strPk(), "CompteEmplacement\">");
			if(patchDroits) {
				r.l();
				r.l("	<script>//<![CDATA[");
				r.l("		function patchCompteBancaire", strPk(), "CompteEmplacement() {");
				r.l("			$.ajax({");
				r.l("				url: '?fq=pk:", strPk(), "',");
				r.l("				dataType: 'json',");
				r.l("				type: 'patch',");
				r.l("				contentType: 'application/json',");
				r.l("				processData: false,");
				r.l("				success: function( data, textStatus, jQxhr ) {");
				r.l("					");
				r.l("				},");
				r.l("				error: function( jqXhr, textStatus, errorThrown ) {");
				r.l("					");
				r.l("				},");
				r.l("				data: {\"setCompteEmplacement\": this.value },");
				r.l("				");
				r.l("			});");
				r.l("		}");
				r.l("	//]]></script>");
				r.l("	<div class=\"\">");
				r.l("		<label class=\"w3-tooltip \">");
				r.l("			<span>", StringEscapeUtils.escapeHtml4(nomAffichageCompteEmplacement()), "</span>");
				r.s("			<input");
							r.s(" name=\"compteEmplacement\"");
							r.s(" value=\"", htmCompteEmplacement(), "\");");
							r.s(" onchange=\"\"");
							r.l("/>");
				r.l("		</label>");
				r.l("	</div>");
			} else {
				r.s(htmCompteEmplacement());
			}
			r.l("</div>");
		}
	}

	////////////////////
	// compteAddresse //
	////////////////////

	/**	L'entité « compteAddresse »
	 *	 is defined as null before being initialized. 
	 */
	protected String compteAddresse;
	@JsonIgnore
	public Couverture<String> compteAddresseCouverture = new Couverture<String>().p(this).c(String.class).var("compteAddresse").o(compteAddresse);

	/**	<br/>L'entité « compteAddresse »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.compte.CompteBancaire&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:compteAddresse">Trouver l'entité compteAddresse dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _compteAddresse(Couverture<String> c);

	public String getCompteAddresse() {
		return compteAddresse;
	}

	public void setCompteAddresse(String compteAddresse) {
		this.compteAddresse = compteAddresse;
		this.compteAddresseCouverture.dejaInitialise = true;
	}
	protected CompteBancaire compteAddresseInit() {
		if(!compteAddresseCouverture.dejaInitialise) {
			_compteAddresse(compteAddresseCouverture);
			if(compteAddresse == null)
				setCompteAddresse(compteAddresseCouverture.o);
		}
		compteAddresseCouverture.dejaInitialise(true);
		return (CompteBancaire)this;
	}

	public String solrCompteAddresse() {
		return compteAddresse;
	}

	public String strCompteAddresse() {
		return compteAddresse == null ? "" : compteAddresse;
	}

	public String jsonCompteAddresse() {
		return compteAddresse == null ? "" : compteAddresse;
	}

	public String nomAffichageCompteAddresse() {
		return "addresse";
	}

	public String htmTooltipCompteAddresse() {
		return null;
	}

	public String htmCompteAddresse() {
		return compteAddresse == null ? "" : StringEscapeUtils.escapeHtml4(strCompteAddresse());
	}

	public void htmCompteAddresse(ToutEcrivain r, Boolean patchDroits) {
		if(pk!= null) {
			r.s("<div id=\"patchCompteBancaire", strPk(), "CompteAddresse\">");
			if(patchDroits) {
				r.l();
				r.l("	<script>//<![CDATA[");
				r.l("		function patchCompteBancaire", strPk(), "CompteAddresse() {");
				r.l("			$.ajax({");
				r.l("				url: '?fq=pk:", strPk(), "',");
				r.l("				dataType: 'json',");
				r.l("				type: 'patch',");
				r.l("				contentType: 'application/json',");
				r.l("				processData: false,");
				r.l("				success: function( data, textStatus, jQxhr ) {");
				r.l("					");
				r.l("				},");
				r.l("				error: function( jqXhr, textStatus, errorThrown ) {");
				r.l("					");
				r.l("				},");
				r.l("				data: {\"setCompteAddresse\": this.value },");
				r.l("				");
				r.l("			});");
				r.l("		}");
				r.l("	//]]></script>");
				r.l("	<div class=\"\">");
				r.l("		<label class=\"w3-tooltip \">");
				r.l("			<span>", StringEscapeUtils.escapeHtml4(nomAffichageCompteAddresse()), "</span>");
				r.s("			<input");
							r.s(" name=\"compteAddresse\"");
							r.s(" value=\"", htmCompteAddresse(), "\");");
							r.s(" onchange=\"\"");
							r.l("/>");
				r.l("		</label>");
				r.l("	</div>");
			} else {
				r.s(htmCompteAddresse());
			}
			r.l("</div>");
		}
	}

	///////////////////////
	// objetSuggerePoids //
	///////////////////////

	/**	L'entité « objetSuggerePoids »
	 *	 is defined as null before being initialized. 
	 */
	protected Double objetSuggerePoids;
	@JsonIgnore
	public Couverture<Double> objetSuggerePoidsCouverture = new Couverture<Double>().p(this).c(Double.class).var("objetSuggerePoids").o(objetSuggerePoids);

	/**	<br/>L'entité « objetSuggerePoids »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.compte.CompteBancaire&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:objetSuggerePoids">Trouver l'entité objetSuggerePoids dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _objetSuggerePoids(Couverture<Double> c);

	public Double getObjetSuggerePoids() {
		return objetSuggerePoids;
	}

	public void setObjetSuggerePoids(Double objetSuggerePoids) {
		this.objetSuggerePoids = objetSuggerePoids;
		this.objetSuggerePoidsCouverture.dejaInitialise = true;
	}
	public CompteBancaire setObjetSuggerePoids(String o) {
		if(NumberUtils.isParsable(o))
			this.objetSuggerePoids = Double.parseDouble(o);
		this.objetSuggerePoidsCouverture.dejaInitialise = true;
		return (CompteBancaire)this;
	}
	protected CompteBancaire objetSuggerePoidsInit() {
		if(!objetSuggerePoidsCouverture.dejaInitialise) {
			_objetSuggerePoids(objetSuggerePoidsCouverture);
			if(objetSuggerePoids == null)
				setObjetSuggerePoids(objetSuggerePoidsCouverture.o);
		}
		objetSuggerePoidsCouverture.dejaInitialise(true);
		return (CompteBancaire)this;
	}

	public Double solrObjetSuggerePoids() {
		return objetSuggerePoids;
	}

	public String strObjetSuggerePoids() {
		return objetSuggerePoids == null ? "" : objetSuggerePoids.toString();
	}

	public String jsonObjetSuggerePoids() {
		return objetSuggerePoids == null ? "" : objetSuggerePoids.toString();
	}

	public String nomAffichageObjetSuggerePoids() {
		return "NomAffichage.enUS: ";
	}

	public String htmTooltipObjetSuggerePoids() {
		return null;
	}

	public String htmObjetSuggerePoids() {
		return objetSuggerePoids == null ? "" : StringEscapeUtils.escapeHtml4(strObjetSuggerePoids());
	}

	public void htmObjetSuggerePoids(ToutEcrivain r, Boolean patchDroits) {
		if(pk!= null) {
			r.s("<div id=\"patchCompteBancaire", strPk(), "ObjetSuggerePoids\">");
			if(patchDroits) {
				r.l();
				r.l("	<script>//<![CDATA[");
				r.l("		function patchCompteBancaire", strPk(), "ObjetSuggerePoids() {");
				r.l("			$.ajax({");
				r.l("				url: '?fq=pk:", strPk(), "',");
				r.l("				dataType: 'json',");
				r.l("				type: 'patch',");
				r.l("				contentType: 'application/json',");
				r.l("				processData: false,");
				r.l("				success: function( data, textStatus, jQxhr ) {");
				r.l("					");
				r.l("				},");
				r.l("				error: function( jqXhr, textStatus, errorThrown ) {");
				r.l("					");
				r.l("				},");
				r.l("				data: {\"setObjetSuggerePoids\": this.value },");
				r.l("				");
				r.l("			});");
				r.l("		}");
				r.l("	//]]></script>");
				r.l("	<div class=\"\">");
				r.l("		<label class=\"w3-tooltip \">");
				r.l("			<span>", StringEscapeUtils.escapeHtml4(nomAffichageObjetSuggerePoids()), "</span>");
				r.s("			<input");
							r.s(" name=\"objetSuggerePoids\"");
							r.s(" value=\"", htmObjetSuggerePoids(), "\");");
							r.s(" onchange=\"\"");
							r.l("/>");
				r.l("		</label>");
				r.l("	</div>");
			} else {
				r.s(htmObjetSuggerePoids());
			}
			r.l("</div>");
		}
	}

	//////////////////
	// objetSuggere //
	//////////////////

	/**	L'entité « objetSuggere »
	 *	 is defined as null before being initialized. 
	 */
	protected String objetSuggere;
	@JsonIgnore
	public Couverture<String> objetSuggereCouverture = new Couverture<String>().p(this).c(String.class).var("objetSuggere").o(objetSuggere);

	/**	<br/>L'entité « objetSuggere »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.compte.CompteBancaire&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:objetSuggere">Trouver l'entité objetSuggere dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _objetSuggere(Couverture<String> c);

	public String getObjetSuggere() {
		return objetSuggere;
	}

	public void setObjetSuggere(String objetSuggere) {
		this.objetSuggere = objetSuggere;
		this.objetSuggereCouverture.dejaInitialise = true;
	}
	protected CompteBancaire objetSuggereInit() {
		if(!objetSuggereCouverture.dejaInitialise) {
			_objetSuggere(objetSuggereCouverture);
			if(objetSuggere == null)
				setObjetSuggere(objetSuggereCouverture.o);
		}
		objetSuggereCouverture.dejaInitialise(true);
		return (CompteBancaire)this;
	}

	public String solrObjetSuggere() {
		return objetSuggere;
	}

	public String strObjetSuggere() {
		return objetSuggere == null ? "" : objetSuggere;
	}

	public String jsonObjetSuggere() {
		return objetSuggere == null ? "" : objetSuggere;
	}

	public String nomAffichageObjetSuggere() {
		return "NomAffichage.enUS: ";
	}

	public String htmTooltipObjetSuggere() {
		return null;
	}

	public String htmObjetSuggere() {
		return objetSuggere == null ? "" : StringEscapeUtils.escapeHtml4(strObjetSuggere());
	}

	public void htmObjetSuggere(ToutEcrivain r, Boolean patchDroits) {
		if(pk!= null) {
			r.s("<div id=\"patchCompteBancaire", strPk(), "ObjetSuggere\">");
			if(patchDroits) {
				r.l();
				r.l("	<script>//<![CDATA[");
				r.l("		function patchCompteBancaire", strPk(), "ObjetSuggere() {");
				r.l("			$.ajax({");
				r.l("				url: '?fq=pk:", strPk(), "',");
				r.l("				dataType: 'json',");
				r.l("				type: 'patch',");
				r.l("				contentType: 'application/json',");
				r.l("				processData: false,");
				r.l("				success: function( data, textStatus, jQxhr ) {");
				r.l("					");
				r.l("				},");
				r.l("				error: function( jqXhr, textStatus, errorThrown ) {");
				r.l("					");
				r.l("				},");
				r.l("				data: {\"setObjetSuggere\": this.value },");
				r.l("				");
				r.l("			});");
				r.l("		}");
				r.l("	//]]></script>");
				r.l("	<div class=\"\">");
				r.l("		<label class=\"w3-tooltip \">");
				r.l("			<span>", StringEscapeUtils.escapeHtml4(nomAffichageObjetSuggere()), "</span>");
				r.s("			<input");
							r.s(" name=\"objetSuggere\"");
							r.s(" value=\"", htmObjetSuggere(), "\");");
							r.s(" onchange=\"\"");
							r.l("/>");
				r.l("		</label>");
				r.l("	</div>");
			} else {
				r.s(htmObjetSuggere());
			}
			r.l("</div>");
		}
	}

	///////////////////////
	// compteNumeroCourt //
	///////////////////////

	/**	L'entité « compteNumeroCourt »
	 *	 is defined as null before being initialized. 
	 */
	protected String compteNumeroCourt;
	@JsonIgnore
	public Couverture<String> compteNumeroCourtCouverture = new Couverture<String>().p(this).c(String.class).var("compteNumeroCourt").o(compteNumeroCourt);

	/**	<br/>L'entité « compteNumeroCourt »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.compte.CompteBancaire&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:compteNumeroCourt">Trouver l'entité compteNumeroCourt dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _compteNumeroCourt(Couverture<String> c);

	public String getCompteNumeroCourt() {
		return compteNumeroCourt;
	}

	public void setCompteNumeroCourt(String compteNumeroCourt) {
		this.compteNumeroCourt = compteNumeroCourt;
		this.compteNumeroCourtCouverture.dejaInitialise = true;
	}
	protected CompteBancaire compteNumeroCourtInit() {
		if(!compteNumeroCourtCouverture.dejaInitialise) {
			_compteNumeroCourt(compteNumeroCourtCouverture);
			if(compteNumeroCourt == null)
				setCompteNumeroCourt(compteNumeroCourtCouverture.o);
		}
		compteNumeroCourtCouverture.dejaInitialise(true);
		return (CompteBancaire)this;
	}

	public String solrCompteNumeroCourt() {
		return compteNumeroCourt;
	}

	public String strCompteNumeroCourt() {
		return compteNumeroCourt == null ? "" : compteNumeroCourt;
	}

	public String jsonCompteNumeroCourt() {
		return compteNumeroCourt == null ? "" : compteNumeroCourt;
	}

	public String nomAffichageCompteNumeroCourt() {
		return "NomAffichage.enUS: ";
	}

	public String htmTooltipCompteNumeroCourt() {
		return null;
	}

	public String htmCompteNumeroCourt() {
		return compteNumeroCourt == null ? "" : StringEscapeUtils.escapeHtml4(strCompteNumeroCourt());
	}

	public void htmCompteNumeroCourt(ToutEcrivain r, Boolean patchDroits) {
		if(pk!= null) {
			r.s("<div id=\"patchCompteBancaire", strPk(), "CompteNumeroCourt\">");
			if(patchDroits) {
				r.l();
				r.l("	<script>//<![CDATA[");
				r.l("		function patchCompteBancaire", strPk(), "CompteNumeroCourt() {");
				r.l("			$.ajax({");
				r.l("				url: '?fq=pk:", strPk(), "',");
				r.l("				dataType: 'json',");
				r.l("				type: 'patch',");
				r.l("				contentType: 'application/json',");
				r.l("				processData: false,");
				r.l("				success: function( data, textStatus, jQxhr ) {");
				r.l("					");
				r.l("				},");
				r.l("				error: function( jqXhr, textStatus, errorThrown ) {");
				r.l("					");
				r.l("				},");
				r.l("				data: {\"setCompteNumeroCourt\": this.value },");
				r.l("				");
				r.l("			});");
				r.l("		}");
				r.l("	//]]></script>");
				r.l("	<div class=\"\">");
				r.l("		<label class=\"w3-tooltip \">");
				r.l("			<span>", StringEscapeUtils.escapeHtml4(nomAffichageCompteNumeroCourt()), "</span>");
				r.s("			<input");
							r.s(" name=\"compteNumeroCourt\"");
							r.s(" value=\"", htmCompteNumeroCourt(), "\");");
							r.s(" onchange=\"\"");
							r.l("/>");
				r.l("		</label>");
				r.l("	</div>");
			} else {
				r.s(htmCompteNumeroCourt());
			}
			r.l("</div>");
		}
	}

	//////////////////////
	// compteNomComplet //
	//////////////////////

	/**	L'entité « compteNomComplet »
	 *	 is defined as null before being initialized. 
	 */
	protected String compteNomComplet;
	@JsonIgnore
	public Couverture<String> compteNomCompletCouverture = new Couverture<String>().p(this).c(String.class).var("compteNomComplet").o(compteNomComplet);

	/**	<br/>L'entité « compteNomComplet »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.compte.CompteBancaire&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:compteNomComplet">Trouver l'entité compteNomComplet dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _compteNomComplet(Couverture<String> c);

	public String getCompteNomComplet() {
		return compteNomComplet;
	}

	public void setCompteNomComplet(String compteNomComplet) {
		this.compteNomComplet = compteNomComplet;
		this.compteNomCompletCouverture.dejaInitialise = true;
	}
	protected CompteBancaire compteNomCompletInit() {
		if(!compteNomCompletCouverture.dejaInitialise) {
			_compteNomComplet(compteNomCompletCouverture);
			if(compteNomComplet == null)
				setCompteNomComplet(compteNomCompletCouverture.o);
		}
		compteNomCompletCouverture.dejaInitialise(true);
		return (CompteBancaire)this;
	}

	public String solrCompteNomComplet() {
		return compteNomComplet;
	}

	public String strCompteNomComplet() {
		return compteNomComplet == null ? "" : compteNomComplet;
	}

	public String jsonCompteNomComplet() {
		return compteNomComplet == null ? "" : compteNomComplet;
	}

	public String nomAffichageCompteNomComplet() {
		return "nom";
	}

	public String htmTooltipCompteNomComplet() {
		return null;
	}

	public String htmCompteNomComplet() {
		return compteNomComplet == null ? "" : StringEscapeUtils.escapeHtml4(strCompteNomComplet());
	}

	public void htmCompteNomComplet(ToutEcrivain r, Boolean patchDroits) {
		if(pk!= null) {
			r.s("<div id=\"patchCompteBancaire", strPk(), "CompteNomComplet\">");
			if(patchDroits) {
				r.l();
				r.l("	<script>//<![CDATA[");
				r.l("		function patchCompteBancaire", strPk(), "CompteNomComplet() {");
				r.l("			$.ajax({");
				r.l("				url: '?fq=pk:", strPk(), "',");
				r.l("				dataType: 'json',");
				r.l("				type: 'patch',");
				r.l("				contentType: 'application/json',");
				r.l("				processData: false,");
				r.l("				success: function( data, textStatus, jQxhr ) {");
				r.l("					");
				r.l("				},");
				r.l("				error: function( jqXhr, textStatus, errorThrown ) {");
				r.l("					");
				r.l("				},");
				r.l("				data: {\"setCompteNomComplet\": this.value },");
				r.l("				");
				r.l("			});");
				r.l("		}");
				r.l("	//]]></script>");
				r.l("	<div class=\"\">");
				r.l("		<label class=\"w3-tooltip \">");
				r.l("			<span>", StringEscapeUtils.escapeHtml4(nomAffichageCompteNomComplet()), "</span>");
				r.s("			<input");
							r.s(" name=\"compteNomComplet\"");
							r.s(" value=\"", htmCompteNomComplet(), "\");");
							r.s(" onchange=\"\"");
							r.l("/>");
				r.l("		</label>");
				r.l("	</div>");
			} else {
				r.s(htmCompteNomComplet());
			}
			r.l("</div>");
		}
	}

	//////////////
	// compteId //
	//////////////

	/**	L'entité « compteId »
	 *	 is defined as null before being initialized. 
	 */
	protected String compteId;
	@JsonIgnore
	public Couverture<String> compteIdCouverture = new Couverture<String>().p(this).c(String.class).var("compteId").o(compteId);

	/**	<br/>L'entité « compteId »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.compte.CompteBancaire&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:compteId">Trouver l'entité compteId dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _compteId(Couverture<String> c);

	public String getCompteId() {
		return compteId;
	}

	public void setCompteId(String compteId) {
		this.compteId = compteId;
		this.compteIdCouverture.dejaInitialise = true;
	}
	protected CompteBancaire compteIdInit() {
		if(!compteIdCouverture.dejaInitialise) {
			_compteId(compteIdCouverture);
			if(compteId == null)
				setCompteId(compteIdCouverture.o);
		}
		compteIdCouverture.dejaInitialise(true);
		return (CompteBancaire)this;
	}

	public String solrCompteId() {
		return compteId;
	}

	public String strCompteId() {
		return compteId == null ? "" : compteId;
	}

	public String jsonCompteId() {
		return compteId == null ? "" : compteId;
	}

	public String nomAffichageCompteId() {
		return "ID";
	}

	public String htmTooltipCompteId() {
		return null;
	}

	public String htmCompteId() {
		return compteId == null ? "" : StringEscapeUtils.escapeHtml4(strCompteId());
	}

	public void htmCompteId(ToutEcrivain r, Boolean patchDroits) {
		if(pk!= null) {
			r.s("<div id=\"patchCompteBancaire", strPk(), "CompteId\">");
			if(patchDroits) {
				r.l();
				r.l("	<script>//<![CDATA[");
				r.l("		function patchCompteBancaire", strPk(), "CompteId() {");
				r.l("			$.ajax({");
				r.l("				url: '?fq=pk:", strPk(), "',");
				r.l("				dataType: 'json',");
				r.l("				type: 'patch',");
				r.l("				contentType: 'application/json',");
				r.l("				processData: false,");
				r.l("				success: function( data, textStatus, jQxhr ) {");
				r.l("					");
				r.l("				},");
				r.l("				error: function( jqXhr, textStatus, errorThrown ) {");
				r.l("					");
				r.l("				},");
				r.l("				data: {\"setCompteId\": this.value },");
				r.l("				");
				r.l("			});");
				r.l("		}");
				r.l("	//]]></script>");
				r.l("	<div class=\"\">");
				r.l("		<label class=\"w3-tooltip \">");
				r.l("			<span>", StringEscapeUtils.escapeHtml4(nomAffichageCompteId()), "</span>");
				r.s("			<input");
							r.s(" name=\"compteId\"");
							r.s(" value=\"", htmCompteId(), "\");");
							r.s(" onchange=\"\"");
							r.l("/>");
				r.l("		</label>");
				r.l("	</div>");
			} else {
				r.s(htmCompteId());
			}
			r.l("</div>");
		}
	}

	/////////////
	// pageUrl //
	/////////////

	/**	L'entité « pageUrl »
	 *	 is defined as null before being initialized. 
	 */
	protected String pageUrl;
	@JsonIgnore
	public Couverture<String> pageUrlCouverture = new Couverture<String>().p(this).c(String.class).var("pageUrl").o(pageUrl);

	/**	<br/>L'entité « pageUrl »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.compte.CompteBancaire&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:pageUrl">Trouver l'entité pageUrl dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _pageUrl(Couverture<String> c);

	public String getPageUrl() {
		return pageUrl;
	}

	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
		this.pageUrlCouverture.dejaInitialise = true;
	}
	protected CompteBancaire pageUrlInit() {
		if(!pageUrlCouverture.dejaInitialise) {
			_pageUrl(pageUrlCouverture);
			if(pageUrl == null)
				setPageUrl(pageUrlCouverture.o);
		}
		pageUrlCouverture.dejaInitialise(true);
		return (CompteBancaire)this;
	}

	public String solrPageUrl() {
		return pageUrl;
	}

	public String strPageUrl() {
		return pageUrl == null ? "" : pageUrl;
	}

	public String jsonPageUrl() {
		return pageUrl == null ? "" : pageUrl;
	}

	public String nomAffichagePageUrl() {
		return null;
	}

	public String htmTooltipPageUrl() {
		return null;
	}

	public String htmPageUrl() {
		return pageUrl == null ? "" : StringEscapeUtils.escapeHtml4(strPageUrl());
	}

	public void htmPageUrl(ToutEcrivain r, Boolean patchDroits) {
		if(pk!= null) {
			r.s("<div id=\"patchCompteBancaire", strPk(), "PageUrl\">");
			if(patchDroits) {
				r.l();
				r.l("	<script>//<![CDATA[");
				r.l("		function patchCompteBancaire", strPk(), "PageUrl() {");
				r.l("			$.ajax({");
				r.l("				url: '?fq=pk:", strPk(), "',");
				r.l("				dataType: 'json',");
				r.l("				type: 'patch',");
				r.l("				contentType: 'application/json',");
				r.l("				processData: false,");
				r.l("				success: function( data, textStatus, jQxhr ) {");
				r.l("					");
				r.l("				},");
				r.l("				error: function( jqXhr, textStatus, errorThrown ) {");
				r.l("					");
				r.l("				},");
				r.l("				data: {\"setPageUrl\": this.value },");
				r.l("				");
				r.l("			});");
				r.l("		}");
				r.l("	//]]></script>");
				r.l("	<div class=\"\">");
				r.l("		<label class=\"w3-tooltip \">");
				r.l("			<span>", StringEscapeUtils.escapeHtml4(nomAffichagePageUrl()), "</span>");
				r.s("			<input");
							r.s(" name=\"pageUrl\"");
							r.s(" value=\"", htmPageUrl(), "\");");
							r.s(" onchange=\"\"");
							r.l("/>");
				r.l("		</label>");
				r.l("	</div>");
			} else {
				r.s(htmPageUrl());
			}
			r.l("</div>");
		}
	}

	////////////
	// pageH1 //
	////////////

	/**	L'entité « pageH1 »
	 *	 is defined as null before being initialized. 
	 */
	protected String pageH1;
	@JsonIgnore
	public Couverture<String> pageH1Couverture = new Couverture<String>().p(this).c(String.class).var("pageH1").o(pageH1);

	/**	<br/>L'entité « pageH1 »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.compte.CompteBancaire&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:pageH1">Trouver l'entité pageH1 dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _pageH1(Couverture<String> c);

	public String getPageH1() {
		return pageH1;
	}

	public void setPageH1(String pageH1) {
		this.pageH1 = pageH1;
		this.pageH1Couverture.dejaInitialise = true;
	}
	protected CompteBancaire pageH1Init() {
		if(!pageH1Couverture.dejaInitialise) {
			_pageH1(pageH1Couverture);
			if(pageH1 == null)
				setPageH1(pageH1Couverture.o);
		}
		pageH1Couverture.dejaInitialise(true);
		return (CompteBancaire)this;
	}

	public String solrPageH1() {
		return pageH1;
	}

	public String strPageH1() {
		return pageH1 == null ? "" : pageH1;
	}

	public String jsonPageH1() {
		return pageH1 == null ? "" : pageH1;
	}

	public String nomAffichagePageH1() {
		return null;
	}

	public String htmTooltipPageH1() {
		return null;
	}

	public String htmPageH1() {
		return pageH1 == null ? "" : StringEscapeUtils.escapeHtml4(strPageH1());
	}

	public void htmPageH1(ToutEcrivain r, Boolean patchDroits) {
		if(pk!= null) {
			r.s("<div id=\"patchCompteBancaire", strPk(), "PageH1\">");
			if(patchDroits) {
				r.l();
				r.l("	<script>//<![CDATA[");
				r.l("		function patchCompteBancaire", strPk(), "PageH1() {");
				r.l("			$.ajax({");
				r.l("				url: '?fq=pk:", strPk(), "',");
				r.l("				dataType: 'json',");
				r.l("				type: 'patch',");
				r.l("				contentType: 'application/json',");
				r.l("				processData: false,");
				r.l("				success: function( data, textStatus, jQxhr ) {");
				r.l("					");
				r.l("				},");
				r.l("				error: function( jqXhr, textStatus, errorThrown ) {");
				r.l("					");
				r.l("				},");
				r.l("				data: {\"setPageH1\": this.value },");
				r.l("				");
				r.l("			});");
				r.l("		}");
				r.l("	//]]></script>");
				r.l("	<div class=\"\">");
				r.l("		<label class=\"w3-tooltip \">");
				r.l("			<span>", StringEscapeUtils.escapeHtml4(nomAffichagePageH1()), "</span>");
				r.s("			<input");
							r.s(" name=\"pageH1\"");
							r.s(" value=\"", htmPageH1(), "\");");
							r.s(" onchange=\"\"");
							r.l("/>");
				r.l("		</label>");
				r.l("	</div>");
			} else {
				r.s(htmPageH1());
			}
			r.l("</div>");
		}
	}

	//////////////
	// initLoin //
	//////////////

	protected boolean dejaInitialiseCompteBancaire = false;

	public CompteBancaire initLoinCompteBancaire(RequeteSiteFrFR requeteSite_) {
		setRequeteSite_(requeteSite_);
		if(!dejaInitialiseCompteBancaire) {
			dejaInitialiseCompteBancaire = true;
			initLoinCompteBancaire();
		}
		return (CompteBancaire)this;
	}

	public void initLoinCompteBancaire() {
		super.initLoinCluster(requeteSite_);
		initCompteBancaire();
	}

	public void initCompteBancaire() {
		compteCleInit();
		transactionClesInit();
		compteNumeroInit();
		compteNumeroTelephoneInit();
		compteAdministrateurNomInit();
		compteEmplacementInit();
		compteAddresseInit();
		objetSuggerePoidsInit();
		objetSuggereInit();
		compteNumeroCourtInit();
		compteNomCompletInit();
		compteIdInit();
		pageUrlInit();
		pageH1Init();
	}

	@Override public void initLoinPourClasse(RequeteSiteFrFR requeteSite_) {
		initLoinCompteBancaire(requeteSite_);
	}

	/////////////////
	// requeteSite //
	/////////////////

	public void requeteSiteCompteBancaire(RequeteSiteFrFR requeteSite_) {
			super.requeteSiteCluster(requeteSite_);
	}

	public void requeteSitePourClasse(RequeteSiteFrFR requeteSite_) {
		requeteSiteCompteBancaire(requeteSite_);
	}

	/////////////
	// obtenir //
	/////////////

	@Override public Object obtenirPourClasse(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtenirCompteBancaire(v);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.obtenirPourClasse(v);
			}
		}
		return o;
	}
	public Object obtenirCompteBancaire(String var) {
		CompteBancaire oCompteBancaire = (CompteBancaire)this;
		switch(var) {
			case "compteCle":
				return oCompteBancaire.compteCle;
			case "transactionCles":
				return oCompteBancaire.transactionCles;
			case "compteNumero":
				return oCompteBancaire.compteNumero;
			case "compteNumeroTelephone":
				return oCompteBancaire.compteNumeroTelephone;
			case "compteAdministrateurNom":
				return oCompteBancaire.compteAdministrateurNom;
			case "compteEmplacement":
				return oCompteBancaire.compteEmplacement;
			case "compteAddresse":
				return oCompteBancaire.compteAddresse;
			case "objetSuggerePoids":
				return oCompteBancaire.objetSuggerePoids;
			case "objetSuggere":
				return oCompteBancaire.objetSuggere;
			case "compteNumeroCourt":
				return oCompteBancaire.compteNumeroCourt;
			case "compteNomComplet":
				return oCompteBancaire.compteNomComplet;
			case "compteId":
				return oCompteBancaire.compteId;
			case "pageUrl":
				return oCompteBancaire.pageUrl;
			case "pageH1":
				return oCompteBancaire.pageH1;
			default:
				return super.obtenirCluster(var);
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
				o = attribuerCompteBancaire(v, val);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.attribuerPourClasse(v, val);
			}
		}
		return o != null;
	}
	public Object attribuerCompteBancaire(String var, Object val) {
		CompteBancaire oCompteBancaire = (CompteBancaire)this;
		switch(var) {
			default:
				return super.attribuerCluster(var, val);
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
					o = definirCompteBancaire(v, val);
				else if(o instanceof Cluster) {
					Cluster cluster = (Cluster)o;
					o = cluster.definirPourClasse(v, val);
				}
			}
		}
		return o != null;
	}
	public Object definirCompteBancaire(String var, String val) {
		switch(var) {
			case "compteNumero":
				setCompteNumero(val);
				sauvegardesCompteBancaire.add(var);
				return val;
			case "compteNumeroTelephone":
				setCompteNumeroTelephone(val);
				sauvegardesCompteBancaire.add(var);
				return val;
			case "compteAdministrateurNom":
				setCompteAdministrateurNom(val);
				sauvegardesCompteBancaire.add(var);
				return val;
			case "compteEmplacement":
				setCompteEmplacement(val);
				sauvegardesCompteBancaire.add(var);
				return val;
			case "compteAddresse":
				setCompteAddresse(val);
				sauvegardesCompteBancaire.add(var);
				return val;
			default:
				return super.definirCluster(var, val);
		}
	}

	/////////////////
	// sauvegardes //
	/////////////////

	protected List<String> sauvegardesCompteBancaire = new ArrayList<String>();

	/////////////
	// peupler //
	/////////////

	@Override public void peuplerPourClasse(SolrDocument solrDocument) {
		peuplerCompteBancaire(solrDocument);
	}
	public void peuplerCompteBancaire(SolrDocument solrDocument) {
		CompteBancaire oCompteBancaire = (CompteBancaire)this;
		sauvegardesCompteBancaire = (List<String>)solrDocument.get("sauvegardesCompteBancaire_stored_strings");
		if(sauvegardesCompteBancaire != null) {

			if(sauvegardesCompteBancaire.contains("compteCle")) {
				Long compteCle = (Long)solrDocument.get("compteCle_stored_long");
				if(compteCle != null)
					oCompteBancaire.setCompteCle(compteCle);
			}

			if(sauvegardesCompteBancaire.contains("transactionCles")) {
				List<Long> transactionCles = (List<Long>)solrDocument.get("transactionCles_stored_longs");
				if(transactionCles != null)
					oCompteBancaire.transactionCles.addAll(transactionCles);
			}

			if(sauvegardesCompteBancaire.contains("compteNumero")) {
				String compteNumero = (String)solrDocument.get("compteNumero_stored_string");
				if(compteNumero != null)
					oCompteBancaire.setCompteNumero(compteNumero);
			}

			if(sauvegardesCompteBancaire.contains("compteNumeroTelephone")) {
				String compteNumeroTelephone = (String)solrDocument.get("compteNumeroTelephone_stored_string");
				if(compteNumeroTelephone != null)
					oCompteBancaire.setCompteNumeroTelephone(compteNumeroTelephone);
			}

			if(sauvegardesCompteBancaire.contains("compteAdministrateurNom")) {
				String compteAdministrateurNom = (String)solrDocument.get("compteAdministrateurNom_stored_string");
				if(compteAdministrateurNom != null)
					oCompteBancaire.setCompteAdministrateurNom(compteAdministrateurNom);
			}

			if(sauvegardesCompteBancaire.contains("compteEmplacement")) {
				String compteEmplacement = (String)solrDocument.get("compteEmplacement_stored_string");
				if(compteEmplacement != null)
					oCompteBancaire.setCompteEmplacement(compteEmplacement);
			}

			if(sauvegardesCompteBancaire.contains("compteAddresse")) {
				String compteAddresse = (String)solrDocument.get("compteAddresse_stored_string");
				if(compteAddresse != null)
					oCompteBancaire.setCompteAddresse(compteAddresse);
			}

			if(sauvegardesCompteBancaire.contains("objetSuggere")) {
				String objetSuggere = (String)solrDocument.get("objetSuggere_suggested");
				oCompteBancaire.setObjetSuggere(objetSuggere);
			}

			if(sauvegardesCompteBancaire.contains("compteNumeroCourt")) {
				String compteNumeroCourt = (String)solrDocument.get("compteNumeroCourt_stored_string");
				if(compteNumeroCourt != null)
					oCompteBancaire.setCompteNumeroCourt(compteNumeroCourt);
			}

			if(sauvegardesCompteBancaire.contains("compteNomComplet")) {
				String compteNomComplet = (String)solrDocument.get("compteNomComplet_stored_string");
				if(compteNomComplet != null)
					oCompteBancaire.setCompteNomComplet(compteNomComplet);
			}

			if(sauvegardesCompteBancaire.contains("compteId")) {
				String compteId = (String)solrDocument.get("compteId_stored_string");
				if(compteId != null)
					oCompteBancaire.setCompteId(compteId);
			}

			if(sauvegardesCompteBancaire.contains("pageUrl")) {
				String pageUrl = (String)solrDocument.get("pageUrl_stored_string");
				if(pageUrl != null)
					oCompteBancaire.setPageUrl(pageUrl);
			}
		}

		super.peuplerCluster(solrDocument);
	}

	/////////////
	// indexer //
	/////////////

	public static void indexer() {
		try {
			RequeteSiteFrFR requeteSite = new RequeteSiteFrFR();
			requeteSite.initLoinRequeteSiteFrFR();
			SiteContexteFrFR siteContexte = new SiteContexteFrFR();
			siteContexte.getConfigSite().setConfigChemin("/usr/local/src/computate-bancaire/computate-bancaire-commun/config/computate-bancaire-commun.config");
			siteContexte.initLoinSiteContexteFrFR();
			requeteSite.setSiteContexte_(siteContexte);
			requeteSite.setConfigSite_(siteContexte.getConfigSite());
			SolrQuery rechercheSolr = new SolrQuery();
			rechercheSolr.setQuery("*:*");
			rechercheSolr.setRows(1);
			rechercheSolr.addFilterQuery("id:" + ClientUtils.escapeQueryChars("org.computate.bancaire.frfr.compte.CompteBancaire"));
			QueryResponse reponseRecherche = requeteSite.getSiteContexte_().getClientSolr().query(rechercheSolr);
			if(reponseRecherche.getResults().size() > 0)
				requeteSite.setDocumentSolr(reponseRecherche.getResults().get(0));
			CompteBancaire o = new CompteBancaire();
			o.requeteSiteCompteBancaire(requeteSite);
			o.initLoinCompteBancaire(requeteSite);
			o.indexerCompteBancaire();
		} catch(Exception e) {
			ExceptionUtils.rethrow(e);
		}
	}


	@Override public void indexerPourClasse() {
		indexerCompteBancaire();
	}

	@Override public void indexerPourClasse(SolrInputDocument document) {
		indexerCompteBancaire(document);
	}

	public void indexerCompteBancaire(SolrClient clientSolr) {
		try {
			SolrInputDocument document = new SolrInputDocument();
			indexerCompteBancaire(document);
			clientSolr.add(document);
			clientSolr.commit();
		} catch(Exception e) {
			ExceptionUtils.rethrow(e);
		}
	}

	public void indexerCompteBancaire() {
		try {
			SolrInputDocument document = new SolrInputDocument();
			indexerCompteBancaire(document);
			SolrClient clientSolr = requeteSite_.getSiteContexte_().getClientSolr();
			clientSolr.add(document);
			clientSolr.commit();
		} catch(Exception e) {
			ExceptionUtils.rethrow(e);
		}
	}

	public void indexerCompteBancaire(SolrInputDocument document) {
		if(sauvegardesCompteBancaire != null)
			document.addField("sauvegardesCompteBancaire_stored_strings", sauvegardesCompteBancaire);

		if(compteCle != null) {
			document.addField("compteCle_indexed_long", compteCle);
			document.addField("compteCle_stored_long", compteCle);
		}
		if(transactionCles != null) {
			for(java.lang.Long o : transactionCles) {
				document.addField("transactionCles_indexed_longs", o);
			}
			for(java.lang.Long o : transactionCles) {
				document.addField("transactionCles_stored_longs", o);
			}
		}
		if(compteNumero != null) {
			document.addField("compteNumero_indexed_string", compteNumero);
			document.addField("compteNumero_stored_string", compteNumero);
		}
		if(compteNumeroTelephone != null) {
			document.addField("compteNumeroTelephone_indexed_string", compteNumeroTelephone);
			document.addField("compteNumeroTelephone_stored_string", compteNumeroTelephone);
		}
		if(compteAdministrateurNom != null) {
			document.addField("compteAdministrateurNom_indexed_string", compteAdministrateurNom);
			document.addField("compteAdministrateurNom_stored_string", compteAdministrateurNom);
		}
		if(compteEmplacement != null) {
			document.addField("compteEmplacement_indexed_string", compteEmplacement);
			document.addField("compteEmplacement_stored_string", compteEmplacement);
		}
		if(compteAddresse != null) {
			document.addField("compteAddresse_indexed_string", compteAddresse);
			document.addField("compteAddresse_stored_string", compteAddresse);
		}
		if(objetSuggere != null) {
			document.addField("objetSuggere_suggested", objetSuggere);
			document.addField("objetSuggere_indexed_string", objetSuggere);
		}
		if(compteNumeroCourt != null) {
			document.addField("compteNumeroCourt_indexed_string", compteNumeroCourt);
			document.addField("compteNumeroCourt_stored_string", compteNumeroCourt);
		}
		if(compteNomComplet != null) {
			document.addField("compteNomComplet_indexed_string", compteNomComplet);
			document.addField("compteNomComplet_stored_string", compteNomComplet);
		}
		if(compteId != null) {
			document.addField("compteId_indexed_string", compteId);
			document.addField("compteId_stored_string", compteId);
		}
		if(pageUrl != null) {
			document.addField("pageUrl_indexed_string", pageUrl);
			document.addField("pageUrl_stored_string", pageUrl);
		}
		super.indexerCluster(document);

	}

	public void desindexerCompteBancaire() {
		try {
		RequeteSiteFrFR requeteSite = new RequeteSiteFrFR();
			requeteSite.initLoinRequeteSiteFrFR();
			SiteContexteFrFR siteContexte = new SiteContexteFrFR();
			siteContexte.initLoinSiteContexteFrFR();
			requeteSite.setSiteContexte_(siteContexte);
			requeteSite.setConfigSite_(siteContexte.getConfigSite());
			initLoinCompteBancaire(requeteSite);
			SolrClient clientSolr = siteContexte.getClientSolr();
			clientSolr.deleteById(id.toString());
			clientSolr.commit();
		} catch(Exception e) {
			ExceptionUtils.rethrow(e);
		}
	}

	/////////////
	// stocker //
	/////////////

	@Override public void stockerPourClasse(SolrDocument solrDocument) {
		stockerCompteBancaire(solrDocument);
	}
	public void stockerCompteBancaire(SolrDocument solrDocument) {
		CompteBancaire oCompteBancaire = (CompteBancaire)this;

		Long compteCle = (Long)solrDocument.get("compteCle_stored_long");
		if(compteCle != null)
			oCompteBancaire.setCompteCle(compteCle);

		List<Long> transactionCles = (List<Long>)solrDocument.get("transactionCles_stored_longs");
		if(transactionCles != null)
			oCompteBancaire.transactionCles.addAll(transactionCles);

		String compteNumero = (String)solrDocument.get("compteNumero_stored_string");
		if(compteNumero != null)
			oCompteBancaire.setCompteNumero(compteNumero);

		String compteNumeroTelephone = (String)solrDocument.get("compteNumeroTelephone_stored_string");
		if(compteNumeroTelephone != null)
			oCompteBancaire.setCompteNumeroTelephone(compteNumeroTelephone);

		String compteAdministrateurNom = (String)solrDocument.get("compteAdministrateurNom_stored_string");
		if(compteAdministrateurNom != null)
			oCompteBancaire.setCompteAdministrateurNom(compteAdministrateurNom);

		String compteEmplacement = (String)solrDocument.get("compteEmplacement_stored_string");
		if(compteEmplacement != null)
			oCompteBancaire.setCompteEmplacement(compteEmplacement);

		String compteAddresse = (String)solrDocument.get("compteAddresse_stored_string");
		if(compteAddresse != null)
			oCompteBancaire.setCompteAddresse(compteAddresse);

		String objetSuggere = (String)solrDocument.get("objetSuggere_suggested");
		oCompteBancaire.setObjetSuggere(objetSuggere);

		String compteNumeroCourt = (String)solrDocument.get("compteNumeroCourt_stored_string");
		if(compteNumeroCourt != null)
			oCompteBancaire.setCompteNumeroCourt(compteNumeroCourt);

		String compteNomComplet = (String)solrDocument.get("compteNomComplet_stored_string");
		if(compteNomComplet != null)
			oCompteBancaire.setCompteNomComplet(compteNomComplet);

		String compteId = (String)solrDocument.get("compteId_stored_string");
		if(compteId != null)
			oCompteBancaire.setCompteId(compteId);

		String pageUrl = (String)solrDocument.get("pageUrl_stored_string");
		if(pageUrl != null)
			oCompteBancaire.setPageUrl(pageUrl);

		super.stockerCluster(solrDocument);
	}

	//////////////
	// htmlBody //
	//////////////

	public void htmlBody() {
		htmlBodyCompteBancaire();
	}

	public void htmlBodyCompteBancaire() {
	}

	//////////////
	// hashCode //
	//////////////

	@Override public int hashCode() {
		return Objects.hash(super.hashCode(), compteNumero, compteNumeroTelephone, compteAdministrateurNom, compteEmplacement, compteAddresse);
	}

	////////////
	// equals //
	////////////

	@Override public boolean equals(Object o) {
		if(this == o)
			return true;
		if(!(o instanceof CompteBancaire))
			return false;
		CompteBancaire that = (CompteBancaire)o;
		return super.equals(o)
				&& Objects.equals( compteNumero, that.compteNumero )
				&& Objects.equals( compteNumeroTelephone, that.compteNumeroTelephone )
				&& Objects.equals( compteAdministrateurNom, that.compteAdministrateurNom )
				&& Objects.equals( compteEmplacement, that.compteEmplacement )
				&& Objects.equals( compteAddresse, that.compteAddresse );
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString() + "\n");
		sb.append("CompteBancaire { ");
		sb.append( "compteNumero: \"" ).append(compteNumero).append( "\"" );
		sb.append( ", compteNumeroTelephone: \"" ).append(compteNumeroTelephone).append( "\"" );
		sb.append( ", compteAdministrateurNom: \"" ).append(compteAdministrateurNom).append( "\"" );
		sb.append( ", compteEmplacement: \"" ).append(compteEmplacement).append( "\"" );
		sb.append( ", compteAddresse: \"" ).append(compteAddresse).append( "\"" );
		sb.append(" }");
		return sb.toString();
	}
}
