package org.computate.bancaire.enus.transaction;

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
public class TransactionGenPage extends TransactionGenPageGen<ClusterPage> {

	/**
	 * {@inheritDoc}
	 * 
	 **/
	protected void _listBankTransaction(Wrap<SearchList<BankTransaction>> c) {
	}

	protected void _bankTransaction(Wrap<BankTransaction> c) {
		if(listBankTransaction != null && listBankTransaction.size() == 1)
			c.o(listBankTransaction.get(0));
	}

	@Override protected void _pageH1(Wrap<String> c) {
			c.o("transactions");
	}

	@Override protected void _pageH2(Wrap<String> c) {
		c.o("");
	}

	@Override protected void _pageH3(Wrap<String> c) {
		c.o("");
	}

	@Override protected void _pageTitle(Wrap<String> c) {
		if(bankTransaction != null && bankTransaction.getTransactionCompleteName() != null)
			c.o(bankTransaction.getTransactionCompleteName());
		else if(bankTransaction != null)
			c.o("");
		else if(listBankTransaction == null || listBankTransaction.size() == 0)
			c.o("no transaction found");
	}

	@Override protected void _pageUri(Wrap<String> c) {
		c.o("/transaction");
	}

	@Override protected void _pageImageUri(Wrap<String> c) {
			c.o("/png/transaction-999.png");
	}

	@Override protected void _contextIconGroup(Wrap<String> c) {
			c.o("duotone");
	}

	@Override protected void _contextIconName(Wrap<String> c) {
			c.o("cash-register");
	}

	@Override public void initDeepTransactionGenPage() {
		initTransactionGenPage();
		super.initDeepPageLayout();
	}

	@Override public void htmlScriptsTransactionGenPage() {
		e("script").a("src", staticBaseUrl, "/js/enUS/TransactionPage.js").f().g("script");
		e("script").a("src", staticBaseUrl, "/js/enUS/AccountPage.js").f().g("script");
	}

	@Override public void htmlScriptTransactionGenPage() {
		l("$(document).ready(function() {");
		tl(1, "window.eventBus = new EventBus('/eventbus');");
		tl(1, "var pk = ", siteRequest_.getRequestPk(), ";");
		tl(1, "suggestBankTransactionAccountKey([{'name':'fq','value':'yearKeys:' + pk}], $('#listBankTransactionAccountKey_Page'), pk); ");
		tl(1, "websocketBankTransaction(websocketBankTransactionInner);");
		l("});");
	}

	public void htmlFormPageBankTransaction(BankTransaction o) {
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPk("Page");
			o.htmCreated("Page");
			o.htmModified("Page");
			o.htmObjectId("Page");
			o.htmTransactionId("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmArchived("Page");
			o.htmDeleted("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmAccountKey("Page");
			o.htmTransactionCode("Page");
			o.htmTransactionFee("Page");
			o.htmTransactionDisplayName("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmTransactionReferenceId("Page");
			o.htmTransactionAmount("Page");
			o.htmTransactionDateTime("Page");
		} g("div");
	}

	public void htmlFormPOSTBankTransaction(BankTransaction o) {
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPk("POST");
			o.htmCreated("POST");
			o.htmModified("POST");
			o.htmObjectId("POST");
			o.htmTransactionId("POST");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmArchived("POST");
			o.htmDeleted("POST");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmAccountKey("POST");
			o.htmTransactionCode("POST");
			o.htmTransactionFee("POST");
			o.htmTransactionDisplayName("POST");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmTransactionReferenceId("POST");
			o.htmTransactionAmount("POST");
			o.htmTransactionDateTime("POST");
		} g("div");
	}

	public void htmlFormPATCHBankTransaction(BankTransaction o) {
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPk("PATCH");
			o.htmCreated("PATCH");
			o.htmModified("PATCH");
			o.htmObjectId("PATCH");
			o.htmTransactionId("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmArchived("PATCH");
			o.htmDeleted("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmAccountKey("PATCH");
			o.htmTransactionCode("PATCH");
			o.htmTransactionFee("PATCH");
			o.htmTransactionDisplayName("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmTransactionReferenceId("PATCH");
			o.htmTransactionAmount("PATCH");
			o.htmTransactionDateTime("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmTransactionCompleteName("PATCH");
		} g("div");
	}

	public void htmlFormSearchBankTransaction(BankTransaction o) {
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPk("Recherche");
			o.htmCreated("Recherche");
			o.htmModified("Recherche");
			o.htmObjectId("Recherche");
			o.htmTransactionId("Recherche");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmArchived("Recherche");
			o.htmDeleted("Recherche");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmAccountKey("Recherche");
			o.htmTransactionCode("Recherche");
			o.htmTransactionFee("Recherche");
			o.htmTransactionDisplayName("Recherche");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmTransactionReferenceId("Recherche");
			o.htmTransactionAmount("Recherche");
			o.htmTransactionDateTime("Recherche");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmTransactionCompleteName("Recherche");
		} g("div");
	}

	@Override public void htmlBodyTransactionGenPage() {

		OperationRequest operationRequest = siteRequest_.getOperationRequest();
		JsonObject params = operationRequest.getParams();
		if(listBankTransaction == null || listBankTransaction.size() == 0) {

			{ e("h1").f();
				{ e("a").a("href", "/transaction").a("class", "w3-bar-item w3-btn w3-center w3-block w3-yellow w3-hover-yellow ").f();
					if(contextIconCssClasses != null)
						e("i").a("class", contextIconCssClasses + " site-menu-icon ").f().g("i");
					e("span").a("class", " ").f().sx("transactions").g("span");
				} g("a");
			} g("h1");
			e("div").a("class", "w3-padding-16 w3-card-4 w3-light-grey ").f();
			{ e("h2").f();
				{ e("span").a("class", "w3-bar-item w3-padding w3-center w3-block w3-yellow ").f();
					if(contextIconCssClasses != null)
						e("i").a("class", contextIconCssClasses + " site-menu-icon ").f().g("i");
					e("span").a("class", " ").f().sx("no transaction found").g("span");
				} g("span");
			} g("h2");
		} else if(listBankTransaction != null && listBankTransaction.size() == 1 && params.getJsonObject("query").getString("q").equals("*:*")) {
			BankTransaction o = listBankTransaction.get(0);
			siteRequest_.setRequestPk(o.getPk());
			if(StringUtils.isNotEmpty(pageH1)) {
				{ e("h1").f();
					{ e("a").a("href", "/transaction").a("class", "w3-bar-item w3-btn w3-center w3-block w3-yellow w3-hover-yellow ").f();
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
					{ e("a").a("href", "/transaction").a("class", "w3-bar-item w3-btn w3-center w3-block w3-yellow w3-hover-yellow ").f();
						if(contextIconCssClasses != null)
							e("i").a("class", contextIconCssClasses + " site-menu-icon ").f().g("i");
						e("span").a("class", " ").f().sx(pageH1).g("span");
					} g("a");
				} g("h1");
			e("div").a("class", "").f();
				{ e("div").f();
					Long num = listBankTransaction.getQueryResponse().getResults().getNumFound();
					String query = StringUtils.replace(listBankTransaction.getQuery(), "_suggested", "");
					Integer rows1 = listBankTransaction.getRows();
					Integer start1 = listBankTransaction.getStart();
					Integer start2 = start1 - rows1;
					Integer start3 = start1 + rows1;
					Integer rows2 = rows1 / 2;
					Integer rows3 = rows1 * 2;
					start2 = start2 < 0 ? 0 : start2;

					if(start1 == 0) {
						e("i").a("class", "fas fa-arrow-square-left w3-opacity ").f().g("i");
					} else {
						{ e("a").a("href", "/transaction?q=", query, "&start=", start2, "&rows=", rows1).f();
							e("i").a("class", "fas fa-arrow-square-left ").f().g("i");
						} g("a");
					}

					if(rows1 <= 1) {
						e("i").a("class", "fas fa-minus-square w3-opacity ").f().g("i");
					} else {
						{ e("a").a("href", "/transaction?q=", query, "&start=", start1, "&rows=", rows2).f();
							e("i").a("class", "fas fa-minus-square ").f().g("i");
						} g("a");
					}

					{ e("a").a("href", "/transaction?q=", query, "&start=", start1, "&rows=", rows3).f();
						e("i").a("class", "fas fa-plus-square ").f().g("i");
					} g("a");

					if(start3 >= num) {
						e("i").a("class", "fas fa-arrow-square-right w3-opacity ").f().g("i");
					} else {
						{ e("a").a("href", "/transaction?q=", query, "&start=", start3, "&rows=", rows1).f();
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
					Map<String, Map<String, List<String>>> highlighting = listBankTransaction.getQueryResponse().getHighlighting();
					for(int i = 0; i < listBankTransaction.size(); i++) {
						BankTransaction o = listBankTransaction.getList().get(i);
						Map<String, List<String>> highlights = highlighting == null ? null : highlighting.get(o.getId());
						List<String> highlightList = highlights == null ? null : highlights.get(highlights.keySet().stream().findFirst().orElse(null));
						String uri = "/transaction/" + o.getPk();
						{ e("tr").f();
							{ e("td").f();
								{ e("a").a("href", uri).f();
									e("i").a("class", "fad fa-cash-register w3-padding-small ").f().g("i");
									{ e("span").f();
										sx(o.strTransactionCompleteName());
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

		if(listBankTransaction != null && listBankTransaction.size() == 1 && params.getJsonObject("query").getString("q").equals("*:*")) {
			BankTransaction o = listBankTransaction.first();

			{ e("div").a("class", "").f();

				if(o.getPk() != null) {
					{ e("form").a("action", "").a("id", "BankTransactionForm").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
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
					htmlFormPageBankTransaction(o);
				}

			} g("div");

		}
		htmlBodyFormsTransactionGenPage();
		htmlSuggestTransactionGenPage(this, null);
		g("div");
	}

	public void htmlBodyFormsTransactionGenPage() {
		e("div").a("class", "w3-margin-top ").f();

		{ e("button")
			.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-yellow ")
				.a("id", "refreshThisTransactionGenPage")
				.a("onclick", "patchBankTransactionVals( [ {name: 'fq', value: 'pk:' + " + siteRequest_.getRequestPk() + " } ], {}, function() { addGlow($('#refreshThisTransactionGenPage')); }, function() { addError($('#refreshThisTransactionGenPage')); }); return false; ").f();
				e("i").a("class", "fas fa-sync-alt w3-padding-small ").f().g("i");
			sx("refresh this transaction");
		} g("button");

		e("button")
			.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-yellow ")
			.a("onclick", "$('#postBankTransactionModal').show(); ")
			.f().sx("Create a transaction")
		.g("button");
		{ e("div").a("id", "postBankTransactionModal").a("class", "w3-modal ").f();
			{ e("div").a("class", "w3-modal-content w3-card-4 ").f();
				{ e("header").a("class", "w3-container w3-yellow ").f();
					e("span").a("class", "w3-button w3-display-topright ").a("onclick", "$('#postBankTransactionModal').hide(); ").f().sx("×").g("span");
					e("h2").a("class", "w3-padding ").f().sx("Create a transaction").g("h2");
				} g("header");
				{ e("div").a("class", "w3-container ").f();
					BankTransaction o = new BankTransaction();
					o.setSiteRequest_(siteRequest_);

					// Form POST
					{ e("div").a("id", "postBankTransactionForm").f();
						htmlFormPOSTBankTransaction(o);
					} g("div");
					e("button")
						.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-yellow ")
						.a("onclick", "postBankTransaction($('#postBankTransactionForm')); ")
						.f().sx("Create a transaction")
					.g("button");

				} g("div");
			} g("div");
		} g("div");


		e("button")
			.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-yellow ")
			.a("onclick", "$('#patchBankTransactionModal').show(); ")
			.f().sx("Modify the transactions")
		.g("button");
		{ e("div").a("id", "patchBankTransactionModal").a("class", "w3-modal ").f();
			{ e("div").a("class", "w3-modal-content w3-card-4 ").f();
				{ e("header").a("class", "w3-container w3-yellow ").f();
					e("span").a("class", "w3-button w3-display-topright ").a("onclick", "$('#patchBankTransactionModal').hide(); ").f().sx("×").g("span");
					e("h2").a("class", "w3-padding ").f().sx("Modify the transactions").g("h2");
				} g("header");
				{ e("div").a("class", "w3-container ").f();
					BankTransaction o = new BankTransaction();
					o.setSiteRequest_(siteRequest_);

					// FormFilters PATCH
					{ e("form").a("action", "").a("id", "patchBankTransactionFormFilters").a("onsubmit", "event.preventDefault(); return false; ").f();
						htmlFormSearchBankTransaction(o);
					} g("form");
					e("button")
						.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-yellow ")
						.a("onclick", "aSearchBankTransaction($('#patchBankTransactionFormFilters')); ")
						.f().sx("Search the a transaction")
					.g("button");


					// FormValues PATCH
					{ e("form").a("action", "").a("id", "patchBankTransactionFormValues").a("onsubmit", "event.preventDefault(); return false; ").f();
						htmlFormPATCHBankTransaction(o);
					} g("form");
					e("button")
						.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-yellow ")
						.a("onclick", "patchBankTransaction($('#patchBankTransactionFormFilters'), $('#patchBankTransactionFormValues'), function() {}, function() {}); ")
						.f().sx("Modify the transactions")
					.g("button");

				} g("div");
			} g("div");
		} g("div");


		if(listBankTransaction != null && listBankTransaction.size() == 1) {
			e("button")
				.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-yellow ")
				.a("onclick", "$('#deleteBankTransactionModal').show(); ")
				.f().sx("Delete the transactions")
			.g("button");
			{ e("div").a("id", "deleteBankTransactionModal").a("class", "w3-modal ").f();
				{ e("div").a("class", "w3-modal-content w3-card-4 ").f();
					{ e("header").a("class", "w3-container w3-yellow ").f();
						e("span").a("class", "w3-button w3-display-topright ").a("onclick", "$('#deleteBankTransactionModal').hide(); ").f().sx("×").g("span");
						e("h2").a("class", "w3-padding ").f().sx("Delete the transactions").g("h2");
					} g("header");
					{ e("div").a("class", "w3-container ").f();
						BankTransaction o = new BankTransaction();
						o.setSiteRequest_(siteRequest_);

						// Form DELETE
						{ e("div").a("id", "deleteBankTransactionForm").f();
							htmlFormPATCHBankTransaction(o);
						} g("div");
						e("button")
							.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-yellow ")
							.a("onclick", "deleteBankTransaction(", o.getPk(), "); ")
							.f().sx("Delete the transactions")
						.g("button");

					} g("div");
				} g("div");
			} g("div");

		}
		g("div");
	}

	/**
	**/
	public static void htmlSuggestTransactionGenPage(PageLayout p, String id) {
		{ p.e("div").a("class", "w3-cell-row ").f();
			{ p.e("div").a("class", "w3-cell ").f();
				{ p.e("a").a("href", "/transaction").a("class", "").f();
					p.e("i").a("class", "fad fa-cash-register w3-padding-small ").f().g("i");
					p.sx("see all the transactions");
				} p.g("a");
			} p.g("div");
			{ p.e("div").a("class", "w3-cell ").f();
				{ p.e("a").a("id", "refreshAllTransactionGenPage", id).a("href", "/transaction").a("class", "").a("onclick", "patchBankTransactionVals([], {}, function() { addGlow($('#refreshAllTransactionGenPage", id, "')); }, function() { addError($('#refreshAllTransactionGenPage", id, "')); }); return false; ").f();
					p.e("i").a("class", "fas fa-sync-alt w3-padding-small ").f().g("i");
					p.sx("refresh all the transactions");
				} p.g("a");
			} p.g("div");
		} p.g("div");
		{ p.e("div").a("class", "w3-cell-row w3-padding ").f();
			{ p.e("div").a("class", "w3-cell ").f();
				{ p.e("span").f();
					p.sx("search transactions: ");
				} p.g("span");
			} p.g("div");
		} p.g("div");
		{ p.e("div").a("class", "w3-cell-row w3-padding ").f();
			{ p.e("div").a("class", "w3-cell ").f();
				{ p.e("div").a("class", "w3-cell-row ").f();

					p.e("i").a("class", "far fa-search w3-xxlarge w3-cell w3-cell-middle ").f().g("i");
					{ p.e("form").a("action", "").a("id", "suggestFormBankTransaction", id).a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); window.location.href='/transaction?q=objectSuggest:' + encodeURIComponent($('#suggestBankTransaction", id, "').val()); return false; ").f();
						p.e("input")
							.a("type", "text")
							.a("class", "suggestBankTransaction w3-input w3-border w3-cell w3-cell-middle ")
							.a("name", "suggestBankTransaction")
							.a("id", "suggestBankTransaction", id)
							.a("autocomplete", "off")
							.a("oninput", "suggestBankTransactionObjectSuggest( [ { 'name': 'q', 'value': 'objectSuggest:' + $(this).val() } ], $('#suggestListBankTransaction", id, "'), ", p.getSiteRequest_().getRequestPk(), "); ")
							.fg();

					} p.g("form");
				} p.g("div");
			} p.g("div");
		} p.g("div");
		{ p.e("div").a("class", "w3-cell-row w3-padding ").f();
			{ p.e("div").a("class", "w3-cell w3-left-align w3-cell-top ").f();
				{ p.e("ul").a("class", "w3-ul w3-hoverable ").a("id", "suggestListBankTransaction", id).f();
				} p.g("ul");
			} p.g("div");
		} p.g("div");
	}

}
