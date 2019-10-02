package org.computate.bancaire.enus.transaction.code;

import java.util.Date;
import org.apache.commons.lang3.StringUtils;
import org.computate.bancaire.enus.request.SiteRequestEnUS;
import io.vertx.core.logging.LoggerFactory;
import java.text.NumberFormat;
import org.computate.bancaire.enus.contexte.SiteContextEnUS;
import java.util.ArrayList;
import java.lang.Long;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.vertx.core.json.JsonObject;
import org.computate.bancaire.enus.writer.AllWriter;
import java.lang.String;
import io.vertx.core.logging.Logger;
import org.computate.bancaire.enus.cluster.Cluster;
import java.math.MathContext;
import org.apache.solr.client.solrj.response.QueryResponse;
import java.util.Set;
import org.apache.commons.text.StringEscapeUtils;
import org.apache.solr.client.solrj.SolrClient;
import java.util.Objects;
import io.vertx.core.json.JsonArray;
import org.apache.solr.common.SolrDocument;
import java.util.List;
import org.computate.bancaire.enus.wrap.Wrap;
import org.apache.solr.client.solrj.SolrQuery;
import io.vertx.ext.sql.SQLConnection;
import org.apache.commons.lang3.math.NumberUtils;
import io.vertx.ext.sql.SQLClient;
import org.apache.solr.client.solrj.util.ClientUtils;
import org.apache.solr.common.SolrInputDocument;
import org.apache.commons.lang3.exception.ExceptionUtils;

/**	
 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enus.transaction.code.TransactionCode&fq=classeEtendGen_indexed_boolean:true">Trouver la classe  dans Solr</a>
 * <br/>
 **/
public abstract class TransactionCodeGen<DEV> extends Cluster {
	private static final Logger LOGGER = LoggerFactory.getLogger(TransactionCode.class);

	public static final String TransactionCode_UnNom = "a transaction code";
	public static final String TransactionCode_Ce = "this ";
	public static final String TransactionCode_CeNom = "this transaction code";
	public static final String TransactionCode_Un = "a ";
	public static final String TransactionCode_LeNom = "the transaction code";
	public static final String TransactionCode_NomSingulier = "transaction code";
	public static final String TransactionCode_NomPluriel = "transaction codes";
	public static final String TransactionCode_NomActuel = "current transaction code";
	public static final String TransactionCode_TousNom = "all the transaction codes";
	public static final String TransactionCode_RechercherTousNomPar = "search transaction codes by ";
	public static final String TransactionCode_LesNoms = "the transaction codes";
	public static final String TransactionCode_AucunNomTrouve = "no transaction code found";
	public static final String TransactionCode_NomVar = "transactionCode";
	public static final String TransactionCode_DeNom = "of transaction code";
	public static final String TransactionCode_AdjectifPluriel = "bank";
	public static final String TransactionCode_AdjectifVar = "bank";
	public static final String TransactionCode_UnNomAdjectif = "a bank transaction code";
	public static final String TransactionCode_NomAdjectifSingulier = "bank transaction code";
	public static final String TransactionCode_NomAdjectifPluriel = "bank transaction codes";
	public static final String TransactionCode_Couleur = "yellow";
	public static final String TransactionCode_IconeGroupe = "duotone";
	public static final String TransactionCode_IconeNom = "code-commit";

	////////////////////////
	// transactionCodeKey //
	////////////////////////

	/**	L'entité « transactionCodeKey »
	 *	 is defined as null before being initialized. 
	 */
	protected Long transactionCodeKey;
	@JsonIgnore
	public Wrap<Long> transactionCodeKeyWrap = new Wrap<Long>().p(this).c(Long.class).var("transactionCodeKey").o(transactionCodeKey);

	/**	<br/>L'entité « transactionCodeKey »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enus.transaction.code.TransactionCode&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:transactionCodeKey">Trouver l'entité transactionCodeKey dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _transactionCodeKey(Wrap<Long> c);

	public Long getTransactionCodeKey() {
		return transactionCodeKey;
	}

	public void setTransactionCodeKey(Long transactionCodeKey) {
		this.transactionCodeKey = transactionCodeKey;
		this.transactionCodeKeyWrap.alreadyInitialized = true;
	}
	public TransactionCode setTransactionCodeKey(String o) {
		if(NumberUtils.isParsable(o))
			this.transactionCodeKey = Long.parseLong(o);
		this.transactionCodeKeyWrap.alreadyInitialized = true;
		return (TransactionCode)this;
	}
	protected TransactionCode transactionCodeKeyInit() {
		if(!transactionCodeKeyWrap.alreadyInitialized) {
			_transactionCodeKey(transactionCodeKeyWrap);
			if(transactionCodeKey == null)
				setTransactionCodeKey(transactionCodeKeyWrap.o);
		}
		transactionCodeKeyWrap.alreadyInitialized(true);
		return (TransactionCode)this;
	}

	public Long solrTransactionCodeKey() {
		return transactionCodeKey;
	}

	public String strTransactionCodeKey() {
		return transactionCodeKey == null ? "" : transactionCodeKey.toString();
	}

	public String jsonTransactionCodeKey() {
		return transactionCodeKey == null ? "" : transactionCodeKey.toString();
	}

	public String nomAffichageTransactionCodeKey() {
		return "key";
	}

	public String htmTooltipTransactionCodeKey() {
		return null;
	}

	public String htmTransactionCodeKey() {
		return transactionCodeKey == null ? "" : StringEscapeUtils.escapeHtml4(strTransactionCodeKey());
	}

	public void htmTransactionCodeKey(AllWriter r, Boolean patchRights) {
		if(pk!= null) {
			r.s("<div id=\"patchTransactionCode", strPk(), "TransactionCodeKey\">");
			if(patchRights) {
				r.l();
				r.l("	<script>//<![CDATA[");
				r.l("		function patchTransactionCode", strPk(), "TransactionCodeKey() {");
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
				r.l("				data: {\"setTransactionCodeKey\": this.value },");
				r.l("				");
				r.l("			});");
				r.l("		}");
				r.l("	//]]></script>");
				r.l("	<div class=\"\">");
				r.l("		<label class=\"w3-tooltip \">");
				r.l("			<span>", StringEscapeUtils.escapeHtml4(nomAffichageTransactionCodeKey()), "</span>");
				r.s("			<input");
							r.s(" name=\"transactionCodeKey\"");
							r.s(" value=\"", htmTransactionCodeKey(), "\");");
							r.s(" onchange=\"\"");
							r.l("/>");
				r.l("		</label>");
				r.l("	</div>");
			} else {
				r.s(htmTransactionCodeKey());
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
	public Wrap<String> transactionCodeWrap = new Wrap<String>().p(this).c(String.class).var("transactionCode").o(transactionCode);

	/**	<br/>L'entité « transactionCode »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enus.transaction.code.TransactionCode&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:transactionCode">Trouver l'entité transactionCode dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _transactionCode(Wrap<String> c);

	public String getTransactionCode() {
		return transactionCode;
	}

	public void setTransactionCode(String transactionCode) {
		this.transactionCode = transactionCode;
		this.transactionCodeWrap.alreadyInitialized = true;
	}
	protected TransactionCode transactionCodeInit() {
		if(!transactionCodeWrap.alreadyInitialized) {
			_transactionCode(transactionCodeWrap);
			if(transactionCode == null)
				setTransactionCode(transactionCodeWrap.o);
		}
		transactionCodeWrap.alreadyInitialized(true);
		return (TransactionCode)this;
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
		return "transaction code";
	}

	public String htmTooltipTransactionCode() {
		return null;
	}

	public String htmTransactionCode() {
		return transactionCode == null ? "" : StringEscapeUtils.escapeHtml4(strTransactionCode());
	}

	public void htmTransactionCode(AllWriter r, Boolean patchRights) {
		if(pk!= null) {
			r.s("<div id=\"patchTransactionCode", strPk(), "TransactionCode\">");
			if(patchRights) {
				r.l();
				r.l("	<script>//<![CDATA[");
				r.l("		function patchTransactionCode", strPk(), "TransactionCode() {");
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

	////////////////////////////////
	// transactionCodeDisplayName //
	////////////////////////////////

	/**	L'entité « transactionCodeDisplayName »
	 *	 is defined as null before being initialized. 
	 */
	protected String transactionCodeDisplayName;
	@JsonIgnore
	public Wrap<String> transactionCodeDisplayNameWrap = new Wrap<String>().p(this).c(String.class).var("transactionCodeDisplayName").o(transactionCodeDisplayName);

	/**	<br/>L'entité « transactionCodeDisplayName »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enus.transaction.code.TransactionCode&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:transactionCodeDisplayName">Trouver l'entité transactionCodeDisplayName dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _transactionCodeDisplayName(Wrap<String> c);

	public String getTransactionCodeDisplayName() {
		return transactionCodeDisplayName;
	}

	public void setTransactionCodeDisplayName(String transactionCodeDisplayName) {
		this.transactionCodeDisplayName = transactionCodeDisplayName;
		this.transactionCodeDisplayNameWrap.alreadyInitialized = true;
	}
	protected TransactionCode transactionCodeDisplayNameInit() {
		if(!transactionCodeDisplayNameWrap.alreadyInitialized) {
			_transactionCodeDisplayName(transactionCodeDisplayNameWrap);
			if(transactionCodeDisplayName == null)
				setTransactionCodeDisplayName(transactionCodeDisplayNameWrap.o);
		}
		transactionCodeDisplayNameWrap.alreadyInitialized(true);
		return (TransactionCode)this;
	}

	public String solrTransactionCodeDisplayName() {
		return transactionCodeDisplayName;
	}

	public String strTransactionCodeDisplayName() {
		return transactionCodeDisplayName == null ? "" : transactionCodeDisplayName;
	}

	public String jsonTransactionCodeDisplayName() {
		return transactionCodeDisplayName == null ? "" : transactionCodeDisplayName;
	}

	public String nomAffichageTransactionCodeDisplayName() {
		return "display name";
	}

	public String htmTooltipTransactionCodeDisplayName() {
		return null;
	}

	public String htmTransactionCodeDisplayName() {
		return transactionCodeDisplayName == null ? "" : StringEscapeUtils.escapeHtml4(strTransactionCodeDisplayName());
	}

	public void htmTransactionCodeDisplayName(AllWriter r, Boolean patchRights) {
		if(pk!= null) {
			r.s("<div id=\"patchTransactionCode", strPk(), "TransactionCodeDisplayName\">");
			if(patchRights) {
				r.l();
				r.l("	<script>//<![CDATA[");
				r.l("		function patchTransactionCode", strPk(), "TransactionCodeDisplayName() {");
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
				r.l("				data: {\"setTransactionCodeDisplayName\": this.value },");
				r.l("				");
				r.l("			});");
				r.l("		}");
				r.l("	//]]></script>");
				r.l("	<div class=\"\">");
				r.l("		<label class=\"w3-tooltip \">");
				r.l("			<span>", StringEscapeUtils.escapeHtml4(nomAffichageTransactionCodeDisplayName()), "</span>");
				r.s("			<input");
							r.s(" name=\"transactionCodeDisplayName\"");
							r.s(" value=\"", htmTransactionCodeDisplayName(), "\");");
							r.s(" onchange=\"\"");
							r.l("/>");
				r.l("		</label>");
				r.l("	</div>");
			} else {
				r.s(htmTransactionCodeDisplayName());
			}
			r.l("</div>");
		}
	}

	/////////////////////////////////
	// transactionCodeCompleteName //
	/////////////////////////////////

	/**	L'entité « transactionCodeCompleteName »
	 *	 is defined as null before being initialized. 
	 */
	protected String transactionCodeCompleteName;
	@JsonIgnore
	public Wrap<String> transactionCodeCompleteNameWrap = new Wrap<String>().p(this).c(String.class).var("transactionCodeCompleteName").o(transactionCodeCompleteName);

	/**	<br/>L'entité « transactionCodeCompleteName »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enus.transaction.code.TransactionCode&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:transactionCodeCompleteName">Trouver l'entité transactionCodeCompleteName dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _transactionCodeCompleteName(Wrap<String> c);

	public String getTransactionCodeCompleteName() {
		return transactionCodeCompleteName;
	}

	public void setTransactionCodeCompleteName(String transactionCodeCompleteName) {
		this.transactionCodeCompleteName = transactionCodeCompleteName;
		this.transactionCodeCompleteNameWrap.alreadyInitialized = true;
	}
	protected TransactionCode transactionCodeCompleteNameInit() {
		if(!transactionCodeCompleteNameWrap.alreadyInitialized) {
			_transactionCodeCompleteName(transactionCodeCompleteNameWrap);
			if(transactionCodeCompleteName == null)
				setTransactionCodeCompleteName(transactionCodeCompleteNameWrap.o);
		}
		transactionCodeCompleteNameWrap.alreadyInitialized(true);
		return (TransactionCode)this;
	}

	public String solrTransactionCodeCompleteName() {
		return transactionCodeCompleteName;
	}

	public String strTransactionCodeCompleteName() {
		return transactionCodeCompleteName == null ? "" : transactionCodeCompleteName;
	}

	public String jsonTransactionCodeCompleteName() {
		return transactionCodeCompleteName == null ? "" : transactionCodeCompleteName;
	}

	public String nomAffichageTransactionCodeCompleteName() {
		return null;
	}

	public String htmTooltipTransactionCodeCompleteName() {
		return null;
	}

	public String htmTransactionCodeCompleteName() {
		return transactionCodeCompleteName == null ? "" : StringEscapeUtils.escapeHtml4(strTransactionCodeCompleteName());
	}

	public void htmTransactionCodeCompleteName(AllWriter r, Boolean patchRights) {
		if(pk!= null) {
			r.s("<div id=\"patchTransactionCode", strPk(), "TransactionCodeCompleteName\">");
			if(patchRights) {
				r.l();
				r.l("	<script>//<![CDATA[");
				r.l("		function patchTransactionCode", strPk(), "TransactionCodeCompleteName() {");
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
				r.l("				data: {\"setTransactionCodeCompleteName\": this.value },");
				r.l("				");
				r.l("			});");
				r.l("		}");
				r.l("	//]]></script>");
				r.l("	<div class=\"\">");
				r.l("		<label class=\"w3-tooltip \">");
				r.l("			<span>", StringEscapeUtils.escapeHtml4(nomAffichageTransactionCodeCompleteName()), "</span>");
				r.s("			<input");
							r.s(" name=\"transactionCodeCompleteName\"");
							r.s(" value=\"", htmTransactionCodeCompleteName(), "\");");
							r.s(" onchange=\"\"");
							r.l("/>");
				r.l("		</label>");
				r.l("	</div>");
			} else {
				r.s(htmTransactionCodeCompleteName());
			}
			r.l("</div>");
		}
	}

	///////////////////////
	// transactionCodeId //
	///////////////////////

	/**	L'entité « transactionCodeId »
	 *	 is defined as null before being initialized. 
	 */
	protected String transactionCodeId;
	@JsonIgnore
	public Wrap<String> transactionCodeIdWrap = new Wrap<String>().p(this).c(String.class).var("transactionCodeId").o(transactionCodeId);

	/**	<br/>L'entité « transactionCodeId »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enus.transaction.code.TransactionCode&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:transactionCodeId">Trouver l'entité transactionCodeId dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _transactionCodeId(Wrap<String> c);

	public String getTransactionCodeId() {
		return transactionCodeId;
	}

	public void setTransactionCodeId(String transactionCodeId) {
		this.transactionCodeId = transactionCodeId;
		this.transactionCodeIdWrap.alreadyInitialized = true;
	}
	protected TransactionCode transactionCodeIdInit() {
		if(!transactionCodeIdWrap.alreadyInitialized) {
			_transactionCodeId(transactionCodeIdWrap);
			if(transactionCodeId == null)
				setTransactionCodeId(transactionCodeIdWrap.o);
		}
		transactionCodeIdWrap.alreadyInitialized(true);
		return (TransactionCode)this;
	}

	public String solrTransactionCodeId() {
		return transactionCodeId;
	}

	public String strTransactionCodeId() {
		return transactionCodeId == null ? "" : transactionCodeId;
	}

	public String jsonTransactionCodeId() {
		return transactionCodeId == null ? "" : transactionCodeId;
	}

	public String nomAffichageTransactionCodeId() {
		return "ID";
	}

	public String htmTooltipTransactionCodeId() {
		return null;
	}

	public String htmTransactionCodeId() {
		return transactionCodeId == null ? "" : StringEscapeUtils.escapeHtml4(strTransactionCodeId());
	}

	public void htmTransactionCodeId(AllWriter r, Boolean patchRights) {
		if(pk!= null) {
			r.s("<div id=\"patchTransactionCode", strPk(), "TransactionCodeId\">");
			if(patchRights) {
				r.l();
				r.l("	<script>//<![CDATA[");
				r.l("		function patchTransactionCode", strPk(), "TransactionCodeId() {");
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
				r.l("				data: {\"setTransactionCodeId\": this.value },");
				r.l("				");
				r.l("			});");
				r.l("		}");
				r.l("	//]]></script>");
				r.l("	<div class=\"\">");
				r.l("		<label class=\"w3-tooltip \">");
				r.l("			<span>", StringEscapeUtils.escapeHtml4(nomAffichageTransactionCodeId()), "</span>");
				r.s("			<input");
							r.s(" name=\"transactionCodeId\"");
							r.s(" value=\"", htmTransactionCodeId(), "\");");
							r.s(" onchange=\"\"");
							r.l("/>");
				r.l("		</label>");
				r.l("	</div>");
			} else {
				r.s(htmTransactionCodeId());
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
	public Wrap<String> pageUrlWrap = new Wrap<String>().p(this).c(String.class).var("pageUrl").o(pageUrl);

	/**	<br/>L'entité « pageUrl »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enus.transaction.code.TransactionCode&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pageUrl">Trouver l'entité pageUrl dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _pageUrl(Wrap<String> c);

	public String getPageUrl() {
		return pageUrl;
	}

	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
		this.pageUrlWrap.alreadyInitialized = true;
	}
	protected TransactionCode pageUrlInit() {
		if(!pageUrlWrap.alreadyInitialized) {
			_pageUrl(pageUrlWrap);
			if(pageUrl == null)
				setPageUrl(pageUrlWrap.o);
		}
		pageUrlWrap.alreadyInitialized(true);
		return (TransactionCode)this;
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

	public void htmPageUrl(AllWriter r, Boolean patchRights) {
		if(pk!= null) {
			r.s("<div id=\"patchTransactionCode", strPk(), "PageUrl\">");
			if(patchRights) {
				r.l();
				r.l("	<script>//<![CDATA[");
				r.l("		function patchTransactionCode", strPk(), "PageUrl() {");
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

	///////////////////
	// objectSuggest //
	///////////////////

	/**	L'entité « objectSuggest »
	 *	 is defined as null before being initialized. 
	 */
	protected String objectSuggest;
	@JsonIgnore
	public Wrap<String> objectSuggestWrap = new Wrap<String>().p(this).c(String.class).var("objectSuggest").o(objectSuggest);

	/**	<br/>L'entité « objectSuggest »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enus.transaction.code.TransactionCode&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:objectSuggest">Trouver l'entité objectSuggest dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _objectSuggest(Wrap<String> c);

	public String getObjectSuggest() {
		return objectSuggest;
	}

	public void setObjectSuggest(String objectSuggest) {
		this.objectSuggest = objectSuggest;
		this.objectSuggestWrap.alreadyInitialized = true;
	}
	protected TransactionCode objectSuggestInit() {
		if(!objectSuggestWrap.alreadyInitialized) {
			_objectSuggest(objectSuggestWrap);
			if(objectSuggest == null)
				setObjectSuggest(objectSuggestWrap.o);
		}
		objectSuggestWrap.alreadyInitialized(true);
		return (TransactionCode)this;
	}

	public String solrObjectSuggest() {
		return objectSuggest;
	}

	public String strObjectSuggest() {
		return objectSuggest == null ? "" : objectSuggest;
	}

	public String jsonObjectSuggest() {
		return objectSuggest == null ? "" : objectSuggest;
	}

	public String nomAffichageObjectSuggest() {
		return null;
	}

	public String htmTooltipObjectSuggest() {
		return null;
	}

	public String htmObjectSuggest() {
		return objectSuggest == null ? "" : StringEscapeUtils.escapeHtml4(strObjectSuggest());
	}

	public void htmObjectSuggest(AllWriter r, Boolean patchRights) {
		if(pk!= null) {
			r.s("<div id=\"patchTransactionCode", strPk(), "ObjectSuggest\">");
			if(patchRights) {
				r.l();
				r.l("	<script>//<![CDATA[");
				r.l("		function patchTransactionCode", strPk(), "ObjectSuggest() {");
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
				r.l("				data: {\"setObjectSuggest\": this.value },");
				r.l("				");
				r.l("			});");
				r.l("		}");
				r.l("	//]]></script>");
				r.l("	<div class=\"\">");
				r.l("		<label class=\"w3-tooltip \">");
				r.l("			<span>", StringEscapeUtils.escapeHtml4(nomAffichageObjectSuggest()), "</span>");
				r.s("			<input");
							r.s(" name=\"objectSuggest\"");
							r.s(" value=\"", htmObjectSuggest(), "\");");
							r.s(" onchange=\"\"");
							r.l("/>");
				r.l("		</label>");
				r.l("	</div>");
			} else {
				r.s(htmObjectSuggest());
			}
			r.l("</div>");
		}
	}

	//////////////
	// initDeep //
	//////////////

	protected boolean alreadyInitializedTransactionCode = false;

	public TransactionCode initDeepTransactionCode(SiteRequestEnUS siteRequest_) {
		setSiteRequest_(siteRequest_);
		if(!alreadyInitializedTransactionCode) {
			alreadyInitializedTransactionCode = true;
			initDeepTransactionCode();
		}
		return (TransactionCode)this;
	}

	public void initDeepTransactionCode() {
		super.initDeepCluster(siteRequest_);
		initTransactionCode();
	}

	public void initTransactionCode() {
		transactionCodeKeyInit();
		transactionCodeInit();
		transactionCodeDisplayNameInit();
		transactionCodeCompleteNameInit();
		transactionCodeIdInit();
		pageUrlInit();
		objectSuggestInit();
	}

	@Override public void initDeepForClass(SiteRequestEnUS siteRequest_) {
		initDeepTransactionCode(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestTransactionCode(SiteRequestEnUS siteRequest_) {
			super.siteRequestCluster(siteRequest_);
	}

	public void siteRequestForClass(SiteRequestEnUS siteRequest_) {
		siteRequestTransactionCode(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	@Override public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainTransactionCode(v);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.obtainForClass(v);
			}
		}
		return o;
	}
	public Object obtainTransactionCode(String var) {
		TransactionCode oTransactionCode = (TransactionCode)this;
		switch(var) {
			case "transactionCodeKey":
				return oTransactionCode.transactionCodeKey;
			case "transactionCode":
				return oTransactionCode.transactionCode;
			case "transactionCodeDisplayName":
				return oTransactionCode.transactionCodeDisplayName;
			case "transactionCodeCompleteName":
				return oTransactionCode.transactionCodeCompleteName;
			case "transactionCodeId":
				return oTransactionCode.transactionCodeId;
			case "pageUrl":
				return oTransactionCode.pageUrl;
			case "objectSuggest":
				return oTransactionCode.objectSuggest;
			default:
				return super.obtainCluster(var);
		}
	}

	///////////////
	// attribute //
	///////////////

	@Override public boolean attributeForClass(String var, Object val) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = attributeTransactionCode(v, val);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.attributeForClass(v, val);
			}
		}
		return o != null;
	}
	public Object attributeTransactionCode(String var, Object val) {
		TransactionCode oTransactionCode = (TransactionCode)this;
		switch(var) {
			default:
				return super.attributeCluster(var, val);
		}
	}

	/////////////
	// define //
	/////////////

	@Override public boolean defineForClass(String var, String val) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		if(val != null) {
			for(String v : vars) {
				if(o == null)
					o = defineTransactionCode(v, val);
				else if(o instanceof Cluster) {
					Cluster cluster = (Cluster)o;
					o = cluster.defineForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object defineTransactionCode(String var, String val) {
		switch(var) {
			case "transactionCode":
				setTransactionCode(val);
				savesTransactionCode.add(var);
				return val;
			case "transactionCodeDisplayName":
				setTransactionCodeDisplayName(val);
				savesTransactionCode.add(var);
				return val;
			default:
				return super.defineCluster(var, val);
		}
	}

	/////////////////
	// saves //
	/////////////////

	protected List<String> savesTransactionCode = new ArrayList<String>();

	/////////////
	// populate //
	/////////////

	@Override public void populateForClass(SolrDocument solrDocument) {
		populateTransactionCode(solrDocument);
	}
	public void populateTransactionCode(SolrDocument solrDocument) {
		TransactionCode oTransactionCode = (TransactionCode)this;
		savesTransactionCode = (List<String>)solrDocument.get("savesTransactionCode_stored_strings");
		if(savesTransactionCode != null) {

			if(savesTransactionCode.contains("transactionCodeKey")) {
				Long transactionCodeKey = (Long)solrDocument.get("transactionCodeKey_stored_long");
				if(transactionCodeKey != null)
					oTransactionCode.setTransactionCodeKey(transactionCodeKey);
			}

			if(savesTransactionCode.contains("transactionCode")) {
				String transactionCode = (String)solrDocument.get("transactionCode_stored_string");
				if(transactionCode != null)
					oTransactionCode.setTransactionCode(transactionCode);
			}

			if(savesTransactionCode.contains("transactionCodeDisplayName")) {
				String transactionCodeDisplayName = (String)solrDocument.get("transactionCodeDisplayName_stored_string");
				if(transactionCodeDisplayName != null)
					oTransactionCode.setTransactionCodeDisplayName(transactionCodeDisplayName);
			}

			if(savesTransactionCode.contains("transactionCodeCompleteName")) {
				String transactionCodeCompleteName = (String)solrDocument.get("transactionCodeCompleteName_stored_string");
				if(transactionCodeCompleteName != null)
					oTransactionCode.setTransactionCodeCompleteName(transactionCodeCompleteName);
			}

			if(savesTransactionCode.contains("transactionCodeId")) {
				String transactionCodeId = (String)solrDocument.get("transactionCodeId_stored_string");
				if(transactionCodeId != null)
					oTransactionCode.setTransactionCodeId(transactionCodeId);
			}

			if(savesTransactionCode.contains("pageUrl")) {
				String pageUrl = (String)solrDocument.get("pageUrl_stored_string");
				if(pageUrl != null)
					oTransactionCode.setPageUrl(pageUrl);
			}

			if(savesTransactionCode.contains("objectSuggest")) {
				String objectSuggest = (String)solrDocument.get("objectSuggest_suggested");
				oTransactionCode.setObjectSuggest(objectSuggest);
			}
		}

		super.populateCluster(solrDocument);
	}

	/////////////
	// index //
	/////////////

	public static void index() {
		try {
			SiteRequestEnUS siteRequest = new SiteRequestEnUS();
			siteRequest.initDeepSiteRequestEnUS();
			SiteContextEnUS siteContext = new SiteContextEnUS();
			siteContext.getSiteConfig().setConfigPath("/usr/local/src/computate-bancaire/computate-bancaire-commun/config/computate-bancaire-commun.config");
			siteContext.initDeepSiteContextEnUS();
			siteRequest.setSiteContext_(siteContext);
			siteRequest.setSiteConfig_(siteContext.getSiteConfig());
			SolrQuery solrQuery = new SolrQuery();
			solrQuery.setQuery("*:*");
			solrQuery.setRows(1);
			solrQuery.addFilterQuery("id:" + ClientUtils.escapeQueryChars("org.computate.bancaire.enus.transaction.code.TransactionCode"));
			QueryResponse queryResponse = siteRequest.getSiteContext_().getSolrClient().query(solrQuery);
			if(queryResponse.getResults().size() > 0)
				siteRequest.setSolrDocument(queryResponse.getResults().get(0));
			TransactionCode o = new TransactionCode();
			o.siteRequestTransactionCode(siteRequest);
			o.initDeepTransactionCode(siteRequest);
			o.indexTransactionCode();
		} catch(Exception e) {
			ExceptionUtils.rethrow(e);
		}
	}


	@Override public void indexForClass() {
		indexTransactionCode();
	}

	@Override public void indexForClass(SolrInputDocument document) {
		indexTransactionCode(document);
	}

	public void indexTransactionCode(SolrClient clientSolr) {
		try {
			SolrInputDocument document = new SolrInputDocument();
			indexTransactionCode(document);
			clientSolr.add(document);
			clientSolr.commit();
		} catch(Exception e) {
			ExceptionUtils.rethrow(e);
		}
	}

	public void indexTransactionCode() {
		try {
			SolrInputDocument document = new SolrInputDocument();
			indexTransactionCode(document);
			SolrClient clientSolr = siteRequest_.getSiteContext_().getSolrClient();
			clientSolr.add(document);
			clientSolr.commit();
		} catch(Exception e) {
			ExceptionUtils.rethrow(e);
		}
	}

	public void indexTransactionCode(SolrInputDocument document) {
		if(savesTransactionCode != null)
			document.addField("savesTransactionCode_stored_strings", savesTransactionCode);

		if(transactionCodeKey != null) {
			document.addField("transactionCodeKey_indexed_long", transactionCodeKey);
			document.addField("transactionCodeKey_stored_long", transactionCodeKey);
		}
		if(transactionCode != null) {
			document.addField("transactionCode_indexed_string", transactionCode);
			document.addField("transactionCode_stored_string", transactionCode);
		}
		if(transactionCodeDisplayName != null) {
			document.addField("transactionCodeDisplayName_indexed_string", transactionCodeDisplayName);
			document.addField("transactionCodeDisplayName_stored_string", transactionCodeDisplayName);
		}
		if(transactionCodeCompleteName != null) {
			document.addField("transactionCodeCompleteName_indexed_string", transactionCodeCompleteName);
			document.addField("transactionCodeCompleteName_stored_string", transactionCodeCompleteName);
		}
		if(transactionCodeId != null) {
			document.addField("transactionCodeId_indexed_string", transactionCodeId);
			document.addField("transactionCodeId_stored_string", transactionCodeId);
		}
		if(pageUrl != null) {
			document.addField("pageUrl_indexed_string", pageUrl);
			document.addField("pageUrl_stored_string", pageUrl);
		}
		if(objectSuggest != null) {
			document.addField("objectSuggest_suggested", objectSuggest);
			document.addField("objectSuggest_indexed_string", objectSuggest);
		}
		super.indexCluster(document);

	}

	public void unindexTransactionCode() {
		try {
		SiteRequestEnUS siteRequest = new SiteRequestEnUS();
			siteRequest.initDeepSiteRequestEnUS();
			SiteContextEnUS siteContext = new SiteContextEnUS();
			siteContext.initDeepSiteContextEnUS();
			siteRequest.setSiteContext_(siteContext);
			siteRequest.setSiteConfig_(siteContext.getSiteConfig());
			initDeepTransactionCode(siteRequest);
			SolrClient solrClient = siteContext.getSolrClient();
			solrClient.deleteById(id.toString());
			solrClient.commit();
		} catch(Exception e) {
			ExceptionUtils.rethrow(e);
		}
	}

	/////////////
	// store //
	/////////////

	@Override public void storeForClass(SolrDocument solrDocument) {
		storeTransactionCode(solrDocument);
	}
	public void storeTransactionCode(SolrDocument solrDocument) {
		TransactionCode oTransactionCode = (TransactionCode)this;

		Long transactionCodeKey = (Long)solrDocument.get("transactionCodeKey_stored_long");
		if(transactionCodeKey != null)
			oTransactionCode.setTransactionCodeKey(transactionCodeKey);

		String transactionCode = (String)solrDocument.get("transactionCode_stored_string");
		if(transactionCode != null)
			oTransactionCode.setTransactionCode(transactionCode);

		String transactionCodeDisplayName = (String)solrDocument.get("transactionCodeDisplayName_stored_string");
		if(transactionCodeDisplayName != null)
			oTransactionCode.setTransactionCodeDisplayName(transactionCodeDisplayName);

		String transactionCodeCompleteName = (String)solrDocument.get("transactionCodeCompleteName_stored_string");
		if(transactionCodeCompleteName != null)
			oTransactionCode.setTransactionCodeCompleteName(transactionCodeCompleteName);

		String transactionCodeId = (String)solrDocument.get("transactionCodeId_stored_string");
		if(transactionCodeId != null)
			oTransactionCode.setTransactionCodeId(transactionCodeId);

		String pageUrl = (String)solrDocument.get("pageUrl_stored_string");
		if(pageUrl != null)
			oTransactionCode.setPageUrl(pageUrl);

		String objectSuggest = (String)solrDocument.get("objectSuggest_suggested");
		oTransactionCode.setObjectSuggest(objectSuggest);

		super.storeCluster(solrDocument);
	}

	//////////////
	// hashCode //
	//////////////

	@Override public int hashCode() {
		return Objects.hash(super.hashCode(), transactionCode, transactionCodeDisplayName);
	}

	////////////
	// equals //
	////////////

	@Override public boolean equals(Object o) {
		if(this == o)
			return true;
		if(!(o instanceof TransactionCode))
			return false;
		TransactionCode that = (TransactionCode)o;
		return super.equals(o)
				&& Objects.equals( transactionCode, that.transactionCode )
				&& Objects.equals( transactionCodeDisplayName, that.transactionCodeDisplayName );
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString() + "\n");
		sb.append("TransactionCode { ");
		sb.append( "transactionCode: \"" ).append(transactionCode).append( "\"" );
		sb.append( ", transactionCodeDisplayName: \"" ).append(transactionCodeDisplayName).append( "\"" );
		sb.append(" }");
		return sb.toString();
	}
}
