package org.computate.bancaire.enus.transaction.code;

import org.computate.bancaire.enus.cluster.ClusterPage;
import org.computate.bancaire.enus.config.SiteConfig;
import org.computate.bancaire.enus.request.SiteRequestEnUS;
import org.computate.bancaire.enus.contexte.SiteContextEnUS;
import org.computate.bancaire.enus.user.SiteUser;
import java.io.IOException;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.core.http.HttpServerResponse;
import org.computate.bancaire.enus.search.SearchList;
import org.computate.bancaire.enus.wrap.Wrap;
import org.computate.bancaire.enus.page.PageLayout;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.api.OperationRequest;
import io.vertx.core.json.JsonArray;
import java.net.URLDecoder;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.commons.lang3.StringUtils;
import java.util.Map;
import java.util.List;


/**
 * Translate: false
 **/
public class CodeTransactionGenPage extends CodeTransactionGenPageGen<ClusterPage> {

	/**
	 * {@inheritDoc}
	 * 
	 **/
	protected void _listTransactionCode(Wrap<SearchList<TransactionCode>> c) {
	}

	protected void _transactionCode(Wrap<TransactionCode> c) {
		if(listTransactionCode != null && listTransactionCode.size() == 1)
			c.o(listTransactionCode.get(0));
	}

	@Override protected void _pageH1(Wrap<String> c) {
			c.o("bank transaction codes");
	}

	@Override protected void _pageH2(Wrap<String> c) {
		c.o("");
	}

	@Override protected void _pageH3(Wrap<String> c) {
		c.o("");
	}

	@Override protected void _pageTitle(Wrap<String> c) {
		if(transactionCode != null && transactionCode.getTransactionCodeCompleteName() != null)
			c.o(transactionCode.getTransactionCodeCompleteName());
		else if(transactionCode != null)
			c.o("");
		else if(listTransactionCode == null || listTransactionCode.size() == 0)
			c.o("no transaction code found");
	}

	@Override protected void _pageUri(Wrap<String> c) {
		c.o("/transaction-code");
	}

	@Override protected void _pageImageUri(Wrap<String> c) {
			c.o("/png/transaction-code-999.png");
	}

	@Override protected void _contextIconGroup(Wrap<String> c) {
			c.o("duotone");
	}

	@Override protected void _contextIconName(Wrap<String> c) {
			c.o("code-commit");
	}

	@Override public void initDeepCodeTransactionGenPage() {
		initCodeTransactionGenPage();
		super.initDeepPageLayout();
	}

	@Override public void htmlScriptsCodeTransactionGenPage() {
		e("script").a("src", staticBaseUrl, "/js/enUS/CodeTransactionPage.js").f().g("script");
	}

	@Override public void htmlScriptCodeTransactionGenPage() {
		l("$(document).ready(function() {");
		tl(1, "window.eventBus = new EventBus('/eventbus');");
		tl(1, "var pk = ", siteRequest_.getRequestPk(), ";");
		tl(1, "websocketTransactionCode(websocketTransactionCodeInner);");
		l("});");
	}

	public void htmlFormPageTransactionCode(TransactionCode o) {
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPk("Page");
			o.htmCreated("Page");
			o.htmModified("Page");
			o.htmObjectId("Page");
			o.htmTransactionCodeId("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmArchived("Page");
			o.htmDeleted("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmTransactionCode("Page");
			o.htmTransactionCodeDisplayName("Page");
		} g("div");
	}

	public void htmlFormPOSTTransactionCode(TransactionCode o) {
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPk("POST");
			o.htmCreated("POST");
			o.htmModified("POST");
			o.htmObjectId("POST");
			o.htmTransactionCodeId("POST");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmArchived("POST");
			o.htmDeleted("POST");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmTransactionCode("POST");
			o.htmTransactionCodeDisplayName("POST");
		} g("div");
	}

	public void htmlFormPATCHTransactionCode(TransactionCode o) {
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPk("PATCH");
			o.htmCreated("PATCH");
			o.htmModified("PATCH");
			o.htmObjectId("PATCH");
			o.htmTransactionCodeId("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmArchived("PATCH");
			o.htmDeleted("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmTransactionCode("PATCH");
			o.htmTransactionCodeDisplayName("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmTransactionCodeCompleteName("PATCH");
		} g("div");
	}

	public void htmlFormSearchTransactionCode(TransactionCode o) {
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPk("Recherche");
			o.htmCreated("Recherche");
			o.htmModified("Recherche");
			o.htmObjectId("Recherche");
			o.htmTransactionCodeId("Recherche");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmArchived("Recherche");
			o.htmDeleted("Recherche");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmTransactionCode("Recherche");
			o.htmTransactionCodeDisplayName("Recherche");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmTransactionCodeCompleteName("Recherche");
		} g("div");
	}

	@Override public void htmlBodyCodeTransactionGenPage() {

		OperationRequest operationRequest = siteRequest_.getOperationRequest();
		JsonObject params = operationRequest.getParams();
		if(listTransactionCode == null || listTransactionCode.size() == 0) {

			{ e("h1").f();
				{ e("a").a("href", "/transaction-code").a("class", "w3-bar-item w3-btn w3-center w3-block w3-yellow w3-hover-yellow ").f();
					if(contextIconCssClasses != null)
						e("i").a("class", contextIconCssClasses + " site-menu-icon ").f().g("i");
					e("span").a("class", " ").f().sx("bank transaction codes").g("span");
				} g("a");
			} g("h1");
			e("div").a("class", "w3-padding-16 w3-card-4 w3-light-grey ").f();
			{ e("h2").f();
				{ e("span").a("class", "w3-bar-item w3-padding w3-center w3-block w3-yellow ").f();
					if(contextIconCssClasses != null)
						e("i").a("class", contextIconCssClasses + " site-menu-icon ").f().g("i");
					e("span").a("class", " ").f().sx("no transaction code found").g("span");
				} g("span");
			} g("h2");
		} else if(listTransactionCode != null && listTransactionCode.size() == 1 && params.getJsonObject("query").getString("q").equals("*:*")) {
			TransactionCode o = listTransactionCode.get(0);
			siteRequest_.setRequestPk(o.getPk());
			if(StringUtils.isNotEmpty(pageH1)) {
				{ e("h1").f();
					{ e("a").a("href", "/transaction-code").a("class", "w3-bar-item w3-btn w3-center w3-block w3-yellow w3-hover-yellow ").f();
						if(contextIconCssClasses != null)
							e("i").a("class", contextIconCssClasses + " site-menu-icon ").f().g("i");
						e("span").a("class", " ").f().sx(pageH1).g("span");
					} g("a");
				} g("h1");
			}
			e("div").a("class", "w3-padding-16 w3-card-4 w3-light-grey ").f();
			if(StringUtils.isNotEmpty(pageH2)) {
				{ e("h2").f();
					{ e("span").a("class", "w3-bar-item w3-padding w3-center w3-block w3-yellow ").f();
						e("span").a("class", " ").f().sx(pageH2).g("span");
					} g("span");
				} g("h2");
			}
			if(StringUtils.isNotEmpty(pageH3)) {
				{ e("h3").f();
					{ e("span").a("class", "w3-bar-item w3-padding w3-center w3-block w3-yellow ").f();
						e("span").a("class", " ").f().sx(pageH3).g("span");
					} g("span");
				} g("h3");
			}
		} else {

				{ e("h1").f();
					{ e("a").a("href", "/transaction-code").a("class", "w3-bar-item w3-btn w3-center w3-block w3-yellow w3-hover-yellow ").f();
						if(contextIconCssClasses != null)
							e("i").a("class", contextIconCssClasses + " site-menu-icon ").f().g("i");
						e("span").a("class", " ").f().sx(pageH1).g("span");
					} g("a");
				} g("h1");
			e("div").a("class", "").f();
				{ e("div").f();
					Long num = listTransactionCode.getQueryResponse().getResults().getNumFound();
					String query = StringUtils.replace(listTransactionCode.getQuery(), "_suggested", "");
					Integer rows1 = listTransactionCode.getRows();
					Integer start1 = listTransactionCode.getStart();
					Integer start2 = start1 - rows1;
					Integer start3 = start1 + rows1;
					Integer rows2 = rows1 / 2;
					Integer rows3 = rows1 * 2;
					start2 = start2 < 0 ? 0 : start2;

					if(start1 == 0) {
						e("i").a("class", "fas fa-arrow-square-left w3-opacity ").f().g("i");
					} else {
						{ e("a").a("href", "/transaction-code?q=", query, "&start=", start2, "&rows=", rows1).f();
							e("i").a("class", "fas fa-arrow-square-left ").f().g("i");
						} g("a");
					}

					if(rows1 <= 1) {
						e("i").a("class", "fas fa-minus-square w3-opacity ").f().g("i");
					} else {
						{ e("a").a("href", "/transaction-code?q=", query, "&start=", start1, "&rows=", rows2).f();
							e("i").a("class", "fas fa-minus-square ").f().g("i");
						} g("a");
					}

					{ e("a").a("href", "/transaction-code?q=", query, "&start=", start1, "&rows=", rows3).f();
						e("i").a("class", "fas fa-plus-square ").f().g("i");
					} g("a");

					if(start3 >= num) {
						e("i").a("class", "fas fa-arrow-square-right w3-opacity ").f().g("i");
					} else {
						{ e("a").a("href", "/transaction-code?q=", query, "&start=", start3, "&rows=", rows1).f();
							e("i").a("class", "fas fa-arrow-square-right ").f().g("i");
						} g("a");
					}
						e("span").f().sx((start1 + 1), " - ", (start1 + rows1), " of ", num).g("span");
				} g("div");
			{ e("table").a("class", "w3-table w3-bordered w3-striped w3-border w3-hoverable ").f();
				{ e("thead").a("class", "w3-yellow w3-hover-yellow ").f();
					{ e("tr").f();
						e("th").f().sx("").g("th");
						e("th").f().sx("created").g("th");
					} g("tr");
				} g("thead");
				{ e("tbody").f();
					Map<String, Map<String, List<String>>> highlighting = listTransactionCode.getQueryResponse().getHighlighting();
					for(int i = 0; i < listTransactionCode.size(); i++) {
						TransactionCode o = listTransactionCode.getList().get(i);
						Map<String, List<String>> highlights = highlighting == null ? null : highlighting.get(o.getId());
						List<String> highlightList = highlights == null ? null : highlights.get(highlights.keySet().stream().findFirst().orElse(null));
						String uri = "/transaction-code/" + o.getPk();
						{ e("tr").f();
							{ e("td").f();
								{ e("a").a("href", uri).f();
									e("i").a("class", "fad fa-code-commit w3-padding-small ").f().g("i");
									{ e("span").f();
										sx(o.strTransactionCodeCompleteName());
									} g("span");
								} g("a");
							} g("td");
							{ e("td").f();
								{ e("a").a("href", uri).f();
									{ e("span").f();
										sx(o.strCreated());
									} g("span");
								} g("a");
							} g("td");
						} g("tr");
					}
				} g("tbody");
			} g("table");
		}

		if(listTransactionCode != null && listTransactionCode.size() == 1 && params.getJsonObject("query").getString("q").equals("*:*")) {
			TransactionCode o = listTransactionCode.first();

			{ e("div").a("class", "").f();

				if(o.getPk() != null) {
					{ e("form").a("action", "").a("id", "TransactionCodeForm").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
						e("input")
						.a("name", "pk")
						.a("class", "valuePk")
						.a("type", "hidden")
						.a("value", o.getPk())
						.fg();
						e("input")
						.a("name", "focusId")
						.a("type", "hidden")
						.fg();
					} g("form");
					htmlFormPageTransactionCode(o);
				}

			} g("div");

		}
		htmlBodyFormsCodeTransactionGenPage();
		htmlSuggestCodeTransactionGenPage(this, null);
		g("div");
	}

	public void htmlBodyFormsCodeTransactionGenPage() {
		e("div").a("class", "w3-margin-top ").f();

		{ e("button")
			.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-yellow ")
				.a("id", "refreshThisCodeTransactionGenPage")
				.a("onclick", "patchTransactionCodeVals( [ {name: 'fq', value: 'pk:' + " + siteRequest_.getRequestPk() + " } ], {}, function() { addGlow($('#refreshThisCodeTransactionGenPage')); }, function() { addError($('#refreshThisCodeTransactionGenPage')); }); return false; ").f();
				e("i").a("class", "fas fa-sync-alt w3-padding-small ").f().g("i");
			sx("refresh this transaction code");
		} g("button");

		e("button")
			.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-yellow ")
			.a("onclick", "$('#postTransactionCodeModal').show(); ")
			.f().sx("Create a transaction code")
		.g("button");
		{ e("div").a("id", "postTransactionCodeModal").a("class", "w3-modal ").f();
			{ e("div").a("class", "w3-modal-content w3-card-4 ").f();
				{ e("header").a("class", "w3-container w3-yellow ").f();
					e("span").a("class", "w3-button w3-display-topright ").a("onclick", "$('#postTransactionCodeModal').hide(); ").f().sx("×").g("span");
					e("h2").a("class", "w3-padding ").f().sx("Create a transaction code").g("h2");
				} g("header");
				{ e("div").a("class", "w3-container ").f();
					TransactionCode o = new TransactionCode();
					o.setSiteRequest_(siteRequest_);

					// Form POST
					{ e("div").a("id", "postTransactionCodeForm").f();
						htmlFormPOSTTransactionCode(o);
					} g("div");
					e("button")
						.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-yellow ")
						.a("onclick", "postTransactionCode($('#postTransactionCodeForm')); ")
						.f().sx("Create a transaction code")
					.g("button");

				} g("div");
			} g("div");
		} g("div");


		e("button")
			.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-yellow ")
			.a("onclick", "$('#patchTransactionCodeModal').show(); ")
			.f().sx("Modify the transaction codes")
		.g("button");
		{ e("div").a("id", "patchTransactionCodeModal").a("class", "w3-modal ").f();
			{ e("div").a("class", "w3-modal-content w3-card-4 ").f();
				{ e("header").a("class", "w3-container w3-yellow ").f();
					e("span").a("class", "w3-button w3-display-topright ").a("onclick", "$('#patchTransactionCodeModal').hide(); ").f().sx("×").g("span");
					e("h2").a("class", "w3-padding ").f().sx("Modify the transaction codes").g("h2");
				} g("header");
				{ e("div").a("class", "w3-container ").f();
					TransactionCode o = new TransactionCode();
					o.setSiteRequest_(siteRequest_);

					// FormFilters PATCH
					{ e("form").a("action", "").a("id", "patchTransactionCodeFormFilters").a("onsubmit", "event.preventDefault(); return false; ").f();
						htmlFormSearchTransactionCode(o);
					} g("form");
					e("button")
						.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-yellow ")
						.a("onclick", "aSearchTransactionCode($('#patchTransactionCodeFormFilters')); ")
						.f().sx("Search the a transaction code")
					.g("button");


					// FormValues PATCH
					{ e("form").a("action", "").a("id", "patchTransactionCodeFormValues").a("onsubmit", "event.preventDefault(); return false; ").f();
						htmlFormPATCHTransactionCode(o);
					} g("form");
					e("button")
						.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-yellow ")
						.a("onclick", "patchTransactionCode($('#patchTransactionCodeFormFilters'), $('#patchTransactionCodeFormValues'), function() {}, function() {}); ")
						.f().sx("Modify the transaction codes")
					.g("button");

				} g("div");
			} g("div");
		} g("div");


		if(listTransactionCode != null && listTransactionCode.size() == 1) {
			e("button")
				.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-yellow ")
				.a("onclick", "$('#deleteTransactionCodeModal').show(); ")
				.f().sx("Delete the transaction codes")
			.g("button");
			{ e("div").a("id", "deleteTransactionCodeModal").a("class", "w3-modal ").f();
				{ e("div").a("class", "w3-modal-content w3-card-4 ").f();
					{ e("header").a("class", "w3-container w3-yellow ").f();
						e("span").a("class", "w3-button w3-display-topright ").a("onclick", "$('#deleteTransactionCodeModal').hide(); ").f().sx("×").g("span");
						e("h2").a("class", "w3-padding ").f().sx("Delete the transaction codes").g("h2");
					} g("header");
					{ e("div").a("class", "w3-container ").f();
						TransactionCode o = new TransactionCode();
						o.setSiteRequest_(siteRequest_);

						// Form DELETE
						{ e("div").a("id", "deleteTransactionCodeForm").f();
							htmlFormPATCHTransactionCode(o);
						} g("div");
						e("button")
							.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-yellow ")
							.a("onclick", "deleteTransactionCode(", o.getPk(), "); ")
							.f().sx("Delete the transaction codes")
						.g("button");

					} g("div");
				} g("div");
			} g("div");

		}
		g("div");
	}

	/**
	**/
	public static void htmlSuggestCodeTransactionGenPage(PageLayout p, String id) {
		{ p.e("div").a("class", "w3-cell-row ").f();
			{ p.e("div").a("class", "w3-cell ").f();
				{ p.e("a").a("href", "/transaction-code").a("class", "").f();
					p.e("i").a("class", "fad fa-code-commit w3-padding-small ").f().g("i");
					p.sx("see all the transaction codes");
				} p.g("a");
			} p.g("div");
			{ p.e("div").a("class", "w3-cell ").f();
				{ p.e("a").a("id", "refreshAllCodeTransactionGenPage", id).a("href", "/transaction-code").a("class", "").a("onclick", "patchTransactionCodeVals([], {}, function() { addGlow($('#refreshAllCodeTransactionGenPage", id, "')); }, function() { addError($('#refreshAllCodeTransactionGenPage", id, "')); }); return false; ").f();
					p.e("i").a("class", "fas fa-sync-alt w3-padding-small ").f().g("i");
					p.sx("refresh all the transaction codes");
				} p.g("a");
			} p.g("div");
		} p.g("div");
		{ p.e("div").a("class", "w3-cell-row w3-padding ").f();
			{ p.e("div").a("class", "w3-cell ").f();
				{ p.e("span").f();
					p.sx("search bank transaction codes: ");
				} p.g("span");
			} p.g("div");
		} p.g("div");
		{ p.e("div").a("class", "w3-cell-row w3-padding ").f();
			{ p.e("div").a("class", "w3-cell ").f();
				{ p.e("div").a("class", "w3-cell-row ").f();

					p.e("i").a("class", "far fa-search w3-xxlarge w3-cell w3-cell-middle ").f().g("i");
					{ p.e("form").a("action", "").a("id", "suggestFormTransactionCode", id).a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); window.location.href='/transaction-code?q=objectSuggest:' + encodeURIComponent($('#suggestTransactionCode", id, "').val()); return false; ").f();
						p.e("input")
							.a("type", "text")
							.a("class", "suggestTransactionCode w3-input w3-border w3-cell w3-cell-middle ")
							.a("name", "suggestTransactionCode")
							.a("id", "suggestTransactionCode", id)
							.a("autocomplete", "off")
							.a("oninput", "suggestTransactionCodeObjectSuggest( [ { 'name': 'q', 'value': 'objectSuggest:' + $(this).val() } ], $('#suggestListTransactionCode", id, "'), ", p.getSiteRequest_().getRequestPk(), "); ")
							.fg();

					} p.g("form");
				} p.g("div");
			} p.g("div");
		} p.g("div");
		{ p.e("div").a("class", "w3-cell-row w3-padding ").f();
			{ p.e("div").a("class", "w3-cell w3-left-align w3-cell-top ").f();
				{ p.e("ul").a("class", "w3-ul w3-hoverable ").a("id", "suggestListTransactionCode", id).f();
				} p.g("ul");
			} p.g("div");
		} p.g("div");
	}

}
