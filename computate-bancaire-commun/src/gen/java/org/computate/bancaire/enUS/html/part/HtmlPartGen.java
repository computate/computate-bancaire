package org.computate.bancaire.enUS.html.part;

import org.computate.bancaire.enus.request.patch.PatchRequest;
import java.lang.Double;
import java.util.Date;
import org.apache.commons.lang3.StringUtils;
import org.computate.bancaire.enus.request.SiteRequestEnUS;
import io.vertx.core.logging.LoggerFactory;
import java.text.NumberFormat;
import org.computate.bancaire.enus.contexte.SiteContextEnUS;
import java.util.ArrayList;
import java.lang.Long;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.lang.Boolean;
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
import java.util.Optional;
import io.vertx.ext.sql.SQLClient;
import org.apache.solr.client.solrj.util.ClientUtils;
import org.apache.solr.common.SolrInputDocument;
import org.apache.commons.lang3.exception.ExceptionUtils;

/**	
 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enUS.html.part.HtmlPart&fq=classeEtendGen_indexed_boolean:true">Trouver la classe  dans Solr</a>
 * <br/>
 **/
public abstract class HtmlPartGen<DEV> extends Cluster {
	private static final Logger LOGGER = LoggerFactory.getLogger(HtmlPart.class);

	public static final String HtmlPart_UnNom = "an HTML part";
	public static final String HtmlPart_Ce = "this ";
	public static final String HtmlPart_CeNom = "this HTML part";
	public static final String HtmlPart_Un = "a ";
	public static final String HtmlPart_LeNom = "theHTML part";
	public static final String HtmlPart_NomSingulier = "HTML part";
	public static final String HtmlPart_NomPluriel = "HTML parts";
	public static final String HtmlPart_NomActuel = "current HTML part";
	public static final String HtmlPart_TousNom = "all the HTML parts";
	public static final String HtmlPart_RechercherTousNomPar = "search HTML parts by ";
	public static final String HtmlPart_LesNoms = "the HTML parts";
	public static final String HtmlPart_AucunNomTrouve = "no HTML part found";
	public static final String HtmlPart_NomVar = "html-part";
	public static final String HtmlPart_DeNom = "of HTML part";
	public static final String HtmlPart_UnNomAdjectif = "an HTML part";
	public static final String HtmlPart_NomAdjectifSingulier = "HTML part";
	public static final String HtmlPart_NomAdjectifPluriel = "HTML parts";
	public static final String HtmlPart_Couleur = "yellow";
	public static final String HtmlPart_IconeGroupe = "regular";
	public static final String HtmlPart_IconeNom = "sun";
	public static final Integer HtmlPart_Rows = 1000000;

	/////////////////
	// htmlPartKey //
	/////////////////

	/**	L'entité « htmlPartKey »
	 *	 is defined as null before being initialized. 
	 */
	protected Long htmlPartKey;
	@JsonIgnore
	public Wrap<Long> htmlPartKeyWrap = new Wrap<Long>().p(this).c(Long.class).var("htmlPartKey").o(htmlPartKey);

	/**	<br/>L'entité « htmlPartKey »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enUS.html.part.HtmlPart&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:htmlPartKey">Trouver l'entité htmlPartKey dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _htmlPartKey(Wrap<Long> c);

	public Long getHtmlPartKey() {
		return htmlPartKey;
	}

	public void setHtmlPartKey(Long htmlPartKey) {
		this.htmlPartKey = htmlPartKey;
		this.htmlPartKeyWrap.alreadyInitialized = true;
	}
	public HtmlPart setHtmlPartKey(String o) {
		if(NumberUtils.isParsable(o))
			this.htmlPartKey = Long.parseLong(o);
		this.htmlPartKeyWrap.alreadyInitialized = true;
		return (HtmlPart)this;
	}
	protected HtmlPart htmlPartKeyInit() {
		if(!htmlPartKeyWrap.alreadyInitialized) {
			_htmlPartKey(htmlPartKeyWrap);
			if(htmlPartKey == null)
				setHtmlPartKey(htmlPartKeyWrap.o);
		}
		htmlPartKeyWrap.alreadyInitialized(true);
		return (HtmlPart)this;
	}

	public Long solrHtmlPartKey() {
		return htmlPartKey;
	}

	public String strHtmlPartKey() {
		return htmlPartKey == null ? "" : htmlPartKey.toString();
	}

	public String jsonHtmlPartKey() {
		return htmlPartKey == null ? "" : htmlPartKey.toString();
	}

	public String nomAffichageHtmlPartKey() {
		return "key";
	}

	public String htmTooltipHtmlPartKey() {
		return null;
	}

	public String htmHtmlPartKey() {
		return htmlPartKey == null ? "" : StringEscapeUtils.escapeHtml4(strHtmlPartKey());
	}

	/////////////////////////
	// enrollmentDesignKey //
	/////////////////////////

	/**	L'entité « enrollmentDesignKey »
	 *	 is defined as null before being initialized. 
	 */
	protected Long enrollmentDesignKey;
	@JsonIgnore
	public Wrap<Long> enrollmentDesignKeyWrap = new Wrap<Long>().p(this).c(Long.class).var("enrollmentDesignKey").o(enrollmentDesignKey);

	/**	<br/>L'entité « enrollmentDesignKey »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enUS.html.part.HtmlPart&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:enrollmentDesignKey">Trouver l'entité enrollmentDesignKey dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _enrollmentDesignKey(Wrap<Long> c);

	public Long getEnrollmentDesignKey() {
		return enrollmentDesignKey;
	}

	public void setEnrollmentDesignKey(Long enrollmentDesignKey) {
		this.enrollmentDesignKey = enrollmentDesignKey;
		this.enrollmentDesignKeyWrap.alreadyInitialized = true;
	}
	public HtmlPart setEnrollmentDesignKey(String o) {
		if(NumberUtils.isParsable(o))
			this.enrollmentDesignKey = Long.parseLong(o);
		this.enrollmentDesignKeyWrap.alreadyInitialized = true;
		return (HtmlPart)this;
	}
	protected HtmlPart enrollmentDesignKeyInit() {
		if(!enrollmentDesignKeyWrap.alreadyInitialized) {
			_enrollmentDesignKey(enrollmentDesignKeyWrap);
			if(enrollmentDesignKey == null)
				setEnrollmentDesignKey(enrollmentDesignKeyWrap.o);
		}
		enrollmentDesignKeyWrap.alreadyInitialized(true);
		return (HtmlPart)this;
	}

	public Long solrEnrollmentDesignKey() {
		return enrollmentDesignKey;
	}

	public String strEnrollmentDesignKey() {
		return enrollmentDesignKey == null ? "" : enrollmentDesignKey.toString();
	}

	public String jsonEnrollmentDesignKey() {
		return enrollmentDesignKey == null ? "" : enrollmentDesignKey.toString();
	}

	public String nomAffichageEnrollmentDesignKey() {
		return "enrollment design";
	}

	public String htmTooltipEnrollmentDesignKey() {
		return null;
	}

	public String htmEnrollmentDesignKey() {
		return enrollmentDesignKey == null ? "" : StringEscapeUtils.escapeHtml4(strEnrollmentDesignKey());
	}

	public void inputEnrollmentDesignKey(String classApiMethodMethod) {
		HtmlPart s = (HtmlPart)this;
	}

	public void htmEnrollmentDesignKey(String classApiMethodMethod) {
		HtmlPart s = (HtmlPart)this;
		{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			if("Page".equals(classApiMethodMethod)) {
				{ e("div").a("class", "w3-padding ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-yellow ").f();
							e("label").a("class", "").f().sx("enrollment design").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row  ").f();
							{ e("div").a("class", "w3-cell ").f();
								{ e("div").a("class", "w3-rest ").f();
									e("span").f().sx(strEnrollmentDesignKey()).g("span");
								} g("div");
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			}
		} g("div");
	}

	//////////////
	// htmlLink //
	//////////////

	/**	L'entité « htmlLink »
	 *	 is defined as null before being initialized. 
	 */
	protected String htmlLink;
	@JsonIgnore
	public Wrap<String> htmlLinkWrap = new Wrap<String>().p(this).c(String.class).var("htmlLink").o(htmlLink);

	/**	<br/>L'entité « htmlLink »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enUS.html.part.HtmlPart&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:htmlLink">Trouver l'entité htmlLink dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _htmlLink(Wrap<String> c);

	public String getHtmlLink() {
		return htmlLink;
	}

	public void setHtmlLink(String htmlLink) {
		this.htmlLink = htmlLink;
		this.htmlLinkWrap.alreadyInitialized = true;
	}
	protected HtmlPart htmlLinkInit() {
		if(!htmlLinkWrap.alreadyInitialized) {
			_htmlLink(htmlLinkWrap);
			if(htmlLink == null)
				setHtmlLink(htmlLinkWrap.o);
		}
		htmlLinkWrap.alreadyInitialized(true);
		return (HtmlPart)this;
	}

	public String solrHtmlLink() {
		return htmlLink;
	}

	public String strHtmlLink() {
		return htmlLink == null ? "" : htmlLink;
	}

	public String jsonHtmlLink() {
		return htmlLink == null ? "" : htmlLink;
	}

	public String nomAffichageHtmlLink() {
		return "link";
	}

	public String htmTooltipHtmlLink() {
		return null;
	}

	public String htmHtmlLink() {
		return htmlLink == null ? "" : StringEscapeUtils.escapeHtml4(strHtmlLink());
	}

	public void inputHtmlLink(String classApiMethodMethod) {
		HtmlPart s = (HtmlPart)this;
		e("input")
			.a("type", "text")
			.a("placeholder", "link")
			.a("id", classApiMethodMethod, "_htmlLink");
			if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
				a("class", "setHtmlLink inputHtmlPart", pk, "HtmlLink w3-input w3-border ");
				a("name", "setHtmlLink");
			} else {
				a("class", "valueHtmlLink w3-input w3-border inputHtmlPart", pk, "HtmlLink w3-input w3-border ");
				a("name", "htmlLink");
			}
			if("Page".equals(classApiMethodMethod)) {
				a("onclick", "removeGlow($(this)); ");
				a("onchange", "patchHtmlPartVal([{ name: 'fq', value: 'pk:", pk, "' }], 'setHtmlLink', $(this).val(), function() { addGlow($('#", classApiMethodMethod, "_htmlLink')); }, function() { addError($('#", classApiMethodMethod, "_htmlLink')); }); ");
			}
			a("value", strHtmlLink())
		.fg();

	}

	public void htmHtmlLink(String classApiMethodMethod) {
		HtmlPart s = (HtmlPart)this;
		{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggestHtmlPartHtmlLink").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-yellow ").f();
							e("label").a("for", classApiMethodMethod, "_htmlLink").a("class", "").f().sx("link").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputHtmlLink(classApiMethodMethod);
							} g("div");
							if("Page".equals(classApiMethodMethod)) {
								{ e("div").a("class", "w3-cell w3-left-align w3-cell-top ").f();
									{ e("button")
										.a("tabindex", "-1")
										.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-bar-item w3-yellow ")
									.a("onclick", "removeGlow($('#", classApiMethodMethod, "_htmlLink')); $('#", classApiMethodMethod, "_htmlLink').val(null); patchHtmlPartVal([{ name: 'fq', value: 'pk:' + $('#HtmlPartForm :input[name=pk]').val() }], 'setHtmlLink', null, function() { addGlow($('#", classApiMethodMethod, "_htmlLink')); }, function() { addError($('#", classApiMethodMethod, "_htmlLink')); }); ")
										.f();
										e("i").a("class", "far fa-eraser ").f().g("i");
									} g("button");
								} g("div");
							}
						} g("div");
					} g("div");
				} g("div");
			} g("div");
		} g("div");
	}

	/////////////////
	// htmlElement //
	/////////////////

	/**	L'entité « htmlElement »
	 *	 is defined as null before being initialized. 
	 */
	protected String htmlElement;
	@JsonIgnore
	public Wrap<String> htmlElementWrap = new Wrap<String>().p(this).c(String.class).var("htmlElement").o(htmlElement);

	/**	<br/>L'entité « htmlElement »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enUS.html.part.HtmlPart&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:htmlElement">Trouver l'entité htmlElement dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _htmlElement(Wrap<String> c);

	public String getHtmlElement() {
		return htmlElement;
	}

	public void setHtmlElement(String htmlElement) {
		this.htmlElement = htmlElement;
		this.htmlElementWrap.alreadyInitialized = true;
	}
	protected HtmlPart htmlElementInit() {
		if(!htmlElementWrap.alreadyInitialized) {
			_htmlElement(htmlElementWrap);
			if(htmlElement == null)
				setHtmlElement(htmlElementWrap.o);
		}
		htmlElementWrap.alreadyInitialized(true);
		return (HtmlPart)this;
	}

	public String solrHtmlElement() {
		return htmlElement;
	}

	public String strHtmlElement() {
		return htmlElement == null ? "" : htmlElement;
	}

	public String jsonHtmlElement() {
		return htmlElement == null ? "" : htmlElement;
	}

	public String nomAffichageHtmlElement() {
		return "HTML element";
	}

	public String htmTooltipHtmlElement() {
		return null;
	}

	public String htmHtmlElement() {
		return htmlElement == null ? "" : StringEscapeUtils.escapeHtml4(strHtmlElement());
	}

	public void inputHtmlElement(String classApiMethodMethod) {
		HtmlPart s = (HtmlPart)this;
		e("input")
			.a("type", "text")
			.a("placeholder", "HTML element")
			.a("id", classApiMethodMethod, "_htmlElement");
			if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
				a("class", "setHtmlElement inputHtmlPart", pk, "HtmlElement w3-input w3-border ");
				a("name", "setHtmlElement");
			} else {
				a("class", "valueHtmlElement w3-input w3-border inputHtmlPart", pk, "HtmlElement w3-input w3-border ");
				a("name", "htmlElement");
			}
			if("Page".equals(classApiMethodMethod)) {
				a("onclick", "removeGlow($(this)); ");
				a("onchange", "patchHtmlPartVal([{ name: 'fq', value: 'pk:", pk, "' }], 'setHtmlElement', $(this).val(), function() { addGlow($('#", classApiMethodMethod, "_htmlElement')); }, function() { addError($('#", classApiMethodMethod, "_htmlElement')); }); ");
			}
			a("value", strHtmlElement())
		.fg();

	}

	public void htmHtmlElement(String classApiMethodMethod) {
		HtmlPart s = (HtmlPart)this;
		{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggestHtmlPartHtmlElement").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-yellow ").f();
							e("label").a("for", classApiMethodMethod, "_htmlElement").a("class", "").f().sx("HTML element").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputHtmlElement(classApiMethodMethod);
							} g("div");
							if("Page".equals(classApiMethodMethod)) {
								{ e("div").a("class", "w3-cell w3-left-align w3-cell-top ").f();
									{ e("button")
										.a("tabindex", "-1")
										.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-bar-item w3-yellow ")
									.a("onclick", "removeGlow($('#", classApiMethodMethod, "_htmlElement')); $('#", classApiMethodMethod, "_htmlElement').val(null); patchHtmlPartVal([{ name: 'fq', value: 'pk:' + $('#HtmlPartForm :input[name=pk]').val() }], 'setHtmlElement', null, function() { addGlow($('#", classApiMethodMethod, "_htmlElement')); }, function() { addError($('#", classApiMethodMethod, "_htmlElement')); }); ")
										.f();
										e("i").a("class", "far fa-eraser ").f().g("i");
									} g("button");
								} g("div");
							}
						} g("div");
					} g("div");
				} g("div");
			} g("div");
		} g("div");
	}

	////////////
	// htmlId //
	////////////

	/**	L'entité « htmlId »
	 *	 is defined as null before being initialized. 
	 */
	protected String htmlId;
	@JsonIgnore
	public Wrap<String> htmlIdWrap = new Wrap<String>().p(this).c(String.class).var("htmlId").o(htmlId);

	/**	<br/>L'entité « htmlId »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enUS.html.part.HtmlPart&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:htmlId">Trouver l'entité htmlId dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _htmlId(Wrap<String> c);

	public String getHtmlId() {
		return htmlId;
	}

	public void setHtmlId(String htmlId) {
		this.htmlId = htmlId;
		this.htmlIdWrap.alreadyInitialized = true;
	}
	protected HtmlPart htmlIdInit() {
		if(!htmlIdWrap.alreadyInitialized) {
			_htmlId(htmlIdWrap);
			if(htmlId == null)
				setHtmlId(htmlIdWrap.o);
		}
		htmlIdWrap.alreadyInitialized(true);
		return (HtmlPart)this;
	}

	public String solrHtmlId() {
		return htmlId;
	}

	public String strHtmlId() {
		return htmlId == null ? "" : htmlId;
	}

	public String jsonHtmlId() {
		return htmlId == null ? "" : htmlId;
	}

	public String nomAffichageHtmlId() {
		return "HTML ID";
	}

	public String htmTooltipHtmlId() {
		return null;
	}

	public String htmHtmlId() {
		return htmlId == null ? "" : StringEscapeUtils.escapeHtml4(strHtmlId());
	}

	public void inputHtmlId(String classApiMethodMethod) {
		HtmlPart s = (HtmlPart)this;
		e("input")
			.a("type", "text")
			.a("placeholder", "HTML ID")
			.a("id", classApiMethodMethod, "_htmlId");
			if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
				a("class", "setHtmlId inputHtmlPart", pk, "HtmlId w3-input w3-border ");
				a("name", "setHtmlId");
			} else {
				a("class", "valueHtmlId w3-input w3-border inputHtmlPart", pk, "HtmlId w3-input w3-border ");
				a("name", "htmlId");
			}
			if("Page".equals(classApiMethodMethod)) {
				a("onclick", "removeGlow($(this)); ");
				a("onchange", "patchHtmlPartVal([{ name: 'fq', value: 'pk:", pk, "' }], 'setHtmlId', $(this).val(), function() { addGlow($('#", classApiMethodMethod, "_htmlId')); }, function() { addError($('#", classApiMethodMethod, "_htmlId')); }); ");
			}
			a("value", strHtmlId())
		.fg();

	}

	public void htmHtmlId(String classApiMethodMethod) {
		HtmlPart s = (HtmlPart)this;
		{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggestHtmlPartHtmlId").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-yellow ").f();
							e("label").a("for", classApiMethodMethod, "_htmlId").a("class", "").f().sx("HTML ID").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputHtmlId(classApiMethodMethod);
							} g("div");
							if("Page".equals(classApiMethodMethod)) {
								{ e("div").a("class", "w3-cell w3-left-align w3-cell-top ").f();
									{ e("button")
										.a("tabindex", "-1")
										.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-bar-item w3-yellow ")
									.a("onclick", "removeGlow($('#", classApiMethodMethod, "_htmlId')); $('#", classApiMethodMethod, "_htmlId').val(null); patchHtmlPartVal([{ name: 'fq', value: 'pk:' + $('#HtmlPartForm :input[name=pk]').val() }], 'setHtmlId', null, function() { addGlow($('#", classApiMethodMethod, "_htmlId')); }, function() { addError($('#", classApiMethodMethod, "_htmlId')); }); ")
										.f();
										e("i").a("class", "far fa-eraser ").f().g("i");
									} g("button");
								} g("div");
							}
						} g("div");
					} g("div");
				} g("div");
			} g("div");
		} g("div");
	}

	/////////////////
	// htmlClasses //
	/////////////////

	/**	L'entité « htmlClasses »
	 *	 is defined as null before being initialized. 
	 */
	protected String htmlClasses;
	@JsonIgnore
	public Wrap<String> htmlClassesWrap = new Wrap<String>().p(this).c(String.class).var("htmlClasses").o(htmlClasses);

	/**	<br/>L'entité « htmlClasses »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enUS.html.part.HtmlPart&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:htmlClasses">Trouver l'entité htmlClasses dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _htmlClasses(Wrap<String> c);

	public String getHtmlClasses() {
		return htmlClasses;
	}

	public void setHtmlClasses(String htmlClasses) {
		this.htmlClasses = htmlClasses;
		this.htmlClassesWrap.alreadyInitialized = true;
	}
	protected HtmlPart htmlClassesInit() {
		if(!htmlClassesWrap.alreadyInitialized) {
			_htmlClasses(htmlClassesWrap);
			if(htmlClasses == null)
				setHtmlClasses(htmlClassesWrap.o);
		}
		htmlClassesWrap.alreadyInitialized(true);
		return (HtmlPart)this;
	}

	public String solrHtmlClasses() {
		return htmlClasses;
	}

	public String strHtmlClasses() {
		return htmlClasses == null ? "" : htmlClasses;
	}

	public String jsonHtmlClasses() {
		return htmlClasses == null ? "" : htmlClasses;
	}

	public String nomAffichageHtmlClasses() {
		return "HTML classes";
	}

	public String htmTooltipHtmlClasses() {
		return null;
	}

	public String htmHtmlClasses() {
		return htmlClasses == null ? "" : StringEscapeUtils.escapeHtml4(strHtmlClasses());
	}

	public void inputHtmlClasses(String classApiMethodMethod) {
		HtmlPart s = (HtmlPart)this;
		e("input")
			.a("type", "text")
			.a("placeholder", "HTML classes")
			.a("id", classApiMethodMethod, "_htmlClasses");
			if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
				a("class", "setHtmlClasses inputHtmlPart", pk, "HtmlClasses w3-input w3-border ");
				a("name", "setHtmlClasses");
			} else {
				a("class", "valueHtmlClasses w3-input w3-border inputHtmlPart", pk, "HtmlClasses w3-input w3-border ");
				a("name", "htmlClasses");
			}
			if("Page".equals(classApiMethodMethod)) {
				a("onclick", "removeGlow($(this)); ");
				a("onchange", "patchHtmlPartVal([{ name: 'fq', value: 'pk:", pk, "' }], 'setHtmlClasses', $(this).val(), function() { addGlow($('#", classApiMethodMethod, "_htmlClasses')); }, function() { addError($('#", classApiMethodMethod, "_htmlClasses')); }); ");
			}
			a("value", strHtmlClasses())
		.fg();

	}

	public void htmHtmlClasses(String classApiMethodMethod) {
		HtmlPart s = (HtmlPart)this;
		{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggestHtmlPartHtmlClasses").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-yellow ").f();
							e("label").a("for", classApiMethodMethod, "_htmlClasses").a("class", "").f().sx("HTML classes").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputHtmlClasses(classApiMethodMethod);
							} g("div");
							if("Page".equals(classApiMethodMethod)) {
								{ e("div").a("class", "w3-cell w3-left-align w3-cell-top ").f();
									{ e("button")
										.a("tabindex", "-1")
										.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-bar-item w3-yellow ")
									.a("onclick", "removeGlow($('#", classApiMethodMethod, "_htmlClasses')); $('#", classApiMethodMethod, "_htmlClasses').val(null); patchHtmlPartVal([{ name: 'fq', value: 'pk:' + $('#HtmlPartForm :input[name=pk]').val() }], 'setHtmlClasses', null, function() { addGlow($('#", classApiMethodMethod, "_htmlClasses')); }, function() { addError($('#", classApiMethodMethod, "_htmlClasses')); }); ")
										.f();
										e("i").a("class", "far fa-eraser ").f().g("i");
									} g("button");
								} g("div");
							}
						} g("div");
					} g("div");
				} g("div");
			} g("div");
		} g("div");
	}

	///////////////
	// htmlStyle //
	///////////////

	/**	L'entité « htmlStyle »
	 *	 is defined as null before being initialized. 
	 */
	protected String htmlStyle;
	@JsonIgnore
	public Wrap<String> htmlStyleWrap = new Wrap<String>().p(this).c(String.class).var("htmlStyle").o(htmlStyle);

	/**	<br/>L'entité « htmlStyle »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enUS.html.part.HtmlPart&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:htmlStyle">Trouver l'entité htmlStyle dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _htmlStyle(Wrap<String> c);

	public String getHtmlStyle() {
		return htmlStyle;
	}

	public void setHtmlStyle(String htmlStyle) {
		this.htmlStyle = htmlStyle;
		this.htmlStyleWrap.alreadyInitialized = true;
	}
	protected HtmlPart htmlStyleInit() {
		if(!htmlStyleWrap.alreadyInitialized) {
			_htmlStyle(htmlStyleWrap);
			if(htmlStyle == null)
				setHtmlStyle(htmlStyleWrap.o);
		}
		htmlStyleWrap.alreadyInitialized(true);
		return (HtmlPart)this;
	}

	public String solrHtmlStyle() {
		return htmlStyle;
	}

	public String strHtmlStyle() {
		return htmlStyle == null ? "" : htmlStyle;
	}

	public String jsonHtmlStyle() {
		return htmlStyle == null ? "" : htmlStyle;
	}

	public String nomAffichageHtmlStyle() {
		return "HTML style";
	}

	public String htmTooltipHtmlStyle() {
		return null;
	}

	public String htmHtmlStyle() {
		return htmlStyle == null ? "" : StringEscapeUtils.escapeHtml4(strHtmlStyle());
	}

	public void inputHtmlStyle(String classApiMethodMethod) {
		HtmlPart s = (HtmlPart)this;
		e("input")
			.a("type", "text")
			.a("placeholder", "HTML style")
			.a("id", classApiMethodMethod, "_htmlStyle");
			if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
				a("class", "setHtmlStyle inputHtmlPart", pk, "HtmlStyle w3-input w3-border ");
				a("name", "setHtmlStyle");
			} else {
				a("class", "valueHtmlStyle w3-input w3-border inputHtmlPart", pk, "HtmlStyle w3-input w3-border ");
				a("name", "htmlStyle");
			}
			if("Page".equals(classApiMethodMethod)) {
				a("onclick", "removeGlow($(this)); ");
				a("onchange", "patchHtmlPartVal([{ name: 'fq', value: 'pk:", pk, "' }], 'setHtmlStyle', $(this).val(), function() { addGlow($('#", classApiMethodMethod, "_htmlStyle')); }, function() { addError($('#", classApiMethodMethod, "_htmlStyle')); }); ");
			}
			a("value", strHtmlStyle())
		.fg();

	}

	public void htmHtmlStyle(String classApiMethodMethod) {
		HtmlPart s = (HtmlPart)this;
		{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggestHtmlPartHtmlStyle").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-yellow ").f();
							e("label").a("for", classApiMethodMethod, "_htmlStyle").a("class", "").f().sx("HTML style").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputHtmlStyle(classApiMethodMethod);
							} g("div");
							if("Page".equals(classApiMethodMethod)) {
								{ e("div").a("class", "w3-cell w3-left-align w3-cell-top ").f();
									{ e("button")
										.a("tabindex", "-1")
										.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-bar-item w3-yellow ")
									.a("onclick", "removeGlow($('#", classApiMethodMethod, "_htmlStyle')); $('#", classApiMethodMethod, "_htmlStyle').val(null); patchHtmlPartVal([{ name: 'fq', value: 'pk:' + $('#HtmlPartForm :input[name=pk]').val() }], 'setHtmlStyle', null, function() { addGlow($('#", classApiMethodMethod, "_htmlStyle')); }, function() { addError($('#", classApiMethodMethod, "_htmlStyle')); }); ")
										.f();
										e("i").a("class", "far fa-eraser ").f().g("i");
									} g("button");
								} g("div");
							}
						} g("div");
					} g("div");
				} g("div");
			} g("div");
		} g("div");
	}

	////////////////
	// htmlBefore //
	////////////////

	/**	L'entité « htmlBefore »
	 *	 is defined as null before being initialized. 
	 */
	protected String htmlBefore;
	@JsonIgnore
	public Wrap<String> htmlBeforeWrap = new Wrap<String>().p(this).c(String.class).var("htmlBefore").o(htmlBefore);

	/**	<br/>L'entité « htmlBefore »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enUS.html.part.HtmlPart&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:htmlBefore">Trouver l'entité htmlBefore dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _htmlBefore(Wrap<String> c);

	public String getHtmlBefore() {
		return htmlBefore;
	}

	public void setHtmlBefore(String htmlBefore) {
		this.htmlBefore = htmlBefore;
		this.htmlBeforeWrap.alreadyInitialized = true;
	}
	protected HtmlPart htmlBeforeInit() {
		if(!htmlBeforeWrap.alreadyInitialized) {
			_htmlBefore(htmlBeforeWrap);
			if(htmlBefore == null)
				setHtmlBefore(htmlBeforeWrap.o);
		}
		htmlBeforeWrap.alreadyInitialized(true);
		return (HtmlPart)this;
	}

	public String solrHtmlBefore() {
		return htmlBefore;
	}

	public String strHtmlBefore() {
		return htmlBefore == null ? "" : htmlBefore;
	}

	public String jsonHtmlBefore() {
		return htmlBefore == null ? "" : htmlBefore;
	}

	public String nomAffichageHtmlBefore() {
		return "HTML before";
	}

	public String htmTooltipHtmlBefore() {
		return null;
	}

	public String htmHtmlBefore() {
		return htmlBefore == null ? "" : StringEscapeUtils.escapeHtml4(strHtmlBefore());
	}

	public void inputHtmlBefore(String classApiMethodMethod) {
		HtmlPart s = (HtmlPart)this;
		e("textarea")
			.a("placeholder", "HTML before")
			.a("id", classApiMethodMethod, "_htmlBefore");
			if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
				a("class", "setHtmlBefore inputHtmlPart", pk, "HtmlBefore w3-input w3-border ");
				a("name", "setHtmlBefore");
			} else {
				a("class", "valueHtmlBefore w3-input w3-border inputHtmlPart", pk, "HtmlBefore w3-input w3-border ");
				a("name", "htmlBefore");
			}
			if("Page".equals(classApiMethodMethod)) {
				a("onclick", "removeGlow($(this)); ");
				a("onchange", "patchHtmlPartVal([{ name: 'fq', value: 'pk:", pk, "' }], 'setHtmlBefore', $(this).val(), function() { addGlow($('#", classApiMethodMethod, "_htmlBefore')); }, function() { addError($('#", classApiMethodMethod, "_htmlBefore')); }); ");
			}
		f().sx(strHtmlBefore()).g("textarea");

	}

	public void htmHtmlBefore(String classApiMethodMethod) {
		HtmlPart s = (HtmlPart)this;
		{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggestHtmlPartHtmlBefore").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-yellow ").f();
							e("label").a("for", classApiMethodMethod, "_htmlBefore").a("class", "").f().sx("HTML before").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputHtmlBefore(classApiMethodMethod);
							} g("div");
							if("Page".equals(classApiMethodMethod)) {
								{ e("div").a("class", "w3-cell w3-left-align w3-cell-top ").f();
									{ e("button")
										.a("tabindex", "-1")
										.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-bar-item w3-yellow ")
									.a("onclick", "removeGlow($('#", classApiMethodMethod, "_htmlBefore')); $('#", classApiMethodMethod, "_htmlBefore').val(null); patchHtmlPartVal([{ name: 'fq', value: 'pk:' + $('#HtmlPartForm :input[name=pk]').val() }], 'setHtmlBefore', null, function() { addGlow($('#", classApiMethodMethod, "_htmlBefore')); }, function() { addError($('#", classApiMethodMethod, "_htmlBefore')); }); ")
										.f();
										e("i").a("class", "far fa-eraser ").f().g("i");
									} g("button");
								} g("div");
							}
						} g("div");
					} g("div");
				} g("div");
			} g("div");
		} g("div");
	}

	///////////////
	// htmlAfter //
	///////////////

	/**	L'entité « htmlAfter »
	 *	 is defined as null before being initialized. 
	 */
	protected String htmlAfter;
	@JsonIgnore
	public Wrap<String> htmlAfterWrap = new Wrap<String>().p(this).c(String.class).var("htmlAfter").o(htmlAfter);

	/**	<br/>L'entité « htmlAfter »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enUS.html.part.HtmlPart&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:htmlAfter">Trouver l'entité htmlAfter dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _htmlAfter(Wrap<String> c);

	public String getHtmlAfter() {
		return htmlAfter;
	}

	public void setHtmlAfter(String htmlAfter) {
		this.htmlAfter = htmlAfter;
		this.htmlAfterWrap.alreadyInitialized = true;
	}
	protected HtmlPart htmlAfterInit() {
		if(!htmlAfterWrap.alreadyInitialized) {
			_htmlAfter(htmlAfterWrap);
			if(htmlAfter == null)
				setHtmlAfter(htmlAfterWrap.o);
		}
		htmlAfterWrap.alreadyInitialized(true);
		return (HtmlPart)this;
	}

	public String solrHtmlAfter() {
		return htmlAfter;
	}

	public String strHtmlAfter() {
		return htmlAfter == null ? "" : htmlAfter;
	}

	public String jsonHtmlAfter() {
		return htmlAfter == null ? "" : htmlAfter;
	}

	public String nomAffichageHtmlAfter() {
		return "HTML after";
	}

	public String htmTooltipHtmlAfter() {
		return null;
	}

	public String htmHtmlAfter() {
		return htmlAfter == null ? "" : StringEscapeUtils.escapeHtml4(strHtmlAfter());
	}

	public void inputHtmlAfter(String classApiMethodMethod) {
		HtmlPart s = (HtmlPart)this;
		e("textarea")
			.a("placeholder", "HTML after")
			.a("id", classApiMethodMethod, "_htmlAfter");
			if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
				a("class", "setHtmlAfter inputHtmlPart", pk, "HtmlAfter w3-input w3-border ");
				a("name", "setHtmlAfter");
			} else {
				a("class", "valueHtmlAfter w3-input w3-border inputHtmlPart", pk, "HtmlAfter w3-input w3-border ");
				a("name", "htmlAfter");
			}
			if("Page".equals(classApiMethodMethod)) {
				a("onclick", "removeGlow($(this)); ");
				a("onchange", "patchHtmlPartVal([{ name: 'fq', value: 'pk:", pk, "' }], 'setHtmlAfter', $(this).val(), function() { addGlow($('#", classApiMethodMethod, "_htmlAfter')); }, function() { addError($('#", classApiMethodMethod, "_htmlAfter')); }); ");
			}
		f().sx(strHtmlAfter()).g("textarea");

	}

	public void htmHtmlAfter(String classApiMethodMethod) {
		HtmlPart s = (HtmlPart)this;
		{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggestHtmlPartHtmlAfter").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-yellow ").f();
							e("label").a("for", classApiMethodMethod, "_htmlAfter").a("class", "").f().sx("HTML after").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputHtmlAfter(classApiMethodMethod);
							} g("div");
							if("Page".equals(classApiMethodMethod)) {
								{ e("div").a("class", "w3-cell w3-left-align w3-cell-top ").f();
									{ e("button")
										.a("tabindex", "-1")
										.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-bar-item w3-yellow ")
									.a("onclick", "removeGlow($('#", classApiMethodMethod, "_htmlAfter')); $('#", classApiMethodMethod, "_htmlAfter').val(null); patchHtmlPartVal([{ name: 'fq', value: 'pk:' + $('#HtmlPartForm :input[name=pk]').val() }], 'setHtmlAfter', null, function() { addGlow($('#", classApiMethodMethod, "_htmlAfter')); }, function() { addError($('#", classApiMethodMethod, "_htmlAfter')); }); ")
										.f();
										e("i").a("class", "far fa-eraser ").f().g("i");
									} g("button");
								} g("div");
							}
						} g("div");
					} g("div");
				} g("div");
			} g("div");
		} g("div");
	}

	//////////////
	// htmlText //
	//////////////

	/**	L'entité « htmlText »
	 *	 is defined as null before being initialized. 
	 */
	protected String htmlText;
	@JsonIgnore
	public Wrap<String> htmlTextWrap = new Wrap<String>().p(this).c(String.class).var("htmlText").o(htmlText);

	/**	<br/>L'entité « htmlText »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enUS.html.part.HtmlPart&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:htmlText">Trouver l'entité htmlText dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _htmlText(Wrap<String> c);

	public String getHtmlText() {
		return htmlText;
	}

	public void setHtmlText(String htmlText) {
		this.htmlText = htmlText;
		this.htmlTextWrap.alreadyInitialized = true;
	}
	protected HtmlPart htmlTextInit() {
		if(!htmlTextWrap.alreadyInitialized) {
			_htmlText(htmlTextWrap);
			if(htmlText == null)
				setHtmlText(htmlTextWrap.o);
		}
		htmlTextWrap.alreadyInitialized(true);
		return (HtmlPart)this;
	}

	public String solrHtmlText() {
		return htmlText;
	}

	public String strHtmlText() {
		return htmlText == null ? "" : htmlText;
	}

	public String jsonHtmlText() {
		return htmlText == null ? "" : htmlText;
	}

	public String nomAffichageHtmlText() {
		return "text";
	}

	public String htmTooltipHtmlText() {
		return null;
	}

	public String htmHtmlText() {
		return htmlText == null ? "" : StringEscapeUtils.escapeHtml4(strHtmlText());
	}

	public void inputHtmlText(String classApiMethodMethod) {
		HtmlPart s = (HtmlPart)this;
		e("textarea")
			.a("placeholder", "text")
			.a("id", classApiMethodMethod, "_htmlText");
			if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
				a("class", "setHtmlText inputHtmlPart", pk, "HtmlText w3-input w3-border ");
				a("name", "setHtmlText");
			} else {
				a("class", "valueHtmlText w3-input w3-border inputHtmlPart", pk, "HtmlText w3-input w3-border ");
				a("name", "htmlText");
			}
			if("Page".equals(classApiMethodMethod)) {
				a("onclick", "removeGlow($(this)); ");
				a("onchange", "patchHtmlPartVal([{ name: 'fq', value: 'pk:", pk, "' }], 'setHtmlText', $(this).val(), function() { addGlow($('#", classApiMethodMethod, "_htmlText')); }, function() { addError($('#", classApiMethodMethod, "_htmlText')); }); ");
			}
		f().sx(strHtmlText()).g("textarea");

	}

	public void htmHtmlText(String classApiMethodMethod) {
		HtmlPart s = (HtmlPart)this;
		{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggestHtmlPartHtmlText").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-yellow ").f();
							e("label").a("for", classApiMethodMethod, "_htmlText").a("class", "").f().sx("text").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputHtmlText(classApiMethodMethod);
							} g("div");
							if("Page".equals(classApiMethodMethod)) {
								{ e("div").a("class", "w3-cell w3-left-align w3-cell-top ").f();
									{ e("button")
										.a("tabindex", "-1")
										.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-bar-item w3-yellow ")
									.a("onclick", "removeGlow($('#", classApiMethodMethod, "_htmlText')); $('#", classApiMethodMethod, "_htmlText').val(null); patchHtmlPartVal([{ name: 'fq', value: 'pk:' + $('#HtmlPartForm :input[name=pk]').val() }], 'setHtmlText', null, function() { addGlow($('#", classApiMethodMethod, "_htmlText')); }, function() { addError($('#", classApiMethodMethod, "_htmlText')); }); ")
										.f();
										e("i").a("class", "far fa-eraser ").f().g("i");
									} g("button");
								} g("div");
							}
						} g("div");
					} g("div");
				} g("div");
			} g("div");
		} g("div");
	}

	/////////////
	// htmlVar //
	/////////////

	/**	L'entité « htmlVar »
	 *	 is defined as null before being initialized. 
	 */
	protected String htmlVar;
	@JsonIgnore
	public Wrap<String> htmlVarWrap = new Wrap<String>().p(this).c(String.class).var("htmlVar").o(htmlVar);

	/**	<br/>L'entité « htmlVar »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enUS.html.part.HtmlPart&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:htmlVar">Trouver l'entité htmlVar dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _htmlVar(Wrap<String> c);

	public String getHtmlVar() {
		return htmlVar;
	}

	public void setHtmlVar(String htmlVar) {
		this.htmlVar = htmlVar;
		this.htmlVarWrap.alreadyInitialized = true;
	}
	protected HtmlPart htmlVarInit() {
		if(!htmlVarWrap.alreadyInitialized) {
			_htmlVar(htmlVarWrap);
			if(htmlVar == null)
				setHtmlVar(htmlVarWrap.o);
		}
		htmlVarWrap.alreadyInitialized(true);
		return (HtmlPart)this;
	}

	public String solrHtmlVar() {
		return htmlVar;
	}

	public String strHtmlVar() {
		return htmlVar == null ? "" : htmlVar;
	}

	public String jsonHtmlVar() {
		return htmlVar == null ? "" : htmlVar;
	}

	public String nomAffichageHtmlVar() {
		return "var";
	}

	public String htmTooltipHtmlVar() {
		return null;
	}

	public String htmHtmlVar() {
		return htmlVar == null ? "" : StringEscapeUtils.escapeHtml4(strHtmlVar());
	}

	public void inputHtmlVar(String classApiMethodMethod) {
		HtmlPart s = (HtmlPart)this;
		e("input")
			.a("type", "text")
			.a("placeholder", "var")
			.a("id", classApiMethodMethod, "_htmlVar");
			if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
				a("class", "setHtmlVar inputHtmlPart", pk, "HtmlVar w3-input w3-border ");
				a("name", "setHtmlVar");
			} else {
				a("class", "valueHtmlVar w3-input w3-border inputHtmlPart", pk, "HtmlVar w3-input w3-border ");
				a("name", "htmlVar");
			}
			if("Page".equals(classApiMethodMethod)) {
				a("onclick", "removeGlow($(this)); ");
				a("onchange", "patchHtmlPartVal([{ name: 'fq', value: 'pk:", pk, "' }], 'setHtmlVar', $(this).val(), function() { addGlow($('#", classApiMethodMethod, "_htmlVar')); }, function() { addError($('#", classApiMethodMethod, "_htmlVar')); }); ");
			}
			a("value", strHtmlVar())
		.fg();

	}

	public void htmHtmlVar(String classApiMethodMethod) {
		HtmlPart s = (HtmlPart)this;
		{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggestHtmlPartHtmlVar").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-yellow ").f();
							e("label").a("for", classApiMethodMethod, "_htmlVar").a("class", "").f().sx("var").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputHtmlVar(classApiMethodMethod);
							} g("div");
							if("Page".equals(classApiMethodMethod)) {
								{ e("div").a("class", "w3-cell w3-left-align w3-cell-top ").f();
									{ e("button")
										.a("tabindex", "-1")
										.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-bar-item w3-yellow ")
									.a("onclick", "removeGlow($('#", classApiMethodMethod, "_htmlVar')); $('#", classApiMethodMethod, "_htmlVar').val(null); patchHtmlPartVal([{ name: 'fq', value: 'pk:' + $('#HtmlPartForm :input[name=pk]').val() }], 'setHtmlVar', null, function() { addGlow($('#", classApiMethodMethod, "_htmlVar')); }, function() { addError($('#", classApiMethodMethod, "_htmlVar')); }); ")
										.f();
										e("i").a("class", "far fa-eraser ").f().g("i");
									} g("button");
								} g("div");
							}
						} g("div");
					} g("div");
				} g("div");
			} g("div");
		} g("div");
	}

	/////////////////
	// htmlVarSpan //
	/////////////////

	/**	L'entité « htmlVarSpan »
	 *	 is defined as null before being initialized. 
	 */
	protected String htmlVarSpan;
	@JsonIgnore
	public Wrap<String> htmlVarSpanWrap = new Wrap<String>().p(this).c(String.class).var("htmlVarSpan").o(htmlVarSpan);

	/**	<br/>L'entité « htmlVarSpan »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enUS.html.part.HtmlPart&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:htmlVarSpan">Trouver l'entité htmlVarSpan dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _htmlVarSpan(Wrap<String> c);

	public String getHtmlVarSpan() {
		return htmlVarSpan;
	}

	public void setHtmlVarSpan(String htmlVarSpan) {
		this.htmlVarSpan = htmlVarSpan;
		this.htmlVarSpanWrap.alreadyInitialized = true;
	}
	protected HtmlPart htmlVarSpanInit() {
		if(!htmlVarSpanWrap.alreadyInitialized) {
			_htmlVarSpan(htmlVarSpanWrap);
			if(htmlVarSpan == null)
				setHtmlVarSpan(htmlVarSpanWrap.o);
		}
		htmlVarSpanWrap.alreadyInitialized(true);
		return (HtmlPart)this;
	}

	public String solrHtmlVarSpan() {
		return htmlVarSpan;
	}

	public String strHtmlVarSpan() {
		return htmlVarSpan == null ? "" : htmlVarSpan;
	}

	public String jsonHtmlVarSpan() {
		return htmlVarSpan == null ? "" : htmlVarSpan;
	}

	public String nomAffichageHtmlVarSpan() {
		return "var span";
	}

	public String htmTooltipHtmlVarSpan() {
		return null;
	}

	public String htmHtmlVarSpan() {
		return htmlVarSpan == null ? "" : StringEscapeUtils.escapeHtml4(strHtmlVarSpan());
	}

	public void inputHtmlVarSpan(String classApiMethodMethod) {
		HtmlPart s = (HtmlPart)this;
		e("input")
			.a("type", "text")
			.a("placeholder", "var span")
			.a("id", classApiMethodMethod, "_htmlVarSpan");
			if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
				a("class", "setHtmlVarSpan inputHtmlPart", pk, "HtmlVarSpan w3-input w3-border ");
				a("name", "setHtmlVarSpan");
			} else {
				a("class", "valueHtmlVarSpan w3-input w3-border inputHtmlPart", pk, "HtmlVarSpan w3-input w3-border ");
				a("name", "htmlVarSpan");
			}
			if("Page".equals(classApiMethodMethod)) {
				a("onclick", "removeGlow($(this)); ");
				a("onchange", "patchHtmlPartVal([{ name: 'fq', value: 'pk:", pk, "' }], 'setHtmlVarSpan', $(this).val(), function() { addGlow($('#", classApiMethodMethod, "_htmlVarSpan')); }, function() { addError($('#", classApiMethodMethod, "_htmlVarSpan')); }); ");
			}
			a("value", strHtmlVarSpan())
		.fg();

	}

	public void htmHtmlVarSpan(String classApiMethodMethod) {
		HtmlPart s = (HtmlPart)this;
		{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggestHtmlPartHtmlVarSpan").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-yellow ").f();
							e("label").a("for", classApiMethodMethod, "_htmlVarSpan").a("class", "").f().sx("var span").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputHtmlVarSpan(classApiMethodMethod);
							} g("div");
							if("Page".equals(classApiMethodMethod)) {
								{ e("div").a("class", "w3-cell w3-left-align w3-cell-top ").f();
									{ e("button")
										.a("tabindex", "-1")
										.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-bar-item w3-yellow ")
									.a("onclick", "removeGlow($('#", classApiMethodMethod, "_htmlVarSpan')); $('#", classApiMethodMethod, "_htmlVarSpan').val(null); patchHtmlPartVal([{ name: 'fq', value: 'pk:' + $('#HtmlPartForm :input[name=pk]').val() }], 'setHtmlVarSpan', null, function() { addGlow($('#", classApiMethodMethod, "_htmlVarSpan')); }, function() { addError($('#", classApiMethodMethod, "_htmlVarSpan')); }); ")
										.f();
										e("i").a("class", "far fa-eraser ").f().g("i");
									} g("button");
								} g("div");
							}
						} g("div");
					} g("div");
				} g("div");
			} g("div");
		} g("div");
	}

	/////////////////
	// htmlVarForm //
	/////////////////

	/**	L'entité « htmlVarForm »
	 *	 is defined as null before being initialized. 
	 */
	protected String htmlVarForm;
	@JsonIgnore
	public Wrap<String> htmlVarFormWrap = new Wrap<String>().p(this).c(String.class).var("htmlVarForm").o(htmlVarForm);

	/**	<br/>L'entité « htmlVarForm »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enUS.html.part.HtmlPart&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:htmlVarForm">Trouver l'entité htmlVarForm dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _htmlVarForm(Wrap<String> c);

	public String getHtmlVarForm() {
		return htmlVarForm;
	}

	public void setHtmlVarForm(String htmlVarForm) {
		this.htmlVarForm = htmlVarForm;
		this.htmlVarFormWrap.alreadyInitialized = true;
	}
	protected HtmlPart htmlVarFormInit() {
		if(!htmlVarFormWrap.alreadyInitialized) {
			_htmlVarForm(htmlVarFormWrap);
			if(htmlVarForm == null)
				setHtmlVarForm(htmlVarFormWrap.o);
		}
		htmlVarFormWrap.alreadyInitialized(true);
		return (HtmlPart)this;
	}

	public String solrHtmlVarForm() {
		return htmlVarForm;
	}

	public String strHtmlVarForm() {
		return htmlVarForm == null ? "" : htmlVarForm;
	}

	public String jsonHtmlVarForm() {
		return htmlVarForm == null ? "" : htmlVarForm;
	}

	public String nomAffichageHtmlVarForm() {
		return "var form";
	}

	public String htmTooltipHtmlVarForm() {
		return null;
	}

	public String htmHtmlVarForm() {
		return htmlVarForm == null ? "" : StringEscapeUtils.escapeHtml4(strHtmlVarForm());
	}

	public void inputHtmlVarForm(String classApiMethodMethod) {
		HtmlPart s = (HtmlPart)this;
		e("input")
			.a("type", "text")
			.a("placeholder", "var form")
			.a("id", classApiMethodMethod, "_htmlVarForm");
			if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
				a("class", "setHtmlVarForm inputHtmlPart", pk, "HtmlVarForm w3-input w3-border ");
				a("name", "setHtmlVarForm");
			} else {
				a("class", "valueHtmlVarForm w3-input w3-border inputHtmlPart", pk, "HtmlVarForm w3-input w3-border ");
				a("name", "htmlVarForm");
			}
			if("Page".equals(classApiMethodMethod)) {
				a("onclick", "removeGlow($(this)); ");
				a("onchange", "patchHtmlPartVal([{ name: 'fq', value: 'pk:", pk, "' }], 'setHtmlVarForm', $(this).val(), function() { addGlow($('#", classApiMethodMethod, "_htmlVarForm')); }, function() { addError($('#", classApiMethodMethod, "_htmlVarForm')); }); ");
			}
			a("value", strHtmlVarForm())
		.fg();

	}

	public void htmHtmlVarForm(String classApiMethodMethod) {
		HtmlPart s = (HtmlPart)this;
		{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggestHtmlPartHtmlVarForm").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-yellow ").f();
							e("label").a("for", classApiMethodMethod, "_htmlVarForm").a("class", "").f().sx("var form").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputHtmlVarForm(classApiMethodMethod);
							} g("div");
							if("Page".equals(classApiMethodMethod)) {
								{ e("div").a("class", "w3-cell w3-left-align w3-cell-top ").f();
									{ e("button")
										.a("tabindex", "-1")
										.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-bar-item w3-yellow ")
									.a("onclick", "removeGlow($('#", classApiMethodMethod, "_htmlVarForm')); $('#", classApiMethodMethod, "_htmlVarForm').val(null); patchHtmlPartVal([{ name: 'fq', value: 'pk:' + $('#HtmlPartForm :input[name=pk]').val() }], 'setHtmlVarForm', null, function() { addGlow($('#", classApiMethodMethod, "_htmlVarForm')); }, function() { addError($('#", classApiMethodMethod, "_htmlVarForm')); }); ")
										.f();
										e("i").a("class", "far fa-eraser ").f().g("i");
									} g("button");
								} g("div");
							}
						} g("div");
					} g("div");
				} g("div");
			} g("div");
		} g("div");
	}

	//////////////////
	// htmlVarInput //
	//////////////////

	/**	L'entité « htmlVarInput »
	 *	 is defined as null before being initialized. 
	 */
	protected String htmlVarInput;
	@JsonIgnore
	public Wrap<String> htmlVarInputWrap = new Wrap<String>().p(this).c(String.class).var("htmlVarInput").o(htmlVarInput);

	/**	<br/>L'entité « htmlVarInput »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enUS.html.part.HtmlPart&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:htmlVarInput">Trouver l'entité htmlVarInput dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _htmlVarInput(Wrap<String> c);

	public String getHtmlVarInput() {
		return htmlVarInput;
	}

	public void setHtmlVarInput(String htmlVarInput) {
		this.htmlVarInput = htmlVarInput;
		this.htmlVarInputWrap.alreadyInitialized = true;
	}
	protected HtmlPart htmlVarInputInit() {
		if(!htmlVarInputWrap.alreadyInitialized) {
			_htmlVarInput(htmlVarInputWrap);
			if(htmlVarInput == null)
				setHtmlVarInput(htmlVarInputWrap.o);
		}
		htmlVarInputWrap.alreadyInitialized(true);
		return (HtmlPart)this;
	}

	public String solrHtmlVarInput() {
		return htmlVarInput;
	}

	public String strHtmlVarInput() {
		return htmlVarInput == null ? "" : htmlVarInput;
	}

	public String jsonHtmlVarInput() {
		return htmlVarInput == null ? "" : htmlVarInput;
	}

	public String nomAffichageHtmlVarInput() {
		return "var input";
	}

	public String htmTooltipHtmlVarInput() {
		return null;
	}

	public String htmHtmlVarInput() {
		return htmlVarInput == null ? "" : StringEscapeUtils.escapeHtml4(strHtmlVarInput());
	}

	public void inputHtmlVarInput(String classApiMethodMethod) {
		HtmlPart s = (HtmlPart)this;
		e("input")
			.a("type", "text")
			.a("placeholder", "var input")
			.a("id", classApiMethodMethod, "_htmlVarInput");
			if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
				a("class", "setHtmlVarInput inputHtmlPart", pk, "HtmlVarInput w3-input w3-border ");
				a("name", "setHtmlVarInput");
			} else {
				a("class", "valueHtmlVarInput w3-input w3-border inputHtmlPart", pk, "HtmlVarInput w3-input w3-border ");
				a("name", "htmlVarInput");
			}
			if("Page".equals(classApiMethodMethod)) {
				a("onclick", "removeGlow($(this)); ");
				a("onchange", "patchHtmlPartVal([{ name: 'fq', value: 'pk:", pk, "' }], 'setHtmlVarInput', $(this).val(), function() { addGlow($('#", classApiMethodMethod, "_htmlVarInput')); }, function() { addError($('#", classApiMethodMethod, "_htmlVarInput')); }); ");
			}
			a("value", strHtmlVarInput())
		.fg();

	}

	public void htmHtmlVarInput(String classApiMethodMethod) {
		HtmlPart s = (HtmlPart)this;
		{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggestHtmlPartHtmlVarInput").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-yellow ").f();
							e("label").a("for", classApiMethodMethod, "_htmlVarInput").a("class", "").f().sx("var input").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputHtmlVarInput(classApiMethodMethod);
							} g("div");
							if("Page".equals(classApiMethodMethod)) {
								{ e("div").a("class", "w3-cell w3-left-align w3-cell-top ").f();
									{ e("button")
										.a("tabindex", "-1")
										.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-bar-item w3-yellow ")
									.a("onclick", "removeGlow($('#", classApiMethodMethod, "_htmlVarInput')); $('#", classApiMethodMethod, "_htmlVarInput').val(null); patchHtmlPartVal([{ name: 'fq', value: 'pk:' + $('#HtmlPartForm :input[name=pk]').val() }], 'setHtmlVarInput', null, function() { addGlow($('#", classApiMethodMethod, "_htmlVarInput')); }, function() { addError($('#", classApiMethodMethod, "_htmlVarInput')); }); ")
										.f();
										e("i").a("class", "far fa-eraser ").f().g("i");
									} g("button");
								} g("div");
							}
						} g("div");
					} g("div");
				} g("div");
			} g("div");
		} g("div");
	}

	////////////////////
	// htmlVarForEach //
	////////////////////

	/**	L'entité « htmlVarForEach »
	 *	 is defined as null before being initialized. 
	 */
	protected String htmlVarForEach;
	@JsonIgnore
	public Wrap<String> htmlVarForEachWrap = new Wrap<String>().p(this).c(String.class).var("htmlVarForEach").o(htmlVarForEach);

	/**	<br/>L'entité « htmlVarForEach »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enUS.html.part.HtmlPart&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:htmlVarForEach">Trouver l'entité htmlVarForEach dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _htmlVarForEach(Wrap<String> c);

	public String getHtmlVarForEach() {
		return htmlVarForEach;
	}

	public void setHtmlVarForEach(String htmlVarForEach) {
		this.htmlVarForEach = htmlVarForEach;
		this.htmlVarForEachWrap.alreadyInitialized = true;
	}
	protected HtmlPart htmlVarForEachInit() {
		if(!htmlVarForEachWrap.alreadyInitialized) {
			_htmlVarForEach(htmlVarForEachWrap);
			if(htmlVarForEach == null)
				setHtmlVarForEach(htmlVarForEachWrap.o);
		}
		htmlVarForEachWrap.alreadyInitialized(true);
		return (HtmlPart)this;
	}

	public String solrHtmlVarForEach() {
		return htmlVarForEach;
	}

	public String strHtmlVarForEach() {
		return htmlVarForEach == null ? "" : htmlVarForEach;
	}

	public String jsonHtmlVarForEach() {
		return htmlVarForEach == null ? "" : htmlVarForEach;
	}

	public String nomAffichageHtmlVarForEach() {
		return "var for each";
	}

	public String htmTooltipHtmlVarForEach() {
		return null;
	}

	public String htmHtmlVarForEach() {
		return htmlVarForEach == null ? "" : StringEscapeUtils.escapeHtml4(strHtmlVarForEach());
	}

	public void inputHtmlVarForEach(String classApiMethodMethod) {
		HtmlPart s = (HtmlPart)this;
		e("input")
			.a("type", "text")
			.a("placeholder", "var for each")
			.a("id", classApiMethodMethod, "_htmlVarForEach");
			if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
				a("class", "setHtmlVarForEach inputHtmlPart", pk, "HtmlVarForEach w3-input w3-border ");
				a("name", "setHtmlVarForEach");
			} else {
				a("class", "valueHtmlVarForEach w3-input w3-border inputHtmlPart", pk, "HtmlVarForEach w3-input w3-border ");
				a("name", "htmlVarForEach");
			}
			if("Page".equals(classApiMethodMethod)) {
				a("onclick", "removeGlow($(this)); ");
				a("onchange", "patchHtmlPartVal([{ name: 'fq', value: 'pk:", pk, "' }], 'setHtmlVarForEach', $(this).val(), function() { addGlow($('#", classApiMethodMethod, "_htmlVarForEach')); }, function() { addError($('#", classApiMethodMethod, "_htmlVarForEach')); }); ");
			}
			a("value", strHtmlVarForEach())
		.fg();

	}

	public void htmHtmlVarForEach(String classApiMethodMethod) {
		HtmlPart s = (HtmlPart)this;
		{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggestHtmlPartHtmlVarForEach").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-yellow ").f();
							e("label").a("for", classApiMethodMethod, "_htmlVarForEach").a("class", "").f().sx("var for each").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputHtmlVarForEach(classApiMethodMethod);
							} g("div");
							if("Page".equals(classApiMethodMethod)) {
								{ e("div").a("class", "w3-cell w3-left-align w3-cell-top ").f();
									{ e("button")
										.a("tabindex", "-1")
										.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-bar-item w3-yellow ")
									.a("onclick", "removeGlow($('#", classApiMethodMethod, "_htmlVarForEach')); $('#", classApiMethodMethod, "_htmlVarForEach').val(null); patchHtmlPartVal([{ name: 'fq', value: 'pk:' + $('#HtmlPartForm :input[name=pk]').val() }], 'setHtmlVarForEach', null, function() { addGlow($('#", classApiMethodMethod, "_htmlVarForEach')); }, function() { addError($('#", classApiMethodMethod, "_htmlVarForEach')); }); ")
										.f();
										e("i").a("class", "far fa-eraser ").f().g("i");
									} g("button");
								} g("div");
							}
						} g("div");
					} g("div");
				} g("div");
			} g("div");
		} g("div");
	}

	/////////////////
	// htmlExclude //
	/////////////////

	/**	L'entité « htmlExclude »
	 *	 is defined as null before being initialized. 
	 */
	protected Boolean htmlExclude;
	@JsonIgnore
	public Wrap<Boolean> htmlExcludeWrap = new Wrap<Boolean>().p(this).c(Boolean.class).var("htmlExclude").o(htmlExclude);

	/**	<br/>L'entité « htmlExclude »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enUS.html.part.HtmlPart&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:htmlExclude">Trouver l'entité htmlExclude dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _htmlExclude(Wrap<Boolean> c);

	public Boolean getHtmlExclude() {
		return htmlExclude;
	}

	public void setHtmlExclude(Boolean htmlExclude) {
		this.htmlExclude = htmlExclude;
		this.htmlExcludeWrap.alreadyInitialized = true;
	}
	public HtmlPart setHtmlExclude(String o) {
		this.htmlExclude = Boolean.parseBoolean(o);
		this.htmlExcludeWrap.alreadyInitialized = true;
		return (HtmlPart)this;
	}
	protected HtmlPart htmlExcludeInit() {
		if(!htmlExcludeWrap.alreadyInitialized) {
			_htmlExclude(htmlExcludeWrap);
			if(htmlExclude == null)
				setHtmlExclude(htmlExcludeWrap.o);
		}
		htmlExcludeWrap.alreadyInitialized(true);
		return (HtmlPart)this;
	}

	public Boolean solrHtmlExclude() {
		return htmlExclude;
	}

	public String strHtmlExclude() {
		return htmlExclude == null ? "" : htmlExclude.toString();
	}

	public String jsonHtmlExclude() {
		return htmlExclude == null ? "" : htmlExclude.toString();
	}

	public String nomAffichageHtmlExclude() {
		return "HTML exclude";
	}

	public String htmTooltipHtmlExclude() {
		return null;
	}

	public String htmHtmlExclude() {
		return htmlExclude == null ? "" : StringEscapeUtils.escapeHtml4(strHtmlExclude());
	}

	public void inputHtmlExclude(String classApiMethodMethod) {
		HtmlPart s = (HtmlPart)this;
		e("input")
			.a("type", "checkbox")
			.a("id", classApiMethodMethod, "_htmlExclude")
			.a("value", "true");
			if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
				a("class", "setHtmlExclude inputHtmlPart", pk, "HtmlExclude w3-input w3-border ");
				a("name", "setHtmlExclude");
			} else {
				a("class", "valueHtmlExclude inputHtmlPart", pk, "HtmlExclude w3-input w3-border ");
				a("name", "htmlExclude");
			}
			if("Page".equals(classApiMethodMethod)) {
				a("onchange", "patchHtmlPartVal([{ name: 'fq', value: 'pk:", pk, "' }], 'setHtmlExclude', $(this).prop('checked'), function() { addGlow($('#", classApiMethodMethod, "_htmlExclude')); }, function() { addError($('#", classApiMethodMethod, "_htmlExclude')); }); ");
			}
			;
			if(getHtmlExclude() != null && getHtmlExclude())
				a("checked", "checked");
		fg();

	}

	public void htmHtmlExclude(String classApiMethodMethod) {
		HtmlPart s = (HtmlPart)this;
		{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggestHtmlPartHtmlExclude").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-yellow ").f();
							e("label").a("for", classApiMethodMethod, "_htmlExclude").a("class", "").f().sx("HTML exclude").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputHtmlExclude(classApiMethodMethod);
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			} g("div");
		} g("div");
	}

	////////////////
	// pdfExclude //
	////////////////

	/**	L'entité « pdfExclude »
	 *	 is defined as null before being initialized. 
	 */
	protected Boolean pdfExclude;
	@JsonIgnore
	public Wrap<Boolean> pdfExcludeWrap = new Wrap<Boolean>().p(this).c(Boolean.class).var("pdfExclude").o(pdfExclude);

	/**	<br/>L'entité « pdfExclude »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enUS.html.part.HtmlPart&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pdfExclude">Trouver l'entité pdfExclude dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _pdfExclude(Wrap<Boolean> c);

	public Boolean getPdfExclude() {
		return pdfExclude;
	}

	public void setPdfExclude(Boolean pdfExclude) {
		this.pdfExclude = pdfExclude;
		this.pdfExcludeWrap.alreadyInitialized = true;
	}
	public HtmlPart setPdfExclude(String o) {
		this.pdfExclude = Boolean.parseBoolean(o);
		this.pdfExcludeWrap.alreadyInitialized = true;
		return (HtmlPart)this;
	}
	protected HtmlPart pdfExcludeInit() {
		if(!pdfExcludeWrap.alreadyInitialized) {
			_pdfExclude(pdfExcludeWrap);
			if(pdfExclude == null)
				setPdfExclude(pdfExcludeWrap.o);
		}
		pdfExcludeWrap.alreadyInitialized(true);
		return (HtmlPart)this;
	}

	public Boolean solrPdfExclude() {
		return pdfExclude;
	}

	public String strPdfExclude() {
		return pdfExclude == null ? "" : pdfExclude.toString();
	}

	public String jsonPdfExclude() {
		return pdfExclude == null ? "" : pdfExclude.toString();
	}

	public String nomAffichagePdfExclude() {
		return "PDF exclude";
	}

	public String htmTooltipPdfExclude() {
		return null;
	}

	public String htmPdfExclude() {
		return pdfExclude == null ? "" : StringEscapeUtils.escapeHtml4(strPdfExclude());
	}

	public void inputPdfExclude(String classApiMethodMethod) {
		HtmlPart s = (HtmlPart)this;
		e("input")
			.a("type", "checkbox")
			.a("id", classApiMethodMethod, "_pdfExclude")
			.a("value", "true");
			if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
				a("class", "setPdfExclude inputHtmlPart", pk, "PdfExclude w3-input w3-border ");
				a("name", "setPdfExclude");
			} else {
				a("class", "valuePdfExclude inputHtmlPart", pk, "PdfExclude w3-input w3-border ");
				a("name", "pdfExclude");
			}
			if("Page".equals(classApiMethodMethod)) {
				a("onchange", "patchHtmlPartVal([{ name: 'fq', value: 'pk:", pk, "' }], 'setPdfExclude', $(this).prop('checked'), function() { addGlow($('#", classApiMethodMethod, "_pdfExclude')); }, function() { addError($('#", classApiMethodMethod, "_pdfExclude')); }); ");
			}
			;
			if(getPdfExclude() != null && getPdfExclude())
				a("checked", "checked");
		fg();

	}

	public void htmPdfExclude(String classApiMethodMethod) {
		HtmlPart s = (HtmlPart)this;
		{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggestHtmlPartPdfExclude").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-yellow ").f();
							e("label").a("for", classApiMethodMethod, "_pdfExclude").a("class", "").f().sx("PDF exclude").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputPdfExclude(classApiMethodMethod);
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			} g("div");
		} g("div");
	}

	///////////
	// sort1 //
	///////////

	/**	L'entité « sort1 »
	 *	 is defined as null before being initialized. 
	 */
	protected Double sort1;
	@JsonIgnore
	public Wrap<Double> sort1Wrap = new Wrap<Double>().p(this).c(Double.class).var("sort1").o(sort1);

	/**	<br/>L'entité « sort1 »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enUS.html.part.HtmlPart&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:sort1">Trouver l'entité sort1 dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _sort1(Wrap<Double> c);

	public Double getSort1() {
		return sort1;
	}

	public void setSort1(Double sort1) {
		this.sort1 = sort1;
		this.sort1Wrap.alreadyInitialized = true;
	}
	public HtmlPart setSort1(String o) {
		if(NumberUtils.isParsable(o))
			this.sort1 = Double.parseDouble(o);
		this.sort1Wrap.alreadyInitialized = true;
		return (HtmlPart)this;
	}
	protected HtmlPart sort1Init() {
		if(!sort1Wrap.alreadyInitialized) {
			_sort1(sort1Wrap);
			if(sort1 == null)
				setSort1(sort1Wrap.o);
		}
		sort1Wrap.alreadyInitialized(true);
		return (HtmlPart)this;
	}

	public Double solrSort1() {
		return sort1;
	}

	public String strSort1() {
		return sort1 == null ? "" : sort1.toString();
	}

	public String jsonSort1() {
		return sort1 == null ? "" : sort1.toString();
	}

	public String nomAffichageSort1() {
		return "sort1";
	}

	public String htmTooltipSort1() {
		return null;
	}

	public String htmSort1() {
		return sort1 == null ? "" : StringEscapeUtils.escapeHtml4(strSort1());
	}

	public void inputSort1(String classApiMethodMethod) {
		HtmlPart s = (HtmlPart)this;
		e("input")
			.a("type", "text")
			.a("placeholder", "sort1")
			.a("id", classApiMethodMethod, "_sort1");
			if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
				a("class", "setSort1 inputHtmlPart", pk, "Sort1 w3-input w3-border ");
				a("name", "setSort1");
			} else {
				a("class", "valueSort1 w3-input w3-border inputHtmlPart", pk, "Sort1 w3-input w3-border ");
				a("name", "sort1");
			}
			if("Page".equals(classApiMethodMethod)) {
				a("onclick", "removeGlow($(this)); ");
				a("onchange", "patchHtmlPartVal([{ name: 'fq', value: 'pk:", pk, "' }], 'setSort1', $(this).val(), function() { addGlow($('#", classApiMethodMethod, "_sort1')); }, function() { addError($('#", classApiMethodMethod, "_sort1')); }); ");
			}
			a("value", strSort1())
		.fg();

	}

	public void htmSort1(String classApiMethodMethod) {
		HtmlPart s = (HtmlPart)this;
		{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggestHtmlPartSort1").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-yellow ").f();
							e("label").a("for", classApiMethodMethod, "_sort1").a("class", "").f().sx("sort1").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputSort1(classApiMethodMethod);
							} g("div");
							if("Page".equals(classApiMethodMethod)) {
								{ e("div").a("class", "w3-cell w3-left-align w3-cell-top ").f();
									{ e("button")
										.a("tabindex", "-1")
										.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-bar-item w3-yellow ")
									.a("onclick", "removeGlow($('#", classApiMethodMethod, "_sort1')); $('#", classApiMethodMethod, "_sort1').val(null); patchHtmlPartVal([{ name: 'fq', value: 'pk:' + $('#HtmlPartForm :input[name=pk]').val() }], 'setSort1', null, function() { addGlow($('#", classApiMethodMethod, "_sort1')); }, function() { addError($('#", classApiMethodMethod, "_sort1')); }); ")
										.f();
										e("i").a("class", "far fa-eraser ").f().g("i");
									} g("button");
								} g("div");
							}
						} g("div");
					} g("div");
				} g("div");
			} g("div");
		} g("div");
	}

	///////////
	// sort2 //
	///////////

	/**	L'entité « sort2 »
	 *	 is defined as null before being initialized. 
	 */
	protected Double sort2;
	@JsonIgnore
	public Wrap<Double> sort2Wrap = new Wrap<Double>().p(this).c(Double.class).var("sort2").o(sort2);

	/**	<br/>L'entité « sort2 »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enUS.html.part.HtmlPart&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:sort2">Trouver l'entité sort2 dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _sort2(Wrap<Double> c);

	public Double getSort2() {
		return sort2;
	}

	public void setSort2(Double sort2) {
		this.sort2 = sort2;
		this.sort2Wrap.alreadyInitialized = true;
	}
	public HtmlPart setSort2(String o) {
		if(NumberUtils.isParsable(o))
			this.sort2 = Double.parseDouble(o);
		this.sort2Wrap.alreadyInitialized = true;
		return (HtmlPart)this;
	}
	protected HtmlPart sort2Init() {
		if(!sort2Wrap.alreadyInitialized) {
			_sort2(sort2Wrap);
			if(sort2 == null)
				setSort2(sort2Wrap.o);
		}
		sort2Wrap.alreadyInitialized(true);
		return (HtmlPart)this;
	}

	public Double solrSort2() {
		return sort2;
	}

	public String strSort2() {
		return sort2 == null ? "" : sort2.toString();
	}

	public String jsonSort2() {
		return sort2 == null ? "" : sort2.toString();
	}

	public String nomAffichageSort2() {
		return "sort2";
	}

	public String htmTooltipSort2() {
		return null;
	}

	public String htmSort2() {
		return sort2 == null ? "" : StringEscapeUtils.escapeHtml4(strSort2());
	}

	public void inputSort2(String classApiMethodMethod) {
		HtmlPart s = (HtmlPart)this;
		e("input")
			.a("type", "text")
			.a("placeholder", "sort2")
			.a("id", classApiMethodMethod, "_sort2");
			if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
				a("class", "setSort2 inputHtmlPart", pk, "Sort2 w3-input w3-border ");
				a("name", "setSort2");
			} else {
				a("class", "valueSort2 w3-input w3-border inputHtmlPart", pk, "Sort2 w3-input w3-border ");
				a("name", "sort2");
			}
			if("Page".equals(classApiMethodMethod)) {
				a("onclick", "removeGlow($(this)); ");
				a("onchange", "patchHtmlPartVal([{ name: 'fq', value: 'pk:", pk, "' }], 'setSort2', $(this).val(), function() { addGlow($('#", classApiMethodMethod, "_sort2')); }, function() { addError($('#", classApiMethodMethod, "_sort2')); }); ");
			}
			a("value", strSort2())
		.fg();

	}

	public void htmSort2(String classApiMethodMethod) {
		HtmlPart s = (HtmlPart)this;
		{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggestHtmlPartSort2").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-yellow ").f();
							e("label").a("for", classApiMethodMethod, "_sort2").a("class", "").f().sx("sort2").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputSort2(classApiMethodMethod);
							} g("div");
							if("Page".equals(classApiMethodMethod)) {
								{ e("div").a("class", "w3-cell w3-left-align w3-cell-top ").f();
									{ e("button")
										.a("tabindex", "-1")
										.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-bar-item w3-yellow ")
									.a("onclick", "removeGlow($('#", classApiMethodMethod, "_sort2')); $('#", classApiMethodMethod, "_sort2').val(null); patchHtmlPartVal([{ name: 'fq', value: 'pk:' + $('#HtmlPartForm :input[name=pk]').val() }], 'setSort2', null, function() { addGlow($('#", classApiMethodMethod, "_sort2')); }, function() { addError($('#", classApiMethodMethod, "_sort2')); }); ")
										.f();
										e("i").a("class", "far fa-eraser ").f().g("i");
									} g("button");
								} g("div");
							}
						} g("div");
					} g("div");
				} g("div");
			} g("div");
		} g("div");
	}

	///////////
	// sort3 //
	///////////

	/**	L'entité « sort3 »
	 *	 is defined as null before being initialized. 
	 */
	protected Double sort3;
	@JsonIgnore
	public Wrap<Double> sort3Wrap = new Wrap<Double>().p(this).c(Double.class).var("sort3").o(sort3);

	/**	<br/>L'entité « sort3 »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enUS.html.part.HtmlPart&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:sort3">Trouver l'entité sort3 dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _sort3(Wrap<Double> c);

	public Double getSort3() {
		return sort3;
	}

	public void setSort3(Double sort3) {
		this.sort3 = sort3;
		this.sort3Wrap.alreadyInitialized = true;
	}
	public HtmlPart setSort3(String o) {
		if(NumberUtils.isParsable(o))
			this.sort3 = Double.parseDouble(o);
		this.sort3Wrap.alreadyInitialized = true;
		return (HtmlPart)this;
	}
	protected HtmlPart sort3Init() {
		if(!sort3Wrap.alreadyInitialized) {
			_sort3(sort3Wrap);
			if(sort3 == null)
				setSort3(sort3Wrap.o);
		}
		sort3Wrap.alreadyInitialized(true);
		return (HtmlPart)this;
	}

	public Double solrSort3() {
		return sort3;
	}

	public String strSort3() {
		return sort3 == null ? "" : sort3.toString();
	}

	public String jsonSort3() {
		return sort3 == null ? "" : sort3.toString();
	}

	public String nomAffichageSort3() {
		return "sort3";
	}

	public String htmTooltipSort3() {
		return null;
	}

	public String htmSort3() {
		return sort3 == null ? "" : StringEscapeUtils.escapeHtml4(strSort3());
	}

	public void inputSort3(String classApiMethodMethod) {
		HtmlPart s = (HtmlPart)this;
		e("input")
			.a("type", "text")
			.a("placeholder", "sort3")
			.a("id", classApiMethodMethod, "_sort3");
			if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
				a("class", "setSort3 inputHtmlPart", pk, "Sort3 w3-input w3-border ");
				a("name", "setSort3");
			} else {
				a("class", "valueSort3 w3-input w3-border inputHtmlPart", pk, "Sort3 w3-input w3-border ");
				a("name", "sort3");
			}
			if("Page".equals(classApiMethodMethod)) {
				a("onclick", "removeGlow($(this)); ");
				a("onchange", "patchHtmlPartVal([{ name: 'fq', value: 'pk:", pk, "' }], 'setSort3', $(this).val(), function() { addGlow($('#", classApiMethodMethod, "_sort3')); }, function() { addError($('#", classApiMethodMethod, "_sort3')); }); ");
			}
			a("value", strSort3())
		.fg();

	}

	public void htmSort3(String classApiMethodMethod) {
		HtmlPart s = (HtmlPart)this;
		{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggestHtmlPartSort3").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-yellow ").f();
							e("label").a("for", classApiMethodMethod, "_sort3").a("class", "").f().sx("sort3").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputSort3(classApiMethodMethod);
							} g("div");
							if("Page".equals(classApiMethodMethod)) {
								{ e("div").a("class", "w3-cell w3-left-align w3-cell-top ").f();
									{ e("button")
										.a("tabindex", "-1")
										.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-bar-item w3-yellow ")
									.a("onclick", "removeGlow($('#", classApiMethodMethod, "_sort3')); $('#", classApiMethodMethod, "_sort3').val(null); patchHtmlPartVal([{ name: 'fq', value: 'pk:' + $('#HtmlPartForm :input[name=pk]').val() }], 'setSort3', null, function() { addGlow($('#", classApiMethodMethod, "_sort3')); }, function() { addError($('#", classApiMethodMethod, "_sort3')); }); ")
										.f();
										e("i").a("class", "far fa-eraser ").f().g("i");
									} g("button");
								} g("div");
							}
						} g("div");
					} g("div");
				} g("div");
			} g("div");
		} g("div");
	}

	///////////
	// sort4 //
	///////////

	/**	L'entité « sort4 »
	 *	 is defined as null before being initialized. 
	 */
	protected Double sort4;
	@JsonIgnore
	public Wrap<Double> sort4Wrap = new Wrap<Double>().p(this).c(Double.class).var("sort4").o(sort4);

	/**	<br/>L'entité « sort4 »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enUS.html.part.HtmlPart&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:sort4">Trouver l'entité sort4 dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _sort4(Wrap<Double> c);

	public Double getSort4() {
		return sort4;
	}

	public void setSort4(Double sort4) {
		this.sort4 = sort4;
		this.sort4Wrap.alreadyInitialized = true;
	}
	public HtmlPart setSort4(String o) {
		if(NumberUtils.isParsable(o))
			this.sort4 = Double.parseDouble(o);
		this.sort4Wrap.alreadyInitialized = true;
		return (HtmlPart)this;
	}
	protected HtmlPart sort4Init() {
		if(!sort4Wrap.alreadyInitialized) {
			_sort4(sort4Wrap);
			if(sort4 == null)
				setSort4(sort4Wrap.o);
		}
		sort4Wrap.alreadyInitialized(true);
		return (HtmlPart)this;
	}

	public Double solrSort4() {
		return sort4;
	}

	public String strSort4() {
		return sort4 == null ? "" : sort4.toString();
	}

	public String jsonSort4() {
		return sort4 == null ? "" : sort4.toString();
	}

	public String nomAffichageSort4() {
		return "sort4";
	}

	public String htmTooltipSort4() {
		return null;
	}

	public String htmSort4() {
		return sort4 == null ? "" : StringEscapeUtils.escapeHtml4(strSort4());
	}

	public void inputSort4(String classApiMethodMethod) {
		HtmlPart s = (HtmlPart)this;
		e("input")
			.a("type", "text")
			.a("placeholder", "sort4")
			.a("id", classApiMethodMethod, "_sort4");
			if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
				a("class", "setSort4 inputHtmlPart", pk, "Sort4 w3-input w3-border ");
				a("name", "setSort4");
			} else {
				a("class", "valueSort4 w3-input w3-border inputHtmlPart", pk, "Sort4 w3-input w3-border ");
				a("name", "sort4");
			}
			if("Page".equals(classApiMethodMethod)) {
				a("onclick", "removeGlow($(this)); ");
				a("onchange", "patchHtmlPartVal([{ name: 'fq', value: 'pk:", pk, "' }], 'setSort4', $(this).val(), function() { addGlow($('#", classApiMethodMethod, "_sort4')); }, function() { addError($('#", classApiMethodMethod, "_sort4')); }); ");
			}
			a("value", strSort4())
		.fg();

	}

	public void htmSort4(String classApiMethodMethod) {
		HtmlPart s = (HtmlPart)this;
		{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggestHtmlPartSort4").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-yellow ").f();
							e("label").a("for", classApiMethodMethod, "_sort4").a("class", "").f().sx("sort4").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputSort4(classApiMethodMethod);
							} g("div");
							if("Page".equals(classApiMethodMethod)) {
								{ e("div").a("class", "w3-cell w3-left-align w3-cell-top ").f();
									{ e("button")
										.a("tabindex", "-1")
										.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-bar-item w3-yellow ")
									.a("onclick", "removeGlow($('#", classApiMethodMethod, "_sort4')); $('#", classApiMethodMethod, "_sort4').val(null); patchHtmlPartVal([{ name: 'fq', value: 'pk:' + $('#HtmlPartForm :input[name=pk]').val() }], 'setSort4', null, function() { addGlow($('#", classApiMethodMethod, "_sort4')); }, function() { addError($('#", classApiMethodMethod, "_sort4')); }); ")
										.f();
										e("i").a("class", "far fa-eraser ").f().g("i");
									} g("button");
								} g("div");
							}
						} g("div");
					} g("div");
				} g("div");
			} g("div");
		} g("div");
	}

	///////////
	// sort5 //
	///////////

	/**	L'entité « sort5 »
	 *	 is defined as null before being initialized. 
	 */
	protected Double sort5;
	@JsonIgnore
	public Wrap<Double> sort5Wrap = new Wrap<Double>().p(this).c(Double.class).var("sort5").o(sort5);

	/**	<br/>L'entité « sort5 »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enUS.html.part.HtmlPart&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:sort5">Trouver l'entité sort5 dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _sort5(Wrap<Double> c);

	public Double getSort5() {
		return sort5;
	}

	public void setSort5(Double sort5) {
		this.sort5 = sort5;
		this.sort5Wrap.alreadyInitialized = true;
	}
	public HtmlPart setSort5(String o) {
		if(NumberUtils.isParsable(o))
			this.sort5 = Double.parseDouble(o);
		this.sort5Wrap.alreadyInitialized = true;
		return (HtmlPart)this;
	}
	protected HtmlPart sort5Init() {
		if(!sort5Wrap.alreadyInitialized) {
			_sort5(sort5Wrap);
			if(sort5 == null)
				setSort5(sort5Wrap.o);
		}
		sort5Wrap.alreadyInitialized(true);
		return (HtmlPart)this;
	}

	public Double solrSort5() {
		return sort5;
	}

	public String strSort5() {
		return sort5 == null ? "" : sort5.toString();
	}

	public String jsonSort5() {
		return sort5 == null ? "" : sort5.toString();
	}

	public String nomAffichageSort5() {
		return "sort5";
	}

	public String htmTooltipSort5() {
		return null;
	}

	public String htmSort5() {
		return sort5 == null ? "" : StringEscapeUtils.escapeHtml4(strSort5());
	}

	public void inputSort5(String classApiMethodMethod) {
		HtmlPart s = (HtmlPart)this;
		e("input")
			.a("type", "text")
			.a("placeholder", "sort5")
			.a("id", classApiMethodMethod, "_sort5");
			if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
				a("class", "setSort5 inputHtmlPart", pk, "Sort5 w3-input w3-border ");
				a("name", "setSort5");
			} else {
				a("class", "valueSort5 w3-input w3-border inputHtmlPart", pk, "Sort5 w3-input w3-border ");
				a("name", "sort5");
			}
			if("Page".equals(classApiMethodMethod)) {
				a("onclick", "removeGlow($(this)); ");
				a("onchange", "patchHtmlPartVal([{ name: 'fq', value: 'pk:", pk, "' }], 'setSort5', $(this).val(), function() { addGlow($('#", classApiMethodMethod, "_sort5')); }, function() { addError($('#", classApiMethodMethod, "_sort5')); }); ");
			}
			a("value", strSort5())
		.fg();

	}

	public void htmSort5(String classApiMethodMethod) {
		HtmlPart s = (HtmlPart)this;
		{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggestHtmlPartSort5").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-yellow ").f();
							e("label").a("for", classApiMethodMethod, "_sort5").a("class", "").f().sx("sort5").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputSort5(classApiMethodMethod);
							} g("div");
							if("Page".equals(classApiMethodMethod)) {
								{ e("div").a("class", "w3-cell w3-left-align w3-cell-top ").f();
									{ e("button")
										.a("tabindex", "-1")
										.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-bar-item w3-yellow ")
									.a("onclick", "removeGlow($('#", classApiMethodMethod, "_sort5')); $('#", classApiMethodMethod, "_sort5').val(null); patchHtmlPartVal([{ name: 'fq', value: 'pk:' + $('#HtmlPartForm :input[name=pk]').val() }], 'setSort5', null, function() { addGlow($('#", classApiMethodMethod, "_sort5')); }, function() { addError($('#", classApiMethodMethod, "_sort5')); }); ")
										.f();
										e("i").a("class", "far fa-eraser ").f().g("i");
									} g("button");
								} g("div");
							}
						} g("div");
					} g("div");
				} g("div");
			} g("div");
		} g("div");
	}

	///////////
	// sort6 //
	///////////

	/**	L'entité « sort6 »
	 *	 is defined as null before being initialized. 
	 */
	protected Double sort6;
	@JsonIgnore
	public Wrap<Double> sort6Wrap = new Wrap<Double>().p(this).c(Double.class).var("sort6").o(sort6);

	/**	<br/>L'entité « sort6 »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enUS.html.part.HtmlPart&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:sort6">Trouver l'entité sort6 dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _sort6(Wrap<Double> c);

	public Double getSort6() {
		return sort6;
	}

	public void setSort6(Double sort6) {
		this.sort6 = sort6;
		this.sort6Wrap.alreadyInitialized = true;
	}
	public HtmlPart setSort6(String o) {
		if(NumberUtils.isParsable(o))
			this.sort6 = Double.parseDouble(o);
		this.sort6Wrap.alreadyInitialized = true;
		return (HtmlPart)this;
	}
	protected HtmlPart sort6Init() {
		if(!sort6Wrap.alreadyInitialized) {
			_sort6(sort6Wrap);
			if(sort6 == null)
				setSort6(sort6Wrap.o);
		}
		sort6Wrap.alreadyInitialized(true);
		return (HtmlPart)this;
	}

	public Double solrSort6() {
		return sort6;
	}

	public String strSort6() {
		return sort6 == null ? "" : sort6.toString();
	}

	public String jsonSort6() {
		return sort6 == null ? "" : sort6.toString();
	}

	public String nomAffichageSort6() {
		return "sort6";
	}

	public String htmTooltipSort6() {
		return null;
	}

	public String htmSort6() {
		return sort6 == null ? "" : StringEscapeUtils.escapeHtml4(strSort6());
	}

	public void inputSort6(String classApiMethodMethod) {
		HtmlPart s = (HtmlPart)this;
		e("input")
			.a("type", "text")
			.a("placeholder", "sort6")
			.a("id", classApiMethodMethod, "_sort6");
			if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
				a("class", "setSort6 inputHtmlPart", pk, "Sort6 w3-input w3-border ");
				a("name", "setSort6");
			} else {
				a("class", "valueSort6 w3-input w3-border inputHtmlPart", pk, "Sort6 w3-input w3-border ");
				a("name", "sort6");
			}
			if("Page".equals(classApiMethodMethod)) {
				a("onclick", "removeGlow($(this)); ");
				a("onchange", "patchHtmlPartVal([{ name: 'fq', value: 'pk:", pk, "' }], 'setSort6', $(this).val(), function() { addGlow($('#", classApiMethodMethod, "_sort6')); }, function() { addError($('#", classApiMethodMethod, "_sort6')); }); ");
			}
			a("value", strSort6())
		.fg();

	}

	public void htmSort6(String classApiMethodMethod) {
		HtmlPart s = (HtmlPart)this;
		{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggestHtmlPartSort6").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-yellow ").f();
							e("label").a("for", classApiMethodMethod, "_sort6").a("class", "").f().sx("sort6").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputSort6(classApiMethodMethod);
							} g("div");
							if("Page".equals(classApiMethodMethod)) {
								{ e("div").a("class", "w3-cell w3-left-align w3-cell-top ").f();
									{ e("button")
										.a("tabindex", "-1")
										.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-bar-item w3-yellow ")
									.a("onclick", "removeGlow($('#", classApiMethodMethod, "_sort6')); $('#", classApiMethodMethod, "_sort6').val(null); patchHtmlPartVal([{ name: 'fq', value: 'pk:' + $('#HtmlPartForm :input[name=pk]').val() }], 'setSort6', null, function() { addGlow($('#", classApiMethodMethod, "_sort6')); }, function() { addError($('#", classApiMethodMethod, "_sort6')); }); ")
										.f();
										e("i").a("class", "far fa-eraser ").f().g("i");
									} g("button");
								} g("div");
							}
						} g("div");
					} g("div");
				} g("div");
			} g("div");
		} g("div");
	}

	///////////
	// sort7 //
	///////////

	/**	L'entité « sort7 »
	 *	 is defined as null before being initialized. 
	 */
	protected Double sort7;
	@JsonIgnore
	public Wrap<Double> sort7Wrap = new Wrap<Double>().p(this).c(Double.class).var("sort7").o(sort7);

	/**	<br/>L'entité « sort7 »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enUS.html.part.HtmlPart&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:sort7">Trouver l'entité sort7 dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _sort7(Wrap<Double> c);

	public Double getSort7() {
		return sort7;
	}

	public void setSort7(Double sort7) {
		this.sort7 = sort7;
		this.sort7Wrap.alreadyInitialized = true;
	}
	public HtmlPart setSort7(String o) {
		if(NumberUtils.isParsable(o))
			this.sort7 = Double.parseDouble(o);
		this.sort7Wrap.alreadyInitialized = true;
		return (HtmlPart)this;
	}
	protected HtmlPart sort7Init() {
		if(!sort7Wrap.alreadyInitialized) {
			_sort7(sort7Wrap);
			if(sort7 == null)
				setSort7(sort7Wrap.o);
		}
		sort7Wrap.alreadyInitialized(true);
		return (HtmlPart)this;
	}

	public Double solrSort7() {
		return sort7;
	}

	public String strSort7() {
		return sort7 == null ? "" : sort7.toString();
	}

	public String jsonSort7() {
		return sort7 == null ? "" : sort7.toString();
	}

	public String nomAffichageSort7() {
		return "sort7";
	}

	public String htmTooltipSort7() {
		return null;
	}

	public String htmSort7() {
		return sort7 == null ? "" : StringEscapeUtils.escapeHtml4(strSort7());
	}

	public void inputSort7(String classApiMethodMethod) {
		HtmlPart s = (HtmlPart)this;
		e("input")
			.a("type", "text")
			.a("placeholder", "sort7")
			.a("id", classApiMethodMethod, "_sort7");
			if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
				a("class", "setSort7 inputHtmlPart", pk, "Sort7 w3-input w3-border ");
				a("name", "setSort7");
			} else {
				a("class", "valueSort7 w3-input w3-border inputHtmlPart", pk, "Sort7 w3-input w3-border ");
				a("name", "sort7");
			}
			if("Page".equals(classApiMethodMethod)) {
				a("onclick", "removeGlow($(this)); ");
				a("onchange", "patchHtmlPartVal([{ name: 'fq', value: 'pk:", pk, "' }], 'setSort7', $(this).val(), function() { addGlow($('#", classApiMethodMethod, "_sort7')); }, function() { addError($('#", classApiMethodMethod, "_sort7')); }); ");
			}
			a("value", strSort7())
		.fg();

	}

	public void htmSort7(String classApiMethodMethod) {
		HtmlPart s = (HtmlPart)this;
		{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggestHtmlPartSort7").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-yellow ").f();
							e("label").a("for", classApiMethodMethod, "_sort7").a("class", "").f().sx("sort7").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputSort7(classApiMethodMethod);
							} g("div");
							if("Page".equals(classApiMethodMethod)) {
								{ e("div").a("class", "w3-cell w3-left-align w3-cell-top ").f();
									{ e("button")
										.a("tabindex", "-1")
										.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-bar-item w3-yellow ")
									.a("onclick", "removeGlow($('#", classApiMethodMethod, "_sort7')); $('#", classApiMethodMethod, "_sort7').val(null); patchHtmlPartVal([{ name: 'fq', value: 'pk:' + $('#HtmlPartForm :input[name=pk]').val() }], 'setSort7', null, function() { addGlow($('#", classApiMethodMethod, "_sort7')); }, function() { addError($('#", classApiMethodMethod, "_sort7')); }); ")
										.f();
										e("i").a("class", "far fa-eraser ").f().g("i");
									} g("button");
								} g("div");
							}
						} g("div");
					} g("div");
				} g("div");
			} g("div");
		} g("div");
	}

	///////////
	// sort8 //
	///////////

	/**	L'entité « sort8 »
	 *	 is defined as null before being initialized. 
	 */
	protected Double sort8;
	@JsonIgnore
	public Wrap<Double> sort8Wrap = new Wrap<Double>().p(this).c(Double.class).var("sort8").o(sort8);

	/**	<br/>L'entité « sort8 »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enUS.html.part.HtmlPart&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:sort8">Trouver l'entité sort8 dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _sort8(Wrap<Double> c);

	public Double getSort8() {
		return sort8;
	}

	public void setSort8(Double sort8) {
		this.sort8 = sort8;
		this.sort8Wrap.alreadyInitialized = true;
	}
	public HtmlPart setSort8(String o) {
		if(NumberUtils.isParsable(o))
			this.sort8 = Double.parseDouble(o);
		this.sort8Wrap.alreadyInitialized = true;
		return (HtmlPart)this;
	}
	protected HtmlPart sort8Init() {
		if(!sort8Wrap.alreadyInitialized) {
			_sort8(sort8Wrap);
			if(sort8 == null)
				setSort8(sort8Wrap.o);
		}
		sort8Wrap.alreadyInitialized(true);
		return (HtmlPart)this;
	}

	public Double solrSort8() {
		return sort8;
	}

	public String strSort8() {
		return sort8 == null ? "" : sort8.toString();
	}

	public String jsonSort8() {
		return sort8 == null ? "" : sort8.toString();
	}

	public String nomAffichageSort8() {
		return "sort8";
	}

	public String htmTooltipSort8() {
		return null;
	}

	public String htmSort8() {
		return sort8 == null ? "" : StringEscapeUtils.escapeHtml4(strSort8());
	}

	public void inputSort8(String classApiMethodMethod) {
		HtmlPart s = (HtmlPart)this;
		e("input")
			.a("type", "text")
			.a("placeholder", "sort8")
			.a("id", classApiMethodMethod, "_sort8");
			if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
				a("class", "setSort8 inputHtmlPart", pk, "Sort8 w3-input w3-border ");
				a("name", "setSort8");
			} else {
				a("class", "valueSort8 w3-input w3-border inputHtmlPart", pk, "Sort8 w3-input w3-border ");
				a("name", "sort8");
			}
			if("Page".equals(classApiMethodMethod)) {
				a("onclick", "removeGlow($(this)); ");
				a("onchange", "patchHtmlPartVal([{ name: 'fq', value: 'pk:", pk, "' }], 'setSort8', $(this).val(), function() { addGlow($('#", classApiMethodMethod, "_sort8')); }, function() { addError($('#", classApiMethodMethod, "_sort8')); }); ");
			}
			a("value", strSort8())
		.fg();

	}

	public void htmSort8(String classApiMethodMethod) {
		HtmlPart s = (HtmlPart)this;
		{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggestHtmlPartSort8").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-yellow ").f();
							e("label").a("for", classApiMethodMethod, "_sort8").a("class", "").f().sx("sort8").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputSort8(classApiMethodMethod);
							} g("div");
							if("Page".equals(classApiMethodMethod)) {
								{ e("div").a("class", "w3-cell w3-left-align w3-cell-top ").f();
									{ e("button")
										.a("tabindex", "-1")
										.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-bar-item w3-yellow ")
									.a("onclick", "removeGlow($('#", classApiMethodMethod, "_sort8')); $('#", classApiMethodMethod, "_sort8').val(null); patchHtmlPartVal([{ name: 'fq', value: 'pk:' + $('#HtmlPartForm :input[name=pk]').val() }], 'setSort8', null, function() { addGlow($('#", classApiMethodMethod, "_sort8')); }, function() { addError($('#", classApiMethodMethod, "_sort8')); }); ")
										.f();
										e("i").a("class", "far fa-eraser ").f().g("i");
									} g("button");
								} g("div");
							}
						} g("div");
					} g("div");
				} g("div");
			} g("div");
		} g("div");
	}

	///////////
	// sort9 //
	///////////

	/**	L'entité « sort9 »
	 *	 is defined as null before being initialized. 
	 */
	protected Double sort9;
	@JsonIgnore
	public Wrap<Double> sort9Wrap = new Wrap<Double>().p(this).c(Double.class).var("sort9").o(sort9);

	/**	<br/>L'entité « sort9 »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enUS.html.part.HtmlPart&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:sort9">Trouver l'entité sort9 dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _sort9(Wrap<Double> c);

	public Double getSort9() {
		return sort9;
	}

	public void setSort9(Double sort9) {
		this.sort9 = sort9;
		this.sort9Wrap.alreadyInitialized = true;
	}
	public HtmlPart setSort9(String o) {
		if(NumberUtils.isParsable(o))
			this.sort9 = Double.parseDouble(o);
		this.sort9Wrap.alreadyInitialized = true;
		return (HtmlPart)this;
	}
	protected HtmlPart sort9Init() {
		if(!sort9Wrap.alreadyInitialized) {
			_sort9(sort9Wrap);
			if(sort9 == null)
				setSort9(sort9Wrap.o);
		}
		sort9Wrap.alreadyInitialized(true);
		return (HtmlPart)this;
	}

	public Double solrSort9() {
		return sort9;
	}

	public String strSort9() {
		return sort9 == null ? "" : sort9.toString();
	}

	public String jsonSort9() {
		return sort9 == null ? "" : sort9.toString();
	}

	public String nomAffichageSort9() {
		return "sort9";
	}

	public String htmTooltipSort9() {
		return null;
	}

	public String htmSort9() {
		return sort9 == null ? "" : StringEscapeUtils.escapeHtml4(strSort9());
	}

	public void inputSort9(String classApiMethodMethod) {
		HtmlPart s = (HtmlPart)this;
		e("input")
			.a("type", "text")
			.a("placeholder", "sort9")
			.a("id", classApiMethodMethod, "_sort9");
			if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
				a("class", "setSort9 inputHtmlPart", pk, "Sort9 w3-input w3-border ");
				a("name", "setSort9");
			} else {
				a("class", "valueSort9 w3-input w3-border inputHtmlPart", pk, "Sort9 w3-input w3-border ");
				a("name", "sort9");
			}
			if("Page".equals(classApiMethodMethod)) {
				a("onclick", "removeGlow($(this)); ");
				a("onchange", "patchHtmlPartVal([{ name: 'fq', value: 'pk:", pk, "' }], 'setSort9', $(this).val(), function() { addGlow($('#", classApiMethodMethod, "_sort9')); }, function() { addError($('#", classApiMethodMethod, "_sort9')); }); ");
			}
			a("value", strSort9())
		.fg();

	}

	public void htmSort9(String classApiMethodMethod) {
		HtmlPart s = (HtmlPart)this;
		{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggestHtmlPartSort9").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-yellow ").f();
							e("label").a("for", classApiMethodMethod, "_sort9").a("class", "").f().sx("sort9").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputSort9(classApiMethodMethod);
							} g("div");
							if("Page".equals(classApiMethodMethod)) {
								{ e("div").a("class", "w3-cell w3-left-align w3-cell-top ").f();
									{ e("button")
										.a("tabindex", "-1")
										.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-bar-item w3-yellow ")
									.a("onclick", "removeGlow($('#", classApiMethodMethod, "_sort9')); $('#", classApiMethodMethod, "_sort9').val(null); patchHtmlPartVal([{ name: 'fq', value: 'pk:' + $('#HtmlPartForm :input[name=pk]').val() }], 'setSort9', null, function() { addGlow($('#", classApiMethodMethod, "_sort9')); }, function() { addError($('#", classApiMethodMethod, "_sort9')); }); ")
										.f();
										e("i").a("class", "far fa-eraser ").f().g("i");
									} g("button");
								} g("div");
							}
						} g("div");
					} g("div");
				} g("div");
			} g("div");
		} g("div");
	}

	////////////
	// sort10 //
	////////////

	/**	L'entité « sort10 »
	 *	 is defined as null before being initialized. 
	 */
	protected Double sort10;
	@JsonIgnore
	public Wrap<Double> sort10Wrap = new Wrap<Double>().p(this).c(Double.class).var("sort10").o(sort10);

	/**	<br/>L'entité « sort10 »
	 *  est défini comme null avant d'être initialisé. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.bancaire.enUS.html.part.HtmlPart&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:sort10">Trouver l'entité sort10 dans Solr</a>
	 * <br/>
	 * @param c est pour envelopper une valeur à assigner à cette entité lors de l'initialisation. 
	 **/
	protected abstract void _sort10(Wrap<Double> c);

	public Double getSort10() {
		return sort10;
	}

	public void setSort10(Double sort10) {
		this.sort10 = sort10;
		this.sort10Wrap.alreadyInitialized = true;
	}
	public HtmlPart setSort10(String o) {
		if(NumberUtils.isParsable(o))
			this.sort10 = Double.parseDouble(o);
		this.sort10Wrap.alreadyInitialized = true;
		return (HtmlPart)this;
	}
	protected HtmlPart sort10Init() {
		if(!sort10Wrap.alreadyInitialized) {
			_sort10(sort10Wrap);
			if(sort10 == null)
				setSort10(sort10Wrap.o);
		}
		sort10Wrap.alreadyInitialized(true);
		return (HtmlPart)this;
	}

	public Double solrSort10() {
		return sort10;
	}

	public String strSort10() {
		return sort10 == null ? "" : sort10.toString();
	}

	public String jsonSort10() {
		return sort10 == null ? "" : sort10.toString();
	}

	public String nomAffichageSort10() {
		return "sort10";
	}

	public String htmTooltipSort10() {
		return null;
	}

	public String htmSort10() {
		return sort10 == null ? "" : StringEscapeUtils.escapeHtml4(strSort10());
	}

	public void inputSort10(String classApiMethodMethod) {
		HtmlPart s = (HtmlPart)this;
		e("input")
			.a("type", "text")
			.a("placeholder", "sort10")
			.a("id", classApiMethodMethod, "_sort10");
			if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
				a("class", "setSort10 inputHtmlPart", pk, "Sort10 w3-input w3-border ");
				a("name", "setSort10");
			} else {
				a("class", "valueSort10 w3-input w3-border inputHtmlPart", pk, "Sort10 w3-input w3-border ");
				a("name", "sort10");
			}
			if("Page".equals(classApiMethodMethod)) {
				a("onclick", "removeGlow($(this)); ");
				a("onchange", "patchHtmlPartVal([{ name: 'fq', value: 'pk:", pk, "' }], 'setSort10', $(this).val(), function() { addGlow($('#", classApiMethodMethod, "_sort10')); }, function() { addError($('#", classApiMethodMethod, "_sort10')); }); ");
			}
			a("value", strSort10())
		.fg();

	}

	public void htmSort10(String classApiMethodMethod) {
		HtmlPart s = (HtmlPart)this;
		{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggestHtmlPartSort10").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-yellow ").f();
							e("label").a("for", classApiMethodMethod, "_sort10").a("class", "").f().sx("sort10").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputSort10(classApiMethodMethod);
							} g("div");
							if("Page".equals(classApiMethodMethod)) {
								{ e("div").a("class", "w3-cell w3-left-align w3-cell-top ").f();
									{ e("button")
										.a("tabindex", "-1")
										.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-bar-item w3-yellow ")
									.a("onclick", "removeGlow($('#", classApiMethodMethod, "_sort10')); $('#", classApiMethodMethod, "_sort10').val(null); patchHtmlPartVal([{ name: 'fq', value: 'pk:' + $('#HtmlPartForm :input[name=pk]').val() }], 'setSort10', null, function() { addGlow($('#", classApiMethodMethod, "_sort10')); }, function() { addError($('#", classApiMethodMethod, "_sort10')); }); ")
										.f();
										e("i").a("class", "far fa-eraser ").f().g("i");
									} g("button");
								} g("div");
							}
						} g("div");
					} g("div");
				} g("div");
			} g("div");
		} g("div");
	}

	//////////////
	// initDeep //
	//////////////

	protected boolean alreadyInitializedHtmlPart = false;

	public HtmlPart initDeepHtmlPart(SiteRequestEnUS siteRequest_) {
		setSiteRequest_(siteRequest_);
		if(!alreadyInitializedHtmlPart) {
			alreadyInitializedHtmlPart = true;
			initDeepHtmlPart();
		}
		return (HtmlPart)this;
	}

	public void initDeepHtmlPart() {
		initHtmlPart();
		super.initDeepCluster(siteRequest_);
	}

	public void initHtmlPart() {
		htmlPartKeyInit();
		enrollmentDesignKeyInit();
		htmlLinkInit();
		htmlElementInit();
		htmlIdInit();
		htmlClassesInit();
		htmlStyleInit();
		htmlBeforeInit();
		htmlAfterInit();
		htmlTextInit();
		htmlVarInit();
		htmlVarSpanInit();
		htmlVarFormInit();
		htmlVarInputInit();
		htmlVarForEachInit();
		htmlExcludeInit();
		pdfExcludeInit();
		sort1Init();
		sort2Init();
		sort3Init();
		sort4Init();
		sort5Init();
		sort6Init();
		sort7Init();
		sort8Init();
		sort9Init();
		sort10Init();
	}

	@Override public void initDeepForClass(SiteRequestEnUS siteRequest_) {
		initDeepHtmlPart(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestHtmlPart(SiteRequestEnUS siteRequest_) {
			super.siteRequestCluster(siteRequest_);
	}

	public void siteRequestForClass(SiteRequestEnUS siteRequest_) {
		siteRequestHtmlPart(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	@Override public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainHtmlPart(v);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.obtainForClass(v);
			}
		}
		return o;
	}
	public Object obtainHtmlPart(String var) {
		HtmlPart oHtmlPart = (HtmlPart)this;
		switch(var) {
			case "htmlPartKey":
				return oHtmlPart.htmlPartKey;
			case "enrollmentDesignKey":
				return oHtmlPart.enrollmentDesignKey;
			case "htmlLink":
				return oHtmlPart.htmlLink;
			case "htmlElement":
				return oHtmlPart.htmlElement;
			case "htmlId":
				return oHtmlPart.htmlId;
			case "htmlClasses":
				return oHtmlPart.htmlClasses;
			case "htmlStyle":
				return oHtmlPart.htmlStyle;
			case "htmlBefore":
				return oHtmlPart.htmlBefore;
			case "htmlAfter":
				return oHtmlPart.htmlAfter;
			case "htmlText":
				return oHtmlPart.htmlText;
			case "htmlVar":
				return oHtmlPart.htmlVar;
			case "htmlVarSpan":
				return oHtmlPart.htmlVarSpan;
			case "htmlVarForm":
				return oHtmlPart.htmlVarForm;
			case "htmlVarInput":
				return oHtmlPart.htmlVarInput;
			case "htmlVarForEach":
				return oHtmlPart.htmlVarForEach;
			case "htmlExclude":
				return oHtmlPart.htmlExclude;
			case "pdfExclude":
				return oHtmlPart.pdfExclude;
			case "sort1":
				return oHtmlPart.sort1;
			case "sort2":
				return oHtmlPart.sort2;
			case "sort3":
				return oHtmlPart.sort3;
			case "sort4":
				return oHtmlPart.sort4;
			case "sort5":
				return oHtmlPart.sort5;
			case "sort6":
				return oHtmlPart.sort6;
			case "sort7":
				return oHtmlPart.sort7;
			case "sort8":
				return oHtmlPart.sort8;
			case "sort9":
				return oHtmlPart.sort9;
			case "sort10":
				return oHtmlPart.sort10;
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
				o = attributeHtmlPart(v, val);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.attributeForClass(v, val);
			}
		}
		return o != null;
	}
	public Object attributeHtmlPart(String var, Object val) {
		HtmlPart oHtmlPart = (HtmlPart)this;
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
					o = defineHtmlPart(v, val);
				else if(o instanceof Cluster) {
					Cluster cluster = (Cluster)o;
					o = cluster.defineForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object defineHtmlPart(String var, String val) {
		switch(var) {
			case "htmlLink":
				setHtmlLink(val);
				savesHtmlPart.add(var);
				return val;
			case "htmlElement":
				setHtmlElement(val);
				savesHtmlPart.add(var);
				return val;
			case "htmlId":
				setHtmlId(val);
				savesHtmlPart.add(var);
				return val;
			case "htmlClasses":
				setHtmlClasses(val);
				savesHtmlPart.add(var);
				return val;
			case "htmlStyle":
				setHtmlStyle(val);
				savesHtmlPart.add(var);
				return val;
			case "htmlBefore":
				setHtmlBefore(val);
				savesHtmlPart.add(var);
				return val;
			case "htmlAfter":
				setHtmlAfter(val);
				savesHtmlPart.add(var);
				return val;
			case "htmlText":
				setHtmlText(val);
				savesHtmlPart.add(var);
				return val;
			case "htmlVar":
				setHtmlVar(val);
				savesHtmlPart.add(var);
				return val;
			case "htmlVarSpan":
				setHtmlVarSpan(val);
				savesHtmlPart.add(var);
				return val;
			case "htmlVarForm":
				setHtmlVarForm(val);
				savesHtmlPart.add(var);
				return val;
			case "htmlVarInput":
				setHtmlVarInput(val);
				savesHtmlPart.add(var);
				return val;
			case "htmlVarForEach":
				setHtmlVarForEach(val);
				savesHtmlPart.add(var);
				return val;
			case "htmlExclude":
				setHtmlExclude(val);
				savesHtmlPart.add(var);
				return val;
			case "pdfExclude":
				setPdfExclude(val);
				savesHtmlPart.add(var);
				return val;
			case "sort1":
				setSort1(val);
				savesHtmlPart.add(var);
				return val;
			case "sort2":
				setSort2(val);
				savesHtmlPart.add(var);
				return val;
			case "sort3":
				setSort3(val);
				savesHtmlPart.add(var);
				return val;
			case "sort4":
				setSort4(val);
				savesHtmlPart.add(var);
				return val;
			case "sort5":
				setSort5(val);
				savesHtmlPart.add(var);
				return val;
			case "sort6":
				setSort6(val);
				savesHtmlPart.add(var);
				return val;
			case "sort7":
				setSort7(val);
				savesHtmlPart.add(var);
				return val;
			case "sort8":
				setSort8(val);
				savesHtmlPart.add(var);
				return val;
			case "sort9":
				setSort9(val);
				savesHtmlPart.add(var);
				return val;
			case "sort10":
				setSort10(val);
				savesHtmlPart.add(var);
				return val;
			default:
				return super.defineCluster(var, val);
		}
	}

	/////////////////
	// saves //
	/////////////////

	protected List<String> savesHtmlPart = new ArrayList<String>();

	/////////////
	// populate //
	/////////////

	@Override public void populateForClass(SolrDocument solrDocument) {
		populateHtmlPart(solrDocument);
	}
	public void populateHtmlPart(SolrDocument solrDocument) {
		HtmlPart oHtmlPart = (HtmlPart)this;
		savesHtmlPart = (List<String>)solrDocument.get("savesHtmlPart_stored_strings");
		if(savesHtmlPart != null) {

			if(savesHtmlPart.contains("htmlPartKey")) {
				Long htmlPartKey = (Long)solrDocument.get("htmlPartKey_stored_long");
				if(htmlPartKey != null)
					oHtmlPart.setHtmlPartKey(htmlPartKey);
			}

			if(savesHtmlPart.contains("enrollmentDesignKey")) {
				Long enrollmentDesignKey = (Long)solrDocument.get("enrollmentDesignKey_stored_long");
				if(enrollmentDesignKey != null)
					oHtmlPart.setEnrollmentDesignKey(enrollmentDesignKey);
			}

			if(savesHtmlPart.contains("htmlLink")) {
				String htmlLink = (String)solrDocument.get("htmlLink_stored_string");
				if(htmlLink != null)
					oHtmlPart.setHtmlLink(htmlLink);
			}

			if(savesHtmlPart.contains("htmlElement")) {
				String htmlElement = (String)solrDocument.get("htmlElement_stored_string");
				if(htmlElement != null)
					oHtmlPart.setHtmlElement(htmlElement);
			}

			if(savesHtmlPart.contains("htmlId")) {
				String htmlId = (String)solrDocument.get("htmlId_stored_string");
				if(htmlId != null)
					oHtmlPart.setHtmlId(htmlId);
			}

			if(savesHtmlPart.contains("htmlClasses")) {
				String htmlClasses = (String)solrDocument.get("htmlClasses_stored_string");
				if(htmlClasses != null)
					oHtmlPart.setHtmlClasses(htmlClasses);
			}

			if(savesHtmlPart.contains("htmlStyle")) {
				String htmlStyle = (String)solrDocument.get("htmlStyle_stored_string");
				if(htmlStyle != null)
					oHtmlPart.setHtmlStyle(htmlStyle);
			}

			if(savesHtmlPart.contains("htmlBefore")) {
				String htmlBefore = (String)solrDocument.get("htmlBefore_stored_string");
				if(htmlBefore != null)
					oHtmlPart.setHtmlBefore(htmlBefore);
			}

			if(savesHtmlPart.contains("htmlAfter")) {
				String htmlAfter = (String)solrDocument.get("htmlAfter_stored_string");
				if(htmlAfter != null)
					oHtmlPart.setHtmlAfter(htmlAfter);
			}

			if(savesHtmlPart.contains("htmlText")) {
				String htmlText = (String)solrDocument.get("htmlText_stored_string");
				if(htmlText != null)
					oHtmlPart.setHtmlText(htmlText);
			}

			if(savesHtmlPart.contains("htmlVar")) {
				String htmlVar = (String)solrDocument.get("htmlVar_stored_string");
				if(htmlVar != null)
					oHtmlPart.setHtmlVar(htmlVar);
			}

			if(savesHtmlPart.contains("htmlVarSpan")) {
				String htmlVarSpan = (String)solrDocument.get("htmlVarSpan_stored_string");
				if(htmlVarSpan != null)
					oHtmlPart.setHtmlVarSpan(htmlVarSpan);
			}

			if(savesHtmlPart.contains("htmlVarForm")) {
				String htmlVarForm = (String)solrDocument.get("htmlVarForm_stored_string");
				if(htmlVarForm != null)
					oHtmlPart.setHtmlVarForm(htmlVarForm);
			}

			if(savesHtmlPart.contains("htmlVarInput")) {
				String htmlVarInput = (String)solrDocument.get("htmlVarInput_stored_string");
				if(htmlVarInput != null)
					oHtmlPart.setHtmlVarInput(htmlVarInput);
			}

			if(savesHtmlPart.contains("htmlVarForEach")) {
				String htmlVarForEach = (String)solrDocument.get("htmlVarForEach_stored_string");
				if(htmlVarForEach != null)
					oHtmlPart.setHtmlVarForEach(htmlVarForEach);
			}

			if(savesHtmlPart.contains("htmlExclude")) {
				Boolean htmlExclude = (Boolean)solrDocument.get("htmlExclude_stored_boolean");
				if(htmlExclude != null)
					oHtmlPart.setHtmlExclude(htmlExclude);
			}

			if(savesHtmlPart.contains("pdfExclude")) {
				Boolean pdfExclude = (Boolean)solrDocument.get("pdfExclude_stored_boolean");
				if(pdfExclude != null)
					oHtmlPart.setPdfExclude(pdfExclude);
			}

			if(savesHtmlPart.contains("sort1")) {
				Double sort1 = (Double)solrDocument.get("sort1_stored_double");
				if(sort1 != null)
					oHtmlPart.setSort1(sort1);
			}

			if(savesHtmlPart.contains("sort2")) {
				Double sort2 = (Double)solrDocument.get("sort2_stored_double");
				if(sort2 != null)
					oHtmlPart.setSort2(sort2);
			}

			if(savesHtmlPart.contains("sort3")) {
				Double sort3 = (Double)solrDocument.get("sort3_stored_double");
				if(sort3 != null)
					oHtmlPart.setSort3(sort3);
			}

			if(savesHtmlPart.contains("sort4")) {
				Double sort4 = (Double)solrDocument.get("sort4_stored_double");
				if(sort4 != null)
					oHtmlPart.setSort4(sort4);
			}

			if(savesHtmlPart.contains("sort5")) {
				Double sort5 = (Double)solrDocument.get("sort5_stored_double");
				if(sort5 != null)
					oHtmlPart.setSort5(sort5);
			}

			if(savesHtmlPart.contains("sort6")) {
				Double sort6 = (Double)solrDocument.get("sort6_stored_double");
				if(sort6 != null)
					oHtmlPart.setSort6(sort6);
			}

			if(savesHtmlPart.contains("sort7")) {
				Double sort7 = (Double)solrDocument.get("sort7_stored_double");
				if(sort7 != null)
					oHtmlPart.setSort7(sort7);
			}

			if(savesHtmlPart.contains("sort8")) {
				Double sort8 = (Double)solrDocument.get("sort8_stored_double");
				if(sort8 != null)
					oHtmlPart.setSort8(sort8);
			}

			if(savesHtmlPart.contains("sort9")) {
				Double sort9 = (Double)solrDocument.get("sort9_stored_double");
				if(sort9 != null)
					oHtmlPart.setSort9(sort9);
			}

			if(savesHtmlPart.contains("sort10")) {
				Double sort10 = (Double)solrDocument.get("sort10_stored_double");
				if(sort10 != null)
					oHtmlPart.setSort10(sort10);
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
			solrQuery.addFilterQuery("id:" + ClientUtils.escapeQueryChars("org.computate.bancaire.enUS.html.part.HtmlPart"));
			QueryResponse queryResponse = siteRequest.getSiteContext_().getSolrClient().query(solrQuery);
			if(queryResponse.getResults().size() > 0)
				siteRequest.setSolrDocument(queryResponse.getResults().get(0));
			HtmlPart o = new HtmlPart();
			o.siteRequestHtmlPart(siteRequest);
			o.initDeepHtmlPart(siteRequest);
			o.indexHtmlPart();
		} catch(Exception e) {
			ExceptionUtils.rethrow(e);
		}
	}


	@Override public void indexForClass() {
		indexHtmlPart();
	}

	@Override public void indexForClass(SolrInputDocument document) {
		indexHtmlPart(document);
	}

	public void indexHtmlPart(SolrClient clientSolr) {
		try {
			SolrInputDocument document = new SolrInputDocument();
			indexHtmlPart(document);
			clientSolr.add(document);
			clientSolr.commit(false, false, true);
		} catch(Exception e) {
			ExceptionUtils.rethrow(e);
		}
	}

	public void indexHtmlPart() {
		try {
			SolrInputDocument document = new SolrInputDocument();
			indexHtmlPart(document);
			SolrClient clientSolr = siteRequest_.getSiteContext_().getSolrClient();
			clientSolr.add(document);
			clientSolr.commit(false, false, true);
		} catch(Exception e) {
			ExceptionUtils.rethrow(e);
		}
	}

	public void indexHtmlPart(SolrInputDocument document) {
		if(savesHtmlPart != null)
			document.addField("savesHtmlPart_stored_strings", savesHtmlPart);

		if(htmlPartKey != null) {
			document.addField("htmlPartKey_indexed_long", htmlPartKey);
			document.addField("htmlPartKey_stored_long", htmlPartKey);
		}
		if(enrollmentDesignKey != null) {
			document.addField("enrollmentDesignKey_indexed_long", enrollmentDesignKey);
			document.addField("enrollmentDesignKey_stored_long", enrollmentDesignKey);
		}
		if(htmlLink != null) {
			document.addField("htmlLink_indexed_string", htmlLink);
			document.addField("htmlLink_stored_string", htmlLink);
		}
		if(htmlElement != null) {
			document.addField("htmlElement_indexed_string", htmlElement);
			document.addField("htmlElement_stored_string", htmlElement);
		}
		if(htmlId != null) {
			document.addField("htmlId_indexed_string", htmlId);
			document.addField("htmlId_stored_string", htmlId);
		}
		if(htmlClasses != null) {
			document.addField("htmlClasses_indexed_string", htmlClasses);
			document.addField("htmlClasses_stored_string", htmlClasses);
		}
		if(htmlStyle != null) {
			document.addField("htmlStyle_indexed_string", htmlStyle);
			document.addField("htmlStyle_stored_string", htmlStyle);
		}
		if(htmlBefore != null) {
			document.addField("htmlBefore_indexed_string", htmlBefore);
			document.addField("htmlBefore_stored_string", htmlBefore);
		}
		if(htmlAfter != null) {
			document.addField("htmlAfter_indexed_string", htmlAfter);
			document.addField("htmlAfter_stored_string", htmlAfter);
		}
		if(htmlText != null) {
			document.addField("htmlText_indexed_string", htmlText);
			document.addField("htmlText_stored_string", htmlText);
		}
		if(htmlVar != null) {
			document.addField("htmlVar_indexed_string", htmlVar);
			document.addField("htmlVar_stored_string", htmlVar);
		}
		if(htmlVarSpan != null) {
			document.addField("htmlVarSpan_indexed_string", htmlVarSpan);
			document.addField("htmlVarSpan_stored_string", htmlVarSpan);
		}
		if(htmlVarForm != null) {
			document.addField("htmlVarForm_indexed_string", htmlVarForm);
			document.addField("htmlVarForm_stored_string", htmlVarForm);
		}
		if(htmlVarInput != null) {
			document.addField("htmlVarInput_indexed_string", htmlVarInput);
			document.addField("htmlVarInput_stored_string", htmlVarInput);
		}
		if(htmlVarForEach != null) {
			document.addField("htmlVarForEach_indexed_string", htmlVarForEach);
			document.addField("htmlVarForEach_stored_string", htmlVarForEach);
		}
		if(htmlExclude != null) {
			document.addField("htmlExclude_indexed_boolean", htmlExclude);
			document.addField("htmlExclude_stored_boolean", htmlExclude);
		}
		if(pdfExclude != null) {
			document.addField("pdfExclude_indexed_boolean", pdfExclude);
			document.addField("pdfExclude_stored_boolean", pdfExclude);
		}
		if(sort1 != null) {
			document.addField("sort1_indexed_double", sort1);
			document.addField("sort1_stored_double", sort1);
		}
		if(sort2 != null) {
			document.addField("sort2_indexed_double", sort2);
			document.addField("sort2_stored_double", sort2);
		}
		if(sort3 != null) {
			document.addField("sort3_indexed_double", sort3);
			document.addField("sort3_stored_double", sort3);
		}
		if(sort4 != null) {
			document.addField("sort4_indexed_double", sort4);
			document.addField("sort4_stored_double", sort4);
		}
		if(sort5 != null) {
			document.addField("sort5_indexed_double", sort5);
			document.addField("sort5_stored_double", sort5);
		}
		if(sort6 != null) {
			document.addField("sort6_indexed_double", sort6);
			document.addField("sort6_stored_double", sort6);
		}
		if(sort7 != null) {
			document.addField("sort7_indexed_double", sort7);
			document.addField("sort7_stored_double", sort7);
		}
		if(sort8 != null) {
			document.addField("sort8_indexed_double", sort8);
			document.addField("sort8_stored_double", sort8);
		}
		if(sort9 != null) {
			document.addField("sort9_indexed_double", sort9);
			document.addField("sort9_stored_double", sort9);
		}
		if(sort10 != null) {
			document.addField("sort10_indexed_double", sort10);
			document.addField("sort10_stored_double", sort10);
		}
		super.indexCluster(document);

	}

	public void unindexHtmlPart() {
		try {
		SiteRequestEnUS siteRequest = new SiteRequestEnUS();
			siteRequest.initDeepSiteRequestEnUS();
			SiteContextEnUS siteContext = new SiteContextEnUS();
			siteContext.initDeepSiteContextEnUS();
			siteRequest.setSiteContext_(siteContext);
			siteRequest.setSiteConfig_(siteContext.getSiteConfig());
			initDeepHtmlPart(siteRequest);
			SolrClient solrClient = siteContext.getSolrClient();
			solrClient.deleteById(id.toString());
			solrClient.commit(false, false, true);
		} catch(Exception e) {
			ExceptionUtils.rethrow(e);
		}
	}

	public static String varIndexedHtmlPart(String entityVar) {
		switch(entityVar) {
			case "htmlPartKey":
				return "htmlPartKey_indexed_long";
			case "enrollmentDesignKey":
				return "enrollmentDesignKey_indexed_long";
			case "htmlLink":
				return "htmlLink_indexed_string";
			case "htmlElement":
				return "htmlElement_indexed_string";
			case "htmlId":
				return "htmlId_indexed_string";
			case "htmlClasses":
				return "htmlClasses_indexed_string";
			case "htmlStyle":
				return "htmlStyle_indexed_string";
			case "htmlBefore":
				return "htmlBefore_indexed_string";
			case "htmlAfter":
				return "htmlAfter_indexed_string";
			case "htmlText":
				return "htmlText_indexed_string";
			case "htmlVar":
				return "htmlVar_indexed_string";
			case "htmlVarSpan":
				return "htmlVarSpan_indexed_string";
			case "htmlVarForm":
				return "htmlVarForm_indexed_string";
			case "htmlVarInput":
				return "htmlVarInput_indexed_string";
			case "htmlVarForEach":
				return "htmlVarForEach_indexed_string";
			case "htmlExclude":
				return "htmlExclude_indexed_boolean";
			case "pdfExclude":
				return "pdfExclude_indexed_boolean";
			case "sort1":
				return "sort1_indexed_double";
			case "sort2":
				return "sort2_indexed_double";
			case "sort3":
				return "sort3_indexed_double";
			case "sort4":
				return "sort4_indexed_double";
			case "sort5":
				return "sort5_indexed_double";
			case "sort6":
				return "sort6_indexed_double";
			case "sort7":
				return "sort7_indexed_double";
			case "sort8":
				return "sort8_indexed_double";
			case "sort9":
				return "sort9_indexed_double";
			case "sort10":
				return "sort10_indexed_double";
			default:
				return Cluster.varIndexedCluster(entityVar);
		}
	}

	public static String varSearchHtmlPart(String entityVar) {
		switch(entityVar) {
			default:
				return Cluster.varSearchCluster(entityVar);
		}
	}

	public static String varSuggestHtmlPart(String entityVar) {
		switch(entityVar) {
			default:
				return Cluster.varSuggestCluster(entityVar);
		}
	}

	/////////////
	// store //
	/////////////

	@Override public void storeForClass(SolrDocument solrDocument) {
		storeHtmlPart(solrDocument);
	}
	public void storeHtmlPart(SolrDocument solrDocument) {
		HtmlPart oHtmlPart = (HtmlPart)this;

		Long htmlPartKey = (Long)solrDocument.get("htmlPartKey_stored_long");
		if(htmlPartKey != null)
			oHtmlPart.setHtmlPartKey(htmlPartKey);

		Long enrollmentDesignKey = (Long)solrDocument.get("enrollmentDesignKey_stored_long");
		if(enrollmentDesignKey != null)
			oHtmlPart.setEnrollmentDesignKey(enrollmentDesignKey);

		String htmlLink = (String)solrDocument.get("htmlLink_stored_string");
		if(htmlLink != null)
			oHtmlPart.setHtmlLink(htmlLink);

		String htmlElement = (String)solrDocument.get("htmlElement_stored_string");
		if(htmlElement != null)
			oHtmlPart.setHtmlElement(htmlElement);

		String htmlId = (String)solrDocument.get("htmlId_stored_string");
		if(htmlId != null)
			oHtmlPart.setHtmlId(htmlId);

		String htmlClasses = (String)solrDocument.get("htmlClasses_stored_string");
		if(htmlClasses != null)
			oHtmlPart.setHtmlClasses(htmlClasses);

		String htmlStyle = (String)solrDocument.get("htmlStyle_stored_string");
		if(htmlStyle != null)
			oHtmlPart.setHtmlStyle(htmlStyle);

		String htmlBefore = (String)solrDocument.get("htmlBefore_stored_string");
		if(htmlBefore != null)
			oHtmlPart.setHtmlBefore(htmlBefore);

		String htmlAfter = (String)solrDocument.get("htmlAfter_stored_string");
		if(htmlAfter != null)
			oHtmlPart.setHtmlAfter(htmlAfter);

		String htmlText = (String)solrDocument.get("htmlText_stored_string");
		if(htmlText != null)
			oHtmlPart.setHtmlText(htmlText);

		String htmlVar = (String)solrDocument.get("htmlVar_stored_string");
		if(htmlVar != null)
			oHtmlPart.setHtmlVar(htmlVar);

		String htmlVarSpan = (String)solrDocument.get("htmlVarSpan_stored_string");
		if(htmlVarSpan != null)
			oHtmlPart.setHtmlVarSpan(htmlVarSpan);

		String htmlVarForm = (String)solrDocument.get("htmlVarForm_stored_string");
		if(htmlVarForm != null)
			oHtmlPart.setHtmlVarForm(htmlVarForm);

		String htmlVarInput = (String)solrDocument.get("htmlVarInput_stored_string");
		if(htmlVarInput != null)
			oHtmlPart.setHtmlVarInput(htmlVarInput);

		String htmlVarForEach = (String)solrDocument.get("htmlVarForEach_stored_string");
		if(htmlVarForEach != null)
			oHtmlPart.setHtmlVarForEach(htmlVarForEach);

		Boolean htmlExclude = (Boolean)solrDocument.get("htmlExclude_stored_boolean");
		if(htmlExclude != null)
			oHtmlPart.setHtmlExclude(htmlExclude);

		Boolean pdfExclude = (Boolean)solrDocument.get("pdfExclude_stored_boolean");
		if(pdfExclude != null)
			oHtmlPart.setPdfExclude(pdfExclude);

		Double sort1 = (Double)solrDocument.get("sort1_stored_double");
		if(sort1 != null)
			oHtmlPart.setSort1(sort1);

		Double sort2 = (Double)solrDocument.get("sort2_stored_double");
		if(sort2 != null)
			oHtmlPart.setSort2(sort2);

		Double sort3 = (Double)solrDocument.get("sort3_stored_double");
		if(sort3 != null)
			oHtmlPart.setSort3(sort3);

		Double sort4 = (Double)solrDocument.get("sort4_stored_double");
		if(sort4 != null)
			oHtmlPart.setSort4(sort4);

		Double sort5 = (Double)solrDocument.get("sort5_stored_double");
		if(sort5 != null)
			oHtmlPart.setSort5(sort5);

		Double sort6 = (Double)solrDocument.get("sort6_stored_double");
		if(sort6 != null)
			oHtmlPart.setSort6(sort6);

		Double sort7 = (Double)solrDocument.get("sort7_stored_double");
		if(sort7 != null)
			oHtmlPart.setSort7(sort7);

		Double sort8 = (Double)solrDocument.get("sort8_stored_double");
		if(sort8 != null)
			oHtmlPart.setSort8(sort8);

		Double sort9 = (Double)solrDocument.get("sort9_stored_double");
		if(sort9 != null)
			oHtmlPart.setSort9(sort9);

		Double sort10 = (Double)solrDocument.get("sort10_stored_double");
		if(sort10 != null)
			oHtmlPart.setSort10(sort10);

		super.storeCluster(solrDocument);
	}

	//////////////////
	// patchRequest //
	//////////////////

	public void patchRequestHtmlPart() {
		PatchRequest patchRequest = Optional.ofNullable(siteRequest_).map(SiteRequestEnUS::getPatchRequest_).orElse(null);
		HtmlPart original = (HtmlPart)Optional.ofNullable(patchRequest).map(PatchRequest::getOriginal).orElse(null);
		if(original != null) {
			if(!Objects.equals(htmlLink, original.getHtmlLink()))
				patchRequest.addVars("htmlLink");
			if(!Objects.equals(htmlElement, original.getHtmlElement()))
				patchRequest.addVars("htmlElement");
			if(!Objects.equals(htmlId, original.getHtmlId()))
				patchRequest.addVars("htmlId");
			if(!Objects.equals(htmlClasses, original.getHtmlClasses()))
				patchRequest.addVars("htmlClasses");
			if(!Objects.equals(htmlStyle, original.getHtmlStyle()))
				patchRequest.addVars("htmlStyle");
			if(!Objects.equals(htmlBefore, original.getHtmlBefore()))
				patchRequest.addVars("htmlBefore");
			if(!Objects.equals(htmlAfter, original.getHtmlAfter()))
				patchRequest.addVars("htmlAfter");
			if(!Objects.equals(htmlText, original.getHtmlText()))
				patchRequest.addVars("htmlText");
			if(!Objects.equals(htmlVar, original.getHtmlVar()))
				patchRequest.addVars("htmlVar");
			if(!Objects.equals(htmlVarSpan, original.getHtmlVarSpan()))
				patchRequest.addVars("htmlVarSpan");
			if(!Objects.equals(htmlVarForm, original.getHtmlVarForm()))
				patchRequest.addVars("htmlVarForm");
			if(!Objects.equals(htmlVarInput, original.getHtmlVarInput()))
				patchRequest.addVars("htmlVarInput");
			if(!Objects.equals(htmlVarForEach, original.getHtmlVarForEach()))
				patchRequest.addVars("htmlVarForEach");
			if(!Objects.equals(htmlExclude, original.getHtmlExclude()))
				patchRequest.addVars("htmlExclude");
			if(!Objects.equals(pdfExclude, original.getPdfExclude()))
				patchRequest.addVars("pdfExclude");
			if(!Objects.equals(sort1, original.getSort1()))
				patchRequest.addVars("sort1");
			if(!Objects.equals(sort2, original.getSort2()))
				patchRequest.addVars("sort2");
			if(!Objects.equals(sort3, original.getSort3()))
				patchRequest.addVars("sort3");
			if(!Objects.equals(sort4, original.getSort4()))
				patchRequest.addVars("sort4");
			if(!Objects.equals(sort5, original.getSort5()))
				patchRequest.addVars("sort5");
			if(!Objects.equals(sort6, original.getSort6()))
				patchRequest.addVars("sort6");
			if(!Objects.equals(sort7, original.getSort7()))
				patchRequest.addVars("sort7");
			if(!Objects.equals(sort8, original.getSort8()))
				patchRequest.addVars("sort8");
			if(!Objects.equals(sort9, original.getSort9()))
				patchRequest.addVars("sort9");
			if(!Objects.equals(sort10, original.getSort10()))
				patchRequest.addVars("sort10");
			super.patchRequestCluster();
		}
	}

	//////////////
	// hashCode //
	//////////////

	@Override public int hashCode() {
		return Objects.hash(super.hashCode(), htmlLink, htmlElement, htmlId, htmlClasses, htmlStyle, htmlBefore, htmlAfter, htmlText, htmlVar, htmlVarSpan, htmlVarForm, htmlVarInput, htmlVarForEach, htmlExclude, pdfExclude, sort1, sort2, sort3, sort4, sort5, sort6, sort7, sort8, sort9, sort10);
	}

	////////////
	// equals //
	////////////

	@Override public boolean equals(Object o) {
		if(this == o)
			return true;
		if(!(o instanceof HtmlPart))
			return false;
		HtmlPart that = (HtmlPart)o;
		return super.equals(o)
				&& Objects.equals( htmlLink, that.htmlLink )
				&& Objects.equals( htmlElement, that.htmlElement )
				&& Objects.equals( htmlId, that.htmlId )
				&& Objects.equals( htmlClasses, that.htmlClasses )
				&& Objects.equals( htmlStyle, that.htmlStyle )
				&& Objects.equals( htmlBefore, that.htmlBefore )
				&& Objects.equals( htmlAfter, that.htmlAfter )
				&& Objects.equals( htmlText, that.htmlText )
				&& Objects.equals( htmlVar, that.htmlVar )
				&& Objects.equals( htmlVarSpan, that.htmlVarSpan )
				&& Objects.equals( htmlVarForm, that.htmlVarForm )
				&& Objects.equals( htmlVarInput, that.htmlVarInput )
				&& Objects.equals( htmlVarForEach, that.htmlVarForEach )
				&& Objects.equals( htmlExclude, that.htmlExclude )
				&& Objects.equals( pdfExclude, that.pdfExclude )
				&& Objects.equals( sort1, that.sort1 )
				&& Objects.equals( sort2, that.sort2 )
				&& Objects.equals( sort3, that.sort3 )
				&& Objects.equals( sort4, that.sort4 )
				&& Objects.equals( sort5, that.sort5 )
				&& Objects.equals( sort6, that.sort6 )
				&& Objects.equals( sort7, that.sort7 )
				&& Objects.equals( sort8, that.sort8 )
				&& Objects.equals( sort9, that.sort9 )
				&& Objects.equals( sort10, that.sort10 );
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString() + "\n");
		sb.append("HtmlPart { ");
		sb.append( "htmlLink: \"" ).append(htmlLink).append( "\"" );
		sb.append( ", htmlElement: \"" ).append(htmlElement).append( "\"" );
		sb.append( ", htmlId: \"" ).append(htmlId).append( "\"" );
		sb.append( ", htmlClasses: \"" ).append(htmlClasses).append( "\"" );
		sb.append( ", htmlStyle: \"" ).append(htmlStyle).append( "\"" );
		sb.append( ", htmlBefore: \"" ).append(htmlBefore).append( "\"" );
		sb.append( ", htmlAfter: \"" ).append(htmlAfter).append( "\"" );
		sb.append( ", htmlText: \"" ).append(htmlText).append( "\"" );
		sb.append( ", htmlVar: \"" ).append(htmlVar).append( "\"" );
		sb.append( ", htmlVarSpan: \"" ).append(htmlVarSpan).append( "\"" );
		sb.append( ", htmlVarForm: \"" ).append(htmlVarForm).append( "\"" );
		sb.append( ", htmlVarInput: \"" ).append(htmlVarInput).append( "\"" );
		sb.append( ", htmlVarForEach: \"" ).append(htmlVarForEach).append( "\"" );
		sb.append( ", htmlExclude: " ).append(htmlExclude);
		sb.append( ", pdfExclude: " ).append(pdfExclude);
		sb.append( ", sort1: " ).append(sort1);
		sb.append( ", sort2: " ).append(sort2);
		sb.append( ", sort3: " ).append(sort3);
		sb.append( ", sort4: " ).append(sort4);
		sb.append( ", sort5: " ).append(sort5);
		sb.append( ", sort6: " ).append(sort6);
		sb.append( ", sort7: " ).append(sort7);
		sb.append( ", sort8: " ).append(sort8);
		sb.append( ", sort9: " ).append(sort9);
		sb.append( ", sort10: " ).append(sort10);
		sb.append(" }");
		return sb.toString();
	}
}
