package org.computate.bancaire.frfr.transaction.code;

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
 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.transaction.code.CodeTransaction&fq=classeEtendGen_indexed_boolean:true">Trouver la classe objectSuggest dans Solr</a>
 * <br/>
 **/
public abstract class CodeTransactionGen<DEV> extends Cluster {
	private static final Logger LOGGER = LoggerFactory.getLogger(CodeTransaction.class);

	public static final String CodeTransaction_UnNom = "un code de transaction";
	public static final String CodeTransaction_Ce = "ce ";
	public static final String CodeTransaction_CeNom = "ce code de transaction";
	public static final String CodeTransaction_Un = "un ";
	public static final String CodeTransaction_LeNom = "le code de transaction";
	public static final String CodeTransaction_NomSingulier = "code de transaction";
	public static final String CodeTransaction_NomPluriel = "code de transactions";
	public static final String CodeTransaction_NomActuel = "code de transaction actuel";
	public static final String CodeTransaction_Tous = "all ";
	public static final String CodeTransaction_TousNom = "tous les code de transactions";
	public static final String CodeTransaction_RechercherTousNomPar = "rechercher code de transactions par ";
	public static final String CodeTransaction_RechercherTousNom = "rechercher code de transactions";
	public static final String CodeTransaction_LesNoms = "les code de transactions";
	public static final String CodeTransaction_AucunNomTrouve = "aucun code de transaction trouvé";
	public static final String CodeTransaction_NomVar = "codeDeTransaction";
	public static final String CodeTransaction_DeNom = "de code de transaction";
	public static final String CodeTransaction_NomAdjectifSingulier = "code de transaction";
	public static final String CodeTransaction_NomAdjectifPluriel = "code de transactions";
	public static final String CodeTransaction_Couleur = "yellow";
	public static final String CodeTransaction_IconeGroupe = "duotone";
	public static final String CodeTransaction_IconeNom = "code-commit";

	////////////////////////
	// codeTransactionCle //
	////////////////////////

	/**	L'entité « codeTransactionCle »
	 *	 is defined as null before being initialized. 
	 */
	protected Long codeTransactionCle;
	@JsonIgnore
	public Couverture<Long> codeTransactionCleCouverture = new Couverture<Long>().p(this).c(Long.class).var("codeTransactionCle").o(codeTransactionCle);

	/**	<br/>L'entité « codeTransactionCle »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.transaction.code.CodeTransaction&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:codeTransactionCle">Trouver l'entité codeTransactionCle dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _codeTransactionCle(Couverture<Long> c);

	public Long getCodeTransactionCle() {
		return codeTransactionCle;
	}

	public void setCodeTransactionCle(Long codeTransactionCle) {
		this.codeTransactionCle = codeTransactionCle;
		this.codeTransactionCleCouverture.dejaInitialise = true;
	}
	public CodeTransaction setCodeTransactionCle(String o) {
		if(NumberUtils.isParsable(o))
			this.codeTransactionCle = Long.parseLong(o);
		this.codeTransactionCleCouverture.dejaInitialise = true;
		return (CodeTransaction)this;
	}
	protected CodeTransaction codeTransactionCleInit() {
		if(!codeTransactionCleCouverture.dejaInitialise) {
			_codeTransactionCle(codeTransactionCleCouverture);
			if(codeTransactionCle == null)
				setCodeTransactionCle(codeTransactionCleCouverture.o);
		}
		codeTransactionCleCouverture.dejaInitialise(true);
		return (CodeTransaction)this;
	}

	public Long solrCodeTransactionCle() {
		return codeTransactionCle;
	}

	public String strCodeTransactionCle() {
		return codeTransactionCle == null ? "" : codeTransactionCle.toString();
	}

	public String jsonCodeTransactionCle() {
		return codeTransactionCle == null ? "" : codeTransactionCle.toString();
	}

	public String nomAffichageCodeTransactionCle() {
		return "clé";
	}

	public String htmTooltipCodeTransactionCle() {
		return null;
	}

	public String htmCodeTransactionCle() {
		return codeTransactionCle == null ? "" : StringEscapeUtils.escapeHtml4(strCodeTransactionCle());
	}

	public void htmCodeTransactionCle(ToutEcrivain r, Boolean patchDroits) {
		if(pk!= null) {
			r.s("<div id=\"patchCodeTransaction", strPk(), "CodeTransactionCle\">");
			if(patchDroits) {
				r.l();
				r.l("	<script>//<![CDATA[");
				r.l("		function patchCodeTransaction", strPk(), "CodeTransactionCle() {");
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
				r.l("				data: {\"setCodeTransactionCle\": this.value },");
				r.l("				");
				r.l("			});");
				r.l("		}");
				r.l("	//]]></script>");
				r.l("	<div class=\"\">");
				r.l("		<label class=\"w3-tooltip \">");
				r.l("			<span>", StringEscapeUtils.escapeHtml4(nomAffichageCodeTransactionCle()), "</span>");
				r.s("			<input");
							r.s(" name=\"codeTransactionCle\"");
							r.s(" value=\"", htmCodeTransactionCle(), "\");");
							r.s(" onchange=\"\"");
							r.l("/>");
				r.l("		</label>");
				r.l("	</div>");
			} else {
				r.s(htmCodeTransactionCle());
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
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.transaction.code.CodeTransaction&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:transactionCode">Trouver l'entité transactionCode dans Solr</a>
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
	protected CodeTransaction transactionCodeInit() {
		if(!transactionCodeCouverture.dejaInitialise) {
			_transactionCode(transactionCodeCouverture);
			if(transactionCode == null)
				setTransactionCode(transactionCodeCouverture.o);
		}
		transactionCodeCouverture.dejaInitialise(true);
		return (CodeTransaction)this;
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
			r.s("<div id=\"patchCodeTransaction", strPk(), "TransactionCode\">");
			if(patchDroits) {
				r.l();
				r.l("	<script>//<![CDATA[");
				r.l("		function patchCodeTransaction", strPk(), "TransactionCode() {");
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

	/////////////////////////////////
	// codeTransactionNomAffichage //
	/////////////////////////////////

	/**	L'entité « codeTransactionNomAffichage »
	 *	 is defined as null before being initialized. 
	 */
	protected String codeTransactionNomAffichage;
	@JsonIgnore
	public Couverture<String> codeTransactionNomAffichageCouverture = new Couverture<String>().p(this).c(String.class).var("codeTransactionNomAffichage").o(codeTransactionNomAffichage);

	/**	<br/>L'entité « codeTransactionNomAffichage »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.transaction.code.CodeTransaction&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:codeTransactionNomAffichage">Trouver l'entité codeTransactionNomAffichage dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _codeTransactionNomAffichage(Couverture<String> c);

	public String getCodeTransactionNomAffichage() {
		return codeTransactionNomAffichage;
	}

	public void setCodeTransactionNomAffichage(String codeTransactionNomAffichage) {
		this.codeTransactionNomAffichage = codeTransactionNomAffichage;
		this.codeTransactionNomAffichageCouverture.dejaInitialise = true;
	}
	protected CodeTransaction codeTransactionNomAffichageInit() {
		if(!codeTransactionNomAffichageCouverture.dejaInitialise) {
			_codeTransactionNomAffichage(codeTransactionNomAffichageCouverture);
			if(codeTransactionNomAffichage == null)
				setCodeTransactionNomAffichage(codeTransactionNomAffichageCouverture.o);
		}
		codeTransactionNomAffichageCouverture.dejaInitialise(true);
		return (CodeTransaction)this;
	}

	public String solrCodeTransactionNomAffichage() {
		return codeTransactionNomAffichage;
	}

	public String strCodeTransactionNomAffichage() {
		return codeTransactionNomAffichage == null ? "" : codeTransactionNomAffichage;
	}

	public String jsonCodeTransactionNomAffichage() {
		return codeTransactionNomAffichage == null ? "" : codeTransactionNomAffichage;
	}

	public String nomAffichageCodeTransactionNomAffichage() {
		return "nom d'affichage";
	}

	public String htmTooltipCodeTransactionNomAffichage() {
		return null;
	}

	public String htmCodeTransactionNomAffichage() {
		return codeTransactionNomAffichage == null ? "" : StringEscapeUtils.escapeHtml4(strCodeTransactionNomAffichage());
	}

	public void htmCodeTransactionNomAffichage(ToutEcrivain r, Boolean patchDroits) {
		if(pk!= null) {
			r.s("<div id=\"patchCodeTransaction", strPk(), "CodeTransactionNomAffichage\">");
			if(patchDroits) {
				r.l();
				r.l("	<script>//<![CDATA[");
				r.l("		function patchCodeTransaction", strPk(), "CodeTransactionNomAffichage() {");
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
				r.l("				data: {\"setCodeTransactionNomAffichage\": this.value },");
				r.l("				");
				r.l("			});");
				r.l("		}");
				r.l("	//]]></script>");
				r.l("	<div class=\"\">");
				r.l("		<label class=\"w3-tooltip \">");
				r.l("			<span>", StringEscapeUtils.escapeHtml4(nomAffichageCodeTransactionNomAffichage()), "</span>");
				r.s("			<input");
							r.s(" name=\"codeTransactionNomAffichage\"");
							r.s(" value=\"", htmCodeTransactionNomAffichage(), "\");");
							r.s(" onchange=\"\"");
							r.l("/>");
				r.l("		</label>");
				r.l("	</div>");
			} else {
				r.s(htmCodeTransactionNomAffichage());
			}
			r.l("</div>");
		}
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
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.transaction.code.CodeTransaction&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:codeTransactionNomComplet">Trouver l'entité codeTransactionNomComplet dans Solr</a>
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
	protected CodeTransaction codeTransactionNomCompletInit() {
		if(!codeTransactionNomCompletCouverture.dejaInitialise) {
			_codeTransactionNomComplet(codeTransactionNomCompletCouverture);
			if(codeTransactionNomComplet == null)
				setCodeTransactionNomComplet(codeTransactionNomCompletCouverture.o);
		}
		codeTransactionNomCompletCouverture.dejaInitialise(true);
		return (CodeTransaction)this;
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
			r.s("<div id=\"patchCodeTransaction", strPk(), "CodeTransactionNomComplet\">");
			if(patchDroits) {
				r.l();
				r.l("	<script>//<![CDATA[");
				r.l("		function patchCodeTransaction", strPk(), "CodeTransactionNomComplet() {");
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

	///////////////////////
	// codeTransactionId //
	///////////////////////

	/**	L'entité « codeTransactionId »
	 *	 is defined as null before being initialized. 
	 */
	protected String codeTransactionId;
	@JsonIgnore
	public Couverture<String> codeTransactionIdCouverture = new Couverture<String>().p(this).c(String.class).var("codeTransactionId").o(codeTransactionId);

	/**	<br/>L'entité « codeTransactionId »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.transaction.code.CodeTransaction&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:codeTransactionId">Trouver l'entité codeTransactionId dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _codeTransactionId(Couverture<String> c);

	public String getCodeTransactionId() {
		return codeTransactionId;
	}

	public void setCodeTransactionId(String codeTransactionId) {
		this.codeTransactionId = codeTransactionId;
		this.codeTransactionIdCouverture.dejaInitialise = true;
	}
	protected CodeTransaction codeTransactionIdInit() {
		if(!codeTransactionIdCouverture.dejaInitialise) {
			_codeTransactionId(codeTransactionIdCouverture);
			if(codeTransactionId == null)
				setCodeTransactionId(codeTransactionIdCouverture.o);
		}
		codeTransactionIdCouverture.dejaInitialise(true);
		return (CodeTransaction)this;
	}

	public String solrCodeTransactionId() {
		return codeTransactionId;
	}

	public String strCodeTransactionId() {
		return codeTransactionId == null ? "" : codeTransactionId;
	}

	public String jsonCodeTransactionId() {
		return codeTransactionId == null ? "" : codeTransactionId;
	}

	public String nomAffichageCodeTransactionId() {
		return "ID";
	}

	public String htmTooltipCodeTransactionId() {
		return null;
	}

	public String htmCodeTransactionId() {
		return codeTransactionId == null ? "" : StringEscapeUtils.escapeHtml4(strCodeTransactionId());
	}

	public void htmCodeTransactionId(ToutEcrivain r, Boolean patchDroits) {
		if(pk!= null) {
			r.s("<div id=\"patchCodeTransaction", strPk(), "CodeTransactionId\">");
			if(patchDroits) {
				r.l();
				r.l("	<script>//<![CDATA[");
				r.l("		function patchCodeTransaction", strPk(), "CodeTransactionId() {");
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
				r.l("				data: {\"setCodeTransactionId\": this.value },");
				r.l("				");
				r.l("			});");
				r.l("		}");
				r.l("	//]]></script>");
				r.l("	<div class=\"\">");
				r.l("		<label class=\"w3-tooltip \">");
				r.l("			<span>", StringEscapeUtils.escapeHtml4(nomAffichageCodeTransactionId()), "</span>");
				r.s("			<input");
							r.s(" name=\"codeTransactionId\"");
							r.s(" value=\"", htmCodeTransactionId(), "\");");
							r.s(" onchange=\"\"");
							r.l("/>");
				r.l("		</label>");
				r.l("	</div>");
			} else {
				r.s(htmCodeTransactionId());
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
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.transaction.code.CodeTransaction&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:pageUrl">Trouver l'entité pageUrl dans Solr</a>
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
	protected CodeTransaction pageUrlInit() {
		if(!pageUrlCouverture.dejaInitialise) {
			_pageUrl(pageUrlCouverture);
			if(pageUrl == null)
				setPageUrl(pageUrlCouverture.o);
		}
		pageUrlCouverture.dejaInitialise(true);
		return (CodeTransaction)this;
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
			r.s("<div id=\"patchCodeTransaction", strPk(), "PageUrl\">");
			if(patchDroits) {
				r.l();
				r.l("	<script>//<![CDATA[");
				r.l("		function patchCodeTransaction", strPk(), "PageUrl() {");
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
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_frFR_indexed_string:org.computate.bancaire.frfr.transaction.code.CodeTransaction&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_frFR_indexed_string:objetSuggere">Trouver l'entité objetSuggere dans Solr</a>
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
	protected CodeTransaction objetSuggereInit() {
		if(!objetSuggereCouverture.dejaInitialise) {
			_objetSuggere(objetSuggereCouverture);
			if(objetSuggere == null)
				setObjetSuggere(objetSuggereCouverture.o);
		}
		objetSuggereCouverture.dejaInitialise(true);
		return (CodeTransaction)this;
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
			r.s("<div id=\"patchCodeTransaction", strPk(), "ObjetSuggere\">");
			if(patchDroits) {
				r.l();
				r.l("	<script>//<![CDATA[");
				r.l("		function patchCodeTransaction", strPk(), "ObjetSuggere() {");
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

	protected boolean dejaInitialiseCodeTransaction = false;

	public CodeTransaction initLoinCodeTransaction(RequeteSiteFrFR requeteSite_) {
		setRequeteSite_(requeteSite_);
		if(!dejaInitialiseCodeTransaction) {
			dejaInitialiseCodeTransaction = true;
			initLoinCodeTransaction();
		}
		return (CodeTransaction)this;
	}

	public void initLoinCodeTransaction() {
		super.initLoinCluster(requeteSite_);
		initCodeTransaction();
	}

	public void initCodeTransaction() {
		codeTransactionCleInit();
		transactionCodeInit();
		codeTransactionNomAffichageInit();
		codeTransactionNomCompletInit();
		codeTransactionIdInit();
		pageUrlInit();
		objetSuggereInit();
	}

	@Override public void initLoinPourClasse(RequeteSiteFrFR requeteSite_) {
		initLoinCodeTransaction(requeteSite_);
	}

	/////////////////
	// requeteSite //
	/////////////////

	public void requeteSiteCodeTransaction(RequeteSiteFrFR requeteSite_) {
			super.requeteSiteCluster(requeteSite_);
	}

	public void requeteSitePourClasse(RequeteSiteFrFR requeteSite_) {
		requeteSiteCodeTransaction(requeteSite_);
	}

	/////////////
	// obtenir //
	/////////////

	@Override public Object obtenirPourClasse(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtenirCodeTransaction(v);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.obtenirPourClasse(v);
			}
		}
		return o;
	}
	public Object obtenirCodeTransaction(String var) {
		CodeTransaction oCodeTransaction = (CodeTransaction)this;
		switch(var) {
			case "codeTransactionCle":
				return oCodeTransaction.codeTransactionCle;
			case "transactionCode":
				return oCodeTransaction.transactionCode;
			case "codeTransactionNomAffichage":
				return oCodeTransaction.codeTransactionNomAffichage;
			case "codeTransactionNomComplet":
				return oCodeTransaction.codeTransactionNomComplet;
			case "codeTransactionId":
				return oCodeTransaction.codeTransactionId;
			case "pageUrl":
				return oCodeTransaction.pageUrl;
			case "objetSuggere":
				return oCodeTransaction.objetSuggere;
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
				o = attribuerCodeTransaction(v, val);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.attribuerPourClasse(v, val);
			}
		}
		return o != null;
	}
	public Object attribuerCodeTransaction(String var, Object val) {
		CodeTransaction oCodeTransaction = (CodeTransaction)this;
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
					o = definirCodeTransaction(v, val);
				else if(o instanceof Cluster) {
					Cluster cluster = (Cluster)o;
					o = cluster.definirPourClasse(v, val);
				}
			}
		}
		return o != null;
	}
	public Object definirCodeTransaction(String var, String val) {
		switch(var) {
			case "transactionCode":
				setTransactionCode(val);
				sauvegardesCodeTransaction.add(var);
				return val;
			case "codeTransactionNomAffichage":
				setCodeTransactionNomAffichage(val);
				sauvegardesCodeTransaction.add(var);
				return val;
			default:
				return super.definirCluster(var, val);
		}
	}

	/////////////////
	// sauvegardes //
	/////////////////

	protected List<String> sauvegardesCodeTransaction = new ArrayList<String>();

	/////////////
	// peupler //
	/////////////

	@Override public void peuplerPourClasse(SolrDocument solrDocument) {
		peuplerCodeTransaction(solrDocument);
	}
	public void peuplerCodeTransaction(SolrDocument solrDocument) {
		CodeTransaction oCodeTransaction = (CodeTransaction)this;
		sauvegardesCodeTransaction = (List<String>)solrDocument.get("sauvegardesCodeTransaction_stored_strings");
		if(sauvegardesCodeTransaction != null) {

			if(sauvegardesCodeTransaction.contains("codeTransactionCle")) {
				Long codeTransactionCle = (Long)solrDocument.get("codeTransactionCle_stored_long");
				if(codeTransactionCle != null)
					oCodeTransaction.setCodeTransactionCle(codeTransactionCle);
			}

			if(sauvegardesCodeTransaction.contains("transactionCode")) {
				String transactionCode = (String)solrDocument.get("transactionCode_stored_string");
				if(transactionCode != null)
					oCodeTransaction.setTransactionCode(transactionCode);
			}

			if(sauvegardesCodeTransaction.contains("codeTransactionNomAffichage")) {
				String codeTransactionNomAffichage = (String)solrDocument.get("codeTransactionNomAffichage_stored_string");
				if(codeTransactionNomAffichage != null)
					oCodeTransaction.setCodeTransactionNomAffichage(codeTransactionNomAffichage);
			}

			if(sauvegardesCodeTransaction.contains("codeTransactionNomComplet")) {
				String codeTransactionNomComplet = (String)solrDocument.get("codeTransactionNomComplet_stored_string");
				if(codeTransactionNomComplet != null)
					oCodeTransaction.setCodeTransactionNomComplet(codeTransactionNomComplet);
			}

			if(sauvegardesCodeTransaction.contains("codeTransactionId")) {
				String codeTransactionId = (String)solrDocument.get("codeTransactionId_stored_string");
				if(codeTransactionId != null)
					oCodeTransaction.setCodeTransactionId(codeTransactionId);
			}

			if(sauvegardesCodeTransaction.contains("pageUrl")) {
				String pageUrl = (String)solrDocument.get("pageUrl_stored_string");
				if(pageUrl != null)
					oCodeTransaction.setPageUrl(pageUrl);
			}

			if(sauvegardesCodeTransaction.contains("objetSuggere")) {
				String objetSuggere = (String)solrDocument.get("objetSuggere_suggested");
				oCodeTransaction.setObjetSuggere(objetSuggere);
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
			rechercheSolr.addFilterQuery("id:" + ClientUtils.escapeQueryChars("org.computate.bancaire.frfr.transaction.code.CodeTransaction"));
			QueryResponse reponseRecherche = requeteSite.getSiteContexte_().getClientSolr().query(rechercheSolr);
			if(reponseRecherche.getResults().size() > 0)
				requeteSite.setDocumentSolr(reponseRecherche.getResults().get(0));
			CodeTransaction o = new CodeTransaction();
			o.requeteSiteCodeTransaction(requeteSite);
			o.initLoinCodeTransaction(requeteSite);
			o.indexerCodeTransaction();
		} catch(Exception e) {
			ExceptionUtils.rethrow(e);
		}
	}


	@Override public void indexerPourClasse() {
		indexerCodeTransaction();
	}

	@Override public void indexerPourClasse(SolrInputDocument document) {
		indexerCodeTransaction(document);
	}

	public void indexerCodeTransaction(SolrClient clientSolr) {
		try {
			SolrInputDocument document = new SolrInputDocument();
			indexerCodeTransaction(document);
			clientSolr.add(document);
			clientSolr.commit();
		} catch(Exception e) {
			ExceptionUtils.rethrow(e);
		}
	}

	public void indexerCodeTransaction() {
		try {
			SolrInputDocument document = new SolrInputDocument();
			indexerCodeTransaction(document);
			SolrClient clientSolr = requeteSite_.getSiteContexte_().getClientSolr();
			clientSolr.add(document);
			clientSolr.commit();
		} catch(Exception e) {
			ExceptionUtils.rethrow(e);
		}
	}

	public void indexerCodeTransaction(SolrInputDocument document) {
		if(sauvegardesCodeTransaction != null)
			document.addField("sauvegardesCodeTransaction_stored_strings", sauvegardesCodeTransaction);

		if(codeTransactionCle != null) {
			document.addField("codeTransactionCle_indexed_long", codeTransactionCle);
			document.addField("codeTransactionCle_stored_long", codeTransactionCle);
		}
		if(transactionCode != null) {
			document.addField("transactionCode_indexed_string", transactionCode);
			document.addField("transactionCode_stored_string", transactionCode);
		}
		if(codeTransactionNomAffichage != null) {
			document.addField("codeTransactionNomAffichage_indexed_string", codeTransactionNomAffichage);
			document.addField("codeTransactionNomAffichage_stored_string", codeTransactionNomAffichage);
		}
		if(codeTransactionNomComplet != null) {
			document.addField("codeTransactionNomComplet_indexed_string", codeTransactionNomComplet);
			document.addField("codeTransactionNomComplet_stored_string", codeTransactionNomComplet);
		}
		if(codeTransactionId != null) {
			document.addField("codeTransactionId_indexed_string", codeTransactionId);
			document.addField("codeTransactionId_stored_string", codeTransactionId);
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

	public void desindexerCodeTransaction() {
		try {
		RequeteSiteFrFR requeteSite = new RequeteSiteFrFR();
			requeteSite.initLoinRequeteSiteFrFR();
			SiteContexteFrFR siteContexte = new SiteContexteFrFR();
			siteContexte.initLoinSiteContexteFrFR();
			requeteSite.setSiteContexte_(siteContexte);
			requeteSite.setConfigSite_(siteContexte.getConfigSite());
			initLoinCodeTransaction(requeteSite);
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
		stockerCodeTransaction(solrDocument);
	}
	public void stockerCodeTransaction(SolrDocument solrDocument) {
		CodeTransaction oCodeTransaction = (CodeTransaction)this;

		Long codeTransactionCle = (Long)solrDocument.get("codeTransactionCle_stored_long");
		if(codeTransactionCle != null)
			oCodeTransaction.setCodeTransactionCle(codeTransactionCle);

		String transactionCode = (String)solrDocument.get("transactionCode_stored_string");
		if(transactionCode != null)
			oCodeTransaction.setTransactionCode(transactionCode);

		String codeTransactionNomAffichage = (String)solrDocument.get("codeTransactionNomAffichage_stored_string");
		if(codeTransactionNomAffichage != null)
			oCodeTransaction.setCodeTransactionNomAffichage(codeTransactionNomAffichage);

		String codeTransactionNomComplet = (String)solrDocument.get("codeTransactionNomComplet_stored_string");
		if(codeTransactionNomComplet != null)
			oCodeTransaction.setCodeTransactionNomComplet(codeTransactionNomComplet);

		String codeTransactionId = (String)solrDocument.get("codeTransactionId_stored_string");
		if(codeTransactionId != null)
			oCodeTransaction.setCodeTransactionId(codeTransactionId);

		String pageUrl = (String)solrDocument.get("pageUrl_stored_string");
		if(pageUrl != null)
			oCodeTransaction.setPageUrl(pageUrl);

		String objetSuggere = (String)solrDocument.get("objetSuggere_suggested");
		oCodeTransaction.setObjetSuggere(objetSuggere);

		super.stockerCluster(solrDocument);
	}

	//////////////
	// hashCode //
	//////////////

	@Override public int hashCode() {
		return Objects.hash(super.hashCode(), transactionCode, codeTransactionNomAffichage);
	}

	////////////
	// equals //
	////////////

	@Override public boolean equals(Object o) {
		if(this == o)
			return true;
		if(!(o instanceof CodeTransaction))
			return false;
		CodeTransaction that = (CodeTransaction)o;
		return super.equals(o)
				&& Objects.equals( transactionCode, that.transactionCode )
				&& Objects.equals( codeTransactionNomAffichage, that.codeTransactionNomAffichage );
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString() + "\n");
		sb.append("CodeTransaction { ");
		sb.append( "transactionCode: \"" ).append(transactionCode).append( "\"" );
		sb.append( ", codeTransactionNomAffichage: \"" ).append(codeTransactionNomAffichage).append( "\"" );
		sb.append(" }");
		return sb.toString();
	}
}
