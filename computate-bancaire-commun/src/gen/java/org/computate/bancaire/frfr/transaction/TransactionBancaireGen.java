package org.computate.bancaire.frfr.transaction;

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
import org.computate.bancaire.frfr.transaction.code.CodeTransaction;
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
 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.transaction.TransactionBancaire&fq=classeEtendGen_indexed_boolean:true">Trouver la classe objectSuggest dans Solr</a>
 * <br/>
 **/
public abstract class TransactionBancaireGen<DEV> extends Cluster {
	private static final Logger LOGGER = LoggerFactory.getLogger(TransactionBancaire.class);

	public static final String TransactionBancaire_UnNom = "une transaction";
	public static final String TransactionBancaire_Ce = "cette ";
	public static final String TransactionBancaire_CeNom = "cette transaction";
	public static final String TransactionBancaire_Un = "une ";
	public static final String TransactionBancaire_LeNom = "la transaction";
	public static final String TransactionBancaire_NomSingulier = "transaction";
	public static final String TransactionBancaire_NomPluriel = "transactions";
	public static final String TransactionBancaire_NomActuel = "transaction actuelle";
	public static final String TransactionBancaire_Tous = "all ";
	public static final String TransactionBancaire_TousNom = "toutes les transactions";
	public static final String TransactionBancaire_RechercherTousNomPar = "rechercher transactions par ";
	public static final String TransactionBancaire_RechercherTousNom = "rechercher transactions";
	public static final String TransactionBancaire_LesNoms = "les transactions";
	public static final String TransactionBancaire_AucunNomTrouve = "aucune transaction trouvée";
	public static final String TransactionBancaire_NomVar = "transaction";
	public static final String TransactionBancaire_DeNom = "de transaction";
	public static final String TransactionBancaire_NomAdjectifSingulier = "transaction";
	public static final String TransactionBancaire_NomAdjectifPluriel = "transactions";
	public static final String TransactionBancaire_Couleur = "yellow";
	public static final String TransactionBancaire_IconeGroupe = "duotone";
	public static final String TransactionBancaire_IconeNom = "cash-register";

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
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.transaction.TransactionBancaire&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:transactionCle">Trouver l'entité transactionCle dans Solr</a>
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
	public TransactionBancaire setTransactionCle(String o) {
		if(NumberUtils.isParsable(o))
			this.transactionCle = Long.parseLong(o);
		this.transactionCleCouverture.dejaInitialise = true;
		return (TransactionBancaire)this;
	}
	protected TransactionBancaire transactionCleInit() {
		if(!transactionCleCouverture.dejaInitialise) {
			_transactionCle(transactionCleCouverture);
			if(transactionCle == null)
				setTransactionCle(transactionCleCouverture.o);
		}
		transactionCleCouverture.dejaInitialise(true);
		return (TransactionBancaire)this;
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
		return "clé";
	}

	public String htmTooltipTransactionCle() {
		return null;
	}

	public String htmTransactionCle() {
		return transactionCle == null ? "" : StringEscapeUtils.escapeHtml4(strTransactionCle());
	}

	public void htmTransactionCle(ToutEcrivain r, Boolean patchDroits) {
		if(pk!= null) {
			r.s("<div id=\"patchTransactionBancaire", strPk(), "TransactionCle\">");
			if(patchDroits) {
				r.l();
				r.l("	<script>//<![CDATA[");
				r.l("		function patchTransactionBancaire", strPk(), "TransactionCle() {");
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
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.transaction.TransactionBancaire&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:compteCle">Trouver l'entité compteCle dans Solr</a>
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
	public TransactionBancaire setCompteCle(String o) {
		if(NumberUtils.isParsable(o))
			this.compteCle = Long.parseLong(o);
		this.compteCleCouverture.dejaInitialise = true;
		return (TransactionBancaire)this;
	}
	protected TransactionBancaire compteCleInit() {
		if(!compteCleCouverture.dejaInitialise) {
			_compteCle(compteCleCouverture);
			if(compteCle == null)
				setCompteCle(compteCleCouverture.o);
		}
		compteCleCouverture.dejaInitialise(true);
		return (TransactionBancaire)this;
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
			r.s("<div id=\"patchTransactionBancaire", strPk(), "CompteCle\">");
			if(patchDroits) {
				r.l();
				r.l("	<script>//<![CDATA[");
				r.l("		function patchTransactionBancaire", strPk(), "CompteCle() {");
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
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.transaction.TransactionBancaire&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:compteRecherche">Trouver l'entité compteRecherche dans Solr</a>
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
	protected TransactionBancaire compteRechercheInit() {
		if(!compteRechercheCouverture.dejaInitialise) {
			_compteRecherche(compteRecherche);
		}
		compteRecherche.initLoinPourClasse(requeteSite_);
		compteRechercheCouverture.dejaInitialise(true);
		return (TransactionBancaire)this;
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
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.transaction.TransactionBancaire&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:compte_">Trouver l'entité compte_ dans Solr</a>
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
	protected TransactionBancaire compte_Init() {
		if(!compte_Couverture.dejaInitialise) {
			_compte_(compte_Couverture);
			if(compte_ == null)
				setCompte_(compte_Couverture.o);
		}
		compte_Couverture.dejaInitialise(true);
		return (TransactionBancaire)this;
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
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.transaction.TransactionBancaire&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:compteNomComplet">Trouver l'entité compteNomComplet dans Solr</a>
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
	protected TransactionBancaire compteNomCompletInit() {
		if(!compteNomCompletCouverture.dejaInitialise) {
			_compteNomComplet(compteNomCompletCouverture);
			if(compteNomComplet == null)
				setCompteNomComplet(compteNomCompletCouverture.o);
		}
		compteNomCompletCouverture.dejaInitialise(true);
		return (TransactionBancaire)this;
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
			r.s("<div id=\"patchTransactionBancaire", strPk(), "CompteNomComplet\">");
			if(patchDroits) {
				r.l();
				r.l("	<script>//<![CDATA[");
				r.l("		function patchTransactionBancaire", strPk(), "CompteNomComplet() {");
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
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.transaction.TransactionBancaire&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:compteNumero">Trouver l'entité compteNumero dans Solr</a>
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
	protected TransactionBancaire compteNumeroInit() {
		if(!compteNumeroCouverture.dejaInitialise) {
			_compteNumero(compteNumeroCouverture);
			if(compteNumero == null)
				setCompteNumero(compteNumeroCouverture.o);
		}
		compteNumeroCouverture.dejaInitialise(true);
		return (TransactionBancaire)this;
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
			r.s("<div id=\"patchTransactionBancaire", strPk(), "CompteNumero\">");
			if(patchDroits) {
				r.l();
				r.l("	<script>//<![CDATA[");
				r.l("		function patchTransactionBancaire", strPk(), "CompteNumero() {");
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
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.transaction.TransactionBancaire&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:transactionCode">Trouver l'entité transactionCode dans Solr</a>
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
	protected TransactionBancaire transactionCodeInit() {
		if(!transactionCodeCouverture.dejaInitialise) {
			_transactionCode(transactionCodeCouverture);
			if(transactionCode == null)
				setTransactionCode(transactionCodeCouverture.o);
		}
		transactionCodeCouverture.dejaInitialise(true);
		return (TransactionBancaire)this;
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
		return "code de transaction";
	}

	public String htmTooltipTransactionCode() {
		return null;
	}

	public String htmTransactionCode() {
		return transactionCode == null ? "" : StringEscapeUtils.escapeHtml4(strTransactionCode());
	}

	public void htmTransactionCode(ToutEcrivain r, Boolean patchDroits) {
		if(pk!= null) {
			r.s("<div id=\"patchTransactionBancaire", strPk(), "TransactionCode\">");
			if(patchDroits) {
				r.l();
				r.l("	<script>//<![CDATA[");
				r.l("		function patchTransactionBancaire", strPk(), "TransactionCode() {");
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

	//////////////////////////////
	// codeTransactionRecherche //
	//////////////////////////////

	/**	L'entité « codeTransactionRecherche »
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut ListeRecherche<CodeTransaction>(). 
	 */
	@JsonIgnore
	protected ListeRecherche<CodeTransaction> codeTransactionRecherche = new ListeRecherche<CodeTransaction>();
	@JsonIgnore
	public Couverture<ListeRecherche<CodeTransaction>> codeTransactionRechercheCouverture = new Couverture<ListeRecherche<CodeTransaction>>().p(this).c(ListeRecherche.class).var("codeTransactionRecherche").o(codeTransactionRecherche);

	/**	<br/>L'entité « codeTransactionRecherche »
	 * Il est construit avant d'être initialisé avec le constructeur par défaut ListeRecherche<CodeTransaction>(). 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.transaction.TransactionBancaire&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:codeTransactionRecherche">Trouver l'entité codeTransactionRecherche dans Solr</a>
	 * <br/>
	 * @param codeTransactionRecherche est l'entité déjà construit. 
	 **/
	protected abstract void _codeTransactionRecherche(ListeRecherche<CodeTransaction> l);

	public ListeRecherche<CodeTransaction> getCodeTransactionRecherche() {
		return codeTransactionRecherche;
	}

	public void setCodeTransactionRecherche(ListeRecherche<CodeTransaction> codeTransactionRecherche) {
		this.codeTransactionRecherche = codeTransactionRecherche;
		this.codeTransactionRechercheCouverture.dejaInitialise = true;
	}
	protected TransactionBancaire codeTransactionRechercheInit() {
		if(!codeTransactionRechercheCouverture.dejaInitialise) {
			_codeTransactionRecherche(codeTransactionRecherche);
		}
		codeTransactionRecherche.initLoinPourClasse(requeteSite_);
		codeTransactionRechercheCouverture.dejaInitialise(true);
		return (TransactionBancaire)this;
	}

	///////////////////////////
	// codeTransactionObjet_ //
	///////////////////////////

	/**	L'entité « codeTransactionObjet_ »
	 *	 is defined as null before being initialized. 
	 */
	@JsonIgnore
	protected CodeTransaction codeTransactionObjet_;
	@JsonIgnore
	public Couverture<CodeTransaction> codeTransactionObjet_Couverture = new Couverture<CodeTransaction>().p(this).c(CodeTransaction.class).var("codeTransactionObjet_").o(codeTransactionObjet_);

	/**	<br/>L'entité « codeTransactionObjet_ »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.transaction.TransactionBancaire&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:codeTransactionObjet_">Trouver l'entité codeTransactionObjet_ dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _codeTransactionObjet_(Couverture<CodeTransaction> c);

	public CodeTransaction getCodeTransactionObjet_() {
		return codeTransactionObjet_;
	}

	public void setCodeTransactionObjet_(CodeTransaction codeTransactionObjet_) {
		this.codeTransactionObjet_ = codeTransactionObjet_;
		this.codeTransactionObjet_Couverture.dejaInitialise = true;
	}
	protected TransactionBancaire codeTransactionObjet_Init() {
		if(!codeTransactionObjet_Couverture.dejaInitialise) {
			_codeTransactionObjet_(codeTransactionObjet_Couverture);
			if(codeTransactionObjet_ == null)
				setCodeTransactionObjet_(codeTransactionObjet_Couverture.o);
		}
		codeTransactionObjet_Couverture.dejaInitialise(true);
		return (TransactionBancaire)this;
	}

	///////////////////////////////
	// codeTransactionNomComplet //
	///////////////////////////////

	/**	L'entité « codeTransactionNomComplet »
	 *	 is defined as null before being initialized. 
	 */
	protected String codeTransactionNomComplet;
	@JsonIgnore
	public Couverture<String> codeTransactionNomCompletCouverture = new Couverture<String>().p(this).c(String.class).var("codeTransactionNomComplet").o(codeTransactionNomComplet);

	/**	<br/>L'entité « codeTransactionNomComplet »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.transaction.TransactionBancaire&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:codeTransactionNomComplet">Trouver l'entité codeTransactionNomComplet dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _codeTransactionNomComplet(Couverture<String> c);

	public String getCodeTransactionNomComplet() {
		return codeTransactionNomComplet;
	}

	public void setCodeTransactionNomComplet(String codeTransactionNomComplet) {
		this.codeTransactionNomComplet = codeTransactionNomComplet;
		this.codeTransactionNomCompletCouverture.dejaInitialise = true;
	}
	protected TransactionBancaire codeTransactionNomCompletInit() {
		if(!codeTransactionNomCompletCouverture.dejaInitialise) {
			_codeTransactionNomComplet(codeTransactionNomCompletCouverture);
			if(codeTransactionNomComplet == null)
				setCodeTransactionNomComplet(codeTransactionNomCompletCouverture.o);
		}
		codeTransactionNomCompletCouverture.dejaInitialise(true);
		return (TransactionBancaire)this;
	}

	public String solrCodeTransactionNomComplet() {
		return codeTransactionNomComplet;
	}

	public String strCodeTransactionNomComplet() {
		return codeTransactionNomComplet == null ? "" : codeTransactionNomComplet;
	}

	public String jsonCodeTransactionNomComplet() {
		return codeTransactionNomComplet == null ? "" : codeTransactionNomComplet;
	}

	public String nomAffichageCodeTransactionNomComplet() {
		return null;
	}

	public String htmTooltipCodeTransactionNomComplet() {
		return null;
	}

	public String htmCodeTransactionNomComplet() {
		return codeTransactionNomComplet == null ? "" : StringEscapeUtils.escapeHtml4(strCodeTransactionNomComplet());
	}

	public void htmCodeTransactionNomComplet(ToutEcrivain r, Boolean patchDroits) {
		if(pk!= null) {
			r.s("<div id=\"patchTransactionBancaire", strPk(), "CodeTransactionNomComplet\">");
			if(patchDroits) {
				r.l();
				r.l("	<script>//<![CDATA[");
				r.l("		function patchTransactionBancaire", strPk(), "CodeTransactionNomComplet() {");
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
				r.l("				data: {\"setCodeTransactionNomComplet\": this.value },");
				r.l("				");
				r.l("			});");
				r.l("		}");
				r.l("	//]]></script>");
				r.l("	<div class=\"\">");
				r.l("		<label class=\"w3-tooltip \">");
				r.l("			<span>", StringEscapeUtils.escapeHtml4(nomAffichageCodeTransactionNomComplet()), "</span>");
				r.s("			<input");
							r.s(" name=\"codeTransactionNomComplet\"");
							r.s(" value=\"", htmCodeTransactionNomComplet(), "\");");
							r.s(" onchange=\"\"");
							r.l("/>");
				r.l("		</label>");
				r.l("	</div>");
			} else {
				r.s(htmCodeTransactionNomComplet());
			}
			r.l("</div>");
		}
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
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.transaction.TransactionBancaire&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:transactionIdReference">Trouver l'entité transactionIdReference dans Solr</a>
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
	protected TransactionBancaire transactionIdReferenceInit() {
		if(!transactionIdReferenceCouverture.dejaInitialise) {
			_transactionIdReference(transactionIdReferenceCouverture);
			if(transactionIdReference == null)
				setTransactionIdReference(transactionIdReferenceCouverture.o);
		}
		transactionIdReferenceCouverture.dejaInitialise(true);
		return (TransactionBancaire)this;
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
			r.s("<div id=\"patchTransactionBancaire", strPk(), "TransactionIdReference\">");
			if(patchDroits) {
				r.l();
				r.l("	<script>//<![CDATA[");
				r.l("		function patchTransactionBancaire", strPk(), "TransactionIdReference() {");
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
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.transaction.TransactionBancaire&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:transactionMontant">Trouver l'entité transactionMontant dans Solr</a>
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
	public TransactionBancaire setTransactionMontant(String o) {
		o = StringUtils.removeAll(o, "[^\\d\\.]");
		if(NumberUtils.isParsable(o))
			this.transactionMontant = new BigDecimal(o, MathContext.DECIMAL64).setScale(2);
		this.transactionMontantCouverture.dejaInitialise = true;
		return (TransactionBancaire)this;
	}
	public TransactionBancaire setTransactionMontant(Double o) {
			this.transactionMontant = new BigDecimal(o, MathContext.DECIMAL64).setScale(2);
		this.transactionMontantCouverture.dejaInitialise = true;
		return (TransactionBancaire)this;
	}
	public TransactionBancaire setTransactionMontant(Integer o) {
			this.transactionMontant = new BigDecimal(o, MathContext.DECIMAL64).setScale(2);
		this.transactionMontantCouverture.dejaInitialise = true;
		return (TransactionBancaire)this;
	}
	protected TransactionBancaire transactionMontantInit() {
		if(!transactionMontantCouverture.dejaInitialise) {
			_transactionMontant(transactionMontantCouverture);
			if(transactionMontant == null)
				setTransactionMontant(transactionMontantCouverture.o);
		}
		transactionMontantCouverture.dejaInitialise(true);
		return (TransactionBancaire)this;
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
			r.s("<div id=\"patchTransactionBancaire", strPk(), "TransactionMontant\">");
			if(patchDroits) {
				r.l();
				r.l("	<script>//<![CDATA[");
				r.l("		function patchTransactionBancaire", strPk(), "TransactionMontant() {");
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
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.transaction.TransactionBancaire&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:transactionDateHeure">Trouver l'entité transactionDateHeure dans Solr</a>
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
	public TransactionBancaire setTransactionDateHeure(Instant o) {
		this.transactionDateHeure = ZonedDateTime.from(o);
		this.transactionDateHeureCouverture.dejaInitialise = true;
		return (TransactionBancaire)this;
	}
	/** Example: 2011-12-03T10:15:30+01:00 **/
	public TransactionBancaire setTransactionDateHeure(String o) {
		this.transactionDateHeure = ZonedDateTime.parse(o, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
		this.transactionDateHeureCouverture.dejaInitialise = true;
		return (TransactionBancaire)this;
	}
	public TransactionBancaire setTransactionDateHeure(Date o) {
		this.transactionDateHeure = ZonedDateTime.ofInstant(o.toInstant(), ZoneId.of(requeteSite_.getConfigSite_().getSiteZone()));
		this.transactionDateHeureCouverture.dejaInitialise = true;
		return (TransactionBancaire)this;
	}
	protected TransactionBancaire transactionDateHeureInit() {
		if(!transactionDateHeureCouverture.dejaInitialise) {
			_transactionDateHeure(transactionDateHeureCouverture);
			if(transactionDateHeure == null)
				setTransactionDateHeure(transactionDateHeureCouverture.o);
		}
		transactionDateHeureCouverture.dejaInitialise(true);
		return (TransactionBancaire)this;
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
			r.s("<div id=\"patchTransactionBancaire", strPk(), "TransactionDateHeure\">");
			if(patchDroits) {
				r.l();
				r.l("	<script>//<![CDATA[");
				r.l("		function patchTransactionBancaire", strPk(), "TransactionDateHeure() {");
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
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.transaction.TransactionBancaire&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:transactionDate">Trouver l'entité transactionDate dans Solr</a>
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
	public TransactionBancaire setTransactionDate(Instant o) {
		this.transactionDate = LocalDate.from(o);
		this.transactionDateCouverture.dejaInitialise = true;
		return (TransactionBancaire)this;
	}
	/** Example: 2011-12-03+01:00 **/
	public TransactionBancaire setTransactionDate(String o) {
		this.transactionDate = LocalDate.parse(o, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
		this.transactionDateCouverture.dejaInitialise = true;
		return (TransactionBancaire)this;
	}
	public TransactionBancaire setTransactionDate(Date o) {
		this.transactionDate = o.toInstant().atZone(ZoneId.of(requeteSite_.getConfigSite_().getSiteZone())).toLocalDate();
		this.transactionDateCouverture.dejaInitialise = true;
		return (TransactionBancaire)this;
	}
	protected TransactionBancaire transactionDateInit() {
		if(!transactionDateCouverture.dejaInitialise) {
			_transactionDate(transactionDateCouverture);
			if(transactionDate == null)
				setTransactionDate(transactionDateCouverture.o);
		}
		transactionDateCouverture.dejaInitialise(true);
		return (TransactionBancaire)this;
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
			r.s("<div id=\"patchTransactionBancaire", strPk(), "TransactionDate\">");
			if(patchDroits) {
				r.l();
				r.l("	<script>//<![CDATA[");
				r.l("		function patchTransactionBancaire", strPk(), "TransactionDate() {");
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
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.transaction.TransactionBancaire&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:transactionFrais">Trouver l'entité transactionFrais dans Solr</a>
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
	public TransactionBancaire setTransactionFrais(String o) {
		this.transactionFrais = Boolean.parseBoolean(o);
		this.transactionFraisCouverture.dejaInitialise = true;
		return (TransactionBancaire)this;
	}
	protected TransactionBancaire transactionFraisInit() {
		if(!transactionFraisCouverture.dejaInitialise) {
			_transactionFrais(transactionFraisCouverture);
			if(transactionFrais == null)
				setTransactionFrais(transactionFraisCouverture.o);
		}
		transactionFraisCouverture.dejaInitialise(true);
		return (TransactionBancaire)this;
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
			r.s("<div id=\"patchTransactionBancaire", strPk(), "TransactionFrais\">");
			if(patchDroits) {
				r.l();
				r.l("	<script>//<![CDATA[");
				r.l("		function patchTransactionBancaire", strPk(), "TransactionFrais() {");
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

	/////////////////////////////
	// transactionNomAffichage //
	/////////////////////////////

	/**	L'entité « transactionNomAffichage »
	 *	 is defined as null before being initialized. 
	 */
	protected String transactionNomAffichage;
	@JsonIgnore
	public Couverture<String> transactionNomAffichageCouverture = new Couverture<String>().p(this).c(String.class).var("transactionNomAffichage").o(transactionNomAffichage);

	/**	<br/>L'entité « transactionNomAffichage »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.transaction.TransactionBancaire&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:transactionNomAffichage">Trouver l'entité transactionNomAffichage dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _transactionNomAffichage(Couverture<String> c);

	public String getTransactionNomAffichage() {
		return transactionNomAffichage;
	}

	public void setTransactionNomAffichage(String transactionNomAffichage) {
		this.transactionNomAffichage = transactionNomAffichage;
		this.transactionNomAffichageCouverture.dejaInitialise = true;
	}
	protected TransactionBancaire transactionNomAffichageInit() {
		if(!transactionNomAffichageCouverture.dejaInitialise) {
			_transactionNomAffichage(transactionNomAffichageCouverture);
			if(transactionNomAffichage == null)
				setTransactionNomAffichage(transactionNomAffichageCouverture.o);
		}
		transactionNomAffichageCouverture.dejaInitialise(true);
		return (TransactionBancaire)this;
	}

	public String solrTransactionNomAffichage() {
		return transactionNomAffichage;
	}

	public String strTransactionNomAffichage() {
		return transactionNomAffichage == null ? "" : transactionNomAffichage;
	}

	public String jsonTransactionNomAffichage() {
		return transactionNomAffichage == null ? "" : transactionNomAffichage;
	}

	public String nomAffichageTransactionNomAffichage() {
		return "nom d'affichage";
	}

	public String htmTooltipTransactionNomAffichage() {
		return null;
	}

	public String htmTransactionNomAffichage() {
		return transactionNomAffichage == null ? "" : StringEscapeUtils.escapeHtml4(strTransactionNomAffichage());
	}

	public void htmTransactionNomAffichage(ToutEcrivain r, Boolean patchDroits) {
		if(pk!= null) {
			r.s("<div id=\"patchTransactionBancaire", strPk(), "TransactionNomAffichage\">");
			if(patchDroits) {
				r.l();
				r.l("	<script>//<![CDATA[");
				r.l("		function patchTransactionBancaire", strPk(), "TransactionNomAffichage() {");
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
				r.l("				data: {\"setTransactionNomAffichage\": this.value },");
				r.l("				");
				r.l("			});");
				r.l("		}");
				r.l("	//]]></script>");
				r.l("	<div class=\"\">");
				r.l("		<label class=\"w3-tooltip \">");
				r.l("			<span>", StringEscapeUtils.escapeHtml4(nomAffichageTransactionNomAffichage()), "</span>");
				r.s("			<input");
							r.s(" name=\"transactionNomAffichage\"");
							r.s(" value=\"", htmTransactionNomAffichage(), "\");");
							r.s(" onchange=\"\"");
							r.l("/>");
				r.l("		</label>");
				r.l("	</div>");
			} else {
				r.s(htmTransactionNomAffichage());
			}
			r.l("</div>");
		}
	}

	///////////////////////////
	// transactionNomComplet //
	///////////////////////////

	/**	L'entité « transactionNomComplet »
	 *	 is defined as null before being initialized. 
	 */
	protected String transactionNomComplet;
	@JsonIgnore
	public Couverture<String> transactionNomCompletCouverture = new Couverture<String>().p(this).c(String.class).var("transactionNomComplet").o(transactionNomComplet);

	/**	<br/>L'entité « transactionNomComplet »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.transaction.TransactionBancaire&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:transactionNomComplet">Trouver l'entité transactionNomComplet dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _transactionNomComplet(Couverture<String> c);

	public String getTransactionNomComplet() {
		return transactionNomComplet;
	}

	public void setTransactionNomComplet(String transactionNomComplet) {
		this.transactionNomComplet = transactionNomComplet;
		this.transactionNomCompletCouverture.dejaInitialise = true;
	}
	protected TransactionBancaire transactionNomCompletInit() {
		if(!transactionNomCompletCouverture.dejaInitialise) {
			_transactionNomComplet(transactionNomCompletCouverture);
			if(transactionNomComplet == null)
				setTransactionNomComplet(transactionNomCompletCouverture.o);
		}
		transactionNomCompletCouverture.dejaInitialise(true);
		return (TransactionBancaire)this;
	}

	public String solrTransactionNomComplet() {
		return transactionNomComplet;
	}

	public String strTransactionNomComplet() {
		return transactionNomComplet == null ? "" : transactionNomComplet;
	}

	public String jsonTransactionNomComplet() {
		return transactionNomComplet == null ? "" : transactionNomComplet;
	}

	public String nomAffichageTransactionNomComplet() {
		return null;
	}

	public String htmTooltipTransactionNomComplet() {
		return null;
	}

	public String htmTransactionNomComplet() {
		return transactionNomComplet == null ? "" : StringEscapeUtils.escapeHtml4(strTransactionNomComplet());
	}

	public void htmTransactionNomComplet(ToutEcrivain r, Boolean patchDroits) {
		if(pk!= null) {
			r.s("<div id=\"patchTransactionBancaire", strPk(), "TransactionNomComplet\">");
			if(patchDroits) {
				r.l();
				r.l("	<script>//<![CDATA[");
				r.l("		function patchTransactionBancaire", strPk(), "TransactionNomComplet() {");
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
				r.l("				data: {\"setTransactionNomComplet\": this.value },");
				r.l("				");
				r.l("			});");
				r.l("		}");
				r.l("	//]]></script>");
				r.l("	<div class=\"\">");
				r.l("		<label class=\"w3-tooltip \">");
				r.l("			<span>", StringEscapeUtils.escapeHtml4(nomAffichageTransactionNomComplet()), "</span>");
				r.s("			<input");
							r.s(" name=\"transactionNomComplet\"");
							r.s(" value=\"", htmTransactionNomComplet(), "\");");
							r.s(" onchange=\"\"");
							r.l("/>");
				r.l("		</label>");
				r.l("	</div>");
			} else {
				r.s(htmTransactionNomComplet());
			}
			r.l("</div>");
		}
	}

	///////////////////
	// transactionId //
	///////////////////

	/**	L'entité « transactionId »
	 *	 is defined as null before being initialized. 
	 */
	protected String transactionId;
	@JsonIgnore
	public Couverture<String> transactionIdCouverture = new Couverture<String>().p(this).c(String.class).var("transactionId").o(transactionId);

	/**	<br/>L'entité « transactionId »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.transaction.TransactionBancaire&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:transactionId">Trouver l'entité transactionId dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _transactionId(Couverture<String> c);

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
		this.transactionIdCouverture.dejaInitialise = true;
	}
	protected TransactionBancaire transactionIdInit() {
		if(!transactionIdCouverture.dejaInitialise) {
			_transactionId(transactionIdCouverture);
			if(transactionId == null)
				setTransactionId(transactionIdCouverture.o);
		}
		transactionIdCouverture.dejaInitialise(true);
		return (TransactionBancaire)this;
	}

	public String solrTransactionId() {
		return transactionId;
	}

	public String strTransactionId() {
		return transactionId == null ? "" : transactionId;
	}

	public String jsonTransactionId() {
		return transactionId == null ? "" : transactionId;
	}

	public String nomAffichageTransactionId() {
		return "ID";
	}

	public String htmTooltipTransactionId() {
		return null;
	}

	public String htmTransactionId() {
		return transactionId == null ? "" : StringEscapeUtils.escapeHtml4(strTransactionId());
	}

	public void htmTransactionId(ToutEcrivain r, Boolean patchDroits) {
		if(pk!= null) {
			r.s("<div id=\"patchTransactionBancaire", strPk(), "TransactionId\">");
			if(patchDroits) {
				r.l();
				r.l("	<script>//<![CDATA[");
				r.l("		function patchTransactionBancaire", strPk(), "TransactionId() {");
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
				r.l("				data: {\"setTransactionId\": this.value },");
				r.l("				");
				r.l("			});");
				r.l("		}");
				r.l("	//]]></script>");
				r.l("	<div class=\"\">");
				r.l("		<label class=\"w3-tooltip \">");
				r.l("			<span>", StringEscapeUtils.escapeHtml4(nomAffichageTransactionId()), "</span>");
				r.s("			<input");
							r.s(" name=\"transactionId\"");
							r.s(" value=\"", htmTransactionId(), "\");");
							r.s(" onchange=\"\"");
							r.l("/>");
				r.l("		</label>");
				r.l("	</div>");
			} else {
				r.s(htmTransactionId());
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
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.transaction.TransactionBancaire&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:pageUrl">Trouver l'entité pageUrl dans Solr</a>
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
	protected TransactionBancaire pageUrlInit() {
		if(!pageUrlCouverture.dejaInitialise) {
			_pageUrl(pageUrlCouverture);
			if(pageUrl == null)
				setPageUrl(pageUrlCouverture.o);
		}
		pageUrlCouverture.dejaInitialise(true);
		return (TransactionBancaire)this;
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
			r.s("<div id=\"patchTransactionBancaire", strPk(), "PageUrl\">");
			if(patchDroits) {
				r.l();
				r.l("	<script>//<![CDATA[");
				r.l("		function patchTransactionBancaire", strPk(), "PageUrl() {");
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
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.transaction.TransactionBancaire&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:objetSuggere">Trouver l'entité objetSuggere dans Solr</a>
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
	protected TransactionBancaire objetSuggereInit() {
		if(!objetSuggereCouverture.dejaInitialise) {
			_objetSuggere(objetSuggereCouverture);
			if(objetSuggere == null)
				setObjetSuggere(objetSuggereCouverture.o);
		}
		objetSuggereCouverture.dejaInitialise(true);
		return (TransactionBancaire)this;
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
			r.s("<div id=\"patchTransactionBancaire", strPk(), "ObjetSuggere\">");
			if(patchDroits) {
				r.l();
				r.l("	<script>//<![CDATA[");
				r.l("		function patchTransactionBancaire", strPk(), "ObjetSuggere() {");
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

	protected boolean dejaInitialiseTransactionBancaire = false;

	public TransactionBancaire initLoinTransactionBancaire(RequeteSiteFrFR requeteSite_) {
		setRequeteSite_(requeteSite_);
		if(!dejaInitialiseTransactionBancaire) {
			dejaInitialiseTransactionBancaire = true;
			initLoinTransactionBancaire();
		}
		return (TransactionBancaire)this;
	}

	public void initLoinTransactionBancaire() {
		super.initLoinCluster(requeteSite_);
		initTransactionBancaire();
	}

	public void initTransactionBancaire() {
		transactionCleInit();
		compteCleInit();
		compteRechercheInit();
		compte_Init();
		compteNomCompletInit();
		compteNumeroInit();
		transactionCodeInit();
		codeTransactionRechercheInit();
		codeTransactionObjet_Init();
		codeTransactionNomCompletInit();
		transactionIdReferenceInit();
		transactionMontantInit();
		transactionDateHeureInit();
		transactionDateInit();
		transactionFraisInit();
		transactionNomAffichageInit();
		transactionNomCompletInit();
		transactionIdInit();
		pageUrlInit();
		objetSuggereInit();
	}

	@Override public void initLoinPourClasse(RequeteSiteFrFR requeteSite_) {
		initLoinTransactionBancaire(requeteSite_);
	}

	/////////////////
	// requeteSite //
	/////////////////

	public void requeteSiteTransactionBancaire(RequeteSiteFrFR requeteSite_) {
			super.requeteSiteCluster(requeteSite_);
		if(compteRecherche != null)
			compteRecherche.setRequeteSite_(requeteSite_);
		if(codeTransactionRecherche != null)
			codeTransactionRecherche.setRequeteSite_(requeteSite_);
	}

	public void requeteSitePourClasse(RequeteSiteFrFR requeteSite_) {
		requeteSiteTransactionBancaire(requeteSite_);
	}

	/////////////
	// obtenir //
	/////////////

	@Override public Object obtenirPourClasse(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtenirTransactionBancaire(v);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.obtenirPourClasse(v);
			}
		}
		return o;
	}
	public Object obtenirTransactionBancaire(String var) {
		TransactionBancaire oTransactionBancaire = (TransactionBancaire)this;
		switch(var) {
			case "transactionCle":
				return oTransactionBancaire.transactionCle;
			case "compteCle":
				return oTransactionBancaire.compteCle;
			case "compteRecherche":
				return oTransactionBancaire.compteRecherche;
			case "compte_":
				return oTransactionBancaire.compte_;
			case "compteNomComplet":
				return oTransactionBancaire.compteNomComplet;
			case "compteNumero":
				return oTransactionBancaire.compteNumero;
			case "transactionCode":
				return oTransactionBancaire.transactionCode;
			case "codeTransactionRecherche":
				return oTransactionBancaire.codeTransactionRecherche;
			case "codeTransactionObjet_":
				return oTransactionBancaire.codeTransactionObjet_;
			case "codeTransactionNomComplet":
				return oTransactionBancaire.codeTransactionNomComplet;
			case "transactionIdReference":
				return oTransactionBancaire.transactionIdReference;
			case "transactionMontant":
				return oTransactionBancaire.transactionMontant;
			case "transactionDateHeure":
				return oTransactionBancaire.transactionDateHeure;
			case "transactionDate":
				return oTransactionBancaire.transactionDate;
			case "transactionFrais":
				return oTransactionBancaire.transactionFrais;
			case "transactionNomAffichage":
				return oTransactionBancaire.transactionNomAffichage;
			case "transactionNomComplet":
				return oTransactionBancaire.transactionNomComplet;
			case "transactionId":
				return oTransactionBancaire.transactionId;
			case "pageUrl":
				return oTransactionBancaire.pageUrl;
			case "objetSuggere":
				return oTransactionBancaire.objetSuggere;
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
				o = attribuerTransactionBancaire(v, val);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.attribuerPourClasse(v, val);
			}
		}
		return o != null;
	}
	public Object attribuerTransactionBancaire(String var, Object val) {
		TransactionBancaire oTransactionBancaire = (TransactionBancaire)this;
		switch(var) {
			case "compteCle":
				oTransactionBancaire.setCompteCle((Long)val);
				return val;
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
					o = definirTransactionBancaire(v, val);
				else if(o instanceof Cluster) {
					Cluster cluster = (Cluster)o;
					o = cluster.definirPourClasse(v, val);
				}
			}
		}
		return o != null;
	}
	public Object definirTransactionBancaire(String var, String val) {
		switch(var) {
			case "transactionCode":
				setTransactionCode(val);
				sauvegardesTransactionBancaire.add(var);
				return val;
			case "transactionIdReference":
				setTransactionIdReference(val);
				sauvegardesTransactionBancaire.add(var);
				return val;
			case "transactionMontant":
				setTransactionMontant(val);
				sauvegardesTransactionBancaire.add(var);
				return val;
			case "transactionDateHeure":
				setTransactionDateHeure(val);
				sauvegardesTransactionBancaire.add(var);
				return val;
			case "transactionFrais":
				setTransactionFrais(val);
				sauvegardesTransactionBancaire.add(var);
				return val;
			case "transactionNomAffichage":
				setTransactionNomAffichage(val);
				sauvegardesTransactionBancaire.add(var);
				return val;
			default:
				return super.definirCluster(var, val);
		}
	}

	/////////////////
	// sauvegardes //
	/////////////////

	protected List<String> sauvegardesTransactionBancaire = new ArrayList<String>();

	/////////////
	// peupler //
	/////////////

	@Override public void peuplerPourClasse(SolrDocument solrDocument) {
		peuplerTransactionBancaire(solrDocument);
	}
	public void peuplerTransactionBancaire(SolrDocument solrDocument) {
		TransactionBancaire oTransactionBancaire = (TransactionBancaire)this;
		sauvegardesTransactionBancaire = (List<String>)solrDocument.get("sauvegardesTransactionBancaire_stored_strings");
		if(sauvegardesTransactionBancaire != null) {

			if(sauvegardesTransactionBancaire.contains("transactionCle")) {
				Long transactionCle = (Long)solrDocument.get("transactionCle_stored_long");
				if(transactionCle != null)
					oTransactionBancaire.setTransactionCle(transactionCle);
			}

			Long compteCle = (Long)solrDocument.get("compteCle_stored_long");
			if(compteCle != null)
				oTransactionBancaire.setCompteCle(compteCle);

			if(sauvegardesTransactionBancaire.contains("compteNomComplet")) {
				String compteNomComplet = (String)solrDocument.get("compteNomComplet_stored_string");
				if(compteNomComplet != null)
					oTransactionBancaire.setCompteNomComplet(compteNomComplet);
			}

			if(sauvegardesTransactionBancaire.contains("compteNumero")) {
				String compteNumero = (String)solrDocument.get("compteNumero_stored_string");
				if(compteNumero != null)
					oTransactionBancaire.setCompteNumero(compteNumero);
			}

			if(sauvegardesTransactionBancaire.contains("transactionCode")) {
				String transactionCode = (String)solrDocument.get("transactionCode_stored_string");
				if(transactionCode != null)
					oTransactionBancaire.setTransactionCode(transactionCode);
			}

			if(sauvegardesTransactionBancaire.contains("codeTransactionNomComplet")) {
				String codeTransactionNomComplet = (String)solrDocument.get("codeTransactionNomComplet_stored_string");
				if(codeTransactionNomComplet != null)
					oTransactionBancaire.setCodeTransactionNomComplet(codeTransactionNomComplet);
			}

			if(sauvegardesTransactionBancaire.contains("transactionIdReference")) {
				String transactionIdReference = (String)solrDocument.get("transactionIdReference_stored_string");
				if(transactionIdReference != null)
					oTransactionBancaire.setTransactionIdReference(transactionIdReference);
			}

			if(sauvegardesTransactionBancaire.contains("transactionMontant")) {
				Double transactionMontant = (Double)solrDocument.get("transactionMontant_stored_double");
				if(transactionMontant != null)
					oTransactionBancaire.setTransactionMontant(transactionMontant);
			}

			if(sauvegardesTransactionBancaire.contains("transactionDateHeure")) {
				Date transactionDateHeure = (Date)solrDocument.get("transactionDateHeure_stored_date");
				if(transactionDateHeure != null)
					oTransactionBancaire.setTransactionDateHeure(transactionDateHeure);
			}

			if(sauvegardesTransactionBancaire.contains("transactionDate")) {
				Date transactionDate = (Date)solrDocument.get("transactionDate_stored_date");
				if(transactionDate != null)
					oTransactionBancaire.setTransactionDate(transactionDate);
			}

			if(sauvegardesTransactionBancaire.contains("transactionFrais")) {
				Boolean transactionFrais = (Boolean)solrDocument.get("transactionFrais_stored_boolean");
				if(transactionFrais != null)
					oTransactionBancaire.setTransactionFrais(transactionFrais);
			}

			if(sauvegardesTransactionBancaire.contains("transactionNomAffichage")) {
				String transactionNomAffichage = (String)solrDocument.get("transactionNomAffichage_stored_string");
				if(transactionNomAffichage != null)
					oTransactionBancaire.setTransactionNomAffichage(transactionNomAffichage);
			}

			if(sauvegardesTransactionBancaire.contains("transactionNomComplet")) {
				String transactionNomComplet = (String)solrDocument.get("transactionNomComplet_stored_string");
				if(transactionNomComplet != null)
					oTransactionBancaire.setTransactionNomComplet(transactionNomComplet);
			}

			if(sauvegardesTransactionBancaire.contains("transactionId")) {
				String transactionId = (String)solrDocument.get("transactionId_stored_string");
				if(transactionId != null)
					oTransactionBancaire.setTransactionId(transactionId);
			}

			if(sauvegardesTransactionBancaire.contains("pageUrl")) {
				String pageUrl = (String)solrDocument.get("pageUrl_stored_string");
				if(pageUrl != null)
					oTransactionBancaire.setPageUrl(pageUrl);
			}

			if(sauvegardesTransactionBancaire.contains("objetSuggere")) {
				String objetSuggere = (String)solrDocument.get("objetSuggere_suggested");
				oTransactionBancaire.setObjetSuggere(objetSuggere);
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
			rechercheSolr.addFilterQuery("id:" + ClientUtils.escapeQueryChars("org.computate.bancaire.frfr.transaction.TransactionBancaire"));
			QueryResponse reponseRecherche = requeteSite.getSiteContexte_().getClientSolr().query(rechercheSolr);
			if(reponseRecherche.getResults().size() > 0)
				requeteSite.setDocumentSolr(reponseRecherche.getResults().get(0));
			TransactionBancaire o = new TransactionBancaire();
			o.requeteSiteTransactionBancaire(requeteSite);
			o.initLoinTransactionBancaire(requeteSite);
			o.indexerTransactionBancaire();
		} catch(Exception e) {
			ExceptionUtils.rethrow(e);
		}
	}


	@Override public void indexerPourClasse() {
		indexerTransactionBancaire();
	}

	@Override public void indexerPourClasse(SolrInputDocument document) {
		indexerTransactionBancaire(document);
	}

	public void indexerTransactionBancaire(SolrClient clientSolr) {
		try {
			SolrInputDocument document = new SolrInputDocument();
			indexerTransactionBancaire(document);
			clientSolr.add(document);
			clientSolr.commit();
		} catch(Exception e) {
			ExceptionUtils.rethrow(e);
		}
	}

	public void indexerTransactionBancaire() {
		try {
			SolrInputDocument document = new SolrInputDocument();
			indexerTransactionBancaire(document);
			SolrClient clientSolr = requeteSite_.getSiteContexte_().getClientSolr();
			clientSolr.add(document);
			clientSolr.commit();
		} catch(Exception e) {
			ExceptionUtils.rethrow(e);
		}
	}

	public void indexerTransactionBancaire(SolrInputDocument document) {
		if(sauvegardesTransactionBancaire != null)
			document.addField("sauvegardesTransactionBancaire_stored_strings", sauvegardesTransactionBancaire);

		if(transactionCle != null) {
			document.addField("transactionCle_indexed_long", transactionCle);
			document.addField("transactionCle_stored_long", transactionCle);
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
		if(transactionCode != null) {
			document.addField("transactionCode_indexed_string", transactionCode);
			document.addField("transactionCode_stored_string", transactionCode);
		}
		if(codeTransactionNomComplet != null) {
			document.addField("codeTransactionNomComplet_indexed_string", codeTransactionNomComplet);
			document.addField("codeTransactionNomComplet_stored_string", codeTransactionNomComplet);
		}
		if(transactionIdReference != null) {
			document.addField("transactionIdReference_indexed_string", transactionIdReference);
			document.addField("transactionIdReference_stored_string", transactionIdReference);
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
		if(transactionNomAffichage != null) {
			document.addField("transactionNomAffichage_indexed_string", transactionNomAffichage);
			document.addField("transactionNomAffichage_stored_string", transactionNomAffichage);
		}
		if(transactionNomComplet != null) {
			document.addField("transactionNomComplet_indexed_string", transactionNomComplet);
			document.addField("transactionNomComplet_stored_string", transactionNomComplet);
		}
		if(transactionId != null) {
			document.addField("transactionId_indexed_string", transactionId);
			document.addField("transactionId_stored_string", transactionId);
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

	public void desindexerTransactionBancaire() {
		try {
		RequeteSiteFrFR requeteSite = new RequeteSiteFrFR();
			requeteSite.initLoinRequeteSiteFrFR();
			SiteContexteFrFR siteContexte = new SiteContexteFrFR();
			siteContexte.initLoinSiteContexteFrFR();
			requeteSite.setSiteContexte_(siteContexte);
			requeteSite.setConfigSite_(siteContexte.getConfigSite());
			initLoinTransactionBancaire(requeteSite);
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
		stockerTransactionBancaire(solrDocument);
	}
	public void stockerTransactionBancaire(SolrDocument solrDocument) {
		TransactionBancaire oTransactionBancaire = (TransactionBancaire)this;

		Long transactionCle = (Long)solrDocument.get("transactionCle_stored_long");
		if(transactionCle != null)
			oTransactionBancaire.setTransactionCle(transactionCle);

		Long compteCle = (Long)solrDocument.get("compteCle_stored_long");
		if(compteCle != null)
			oTransactionBancaire.setCompteCle(compteCle);

		String compteNomComplet = (String)solrDocument.get("compteNomComplet_stored_string");
		if(compteNomComplet != null)
			oTransactionBancaire.setCompteNomComplet(compteNomComplet);

		String compteNumero = (String)solrDocument.get("compteNumero_stored_string");
		if(compteNumero != null)
			oTransactionBancaire.setCompteNumero(compteNumero);

		String transactionCode = (String)solrDocument.get("transactionCode_stored_string");
		if(transactionCode != null)
			oTransactionBancaire.setTransactionCode(transactionCode);

		String codeTransactionNomComplet = (String)solrDocument.get("codeTransactionNomComplet_stored_string");
		if(codeTransactionNomComplet != null)
			oTransactionBancaire.setCodeTransactionNomComplet(codeTransactionNomComplet);

		String transactionIdReference = (String)solrDocument.get("transactionIdReference_stored_string");
		if(transactionIdReference != null)
			oTransactionBancaire.setTransactionIdReference(transactionIdReference);

		Double transactionMontant = (Double)solrDocument.get("transactionMontant_stored_double");
		if(transactionMontant != null)
			oTransactionBancaire.setTransactionMontant(transactionMontant);

		Date transactionDateHeure = (Date)solrDocument.get("transactionDateHeure_stored_date");
		if(transactionDateHeure != null)
			oTransactionBancaire.setTransactionDateHeure(transactionDateHeure);

		Date transactionDate = (Date)solrDocument.get("transactionDate_stored_date");
		if(transactionDate != null)
			oTransactionBancaire.setTransactionDate(transactionDate);

		Boolean transactionFrais = (Boolean)solrDocument.get("transactionFrais_stored_boolean");
		if(transactionFrais != null)
			oTransactionBancaire.setTransactionFrais(transactionFrais);

		String transactionNomAffichage = (String)solrDocument.get("transactionNomAffichage_stored_string");
		if(transactionNomAffichage != null)
			oTransactionBancaire.setTransactionNomAffichage(transactionNomAffichage);

		String transactionNomComplet = (String)solrDocument.get("transactionNomComplet_stored_string");
		if(transactionNomComplet != null)
			oTransactionBancaire.setTransactionNomComplet(transactionNomComplet);

		String transactionId = (String)solrDocument.get("transactionId_stored_string");
		if(transactionId != null)
			oTransactionBancaire.setTransactionId(transactionId);

		String pageUrl = (String)solrDocument.get("pageUrl_stored_string");
		if(pageUrl != null)
			oTransactionBancaire.setPageUrl(pageUrl);

		String objetSuggere = (String)solrDocument.get("objetSuggere_suggested");
		oTransactionBancaire.setObjetSuggere(objetSuggere);

		super.stockerCluster(solrDocument);
	}

	//////////////
	// hashCode //
	//////////////

	@Override public int hashCode() {
		return Objects.hash(super.hashCode(), compteCle, transactionCode, transactionIdReference, transactionMontant, transactionDateHeure, transactionFrais, transactionNomAffichage);
	}

	////////////
	// equals //
	////////////

	@Override public boolean equals(Object o) {
		if(this == o)
			return true;
		if(!(o instanceof TransactionBancaire))
			return false;
		TransactionBancaire that = (TransactionBancaire)o;
		return super.equals(o)
				&& Objects.equals( compteCle, that.compteCle )
				&& Objects.equals( transactionCode, that.transactionCode )
				&& Objects.equals( transactionIdReference, that.transactionIdReference )
				&& Objects.equals( transactionMontant, that.transactionMontant )
				&& Objects.equals( transactionDateHeure, that.transactionDateHeure )
				&& Objects.equals( transactionFrais, that.transactionFrais )
				&& Objects.equals( transactionNomAffichage, that.transactionNomAffichage );
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString() + "\n");
		sb.append("TransactionBancaire { ");
		sb.append( "compteCle: " ).append(compteCle);
		sb.append( ", transactionCode: \"" ).append(transactionCode).append( "\"" );
		sb.append( ", transactionIdReference: \"" ).append(transactionIdReference).append( "\"" );
		sb.append( ", transactionMontant: " ).append(transactionMontant);
		sb.append( ", transactionDateHeure: " ).append(transactionDateHeure);
		sb.append( ", transactionFrais: " ).append(transactionFrais);
		sb.append( ", transactionNomAffichage: \"" ).append(transactionNomAffichage).append( "\"" );
		sb.append(" }");
		return sb.toString();
	}
}
