package org.computate.bancaire.frfr.ajustement;

import java.util.Date;
import java.time.ZonedDateTime;
import java.time.LocalDateTime;
import org.apache.commons.lang3.StringUtils;
import org.computate.bancaire.frfr.requete.RequeteSiteFrFR;
import io.vertx.core.logging.LoggerFactory;
import java.text.NumberFormat;
import org.computate.bancaire.frfr.contexte.SiteContexteFrFR;
import java.util.ArrayList;
import java.math.BigDecimal;
import java.lang.Long;
import java.util.Locale;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.lang.Boolean;
import io.vertx.core.json.JsonObject;
import org.computate.bancaire.frfr.ecrivain.ToutEcrivain;
import java.lang.String;
import java.time.ZoneOffset;
import io.vertx.core.logging.Logger;
import org.computate.bancaire.frfr.transaction.TransactionBancaire;
import org.computate.bancaire.frfr.cluster.Cluster;
import java.math.MathContext;
import org.apache.solr.client.solrj.response.QueryResponse;
import java.util.Set;
import org.apache.commons.text.StringEscapeUtils;
import java.time.Instant;
import java.time.ZoneId;
import org.apache.solr.client.solrj.SolrClient;
import java.util.Objects;
import io.vertx.core.json.JsonArray;
import org.apache.solr.common.SolrDocument;
import java.util.List;
import org.computate.bancaire.frfr.couverture.Couverture;
import org.computate.bancaire.frfr.recherche.ListeRecherche;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import org.apache.solr.client.solrj.SolrQuery;
import io.vertx.ext.sql.SQLConnection;
import org.apache.commons.lang3.math.NumberUtils;
import org.computate.bancaire.frfr.compte.CompteBancaire;
import io.vertx.ext.sql.SQLClient;
import org.apache.solr.client.solrj.util.ClientUtils;
import org.apache.solr.common.SolrInputDocument;
import org.apache.commons.lang3.exception.ExceptionUtils;

/**	
 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.ajustement.AjustementBancaire&fq=classeEtendGen_indexed_boolean:true">Trouver la classe objectSuggest dans Solr</a>
 * <br/>
 **/
public abstract class AjustementBancaireGen<DEV> extends Cluster {
	private static final Logger LOGGER = LoggerFactory.getLogger(AjustementBancaire.class);

	public static final String AjustementBancaire_UnNom = "un ajustement";
	public static final String AjustementBancaire_Ce = "ce ";
	public static final String AjustementBancaire_CeNom = "cet ajustement";
	public static final String AjustementBancaire_Un = "un ";
	public static final String AjustementBancaire_LeNom = "l'ajustement";
	public static final String AjustementBancaire_NomSingulier = "ajustement";
	public static final String AjustementBancaire_NomPluriel = "ajustements";
	public static final String AjustementBancaire_NomActuel = "ajustement actuel";
	public static final String AjustementBancaire_Tous = "all ";
	public static final String AjustementBancaire_TousNom = "tous les ajustements";
	public static final String AjustementBancaire_RechercherTousNomPar = "rechercher ajustements par ";
	public static final String AjustementBancaire_RechercherTousNom = "rechercher ajustements";
	public static final String AjustementBancaire_LesNoms = "les ajustements";
	public static final String AjustementBancaire_AucunNomTrouve = "aucun ajustement trouvé";
	public static final String AjustementBancaire_NomVar = "ajustement";
	public static final String AjustementBancaire_DeNom = "d'ajustement";
	public static final String AjustementBancaire_NomAdjectifSingulier = "ajustement";
	public static final String AjustementBancaire_NomAdjectifPluriel = "ajustements";
	public static final String AjustementBancaire_Couleur = "yellow";
	public static final String AjustementBancaire_IconeGroupe = "duotone";
	public static final String AjustementBancaire_IconeNom = "cash-register";

	///////////////////
	// ajustementCle //
	///////////////////

	/**	L'entité « ajustementCle »
	 *	 is defined as null before being initialized. 
	 */
	protected Long ajustementCle;
	@JsonIgnore
	public Couverture<Long> ajustementCleCouverture = new Couverture<Long>().p(this).c(Long.class).var("ajustementCle").o(ajustementCle);

	/**	<br/>L'entité « ajustementCle »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.ajustement.AjustementBancaire&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:ajustementCle">Trouver l'entité ajustementCle dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _ajustementCle(Couverture<Long> c);

	public Long getAjustementCle() {
		return ajustementCle;
	}

	public void setAjustementCle(Long ajustementCle) {
		this.ajustementCle = ajustementCle;
		this.ajustementCleCouverture.dejaInitialise = true;
	}
	public AjustementBancaire setAjustementCle(String o) {
		if(NumberUtils.isParsable(o))
			this.ajustementCle = Long.parseLong(o);
		this.ajustementCleCouverture.dejaInitialise = true;
		return (AjustementBancaire)this;
	}
	protected AjustementBancaire ajustementCleInit() {
		if(!ajustementCleCouverture.dejaInitialise) {
			_ajustementCle(ajustementCleCouverture);
			if(ajustementCle == null)
				setAjustementCle(ajustementCleCouverture.o);
		}
		ajustementCleCouverture.dejaInitialise(true);
		return (AjustementBancaire)this;
	}

	public Long solrAjustementCle() {
		return ajustementCle;
	}

	public String strAjustementCle() {
		return ajustementCle == null ? "" : ajustementCle.toString();
	}

	public String jsonAjustementCle() {
		return ajustementCle == null ? "" : ajustementCle.toString();
	}

	public String nomAffichageAjustementCle() {
		return "clé";
	}

	public String htmTooltipAjustementCle() {
		return null;
	}

	public String htmAjustementCle() {
		return ajustementCle == null ? "" : StringEscapeUtils.escapeHtml4(strAjustementCle());
	}

	public void htmAjustementCle(ToutEcrivain r, Boolean patchDroits) {
		if(pk!= null) {
			r.s("<div id=\"patchAjustementBancaire", strPk(), "AjustementCle\">");
			if(patchDroits) {
				r.l();
				r.l("	<script>//<![CDATA[");
				r.l("		function patchAjustementBancaire", strPk(), "AjustementCle() {");
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
				r.l("				data: {\"setAjustementCle\": this.value },");
				r.l("				");
				r.l("			});");
				r.l("		}");
				r.l("	//]]></script>");
				r.l("	<div class=\"\">");
				r.l("		<label class=\"w3-tooltip \">");
				r.l("			<span>", StringEscapeUtils.escapeHtml4(nomAffichageAjustementCle()), "</span>");
				r.s("			<input");
							r.s(" name=\"ajustementCle\"");
							r.s(" value=\"", htmAjustementCle(), "\");");
							r.s(" onchange=\"\"");
							r.l("/>");
				r.l("		</label>");
				r.l("	</div>");
			} else {
				r.s(htmAjustementCle());
			}
			r.l("</div>");
		}
	}

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
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.ajustement.AjustementBancaire&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:compteCle">Trouver l'entité compteCle dans Solr</a>
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
	public AjustementBancaire setCompteCle(String o) {
		if(NumberUtils.isParsable(o))
			this.compteCle = Long.parseLong(o);
		this.compteCleCouverture.dejaInitialise = true;
		return (AjustementBancaire)this;
	}
	protected AjustementBancaire compteCleInit() {
		if(!compteCleCouverture.dejaInitialise) {
			_compteCle(compteCleCouverture);
			if(compteCle == null)
				setCompteCle(compteCleCouverture.o);
		}
		compteCleCouverture.dejaInitialise(true);
		return (AjustementBancaire)this;
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
		return "compte";
	}

	public String htmTooltipCompteCle() {
		return null;
	}

	public String htmCompteCle() {
		return compteCle == null ? "" : StringEscapeUtils.escapeHtml4(strCompteCle());
	}

	public void htmCompteCle(ToutEcrivain r, Boolean patchDroits) {
		if(pk!= null) {
			r.s("<div id=\"patchAjustementBancaire", strPk(), "CompteCle\">");
			if(patchDroits) {
				r.l();
				r.l("	<script>//<![CDATA[");
				r.l("		function patchAjustementBancaire", strPk(), "CompteCle() {");
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
	// compteRecherche //
	/////////////////////

	/**	L'entité « compteRecherche »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut ListeRecherche<CompteBancaire>(). 
	 */
	@JsonIgnore
	protected ListeRecherche<CompteBancaire> compteRecherche = new ListeRecherche<CompteBancaire>();
	@JsonIgnore
	public Couverture<ListeRecherche<CompteBancaire>> compteRechercheCouverture = new Couverture<ListeRecherche<CompteBancaire>>().p(this).c(ListeRecherche.class).var("compteRecherche").o(compteRecherche);

	/**	<br/>L'entité « compteRecherche »
	 * Il est construit avant d'être initialisé avec le constructeur par défaut ListeRecherche<CompteBancaire>(). 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.ajustement.AjustementBancaire&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:compteRecherche">Trouver l'entité compteRecherche dans Solr</a>
	 * <br/>
	 * @param compteRecherche est l'entité déjà construit. 
	 **/
	protected abstract void _compteRecherche(ListeRecherche<CompteBancaire> l);

	public ListeRecherche<CompteBancaire> getCompteRecherche() {
		return compteRecherche;
	}

	public void setCompteRecherche(ListeRecherche<CompteBancaire> compteRecherche) {
		this.compteRecherche = compteRecherche;
		this.compteRechercheCouverture.dejaInitialise = true;
	}
	protected AjustementBancaire compteRechercheInit() {
		if(!compteRechercheCouverture.dejaInitialise) {
			_compteRecherche(compteRecherche);
		}
		compteRecherche.initLoinPourClasse(requeteSite_);
		compteRechercheCouverture.dejaInitialise(true);
		return (AjustementBancaire)this;
	}

	/////////////
	// compte_ //
	/////////////

	/**	L'entité « compte_ »
	 *	 is defined as null before being initialized. 
	 */
	@JsonIgnore
	protected CompteBancaire compte_;
	@JsonIgnore
	public Couverture<CompteBancaire> compte_Couverture = new Couverture<CompteBancaire>().p(this).c(CompteBancaire.class).var("compte_").o(compte_);

	/**	<br/>L'entité « compte_ »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.ajustement.AjustementBancaire&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:compte_">Trouver l'entité compte_ dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _compte_(Couverture<CompteBancaire> c);

	public CompteBancaire getCompte_() {
		return compte_;
	}

	public void setCompte_(CompteBancaire compte_) {
		this.compte_ = compte_;
		this.compte_Couverture.dejaInitialise = true;
	}
	protected AjustementBancaire compte_Init() {
		if(!compte_Couverture.dejaInitialise) {
			_compte_(compte_Couverture);
			if(compte_ == null)
				setCompte_(compte_Couverture.o);
		}
		compte_Couverture.dejaInitialise(true);
		return (AjustementBancaire)this;
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
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.ajustement.AjustementBancaire&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:compteNomComplet">Trouver l'entité compteNomComplet dans Solr</a>
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
	protected AjustementBancaire compteNomCompletInit() {
		if(!compteNomCompletCouverture.dejaInitialise) {
			_compteNomComplet(compteNomCompletCouverture);
			if(compteNomComplet == null)
				setCompteNomComplet(compteNomCompletCouverture.o);
		}
		compteNomCompletCouverture.dejaInitialise(true);
		return (AjustementBancaire)this;
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
		return null;
	}

	public String htmTooltipCompteNomComplet() {
		return null;
	}

	public String htmCompteNomComplet() {
		return compteNomComplet == null ? "" : StringEscapeUtils.escapeHtml4(strCompteNomComplet());
	}

	public void htmCompteNomComplet(ToutEcrivain r, Boolean patchDroits) {
		if(pk!= null) {
			r.s("<div id=\"patchAjustementBancaire", strPk(), "CompteNomComplet\">");
			if(patchDroits) {
				r.l();
				r.l("	<script>//<![CDATA[");
				r.l("		function patchAjustementBancaire", strPk(), "CompteNomComplet() {");
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
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.ajustement.AjustementBancaire&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:compteNumero">Trouver l'entité compteNumero dans Solr</a>
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
	protected AjustementBancaire compteNumeroInit() {
		if(!compteNumeroCouverture.dejaInitialise) {
			_compteNumero(compteNumeroCouverture);
			if(compteNumero == null)
				setCompteNumero(compteNumeroCouverture.o);
		}
		compteNumeroCouverture.dejaInitialise(true);
		return (AjustementBancaire)this;
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
		return null;
	}

	public String htmTooltipCompteNumero() {
		return null;
	}

	public String htmCompteNumero() {
		return compteNumero == null ? "" : StringEscapeUtils.escapeHtml4(strCompteNumero());
	}

	public void htmCompteNumero(ToutEcrivain r, Boolean patchDroits) {
		if(pk!= null) {
			r.s("<div id=\"patchAjustementBancaire", strPk(), "CompteNumero\">");
			if(patchDroits) {
				r.l();
				r.l("	<script>//<![CDATA[");
				r.l("		function patchAjustementBancaire", strPk(), "CompteNumero() {");
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

	////////////////////
	// transactionCle //
	////////////////////

	/**	L'entité « transactionCle »
	 *	 is defined as null before being initialized. 
	 */
	protected Long transactionCle;
	@JsonIgnore
	public Couverture<Long> transactionCleCouverture = new Couverture<Long>().p(this).c(Long.class).var("transactionCle").o(transactionCle);

	/**	<br/>L'entité « transactionCle »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.ajustement.AjustementBancaire&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:transactionCle">Trouver l'entité transactionCle dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _transactionCle(Couverture<Long> c);

	public Long getTransactionCle() {
		return transactionCle;
	}

	public void setTransactionCle(Long transactionCle) {
		this.transactionCle = transactionCle;
		this.transactionCleCouverture.dejaInitialise = true;
	}
	public AjustementBancaire setTransactionCle(String o) {
		if(NumberUtils.isParsable(o))
			this.transactionCle = Long.parseLong(o);
		this.transactionCleCouverture.dejaInitialise = true;
		return (AjustementBancaire)this;
	}
	protected AjustementBancaire transactionCleInit() {
		if(!transactionCleCouverture.dejaInitialise) {
			_transactionCle(transactionCleCouverture);
			if(transactionCle == null)
				setTransactionCle(transactionCleCouverture.o);
		}
		transactionCleCouverture.dejaInitialise(true);
		return (AjustementBancaire)this;
	}

	public Long solrTransactionCle() {
		return transactionCle;
	}

	public String strTransactionCle() {
		return transactionCle == null ? "" : transactionCle.toString();
	}

	public String jsonTransactionCle() {
		return transactionCle == null ? "" : transactionCle.toString();
	}

	public String nomAffichageTransactionCle() {
		return "transaction";
	}

	public String htmTooltipTransactionCle() {
		return null;
	}

	public String htmTransactionCle() {
		return transactionCle == null ? "" : StringEscapeUtils.escapeHtml4(strTransactionCle());
	}

	public void htmTransactionCle(ToutEcrivain r, Boolean patchDroits) {
		if(pk!= null) {
			r.s("<div id=\"patchAjustementBancaire", strPk(), "TransactionCle\">");
			if(patchDroits) {
				r.l();
				r.l("	<script>//<![CDATA[");
				r.l("		function patchAjustementBancaire", strPk(), "TransactionCle() {");
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
				r.l("				data: {\"setTransactionCle\": this.value },");
				r.l("				");
				r.l("			});");
				r.l("		}");
				r.l("	//]]></script>");
				r.l("	<div class=\"\">");
				r.l("		<label class=\"w3-tooltip \">");
				r.l("			<span>", StringEscapeUtils.escapeHtml4(nomAffichageTransactionCle()), "</span>");
				r.s("			<input");
							r.s(" name=\"transactionCle\"");
							r.s(" value=\"", htmTransactionCle(), "\");");
							r.s(" onchange=\"\"");
							r.l("/>");
				r.l("		</label>");
				r.l("	</div>");
			} else {
				r.s(htmTransactionCle());
			}
			r.l("</div>");
		}
	}

	//////////////////////////
	// transactionRecherche //
	//////////////////////////

	/**	L'entité « transactionRecherche »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut ListeRecherche<TransactionBancaire>(). 
	 */
	@JsonIgnore
	protected ListeRecherche<TransactionBancaire> transactionRecherche = new ListeRecherche<TransactionBancaire>();
	@JsonIgnore
	public Couverture<ListeRecherche<TransactionBancaire>> transactionRechercheCouverture = new Couverture<ListeRecherche<TransactionBancaire>>().p(this).c(ListeRecherche.class).var("transactionRecherche").o(transactionRecherche);

	/**	<br/>L'entité « transactionRecherche »
	 * Il est construit avant d'être initialisé avec le constructeur par défaut ListeRecherche<TransactionBancaire>(). 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.ajustement.AjustementBancaire&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:transactionRecherche">Trouver l'entité transactionRecherche dans Solr</a>
	 * <br/>
	 * @param transactionRecherche est l'entité déjà construit. 
	 **/
	protected abstract void _transactionRecherche(ListeRecherche<TransactionBancaire> l);

	public ListeRecherche<TransactionBancaire> getTransactionRecherche() {
		return transactionRecherche;
	}

	public void setTransactionRecherche(ListeRecherche<TransactionBancaire> transactionRecherche) {
		this.transactionRecherche = transactionRecherche;
		this.transactionRechercheCouverture.dejaInitialise = true;
	}
	protected AjustementBancaire transactionRechercheInit() {
		if(!transactionRechercheCouverture.dejaInitialise) {
			_transactionRecherche(transactionRecherche);
		}
		transactionRecherche.initLoinPourClasse(requeteSite_);
		transactionRechercheCouverture.dejaInitialise(true);
		return (AjustementBancaire)this;
	}

	//////////////////
	// transaction_ //
	//////////////////

	/**	L'entité « transaction_ »
	 *	 is defined as null before being initialized. 
	 */
	@JsonIgnore
	protected TransactionBancaire transaction_;
	@JsonIgnore
	public Couverture<TransactionBancaire> transaction_Couverture = new Couverture<TransactionBancaire>().p(this).c(TransactionBancaire.class).var("transaction_").o(transaction_);

	/**	<br/>L'entité « transaction_ »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.ajustement.AjustementBancaire&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:transaction_">Trouver l'entité transaction_ dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _transaction_(Couverture<TransactionBancaire> c);

	public TransactionBancaire getTransaction_() {
		return transaction_;
	}

	public void setTransaction_(TransactionBancaire transaction_) {
		this.transaction_ = transaction_;
		this.transaction_Couverture.dejaInitialise = true;
	}
	protected AjustementBancaire transaction_Init() {
		if(!transaction_Couverture.dejaInitialise) {
			_transaction_(transaction_Couverture);
			if(transaction_ == null)
				setTransaction_(transaction_Couverture.o);
		}
		transaction_Couverture.dejaInitialise(true);
		return (AjustementBancaire)this;
	}

	////////////////////////////
	// transactionIdReference //
	////////////////////////////

	/**	L'entité « transactionIdReference »
	 *	 is defined as null before being initialized. 
	 */
	protected String transactionIdReference;
	@JsonIgnore
	public Couverture<String> transactionIdReferenceCouverture = new Couverture<String>().p(this).c(String.class).var("transactionIdReference").o(transactionIdReference);

	/**	<br/>L'entité « transactionIdReference »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.ajustement.AjustementBancaire&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:transactionIdReference">Trouver l'entité transactionIdReference dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _transactionIdReference(Couverture<String> c);

	public String getTransactionIdReference() {
		return transactionIdReference;
	}

	public void setTransactionIdReference(String transactionIdReference) {
		this.transactionIdReference = transactionIdReference;
		this.transactionIdReferenceCouverture.dejaInitialise = true;
	}
	protected AjustementBancaire transactionIdReferenceInit() {
		if(!transactionIdReferenceCouverture.dejaInitialise) {
			_transactionIdReference(transactionIdReferenceCouverture);
			if(transactionIdReference == null)
				setTransactionIdReference(transactionIdReferenceCouverture.o);
		}
		transactionIdReferenceCouverture.dejaInitialise(true);
		return (AjustementBancaire)this;
	}

	public String solrTransactionIdReference() {
		return transactionIdReference;
	}

	public String strTransactionIdReference() {
		return transactionIdReference == null ? "" : transactionIdReference;
	}

	public String jsonTransactionIdReference() {
		return transactionIdReference == null ? "" : transactionIdReference;
	}

	public String nomAffichageTransactionIdReference() {
		return "ID de référence de transaction";
	}

	public String htmTooltipTransactionIdReference() {
		return null;
	}

	public String htmTransactionIdReference() {
		return transactionIdReference == null ? "" : StringEscapeUtils.escapeHtml4(strTransactionIdReference());
	}

	public void htmTransactionIdReference(ToutEcrivain r, Boolean patchDroits) {
		if(pk!= null) {
			r.s("<div id=\"patchAjustementBancaire", strPk(), "TransactionIdReference\">");
			if(patchDroits) {
				r.l();
				r.l("	<script>//<![CDATA[");
				r.l("		function patchAjustementBancaire", strPk(), "TransactionIdReference() {");
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
				r.l("				data: {\"setTransactionIdReference\": this.value },");
				r.l("				");
				r.l("			});");
				r.l("		}");
				r.l("	//]]></script>");
				r.l("	<div class=\"\">");
				r.l("		<label class=\"w3-tooltip \">");
				r.l("			<span>", StringEscapeUtils.escapeHtml4(nomAffichageTransactionIdReference()), "</span>");
				r.s("			<input");
							r.s(" name=\"transactionIdReference\"");
							r.s(" value=\"", htmTransactionIdReference(), "\");");
							r.s(" onchange=\"\"");
							r.l("/>");
				r.l("		</label>");
				r.l("	</div>");
			} else {
				r.s(htmTransactionIdReference());
			}
			r.l("</div>");
		}
	}

	/////////////////////
	// transactionCode //
	/////////////////////

	/**	L'entité « transactionCode »
	 *	 is defined as null before being initialized. 
	 */
	protected String transactionCode;
	@JsonIgnore
	public Couverture<String> transactionCodeCouverture = new Couverture<String>().p(this).c(String.class).var("transactionCode").o(transactionCode);

	/**	<br/>L'entité « transactionCode »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.ajustement.AjustementBancaire&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:transactionCode">Trouver l'entité transactionCode dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _transactionCode(Couverture<String> c);

	public String getTransactionCode() {
		return transactionCode;
	}

	public void setTransactionCode(String transactionCode) {
		this.transactionCode = transactionCode;
		this.transactionCodeCouverture.dejaInitialise = true;
	}
	protected AjustementBancaire transactionCodeInit() {
		if(!transactionCodeCouverture.dejaInitialise) {
			_transactionCode(transactionCodeCouverture);
			if(transactionCode == null)
				setTransactionCode(transactionCodeCouverture.o);
		}
		transactionCodeCouverture.dejaInitialise(true);
		return (AjustementBancaire)this;
	}

	public String solrTransactionCode() {
		return transactionCode;
	}

	public String strTransactionCode() {
		return transactionCode == null ? "" : transactionCode;
	}

	public String jsonTransactionCode() {
		return transactionCode == null ? "" : transactionCode;
	}

	public String nomAffichageTransactionCode() {
		return null;
	}

	public String htmTooltipTransactionCode() {
		return null;
	}

	public String htmTransactionCode() {
		return transactionCode == null ? "" : StringEscapeUtils.escapeHtml4(strTransactionCode());
	}

	public void htmTransactionCode(ToutEcrivain r, Boolean patchDroits) {
		if(pk!= null) {
			r.s("<div id=\"patchAjustementBancaire", strPk(), "TransactionCode\">");
			if(patchDroits) {
				r.l();
				r.l("	<script>//<![CDATA[");
				r.l("		function patchAjustementBancaire", strPk(), "TransactionCode() {");
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
				r.l("				data: {\"setTransactionCode\": this.value },");
				r.l("				");
				r.l("			});");
				r.l("		}");
				r.l("	//]]></script>");
				r.l("	<div class=\"\">");
				r.l("		<label class=\"w3-tooltip \">");
				r.l("			<span>", StringEscapeUtils.escapeHtml4(nomAffichageTransactionCode()), "</span>");
				r.s("			<input");
							r.s(" name=\"transactionCode\"");
							r.s(" value=\"", htmTransactionCode(), "\");");
							r.s(" onchange=\"\"");
							r.l("/>");
				r.l("		</label>");
				r.l("	</div>");
			} else {
				r.s(htmTransactionCode());
			}
			r.l("</div>");
		}
	}

	////////////////////////
	// transactionMontant //
	////////////////////////

	/**	L'entité « transactionMontant »
	 *	 is defined as null before being initialized. 
	 */
	protected BigDecimal transactionMontant;
	@JsonIgnore
	public Couverture<BigDecimal> transactionMontantCouverture = new Couverture<BigDecimal>().p(this).c(BigDecimal.class).var("transactionMontant").o(transactionMontant);

	/**	<br/>L'entité « transactionMontant »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.ajustement.AjustementBancaire&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:transactionMontant">Trouver l'entité transactionMontant dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _transactionMontant(Couverture<BigDecimal> c);

	public BigDecimal getTransactionMontant() {
		return transactionMontant;
	}

	public void setTransactionMontant(BigDecimal transactionMontant) {
		this.transactionMontant = transactionMontant;
		this.transactionMontantCouverture.dejaInitialise = true;
	}
	public AjustementBancaire setTransactionMontant(String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			this.transactionMontant = new BigDecimal(o, MathContext.DECIMAL64).setScale(2);
		this.transactionMontantCouverture.dejaInitialise = true;
		return (AjustementBancaire)this;
	}
	public AjustementBancaire setTransactionMontant(Double o) {
			this.transactionMontant = new BigDecimal(o, MathContext.DECIMAL64).setScale(2);
		this.transactionMontantCouverture.dejaInitialise = true;
		return (AjustementBancaire)this;
	}
	public AjustementBancaire setTransactionMontant(Integer o) {
			this.transactionMontant = new BigDecimal(o, MathContext.DECIMAL64).setScale(2);
		this.transactionMontantCouverture.dejaInitialise = true;
		return (AjustementBancaire)this;
	}
	protected AjustementBancaire transactionMontantInit() {
		if(!transactionMontantCouverture.dejaInitialise) {
			_transactionMontant(transactionMontantCouverture);
			if(transactionMontant == null)
				setTransactionMontant(transactionMontantCouverture.o);
		}
		transactionMontantCouverture.dejaInitialise(true);
		return (AjustementBancaire)this;
	}

	public Double solrTransactionMontant() {
		return transactionMontant == null ? null : transactionMontant.doubleValue();
	}

	public String strTransactionMontant() {
		return transactionMontant == null ? "" : transactionMontant.toString();
	}

	public String jsonTransactionMontant() {
		return transactionMontant == null ? "" : transactionMontant.toString();
	}

	public String nomAffichageTransactionMontant() {
		return "date et heure de la transaction";
	}

	public String htmTooltipTransactionMontant() {
		return null;
	}

	public String htmTransactionMontant() {
		return transactionMontant == null ? "" : StringEscapeUtils.escapeHtml4(strTransactionMontant());
	}

	public void htmTransactionMontant(ToutEcrivain r, Boolean patchDroits) {
		if(pk!= null) {
			r.s("<div id=\"patchAjustementBancaire", strPk(), "TransactionMontant\">");
			if(patchDroits) {
				r.l();
				r.l("	<script>//<![CDATA[");
				r.l("		function patchAjustementBancaire", strPk(), "TransactionMontant() {");
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
				r.l("				data: {\"setTransactionMontant\": this.value },");
				r.l("				");
				r.l("			});");
				r.l("		}");
				r.l("	//]]></script>");
				r.l("	<div class=\"\">");
				r.l("		<label class=\"w3-tooltip \">");
				r.l("			<span>", StringEscapeUtils.escapeHtml4(nomAffichageTransactionMontant()), "</span>");
				r.s("			<input");
							r.s(" name=\"transactionMontant\"");
							r.s(" value=\"", htmTransactionMontant(), "\");");
							r.s(" onchange=\"\"");
							r.l("/>");
				r.l("		</label>");
				r.l("	</div>");
			} else {
				r.s(htmTransactionMontant());
			}
			r.l("</div>");
		}
	}

	//////////////////////////
	// transactionDateHeure //
	//////////////////////////

	/**	L'entité « transactionDateHeure »
	 *	 is defined as null before being initialized. 
	 */
	protected ZonedDateTime transactionDateHeure;
	@JsonIgnore
	public Couverture<ZonedDateTime> transactionDateHeureCouverture = new Couverture<ZonedDateTime>().p(this).c(ZonedDateTime.class).var("transactionDateHeure").o(transactionDateHeure);

	/**	<br/>L'entité « transactionDateHeure »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.ajustement.AjustementBancaire&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:transactionDateHeure">Trouver l'entité transactionDateHeure dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _transactionDateHeure(Couverture<ZonedDateTime> c);

	public ZonedDateTime getTransactionDateHeure() {
		return transactionDateHeure;
	}

	public void setTransactionDateHeure(ZonedDateTime transactionDateHeure) {
		this.transactionDateHeure = transactionDateHeure;
		this.transactionDateHeureCouverture.dejaInitialise = true;
	}
	public AjustementBancaire setTransactionDateHeure(Instant o) {
		this.transactionDateHeure = ZonedDateTime.from(o);
		this.transactionDateHeureCouverture.dejaInitialise = true;
		return (AjustementBancaire)this;
	}
	/** Example: 2011-12-03T10:15:30+01:00 **/
	public AjustementBancaire setTransactionDateHeure(String o) {
		this.transactionDateHeure = ZonedDateTime.parse(o, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
		this.transactionDateHeureCouverture.dejaInitialise = true;
		return (AjustementBancaire)this;
	}
	public AjustementBancaire setTransactionDateHeure(Date o) {
		this.transactionDateHeure = ZonedDateTime.ofInstant(o.toInstant(), ZoneId.of(requeteSite_.getConfigSite_().getSiteZone()));
		this.transactionDateHeureCouverture.dejaInitialise = true;
		return (AjustementBancaire)this;
	}
	protected AjustementBancaire transactionDateHeureInit() {
		if(!transactionDateHeureCouverture.dejaInitialise) {
			_transactionDateHeure(transactionDateHeureCouverture);
			if(transactionDateHeure == null)
				setTransactionDateHeure(transactionDateHeureCouverture.o);
		}
		transactionDateHeureCouverture.dejaInitialise(true);
		return (AjustementBancaire)this;
	}

	public Date solrTransactionDateHeure() {
		return transactionDateHeure == null ? null : Date.from(transactionDateHeure.toInstant());
	}

	public String strTransactionDateHeure() {
		return transactionDateHeure == null ? "" : transactionDateHeure.format(DateTimeFormatter.ofPattern("EEE d MMM yyyy H'h'mm:ss.SSS zz VV", Locale.FRANCE));
	}

	public String jsonTransactionDateHeure() {
		return transactionDateHeure == null ? "" : transactionDateHeure.format(DateTimeFormatter.ofPattern("EEE d MMM yyyy H'h'mm:ss.SSS zz VV", Locale.FRANCE));
	}

	public String nomAffichageTransactionDateHeure() {
		return "date et heure de la transaction";
	}

	public String htmTooltipTransactionDateHeure() {
		return null;
	}

	public String htmTransactionDateHeure() {
		return transactionDateHeure == null ? "" : StringEscapeUtils.escapeHtml4(strTransactionDateHeure());
	}

	public void htmTransactionDateHeure(ToutEcrivain r, Boolean patchDroits) {
		if(pk!= null) {
			r.s("<div id=\"patchAjustementBancaire", strPk(), "TransactionDateHeure\">");
			if(patchDroits) {
				r.l();
				r.l("	<script>//<![CDATA[");
				r.l("		function patchAjustementBancaire", strPk(), "TransactionDateHeure() {");
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
				r.l("				data: {\"setTransactionDateHeure\": this.value },");
				r.l("				");
				r.l("			});");
				r.l("		}");
				r.l("	//]]></script>");
				r.l("	<div class=\"\">");
				r.l("		<label class=\"w3-tooltip \">");
				r.l("			<span>", StringEscapeUtils.escapeHtml4(nomAffichageTransactionDateHeure()), "</span>");
				r.s("			<input");
							r.s(" name=\"transactionDateHeure\"");
							r.s(" value=\"", htmTransactionDateHeure(), "\");");
							r.s(" onchange=\"\"");
							r.l("/>");
				r.l("		</label>");
				r.l("	</div>");
			} else {
				r.s(htmTransactionDateHeure());
			}
			r.l("</div>");
		}
	}

	/////////////////////
	// transactionDate //
	/////////////////////

	/**	L'entité « transactionDate »
	 *	 is defined as null before being initialized. 
	 */
	protected LocalDate transactionDate;
	@JsonIgnore
	public Couverture<LocalDate> transactionDateCouverture = new Couverture<LocalDate>().p(this).c(LocalDate.class).var("transactionDate").o(transactionDate);

	/**	<br/>L'entité « transactionDate »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.ajustement.AjustementBancaire&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:transactionDate">Trouver l'entité transactionDate dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _transactionDate(Couverture<LocalDate> c);

	public LocalDate getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
		this.transactionDateCouverture.dejaInitialise = true;
	}
	public AjustementBancaire setTransactionDate(Instant o) {
		this.transactionDate = LocalDate.from(o);
		this.transactionDateCouverture.dejaInitialise = true;
		return (AjustementBancaire)this;
	}
	/** Example: 2011-12-03+01:00 **/
	public AjustementBancaire setTransactionDate(String o) {
		this.transactionDate = LocalDate.parse(o, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
		this.transactionDateCouverture.dejaInitialise = true;
		return (AjustementBancaire)this;
	}
	public AjustementBancaire setTransactionDate(Date o) {
		this.transactionDate = o.toInstant().atZone(ZoneId.of(requeteSite_.getConfigSite_().getSiteZone())).toLocalDate();
		this.transactionDateCouverture.dejaInitialise = true;
		return (AjustementBancaire)this;
	}
	protected AjustementBancaire transactionDateInit() {
		if(!transactionDateCouverture.dejaInitialise) {
			_transactionDate(transactionDateCouverture);
			if(transactionDate == null)
				setTransactionDate(transactionDateCouverture.o);
		}
		transactionDateCouverture.dejaInitialise(true);
		return (AjustementBancaire)this;
	}

	public Date solrTransactionDate() {
		return transactionDate == null ? null : Date.from(transactionDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}

	public String strTransactionDate() {
		return transactionDate == null ? "" : transactionDate.format(DateTimeFormatter.ofPattern("EEE d MMM yyyy", Locale.FRANCE));
	}

	public String jsonTransactionDate() {
		return transactionDate == null ? "" : transactionDate.format(DateTimeFormatter.ofPattern("MM/dd/yyyy", Locale.FRANCE));
	}

	public String nomAffichageTransactionDate() {
		return "date de la transaction";
	}

	public String htmTooltipTransactionDate() {
		return null;
	}

	public String htmTransactionDate() {
		return transactionDate == null ? "" : StringEscapeUtils.escapeHtml4(strTransactionDate());
	}

	public void htmTransactionDate(ToutEcrivain r, Boolean patchDroits) {
		if(pk!= null) {
			r.s("<div id=\"patchAjustementBancaire", strPk(), "TransactionDate\">");
			if(patchDroits) {
				r.l();
				r.l("	<script>//<![CDATA[");
				r.l("		function patchAjustementBancaire", strPk(), "TransactionDate() {");
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
				r.l("				data: {\"setTransactionDate\": this.value },");
				r.l("				");
				r.l("			});");
				r.l("		}");
				r.l("	//]]></script>");
				r.l("	<div class=\"\">");
				r.l("		<label class=\"w3-tooltip \">");
				r.l("			<span>", StringEscapeUtils.escapeHtml4(nomAffichageTransactionDate()), "</span>");
				r.s("			<input");
							r.s(" name=\"transactionDate\"");
							r.s(" value=\"", htmTransactionDate(), "\");");
							r.s(" onchange=\"\"");
							r.l("/>");
				r.l("		</label>");
				r.l("	</div>");
			} else {
				r.s(htmTransactionDate());
			}
			r.l("</div>");
		}
	}

	//////////////////////
	// transactionFrais //
	//////////////////////

	/**	L'entité « transactionFrais »
	 *	 is defined as null before being initialized. 
	 */
	protected Boolean transactionFrais;
	@JsonIgnore
	public Couverture<Boolean> transactionFraisCouverture = new Couverture<Boolean>().p(this).c(Boolean.class).var("transactionFrais").o(transactionFrais);

	/**	<br/>L'entité « transactionFrais »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.ajustement.AjustementBancaire&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:transactionFrais">Trouver l'entité transactionFrais dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _transactionFrais(Couverture<Boolean> c);

	public Boolean getTransactionFrais() {
		return transactionFrais;
	}

	public void setTransactionFrais(Boolean transactionFrais) {
		this.transactionFrais = transactionFrais;
		this.transactionFraisCouverture.dejaInitialise = true;
	}
	public AjustementBancaire setTransactionFrais(String o) {
		this.transactionFrais = Boolean.parseBoolean(o);
		this.transactionFraisCouverture.dejaInitialise = true;
		return (AjustementBancaire)this;
	}
	protected AjustementBancaire transactionFraisInit() {
		if(!transactionFraisCouverture.dejaInitialise) {
			_transactionFrais(transactionFraisCouverture);
			if(transactionFrais == null)
				setTransactionFrais(transactionFraisCouverture.o);
		}
		transactionFraisCouverture.dejaInitialise(true);
		return (AjustementBancaire)this;
	}

	public Boolean solrTransactionFrais() {
		return transactionFrais;
	}

	public String strTransactionFrais() {
		return transactionFrais == null ? "" : transactionFrais.toString();
	}

	public String jsonTransactionFrais() {
		return transactionFrais == null ? "" : transactionFrais.toString();
	}

	public String nomAffichageTransactionFrais() {
		return "transaction de frais";
	}

	public String htmTooltipTransactionFrais() {
		return null;
	}

	public String htmTransactionFrais() {
		return transactionFrais == null ? "" : StringEscapeUtils.escapeHtml4(strTransactionFrais());
	}

	public void htmTransactionFrais(ToutEcrivain r, Boolean patchDroits) {
		if(pk!= null) {
			r.s("<div id=\"patchAjustementBancaire", strPk(), "TransactionFrais\">");
			if(patchDroits) {
				r.l();
				r.l("	<script>//<![CDATA[");
				r.l("		function patchAjustementBancaire", strPk(), "TransactionFrais() {");
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
				r.l("				data: {\"setTransactionFrais\": this.value },");
				r.l("				");
				r.l("			});");
				r.l("		}");
				r.l("	//]]></script>");
				r.l("	<div class=\"\">");
				r.l("		<label class=\"w3-tooltip \">");
				r.l("			<span>", StringEscapeUtils.escapeHtml4(nomAffichageTransactionFrais()), "</span>");
				r.s("			<input");
							r.s(" name=\"transactionFrais\"");
							r.s(" value=\"", htmTransactionFrais(), "\");");
							r.s(" onchange=\"\"");
							r.l("/>");
				r.l("		</label>");
				r.l("	</div>");
			} else {
				r.s(htmTransactionFrais());
			}
			r.l("</div>");
		}
	}

	////////////////
	// agentZones //
	////////////////

	/**	L'entité « agentZones »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut List<String>(). 
	 */
	protected List<String> agentZones = new java.util.ArrayList<java.lang.String>();
	@JsonIgnore
	public Couverture<List<String>> agentZonesCouverture = new Couverture<List<String>>().p(this).c(List.class).var("agentZones").o(agentZones);

	/**	<br/>L'entité « agentZones »
	 * Il est construit avant d'être initialisé avec le constructeur par défaut List<String>(). 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.ajustement.AjustementBancaire&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:agentZones">Trouver l'entité agentZones dans Solr</a>
	 * <br/>
	 * @param agentZones est l'entité déjà construit. 
	 **/
	protected abstract void _agentZones(List<String> l);

	public List<String> getAgentZones() {
		return agentZones;
	}

	public void setAgentZones(List<String> agentZones) {
		this.agentZones = agentZones;
		this.agentZonesCouverture.dejaInitialise = true;
	}
	public AjustementBancaire addAgentZones(String...objets) {
		for(String o : objets) {
			addAgentZones(o);
		}
		return (AjustementBancaire)this;
	}
	public AjustementBancaire addAgentZones(String o) {
		if(o != null && !agentZones.contains(o))
			this.agentZones.add(o);
		return (AjustementBancaire)this;
	}
	public AjustementBancaire setAgentZones(JsonArray objets) {
		agentZones.clear();
		for(int i = 0; i < objets.size(); i++) {
			String o = objets.getString(i);
			addAgentZones(o);
		}
		return (AjustementBancaire)this;
	}
	protected AjustementBancaire agentZonesInit() {
		if(!agentZonesCouverture.dejaInitialise) {
			_agentZones(agentZones);
		}
		agentZonesCouverture.dejaInitialise(true);
		return (AjustementBancaire)this;
	}

	public List<String> solrAgentZones() {
		return agentZones;
	}

	public String strAgentZones() {
		return agentZones == null ? "" : agentZones.toString();
	}

	public String jsonAgentZones() {
		return agentZones == null ? "" : agentZones.toString();
	}

	public String nomAffichageAgentZones() {
		return "zones d'agent";
	}

	public String htmTooltipAgentZones() {
		return null;
	}

	public String htmAgentZones() {
		return agentZones == null ? "" : StringEscapeUtils.escapeHtml4(strAgentZones());
	}

	public void htmAgentZones(ToutEcrivain r, Boolean patchDroits) {
		if(pk!= null) {
			r.s("<div id=\"patchAjustementBancaire", strPk(), "AgentZones\">");
			if(patchDroits) {
				r.l();
				r.l("	<script>//<![CDATA[");
				r.l("		function patchAjustementBancaire", strPk(), "AgentZones() {");
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
				r.l("				data: {\"setAgentZones\": this.value },");
				r.l("				");
				r.l("			});");
				r.l("		}");
				r.l("	//]]></script>");
				r.l("	<div class=\"\">");
				r.l("		<label class=\"w3-tooltip \">");
				r.l("			<span>", StringEscapeUtils.escapeHtml4(nomAffichageAgentZones()), "</span>");
				r.s("			<input");
							r.s(" name=\"agentZones\"");
							r.s(" value=\"", htmAgentZones(), "\");");
							r.s(" onchange=\"\"");
							r.l("/>");
				r.l("		</label>");
				r.l("	</div>");
			} else {
				r.s(htmAgentZones());
			}
			r.l("</div>");
		}
	}

	////////////////
	// agentRoles //
	////////////////

	/**	L'entité « agentRoles »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut List<String>(). 
	 */
	protected List<String> agentRoles = new java.util.ArrayList<java.lang.String>();
	@JsonIgnore
	public Couverture<List<String>> agentRolesCouverture = new Couverture<List<String>>().p(this).c(List.class).var("agentRoles").o(agentRoles);

	/**	<br/>L'entité « agentRoles »
	 * Il est construit avant d'être initialisé avec le constructeur par défaut List<String>(). 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.ajustement.AjustementBancaire&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:agentRoles">Trouver l'entité agentRoles dans Solr</a>
	 * <br/>
	 * @param agentRoles est l'entité déjà construit. 
	 **/
	protected abstract void _agentRoles(List<String> l);

	public List<String> getAgentRoles() {
		return agentRoles;
	}

	public void setAgentRoles(List<String> agentRoles) {
		this.agentRoles = agentRoles;
		this.agentRolesCouverture.dejaInitialise = true;
	}
	public AjustementBancaire addAgentRoles(String...objets) {
		for(String o : objets) {
			addAgentRoles(o);
		}
		return (AjustementBancaire)this;
	}
	public AjustementBancaire addAgentRoles(String o) {
		if(o != null && !agentRoles.contains(o))
			this.agentRoles.add(o);
		return (AjustementBancaire)this;
	}
	public AjustementBancaire setAgentRoles(JsonArray objets) {
		agentRoles.clear();
		for(int i = 0; i < objets.size(); i++) {
			String o = objets.getString(i);
			addAgentRoles(o);
		}
		return (AjustementBancaire)this;
	}
	protected AjustementBancaire agentRolesInit() {
		if(!agentRolesCouverture.dejaInitialise) {
			_agentRoles(agentRoles);
		}
		agentRolesCouverture.dejaInitialise(true);
		return (AjustementBancaire)this;
	}

	public List<String> solrAgentRoles() {
		return agentRoles;
	}

	public String strAgentRoles() {
		return agentRoles == null ? "" : agentRoles.toString();
	}

	public String jsonAgentRoles() {
		return agentRoles == null ? "" : agentRoles.toString();
	}

	public String nomAffichageAgentRoles() {
		return "rôles d'agent";
	}

	public String htmTooltipAgentRoles() {
		return null;
	}

	public String htmAgentRoles() {
		return agentRoles == null ? "" : StringEscapeUtils.escapeHtml4(strAgentRoles());
	}

	public void htmAgentRoles(ToutEcrivain r, Boolean patchDroits) {
		if(pk!= null) {
			r.s("<div id=\"patchAjustementBancaire", strPk(), "AgentRoles\">");
			if(patchDroits) {
				r.l();
				r.l("	<script>//<![CDATA[");
				r.l("		function patchAjustementBancaire", strPk(), "AgentRoles() {");
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
				r.l("				data: {\"setAgentRoles\": this.value },");
				r.l("				");
				r.l("			});");
				r.l("		}");
				r.l("	//]]></script>");
				r.l("	<div class=\"\">");
				r.l("		<label class=\"w3-tooltip \">");
				r.l("			<span>", StringEscapeUtils.escapeHtml4(nomAffichageAgentRoles()), "</span>");
				r.s("			<input");
							r.s(" name=\"agentRoles\"");
							r.s(" value=\"", htmAgentRoles(), "\");");
							r.s(" onchange=\"\"");
							r.l("/>");
				r.l("		</label>");
				r.l("	</div>");
			} else {
				r.s(htmAgentRoles());
			}
			r.l("</div>");
		}
	}

	//////////////////////
	// agentPasserOutre //
	//////////////////////

	/**	L'entité « agentPasserOutre »
	 *	 is defined as null before being initialized. 
	 */
	protected Boolean agentPasserOutre;
	@JsonIgnore
	public Couverture<Boolean> agentPasserOutreCouverture = new Couverture<Boolean>().p(this).c(Boolean.class).var("agentPasserOutre").o(agentPasserOutre);

	/**	<br/>L'entité « agentPasserOutre »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.ajustement.AjustementBancaire&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:agentPasserOutre">Trouver l'entité agentPasserOutre dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _agentPasserOutre(Couverture<Boolean> c);

	public Boolean getAgentPasserOutre() {
		return agentPasserOutre;
	}

	public void setAgentPasserOutre(Boolean agentPasserOutre) {
		this.agentPasserOutre = agentPasserOutre;
		this.agentPasserOutreCouverture.dejaInitialise = true;
	}
	public AjustementBancaire setAgentPasserOutre(String o) {
		this.agentPasserOutre = Boolean.parseBoolean(o);
		this.agentPasserOutreCouverture.dejaInitialise = true;
		return (AjustementBancaire)this;
	}
	protected AjustementBancaire agentPasserOutreInit() {
		if(!agentPasserOutreCouverture.dejaInitialise) {
			_agentPasserOutre(agentPasserOutreCouverture);
			if(agentPasserOutre == null)
				setAgentPasserOutre(agentPasserOutreCouverture.o);
		}
		agentPasserOutreCouverture.dejaInitialise(true);
		return (AjustementBancaire)this;
	}

	public Boolean solrAgentPasserOutre() {
		return agentPasserOutre;
	}

	public String strAgentPasserOutre() {
		return agentPasserOutre == null ? "" : agentPasserOutre.toString();
	}

	public String jsonAgentPasserOutre() {
		return agentPasserOutre == null ? "" : agentPasserOutre.toString();
	}

	public String nomAffichageAgentPasserOutre() {
		return "agent peut passer outre";
	}

	public String htmTooltipAgentPasserOutre() {
		return null;
	}

	public String htmAgentPasserOutre() {
		return agentPasserOutre == null ? "" : StringEscapeUtils.escapeHtml4(strAgentPasserOutre());
	}

	public void htmAgentPasserOutre(ToutEcrivain r, Boolean patchDroits) {
		if(pk!= null) {
			r.s("<div id=\"patchAjustementBancaire", strPk(), "AgentPasserOutre\">");
			if(patchDroits) {
				r.l();
				r.l("	<script>//<![CDATA[");
				r.l("		function patchAjustementBancaire", strPk(), "AgentPasserOutre() {");
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
				r.l("				data: {\"setAgentPasserOutre\": this.value },");
				r.l("				");
				r.l("			});");
				r.l("		}");
				r.l("	//]]></script>");
				r.l("	<div class=\"\">");
				r.l("		<label class=\"w3-tooltip \">");
				r.l("			<span>", StringEscapeUtils.escapeHtml4(nomAffichageAgentPasserOutre()), "</span>");
				r.s("			<input");
							r.s(" name=\"agentPasserOutre\"");
							r.s(" value=\"", htmAgentPasserOutre(), "\");");
							r.s(" onchange=\"\"");
							r.l("/>");
				r.l("		</label>");
				r.l("	</div>");
			} else {
				r.s(htmAgentPasserOutre());
			}
			r.l("</div>");
		}
	}

	///////////////////
	// droitEligible //
	///////////////////

	/**	L'entité « droitEligible »
	 *	 is defined as null before being initialized. 
	 */
	protected Boolean droitEligible;
	@JsonIgnore
	public Couverture<Boolean> droitEligibleCouverture = new Couverture<Boolean>().p(this).c(Boolean.class).var("droitEligible").o(droitEligible);

	/**	<br/>L'entité « droitEligible »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.ajustement.AjustementBancaire&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:droitEligible">Trouver l'entité droitEligible dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _droitEligible(Couverture<Boolean> c);

	public Boolean getDroitEligible() {
		return droitEligible;
	}

	public void setDroitEligible(Boolean droitEligible) {
		this.droitEligible = droitEligible;
		this.droitEligibleCouverture.dejaInitialise = true;
	}
	public AjustementBancaire setDroitEligible(String o) {
		this.droitEligible = Boolean.parseBoolean(o);
		this.droitEligibleCouverture.dejaInitialise = true;
		return (AjustementBancaire)this;
	}
	protected AjustementBancaire droitEligibleInit() {
		if(!droitEligibleCouverture.dejaInitialise) {
			_droitEligible(droitEligibleCouverture);
			if(droitEligible == null)
				setDroitEligible(droitEligibleCouverture.o);
		}
		droitEligibleCouverture.dejaInitialise(true);
		return (AjustementBancaire)this;
	}

	public Boolean solrDroitEligible() {
		return droitEligible;
	}

	public String strDroitEligible() {
		return droitEligible == null ? "" : droitEligible.toString();
	}

	public String jsonDroitEligible() {
		return droitEligible == null ? "" : droitEligible.toString();
	}

	public String nomAffichageDroitEligible() {
		return "droit éligible";
	}

	public String htmTooltipDroitEligible() {
		return null;
	}

	public String htmDroitEligible() {
		return droitEligible == null ? "" : StringEscapeUtils.escapeHtml4(strDroitEligible());
	}

	public void htmDroitEligible(ToutEcrivain r, Boolean patchDroits) {
		if(pk!= null) {
			r.s("<div id=\"patchAjustementBancaire", strPk(), "DroitEligible\">");
			if(patchDroits) {
				r.l();
				r.l("	<script>//<![CDATA[");
				r.l("		function patchAjustementBancaire", strPk(), "DroitEligible() {");
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
				r.l("				data: {\"setDroitEligible\": this.value },");
				r.l("				");
				r.l("			});");
				r.l("		}");
				r.l("	//]]></script>");
				r.l("	<div class=\"\">");
				r.l("		<label class=\"w3-tooltip \">");
				r.l("			<span>", StringEscapeUtils.escapeHtml4(nomAffichageDroitEligible()), "</span>");
				r.s("			<input");
							r.s(" name=\"droitEligible\"");
							r.s(" value=\"", htmDroitEligible(), "\");");
							r.s(" onchange=\"\"");
							r.l("/>");
				r.l("		</label>");
				r.l("	</div>");
			} else {
				r.s(htmDroitEligible());
			}
			r.l("</div>");
		}
	}

	///////////////////
	// partenaireNom //
	///////////////////

	/**	L'entité « partenaireNom »
	 *	 is defined as null before being initialized. 
	 */
	protected String partenaireNom;
	@JsonIgnore
	public Couverture<String> partenaireNomCouverture = new Couverture<String>().p(this).c(String.class).var("partenaireNom").o(partenaireNom);

	/**	<br/>L'entité « partenaireNom »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.ajustement.AjustementBancaire&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:partenaireNom">Trouver l'entité partenaireNom dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _partenaireNom(Couverture<String> c);

	public String getPartenaireNom() {
		return partenaireNom;
	}

	public void setPartenaireNom(String partenaireNom) {
		this.partenaireNom = partenaireNom;
		this.partenaireNomCouverture.dejaInitialise = true;
	}
	protected AjustementBancaire partenaireNomInit() {
		if(!partenaireNomCouverture.dejaInitialise) {
			_partenaireNom(partenaireNomCouverture);
			if(partenaireNom == null)
				setPartenaireNom(partenaireNomCouverture.o);
		}
		partenaireNomCouverture.dejaInitialise(true);
		return (AjustementBancaire)this;
	}

	public String solrPartenaireNom() {
		return partenaireNom;
	}

	public String strPartenaireNom() {
		return partenaireNom == null ? "" : partenaireNom;
	}

	public String jsonPartenaireNom() {
		return partenaireNom == null ? "" : partenaireNom;
	}

	public String nomAffichagePartenaireNom() {
		return "nom de partenaire";
	}

	public String htmTooltipPartenaireNom() {
		return null;
	}

	public String htmPartenaireNom() {
		return partenaireNom == null ? "" : StringEscapeUtils.escapeHtml4(strPartenaireNom());
	}

	public void htmPartenaireNom(ToutEcrivain r, Boolean patchDroits) {
		if(pk!= null) {
			r.s("<div id=\"patchAjustementBancaire", strPk(), "PartenaireNom\">");
			if(patchDroits) {
				r.l();
				r.l("	<script>//<![CDATA[");
				r.l("		function patchAjustementBancaire", strPk(), "PartenaireNom() {");
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
				r.l("				data: {\"setPartenaireNom\": this.value },");
				r.l("				");
				r.l("			});");
				r.l("		}");
				r.l("	//]]></script>");
				r.l("	<div class=\"\">");
				r.l("		<label class=\"w3-tooltip \">");
				r.l("			<span>", StringEscapeUtils.escapeHtml4(nomAffichagePartenaireNom()), "</span>");
				r.s("			<input");
							r.s(" name=\"partenaireNom\"");
							r.s(" value=\"", htmPartenaireNom(), "\");");
							r.s(" onchange=\"\"");
							r.l("/>");
				r.l("		</label>");
				r.l("	</div>");
			} else {
				r.s(htmPartenaireNom());
			}
			r.l("</div>");
		}
	}

	////////////////////////////
	// ajustementNomAffichage //
	////////////////////////////

	/**	L'entité « ajustementNomAffichage »
	 *	 is defined as null before being initialized. 
	 */
	protected String ajustementNomAffichage;
	@JsonIgnore
	public Couverture<String> ajustementNomAffichageCouverture = new Couverture<String>().p(this).c(String.class).var("ajustementNomAffichage").o(ajustementNomAffichage);

	/**	<br/>L'entité « ajustementNomAffichage »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.ajustement.AjustementBancaire&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:ajustementNomAffichage">Trouver l'entité ajustementNomAffichage dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _ajustementNomAffichage(Couverture<String> c);

	public String getAjustementNomAffichage() {
		return ajustementNomAffichage;
	}

	public void setAjustementNomAffichage(String ajustementNomAffichage) {
		this.ajustementNomAffichage = ajustementNomAffichage;
		this.ajustementNomAffichageCouverture.dejaInitialise = true;
	}
	protected AjustementBancaire ajustementNomAffichageInit() {
		if(!ajustementNomAffichageCouverture.dejaInitialise) {
			_ajustementNomAffichage(ajustementNomAffichageCouverture);
			if(ajustementNomAffichage == null)
				setAjustementNomAffichage(ajustementNomAffichageCouverture.o);
		}
		ajustementNomAffichageCouverture.dejaInitialise(true);
		return (AjustementBancaire)this;
	}

	public String solrAjustementNomAffichage() {
		return ajustementNomAffichage;
	}

	public String strAjustementNomAffichage() {
		return ajustementNomAffichage == null ? "" : ajustementNomAffichage;
	}

	public String jsonAjustementNomAffichage() {
		return ajustementNomAffichage == null ? "" : ajustementNomAffichage;
	}

	public String nomAffichageAjustementNomAffichage() {
		return "nom d'affichage";
	}

	public String htmTooltipAjustementNomAffichage() {
		return null;
	}

	public String htmAjustementNomAffichage() {
		return ajustementNomAffichage == null ? "" : StringEscapeUtils.escapeHtml4(strAjustementNomAffichage());
	}

	public void htmAjustementNomAffichage(ToutEcrivain r, Boolean patchDroits) {
		if(pk!= null) {
			r.s("<div id=\"patchAjustementBancaire", strPk(), "AjustementNomAffichage\">");
			if(patchDroits) {
				r.l();
				r.l("	<script>//<![CDATA[");
				r.l("		function patchAjustementBancaire", strPk(), "AjustementNomAffichage() {");
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
				r.l("				data: {\"setAjustementNomAffichage\": this.value },");
				r.l("				");
				r.l("			});");
				r.l("		}");
				r.l("	//]]></script>");
				r.l("	<div class=\"\">");
				r.l("		<label class=\"w3-tooltip \">");
				r.l("			<span>", StringEscapeUtils.escapeHtml4(nomAffichageAjustementNomAffichage()), "</span>");
				r.s("			<input");
							r.s(" name=\"ajustementNomAffichage\"");
							r.s(" value=\"", htmAjustementNomAffichage(), "\");");
							r.s(" onchange=\"\"");
							r.l("/>");
				r.l("		</label>");
				r.l("	</div>");
			} else {
				r.s(htmAjustementNomAffichage());
			}
			r.l("</div>");
		}
	}

	//////////////////////////
	// ajustementNomComplet //
	//////////////////////////

	/**	L'entité « ajustementNomComplet »
	 *	 is defined as null before being initialized. 
	 */
	protected String ajustementNomComplet;
	@JsonIgnore
	public Couverture<String> ajustementNomCompletCouverture = new Couverture<String>().p(this).c(String.class).var("ajustementNomComplet").o(ajustementNomComplet);

	/**	<br/>L'entité « ajustementNomComplet »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.ajustement.AjustementBancaire&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:ajustementNomComplet">Trouver l'entité ajustementNomComplet dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _ajustementNomComplet(Couverture<String> c);

	public String getAjustementNomComplet() {
		return ajustementNomComplet;
	}

	public void setAjustementNomComplet(String ajustementNomComplet) {
		this.ajustementNomComplet = ajustementNomComplet;
		this.ajustementNomCompletCouverture.dejaInitialise = true;
	}
	protected AjustementBancaire ajustementNomCompletInit() {
		if(!ajustementNomCompletCouverture.dejaInitialise) {
			_ajustementNomComplet(ajustementNomCompletCouverture);
			if(ajustementNomComplet == null)
				setAjustementNomComplet(ajustementNomCompletCouverture.o);
		}
		ajustementNomCompletCouverture.dejaInitialise(true);
		return (AjustementBancaire)this;
	}

	public String solrAjustementNomComplet() {
		return ajustementNomComplet;
	}

	public String strAjustementNomComplet() {
		return ajustementNomComplet == null ? "" : ajustementNomComplet;
	}

	public String jsonAjustementNomComplet() {
		return ajustementNomComplet == null ? "" : ajustementNomComplet;
	}

	public String nomAffichageAjustementNomComplet() {
		return null;
	}

	public String htmTooltipAjustementNomComplet() {
		return null;
	}

	public String htmAjustementNomComplet() {
		return ajustementNomComplet == null ? "" : StringEscapeUtils.escapeHtml4(strAjustementNomComplet());
	}

	public void htmAjustementNomComplet(ToutEcrivain r, Boolean patchDroits) {
		if(pk!= null) {
			r.s("<div id=\"patchAjustementBancaire", strPk(), "AjustementNomComplet\">");
			if(patchDroits) {
				r.l();
				r.l("	<script>//<![CDATA[");
				r.l("		function patchAjustementBancaire", strPk(), "AjustementNomComplet() {");
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
				r.l("				data: {\"setAjustementNomComplet\": this.value },");
				r.l("				");
				r.l("			});");
				r.l("		}");
				r.l("	//]]></script>");
				r.l("	<div class=\"\">");
				r.l("		<label class=\"w3-tooltip \">");
				r.l("			<span>", StringEscapeUtils.escapeHtml4(nomAffichageAjustementNomComplet()), "</span>");
				r.s("			<input");
							r.s(" name=\"ajustementNomComplet\"");
							r.s(" value=\"", htmAjustementNomComplet(), "\");");
							r.s(" onchange=\"\"");
							r.l("/>");
				r.l("		</label>");
				r.l("	</div>");
			} else {
				r.s(htmAjustementNomComplet());
			}
			r.l("</div>");
		}
	}

	//////////////////
	// ajustementId //
	//////////////////

	/**	L'entité « ajustementId »
	 *	 is defined as null before being initialized. 
	 */
	protected String ajustementId;
	@JsonIgnore
	public Couverture<String> ajustementIdCouverture = new Couverture<String>().p(this).c(String.class).var("ajustementId").o(ajustementId);

	/**	<br/>L'entité « ajustementId »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.ajustement.AjustementBancaire&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:ajustementId">Trouver l'entité ajustementId dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _ajustementId(Couverture<String> c);

	public String getAjustementId() {
		return ajustementId;
	}

	public void setAjustementId(String ajustementId) {
		this.ajustementId = ajustementId;
		this.ajustementIdCouverture.dejaInitialise = true;
	}
	protected AjustementBancaire ajustementIdInit() {
		if(!ajustementIdCouverture.dejaInitialise) {
			_ajustementId(ajustementIdCouverture);
			if(ajustementId == null)
				setAjustementId(ajustementIdCouverture.o);
		}
		ajustementIdCouverture.dejaInitialise(true);
		return (AjustementBancaire)this;
	}

	public String solrAjustementId() {
		return ajustementId;
	}

	public String strAjustementId() {
		return ajustementId == null ? "" : ajustementId;
	}

	public String jsonAjustementId() {
		return ajustementId == null ? "" : ajustementId;
	}

	public String nomAffichageAjustementId() {
		return "ID";
	}

	public String htmTooltipAjustementId() {
		return null;
	}

	public String htmAjustementId() {
		return ajustementId == null ? "" : StringEscapeUtils.escapeHtml4(strAjustementId());
	}

	public void htmAjustementId(ToutEcrivain r, Boolean patchDroits) {
		if(pk!= null) {
			r.s("<div id=\"patchAjustementBancaire", strPk(), "AjustementId\">");
			if(patchDroits) {
				r.l();
				r.l("	<script>//<![CDATA[");
				r.l("		function patchAjustementBancaire", strPk(), "AjustementId() {");
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
				r.l("				data: {\"setAjustementId\": this.value },");
				r.l("				");
				r.l("			});");
				r.l("		}");
				r.l("	//]]></script>");
				r.l("	<div class=\"\">");
				r.l("		<label class=\"w3-tooltip \">");
				r.l("			<span>", StringEscapeUtils.escapeHtml4(nomAffichageAjustementId()), "</span>");
				r.s("			<input");
							r.s(" name=\"ajustementId\"");
							r.s(" value=\"", htmAjustementId(), "\");");
							r.s(" onchange=\"\"");
							r.l("/>");
				r.l("		</label>");
				r.l("	</div>");
			} else {
				r.s(htmAjustementId());
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
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.ajustement.AjustementBancaire&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:pageUrl">Trouver l'entité pageUrl dans Solr</a>
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
	protected AjustementBancaire pageUrlInit() {
		if(!pageUrlCouverture.dejaInitialise) {
			_pageUrl(pageUrlCouverture);
			if(pageUrl == null)
				setPageUrl(pageUrlCouverture.o);
		}
		pageUrlCouverture.dejaInitialise(true);
		return (AjustementBancaire)this;
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
			r.s("<div id=\"patchAjustementBancaire", strPk(), "PageUrl\">");
			if(patchDroits) {
				r.l();
				r.l("	<script>//<![CDATA[");
				r.l("		function patchAjustementBancaire", strPk(), "PageUrl() {");
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
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.ajustement.AjustementBancaire&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:objetSuggere">Trouver l'entité objetSuggere dans Solr</a>
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
	protected AjustementBancaire objetSuggereInit() {
		if(!objetSuggereCouverture.dejaInitialise) {
			_objetSuggere(objetSuggereCouverture);
			if(objetSuggere == null)
				setObjetSuggere(objetSuggereCouverture.o);
		}
		objetSuggereCouverture.dejaInitialise(true);
		return (AjustementBancaire)this;
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
		return null;
	}

	public String htmTooltipObjetSuggere() {
		return null;
	}

	public String htmObjetSuggere() {
		return objetSuggere == null ? "" : StringEscapeUtils.escapeHtml4(strObjetSuggere());
	}

	public void htmObjetSuggere(ToutEcrivain r, Boolean patchDroits) {
		if(pk!= null) {
			r.s("<div id=\"patchAjustementBancaire", strPk(), "ObjetSuggere\">");
			if(patchDroits) {
				r.l();
				r.l("	<script>//<![CDATA[");
				r.l("		function patchAjustementBancaire", strPk(), "ObjetSuggere() {");
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

	//////////////
	// initLoin //
	//////////////

	protected boolean dejaInitialiseAjustementBancaire = false;

	public AjustementBancaire initLoinAjustementBancaire(RequeteSiteFrFR requeteSite_) {
		setRequeteSite_(requeteSite_);
		if(!dejaInitialiseAjustementBancaire) {
			dejaInitialiseAjustementBancaire = true;
			initLoinAjustementBancaire();
		}
		return (AjustementBancaire)this;
	}

	public void initLoinAjustementBancaire() {
		super.initLoinCluster(requeteSite_);
		initAjustementBancaire();
	}

	public void initAjustementBancaire() {
		ajustementCleInit();
		compteCleInit();
		compteRechercheInit();
		compte_Init();
		compteNomCompletInit();
		compteNumeroInit();
		transactionCleInit();
		transactionRechercheInit();
		transaction_Init();
		transactionIdReferenceInit();
		transactionCodeInit();
		transactionMontantInit();
		transactionDateHeureInit();
		transactionDateInit();
		transactionFraisInit();
		agentZonesInit();
		agentRolesInit();
		agentPasserOutreInit();
		droitEligibleInit();
		partenaireNomInit();
		ajustementNomAffichageInit();
		ajustementNomCompletInit();
		ajustementIdInit();
		pageUrlInit();
		objetSuggereInit();
	}

	@Override public void initLoinPourClasse(RequeteSiteFrFR requeteSite_) {
		initLoinAjustementBancaire(requeteSite_);
	}

	/////////////////
	// requeteSite //
	/////////////////

	public void requeteSiteAjustementBancaire(RequeteSiteFrFR requeteSite_) {
			super.requeteSiteCluster(requeteSite_);
		if(compteRecherche != null)
			compteRecherche.setRequeteSite_(requeteSite_);
		if(transactionRecherche != null)
			transactionRecherche.setRequeteSite_(requeteSite_);
	}

	public void requeteSitePourClasse(RequeteSiteFrFR requeteSite_) {
		requeteSiteAjustementBancaire(requeteSite_);
	}

	/////////////
	// obtenir //
	/////////////

	@Override public Object obtenirPourClasse(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtenirAjustementBancaire(v);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.obtenirPourClasse(v);
			}
		}
		return o;
	}
	public Object obtenirAjustementBancaire(String var) {
		AjustementBancaire oAjustementBancaire = (AjustementBancaire)this;
		switch(var) {
			case "ajustementCle":
				return oAjustementBancaire.ajustementCle;
			case "compteCle":
				return oAjustementBancaire.compteCle;
			case "compteRecherche":
				return oAjustementBancaire.compteRecherche;
			case "compte_":
				return oAjustementBancaire.compte_;
			case "compteNomComplet":
				return oAjustementBancaire.compteNomComplet;
			case "compteNumero":
				return oAjustementBancaire.compteNumero;
			case "transactionCle":
				return oAjustementBancaire.transactionCle;
			case "transactionRecherche":
				return oAjustementBancaire.transactionRecherche;
			case "transaction_":
				return oAjustementBancaire.transaction_;
			case "transactionIdReference":
				return oAjustementBancaire.transactionIdReference;
			case "transactionCode":
				return oAjustementBancaire.transactionCode;
			case "transactionMontant":
				return oAjustementBancaire.transactionMontant;
			case "transactionDateHeure":
				return oAjustementBancaire.transactionDateHeure;
			case "transactionDate":
				return oAjustementBancaire.transactionDate;
			case "transactionFrais":
				return oAjustementBancaire.transactionFrais;
			case "agentZones":
				return oAjustementBancaire.agentZones;
			case "agentRoles":
				return oAjustementBancaire.agentRoles;
			case "agentPasserOutre":
				return oAjustementBancaire.agentPasserOutre;
			case "droitEligible":
				return oAjustementBancaire.droitEligible;
			case "partenaireNom":
				return oAjustementBancaire.partenaireNom;
			case "ajustementNomAffichage":
				return oAjustementBancaire.ajustementNomAffichage;
			case "ajustementNomComplet":
				return oAjustementBancaire.ajustementNomComplet;
			case "ajustementId":
				return oAjustementBancaire.ajustementId;
			case "pageUrl":
				return oAjustementBancaire.pageUrl;
			case "objetSuggere":
				return oAjustementBancaire.objetSuggere;
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
				o = attribuerAjustementBancaire(v, val);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.attribuerPourClasse(v, val);
			}
		}
		return o != null;
	}
	public Object attribuerAjustementBancaire(String var, Object val) {
		AjustementBancaire oAjustementBancaire = (AjustementBancaire)this;
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
					o = definirAjustementBancaire(v, val);
				else if(o instanceof Cluster) {
					Cluster cluster = (Cluster)o;
					o = cluster.definirPourClasse(v, val);
				}
			}
		}
		return o != null;
	}
	public Object definirAjustementBancaire(String var, String val) {
		switch(var) {
			case "agentZones":
				addAgentZones(val);
				if(!sauvegardesAjustementBancaire.contains(var))
					sauvegardesAjustementBancaire.add(var);
				return val;
			case "agentRoles":
				addAgentRoles(val);
				if(!sauvegardesAjustementBancaire.contains(var))
					sauvegardesAjustementBancaire.add(var);
				return val;
			case "agentPasserOutre":
				setAgentPasserOutre(val);
				sauvegardesAjustementBancaire.add(var);
				return val;
			case "droitEligible":
				setDroitEligible(val);
				sauvegardesAjustementBancaire.add(var);
				return val;
			case "partenaireNom":
				setPartenaireNom(val);
				sauvegardesAjustementBancaire.add(var);
				return val;
			case "ajustementNomAffichage":
				setAjustementNomAffichage(val);
				sauvegardesAjustementBancaire.add(var);
				return val;
			default:
				return super.definirCluster(var, val);
		}
	}

	/////////////////
	// sauvegardes //
	/////////////////

	protected List<String> sauvegardesAjustementBancaire = new ArrayList<String>();

	/////////////
	// peupler //
	/////////////

	@Override public void peuplerPourClasse(SolrDocument solrDocument) {
		peuplerAjustementBancaire(solrDocument);
	}
	public void peuplerAjustementBancaire(SolrDocument solrDocument) {
		AjustementBancaire oAjustementBancaire = (AjustementBancaire)this;
		sauvegardesAjustementBancaire = (List<String>)solrDocument.get("sauvegardesAjustementBancaire_stored_strings");
		if(sauvegardesAjustementBancaire != null) {

			if(sauvegardesAjustementBancaire.contains("ajustementCle")) {
				Long ajustementCle = (Long)solrDocument.get("ajustementCle_stored_long");
				if(ajustementCle != null)
					oAjustementBancaire.setAjustementCle(ajustementCle);
			}

			if(sauvegardesAjustementBancaire.contains("compteCle")) {
				Long compteCle = (Long)solrDocument.get("compteCle_stored_long");
				if(compteCle != null)
					oAjustementBancaire.setCompteCle(compteCle);
			}

			if(sauvegardesAjustementBancaire.contains("compteNomComplet")) {
				String compteNomComplet = (String)solrDocument.get("compteNomComplet_stored_string");
				if(compteNomComplet != null)
					oAjustementBancaire.setCompteNomComplet(compteNomComplet);
			}

			if(sauvegardesAjustementBancaire.contains("compteNumero")) {
				String compteNumero = (String)solrDocument.get("compteNumero_stored_string");
				if(compteNumero != null)
					oAjustementBancaire.setCompteNumero(compteNumero);
			}

			if(sauvegardesAjustementBancaire.contains("transactionCle")) {
				Long transactionCle = (Long)solrDocument.get("transactionCle_stored_long");
				if(transactionCle != null)
					oAjustementBancaire.setTransactionCle(transactionCle);
			}

			if(sauvegardesAjustementBancaire.contains("transactionIdReference")) {
				String transactionIdReference = (String)solrDocument.get("transactionIdReference_stored_string");
				if(transactionIdReference != null)
					oAjustementBancaire.setTransactionIdReference(transactionIdReference);
			}

			if(sauvegardesAjustementBancaire.contains("transactionCode")) {
				String transactionCode = (String)solrDocument.get("transactionCode_stored_string");
				if(transactionCode != null)
					oAjustementBancaire.setTransactionCode(transactionCode);
			}

			if(sauvegardesAjustementBancaire.contains("transactionMontant")) {
				Double transactionMontant = (Double)solrDocument.get("transactionMontant_stored_double");
				if(transactionMontant != null)
					oAjustementBancaire.setTransactionMontant(transactionMontant);
			}

			if(sauvegardesAjustementBancaire.contains("transactionDateHeure")) {
				Date transactionDateHeure = (Date)solrDocument.get("transactionDateHeure_stored_date");
				if(transactionDateHeure != null)
					oAjustementBancaire.setTransactionDateHeure(transactionDateHeure);
			}

			if(sauvegardesAjustementBancaire.contains("transactionDate")) {
				Date transactionDate = (Date)solrDocument.get("transactionDate_stored_date");
				if(transactionDate != null)
					oAjustementBancaire.setTransactionDate(transactionDate);
			}

			if(sauvegardesAjustementBancaire.contains("transactionFrais")) {
				Boolean transactionFrais = (Boolean)solrDocument.get("transactionFrais_stored_boolean");
				if(transactionFrais != null)
					oAjustementBancaire.setTransactionFrais(transactionFrais);
			}

			if(sauvegardesAjustementBancaire.contains("agentZones")) {
				List<String> agentZones = (List<String>)solrDocument.get("agentZones_stored_strings");
				if(agentZones != null)
					oAjustementBancaire.agentZones.addAll(agentZones);
			}

			if(sauvegardesAjustementBancaire.contains("agentRoles")) {
				List<String> agentRoles = (List<String>)solrDocument.get("agentRoles_stored_strings");
				if(agentRoles != null)
					oAjustementBancaire.agentRoles.addAll(agentRoles);
			}

			if(sauvegardesAjustementBancaire.contains("agentPasserOutre")) {
				Boolean agentPasserOutre = (Boolean)solrDocument.get("agentPasserOutre_stored_boolean");
				if(agentPasserOutre != null)
					oAjustementBancaire.setAgentPasserOutre(agentPasserOutre);
			}

			if(sauvegardesAjustementBancaire.contains("droitEligible")) {
				Boolean droitEligible = (Boolean)solrDocument.get("droitEligible_stored_boolean");
				if(droitEligible != null)
					oAjustementBancaire.setDroitEligible(droitEligible);
			}

			if(sauvegardesAjustementBancaire.contains("partenaireNom")) {
				String partenaireNom = (String)solrDocument.get("partenaireNom_stored_string");
				if(partenaireNom != null)
					oAjustementBancaire.setPartenaireNom(partenaireNom);
			}

			if(sauvegardesAjustementBancaire.contains("ajustementNomAffichage")) {
				String ajustementNomAffichage = (String)solrDocument.get("ajustementNomAffichage_stored_string");
				if(ajustementNomAffichage != null)
					oAjustementBancaire.setAjustementNomAffichage(ajustementNomAffichage);
			}

			if(sauvegardesAjustementBancaire.contains("ajustementNomComplet")) {
				String ajustementNomComplet = (String)solrDocument.get("ajustementNomComplet_stored_string");
				if(ajustementNomComplet != null)
					oAjustementBancaire.setAjustementNomComplet(ajustementNomComplet);
			}

			if(sauvegardesAjustementBancaire.contains("ajustementId")) {
				String ajustementId = (String)solrDocument.get("ajustementId_stored_string");
				if(ajustementId != null)
					oAjustementBancaire.setAjustementId(ajustementId);
			}

			if(sauvegardesAjustementBancaire.contains("pageUrl")) {
				String pageUrl = (String)solrDocument.get("pageUrl_stored_string");
				if(pageUrl != null)
					oAjustementBancaire.setPageUrl(pageUrl);
			}

			if(sauvegardesAjustementBancaire.contains("objetSuggere")) {
				String objetSuggere = (String)solrDocument.get("objetSuggere_suggested");
				oAjustementBancaire.setObjetSuggere(objetSuggere);
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
			rechercheSolr.addFilterQuery("id:" + ClientUtils.escapeQueryChars("org.computate.bancaire.frfr.ajustement.AjustementBancaire"));
			QueryResponse reponseRecherche = requeteSite.getSiteContexte_().getClientSolr().query(rechercheSolr);
			if(reponseRecherche.getResults().size() > 0)
				requeteSite.setDocumentSolr(reponseRecherche.getResults().get(0));
			AjustementBancaire o = new AjustementBancaire();
			o.requeteSiteAjustementBancaire(requeteSite);
			o.initLoinAjustementBancaire(requeteSite);
			o.indexerAjustementBancaire();
		} catch(Exception e) {
			ExceptionUtils.rethrow(e);
		}
	}


	@Override public void indexerPourClasse() {
		indexerAjustementBancaire();
	}

	@Override public void indexerPourClasse(SolrInputDocument document) {
		indexerAjustementBancaire(document);
	}

	public void indexerAjustementBancaire(SolrClient clientSolr) {
		try {
			SolrInputDocument document = new SolrInputDocument();
			indexerAjustementBancaire(document);
			clientSolr.add(document);
			clientSolr.commit();
		} catch(Exception e) {
			ExceptionUtils.rethrow(e);
		}
	}

	public void indexerAjustementBancaire() {
		try {
			SolrInputDocument document = new SolrInputDocument();
			indexerAjustementBancaire(document);
			SolrClient clientSolr = requeteSite_.getSiteContexte_().getClientSolr();
			clientSolr.add(document);
			clientSolr.commit();
		} catch(Exception e) {
			ExceptionUtils.rethrow(e);
		}
	}

	public void indexerAjustementBancaire(SolrInputDocument document) {
		if(sauvegardesAjustementBancaire != null)
			document.addField("sauvegardesAjustementBancaire_stored_strings", sauvegardesAjustementBancaire);

		if(ajustementCle != null) {
			document.addField("ajustementCle_indexed_long", ajustementCle);
			document.addField("ajustementCle_stored_long", ajustementCle);
		}
		if(compteCle != null) {
			document.addField("compteCle_indexed_long", compteCle);
			document.addField("compteCle_stored_long", compteCle);
		}
		if(compteNomComplet != null) {
			document.addField("compteNomComplet_indexed_string", compteNomComplet);
			document.addField("compteNomComplet_stored_string", compteNomComplet);
		}
		if(compteNumero != null) {
			document.addField("compteNumero_indexed_string", compteNumero);
			document.addField("compteNumero_stored_string", compteNumero);
		}
		if(transactionCle != null) {
			document.addField("transactionCle_indexed_long", transactionCle);
			document.addField("transactionCle_stored_long", transactionCle);
		}
		if(transactionIdReference != null) {
			document.addField("transactionIdReference_indexed_string", transactionIdReference);
			document.addField("transactionIdReference_stored_string", transactionIdReference);
		}
		if(transactionCode != null) {
			document.addField("transactionCode_indexed_string", transactionCode);
			document.addField("transactionCode_stored_string", transactionCode);
		}
		if(transactionMontant != null) {
			document.addField("transactionMontant_indexed_double", transactionMontant.doubleValue());
			document.addField("transactionMontant_stored_double", transactionMontant.doubleValue());
		}
		if(transactionDateHeure != null) {
			document.addField("transactionDateHeure_indexed_date", DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").format(ZonedDateTime.ofInstant(transactionDateHeure.toInstant(), ZoneId.of("UTC"))));
			document.addField("transactionDateHeure_stored_date", DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").format(ZonedDateTime.ofInstant(transactionDateHeure.toInstant(), ZoneId.of("UTC"))));
		}
		if(transactionDate != null) {
			document.addField("transactionDate_indexed_date", DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").format(transactionDate.atStartOfDay(ZoneId.systemDefault()).toInstant().atZone(ZoneId.of("Z"))));
			document.addField("transactionDate_stored_date", DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").format(transactionDate.atStartOfDay(ZoneId.systemDefault()).toInstant().atZone(ZoneId.of("Z"))));
		}
		if(transactionFrais != null) {
			document.addField("transactionFrais_indexed_boolean", transactionFrais);
			document.addField("transactionFrais_stored_boolean", transactionFrais);
		}
		if(agentZones != null) {
			for(java.lang.String o : agentZones) {
				document.addField("agentZones_indexed_strings", o);
			}
			for(java.lang.String o : agentZones) {
				document.addField("agentZones_stored_strings", o);
			}
		}
		if(agentRoles != null) {
			for(java.lang.String o : agentRoles) {
				document.addField("agentRoles_indexed_strings", o);
			}
			for(java.lang.String o : agentRoles) {
				document.addField("agentRoles_stored_strings", o);
			}
		}
		if(agentPasserOutre != null) {
			document.addField("agentPasserOutre_indexed_boolean", agentPasserOutre);
			document.addField("agentPasserOutre_stored_boolean", agentPasserOutre);
		}
		if(droitEligible != null) {
			document.addField("droitEligible_indexed_boolean", droitEligible);
			document.addField("droitEligible_stored_boolean", droitEligible);
		}
		if(partenaireNom != null) {
			document.addField("partenaireNom_indexed_string", partenaireNom);
			document.addField("partenaireNom_stored_string", partenaireNom);
		}
		if(ajustementNomAffichage != null) {
			document.addField("ajustementNomAffichage_indexed_string", ajustementNomAffichage);
			document.addField("ajustementNomAffichage_stored_string", ajustementNomAffichage);
		}
		if(ajustementNomComplet != null) {
			document.addField("ajustementNomComplet_indexed_string", ajustementNomComplet);
			document.addField("ajustementNomComplet_stored_string", ajustementNomComplet);
		}
		if(ajustementId != null) {
			document.addField("ajustementId_indexed_string", ajustementId);
			document.addField("ajustementId_stored_string", ajustementId);
		}
		if(pageUrl != null) {
			document.addField("pageUrl_indexed_string", pageUrl);
			document.addField("pageUrl_stored_string", pageUrl);
		}
		if(objetSuggere != null) {
			document.addField("objetSuggere_suggested", objetSuggere);
			document.addField("objetSuggere_indexed_string", objetSuggere);
		}
		super.indexerCluster(document);

	}

	public void desindexerAjustementBancaire() {
		try {
		RequeteSiteFrFR requeteSite = new RequeteSiteFrFR();
			requeteSite.initLoinRequeteSiteFrFR();
			SiteContexteFrFR siteContexte = new SiteContexteFrFR();
			siteContexte.initLoinSiteContexteFrFR();
			requeteSite.setSiteContexte_(siteContexte);
			requeteSite.setConfigSite_(siteContexte.getConfigSite());
			initLoinAjustementBancaire(requeteSite);
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
		stockerAjustementBancaire(solrDocument);
	}
	public void stockerAjustementBancaire(SolrDocument solrDocument) {
		AjustementBancaire oAjustementBancaire = (AjustementBancaire)this;

		Long ajustementCle = (Long)solrDocument.get("ajustementCle_stored_long");
		if(ajustementCle != null)
			oAjustementBancaire.setAjustementCle(ajustementCle);

		Long compteCle = (Long)solrDocument.get("compteCle_stored_long");
		if(compteCle != null)
			oAjustementBancaire.setCompteCle(compteCle);

		String compteNomComplet = (String)solrDocument.get("compteNomComplet_stored_string");
		if(compteNomComplet != null)
			oAjustementBancaire.setCompteNomComplet(compteNomComplet);

		String compteNumero = (String)solrDocument.get("compteNumero_stored_string");
		if(compteNumero != null)
			oAjustementBancaire.setCompteNumero(compteNumero);

		Long transactionCle = (Long)solrDocument.get("transactionCle_stored_long");
		if(transactionCle != null)
			oAjustementBancaire.setTransactionCle(transactionCle);

		String transactionIdReference = (String)solrDocument.get("transactionIdReference_stored_string");
		if(transactionIdReference != null)
			oAjustementBancaire.setTransactionIdReference(transactionIdReference);

		String transactionCode = (String)solrDocument.get("transactionCode_stored_string");
		if(transactionCode != null)
			oAjustementBancaire.setTransactionCode(transactionCode);

		Double transactionMontant = (Double)solrDocument.get("transactionMontant_stored_double");
		if(transactionMontant != null)
			oAjustementBancaire.setTransactionMontant(transactionMontant);

		Date transactionDateHeure = (Date)solrDocument.get("transactionDateHeure_stored_date");
		if(transactionDateHeure != null)
			oAjustementBancaire.setTransactionDateHeure(transactionDateHeure);

		Date transactionDate = (Date)solrDocument.get("transactionDate_stored_date");
		if(transactionDate != null)
			oAjustementBancaire.setTransactionDate(transactionDate);

		Boolean transactionFrais = (Boolean)solrDocument.get("transactionFrais_stored_boolean");
		if(transactionFrais != null)
			oAjustementBancaire.setTransactionFrais(transactionFrais);

		List<String> agentZones = (List<String>)solrDocument.get("agentZones_stored_strings");
		if(agentZones != null)
			oAjustementBancaire.agentZones.addAll(agentZones);

		List<String> agentRoles = (List<String>)solrDocument.get("agentRoles_stored_strings");
		if(agentRoles != null)
			oAjustementBancaire.agentRoles.addAll(agentRoles);

		Boolean agentPasserOutre = (Boolean)solrDocument.get("agentPasserOutre_stored_boolean");
		if(agentPasserOutre != null)
			oAjustementBancaire.setAgentPasserOutre(agentPasserOutre);

		Boolean droitEligible = (Boolean)solrDocument.get("droitEligible_stored_boolean");
		if(droitEligible != null)
			oAjustementBancaire.setDroitEligible(droitEligible);

		String partenaireNom = (String)solrDocument.get("partenaireNom_stored_string");
		if(partenaireNom != null)
			oAjustementBancaire.setPartenaireNom(partenaireNom);

		String ajustementNomAffichage = (String)solrDocument.get("ajustementNomAffichage_stored_string");
		if(ajustementNomAffichage != null)
			oAjustementBancaire.setAjustementNomAffichage(ajustementNomAffichage);

		String ajustementNomComplet = (String)solrDocument.get("ajustementNomComplet_stored_string");
		if(ajustementNomComplet != null)
			oAjustementBancaire.setAjustementNomComplet(ajustementNomComplet);

		String ajustementId = (String)solrDocument.get("ajustementId_stored_string");
		if(ajustementId != null)
			oAjustementBancaire.setAjustementId(ajustementId);

		String pageUrl = (String)solrDocument.get("pageUrl_stored_string");
		if(pageUrl != null)
			oAjustementBancaire.setPageUrl(pageUrl);

		String objetSuggere = (String)solrDocument.get("objetSuggere_suggested");
		oAjustementBancaire.setObjetSuggere(objetSuggere);

		super.stockerCluster(solrDocument);
	}

	//////////////
	// hashCode //
	//////////////

	@Override public int hashCode() {
		return Objects.hash(super.hashCode(), agentZones, agentRoles, agentPasserOutre, droitEligible, partenaireNom, ajustementNomAffichage);
	}

	////////////
	// equals //
	////////////

	@Override public boolean equals(Object o) {
		if(this == o)
			return true;
		if(!(o instanceof AjustementBancaire))
			return false;
		AjustementBancaire that = (AjustementBancaire)o;
		return super.equals(o)
				&& Objects.equals( agentZones, that.agentZones )
				&& Objects.equals( agentRoles, that.agentRoles )
				&& Objects.equals( agentPasserOutre, that.agentPasserOutre )
				&& Objects.equals( droitEligible, that.droitEligible )
				&& Objects.equals( partenaireNom, that.partenaireNom )
				&& Objects.equals( ajustementNomAffichage, that.ajustementNomAffichage );
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString() + "\n");
		sb.append("AjustementBancaire { ");
		sb.append( "agentZones: " ).append(agentZones);
		sb.append( ", agentRoles: " ).append(agentRoles);
		sb.append( ", agentPasserOutre: " ).append(agentPasserOutre);
		sb.append( ", droitEligible: " ).append(droitEligible);
		sb.append( ", partenaireNom: \"" ).append(partenaireNom).append( "\"" );
		sb.append( ", ajustementNomAffichage: \"" ).append(ajustementNomAffichage).append( "\"" );
		sb.append(" }");
		return sb.toString();
	}
}
