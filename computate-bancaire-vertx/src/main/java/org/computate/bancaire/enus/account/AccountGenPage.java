package org.computate.bancaire.enus.account;

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
public class AccountGenPage extends AccountGenPageGen<ClusterPage> {

	/**
	 * {@inheritDoc}
	 * 
	 **/
	protected void _listBankAccount(Wrap<SearchList<BankAccount>> c) {
	}

	protected void _bankAccount(Wrap<BankAccount> c) {
		if(listBankAccount != null && listBankAccount.size() == 1)
			c.o(listBankAccount.get(0));
	}

	@Override protected void _pageH1(Wrap<String> c) {
			c.o("bank accounts");
	}

	@Override protected void _pageH2(Wrap<String> c) {
		c.o("");
	}

	@Override protected void _pageH3(Wrap<String> c) {
		c.o("");
	}

	@Override protected void _pageTitle(Wrap<String> c) {
		if(bankAccount != null && bankAccount.getAccountCompleteName() != null)
			c.o(bankAccount.getAccountCompleteName());
		else if(bankAccount != null)
			c.o("");
		else if(listBankAccount == null || listBankAccount.size() == 0)
			c.o("no account found");
	}

	@Override protected void _pageUri(Wrap<String> c) {
		c.o("/account");
	}

	@Override protected void _pageImageUri(Wrap<String> c) {
			c.o("/png/account-999.png");
	}

	@Override protected void _contextIconGroup(Wrap<String> c) {
			c.o("duotone");
	}

	@Override protected void _contextIconName(Wrap<String> c) {
			c.o("money-check");
	}

	@Override public void initDeepAccountGenPage() {
		initAccountGenPage();
		super.initDeepPageLayout();
	}

	@Override public void htmlScriptsAccountGenPage() {
		e("script").a("src", staticBaseUrl, "/js/enUS/AccountPage.js").f().g("script");
	}

	@Override public void htmlScriptAccountGenPage() {
		l("$(document).ready(function() {");
		tl(1, "window.eventBus = new EventBus('/eventbus');");
		tl(1, "var pk = ", siteRequest_.getRequestPk(), ";");
		tl(1, "websocketBankAccount(websocketBankAccountInner);");
		l("});");
	}

	public void htmlFormPageBankAccount(BankAccount o) {
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPk("Page");
			o.htmCreated("Page");
			o.htmModified("Page");
			o.htmObjectId("Page");
			o.htmAccountId("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmArchived("Page");
			o.htmDeleted("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmYearKeys("Page");
			o.htmAccountNumber("Page");
			o.htmAccountAdministratorName("Page");
			o.htmAccountLocation("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmAccountPhoneNumber("Page");
			o.htmAccountAddress("Page");
		} g("div");
	}

	public void htmlFormPOSTBankAccount(BankAccount o) {
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPk("POST");
			o.htmCreated("POST");
			o.htmModified("POST");
			o.htmObjectId("POST");
			o.htmAccountId("POST");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmArchived("POST");
			o.htmDeleted("POST");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmYearKeys("POST");
			o.htmAccountNumber("POST");
			o.htmAccountAdministratorName("POST");
			o.htmAccountLocation("POST");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmAccountPhoneNumber("POST");
			o.htmAccountAddress("POST");
		} g("div");
	}

	public void htmlFormPATCHBankAccount(BankAccount o) {
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPk("PATCH");
			o.htmCreated("PATCH");
			o.htmModified("PATCH");
			o.htmObjectId("PATCH");
			o.htmAccountId("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmArchived("PATCH");
			o.htmDeleted("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmYearKeys("PATCH");
			o.htmAccountNumber("PATCH");
			o.htmAccountAdministratorName("PATCH");
			o.htmAccountLocation("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmAccountPhoneNumber("PATCH");
			o.htmAccountAddress("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmAccountCompleteName("PATCH");
		} g("div");
	}

	public void htmlFormSearchBankAccount(BankAccount o) {
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPk("Recherche");
			o.htmCreated("Recherche");
			o.htmModified("Recherche");
			o.htmObjectId("Recherche");
			o.htmAccountId("Recherche");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmArchived("Recherche");
			o.htmDeleted("Recherche");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmYearKeys("Recherche");
			o.htmAccountNumber("Recherche");
			o.htmAccountAdministratorName("Recherche");
			o.htmAccountLocation("Recherche");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmAccountPhoneNumber("Recherche");
			o.htmAccountAddress("Recherche");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmAccountCompleteName("Recherche");
		} g("div");
	}

	@Override public void htmlBodyAccountGenPage() {

		OperationRequest operationRequest = siteRequest_.getOperationRequest();
		JsonObject params = operationRequest.getParams();
		if(listBankAccount == null || listBankAccount.size() == 0) {

			{ e("h1").f();
				{ e("a").a("href", "/account").a("class", "w3-bar-item w3-btn w3-center w3-block w3-gray w3-hover-gray ").f();
					if(contextIconCssClasses != null)
						e("i").a("class", contextIconCssClasses + " site-menu-icon ").f().g("i");
					e("span").a("class", " ").f().sx("bank accounts").g("span");
				} g("a");
			} g("h1");
			e("div").a("class", "w3-padding-16 w3-card-4 w3-light-grey ").f();
			{ e("h2").f();
				{ e("span").a("class", "w3-bar-item w3-padding w3-center w3-block w3-gray ").f();
					if(contextIconCssClasses != null)
						e("i").a("class", contextIconCssClasses + " site-menu-icon ").f().g("i");
					e("span").a("class", " ").f().sx("no account found").g("span");
				} g("span");
			} g("h2");
		} else if(listBankAccount != null && listBankAccount.size() == 1 && params.getJsonObject("query").getString("q").equals("*:*")) {
			BankAccount o = listBankAccount.get(0);
			siteRequest_.setRequestPk(o.getPk());
			if(StringUtils.isNotEmpty(pageH1)) {
				{ e("h1").f();
					{ e("a").a("href", "/account").a("class", "w3-bar-item w3-btn w3-center w3-block w3-gray w3-hover-gray ").f();
						if(contextIconCssClasses != null)
							e("i").a("class", contextIconCssClasses + " site-menu-icon ").f().g("i");
						e("span").a("class", " ").f().sx(pageH1).g("span");
					} g("a");
				} g("h1");
			}
			e("div").a("class", "w3-padding-16 w3-card-4 w3-light-grey ").f();
			if(StringUtils.isNotEmpty(pageH2)) {
				{ e("h2").f();
					{ e("span").a("class", "w3-bar-item w3-padding w3-center w3-block w3-gray ").f();
						e("span").a("class", " ").f().sx(pageH2).g("span");
					} g("span");
				} g("h2");
			}
			if(StringUtils.isNotEmpty(pageH3)) {
				{ e("h3").f();
					{ e("span").a("class", "w3-bar-item w3-padding w3-center w3-block w3-gray ").f();
						e("span").a("class", " ").f().sx(pageH3).g("span");
					} g("span");
				} g("h3");
			}
		} else {

				{ e("h1").f();
					{ e("a").a("href", "/account").a("class", "w3-bar-item w3-btn w3-center w3-block w3-gray w3-hover-gray ").f();
						if(contextIconCssClasses != null)
							e("i").a("class", contextIconCssClasses + " site-menu-icon ").f().g("i");
						e("span").a("class", " ").f().sx(pageH1).g("span");
					} g("a");
				} g("h1");
			e("div").a("class", "").f();
				{ e("div").f();
					Long num = listBankAccount.getQueryResponse().getResults().getNumFound();
					String query = StringUtils.replace(listBankAccount.getQuery(), "_suggested", "");
					Integer rows1 = listBankAccount.getRows();
					Integer start1 = listBankAccount.getStart();
					Integer start2 = start1 - rows1;
					Integer start3 = start1 + rows1;
					Integer rows2 = rows1 / 2;
					Integer rows3 = rows1 * 2;
					start2 = start2 < 0 ? 0 : start2;

					if(start1 == 0) {
						e("i").a("class", "fas fa-arrow-square-left w3-opacity ").f().g("i");
					} else {
						{ e("a").a("href", "/account?q=", query, "&start=", start2, "&rows=", rows1).f();
							e("i").a("class", "fas fa-arrow-square-left ").f().g("i");
						} g("a");
					}

					if(rows1 <= 1) {
						e("i").a("class", "fas fa-minus-square w3-opacity ").f().g("i");
					} else {
						{ e("a").a("href", "/account?q=", query, "&start=", start1, "&rows=", rows2).f();
							e("i").a("class", "fas fa-minus-square ").f().g("i");
						} g("a");
					}

					{ e("a").a("href", "/account?q=", query, "&start=", start1, "&rows=", rows3).f();
						e("i").a("class", "fas fa-plus-square ").f().g("i");
					} g("a");

					if(start3 >= num) {
						e("i").a("class", "fas fa-arrow-square-right w3-opacity ").f().g("i");
					} else {
						{ e("a").a("href", "/account?q=", query, "&start=", start3, "&rows=", rows1).f();
							e("i").a("class", "fas fa-arrow-square-right ").f().g("i");
						} g("a");
					}
						e("span").f().sx((start1 + 1), " - ", (start1 + rows1), " of ", num).g("span");
				} g("div");
			{ e("table").a("class", "w3-table w3-bordered w3-striped w3-border w3-hoverable ").f();
				{ e("thead").a("class", "w3-gray w3-hover-gray ").f();
					{ e("tr").f();
						e("th").f().sx("name").g("th");
						e("th").f().sx("created").g("th");
					} g("tr");
				} g("thead");
				{ e("tbody").f();
					Map<String, Map<String, List<String>>> highlighting = listBankAccount.getQueryResponse().getHighlighting();
					for(int i = 0; i < listBankAccount.size(); i++) {
						BankAccount o = listBankAccount.getList().get(i);
						Map<String, List<String>> highlights = highlighting == null ? null : highlighting.get(o.getId());
						List<String> highlightList = highlights == null ? null : highlights.get(highlights.keySet().stream().findFirst().orElse(null));
						String uri = "/account/" + o.getPk();
						{ e("tr").f();
							{ e("td").f();
								{ e("a").a("href", uri).f();
									e("i").a("class", "fad fa-money-check w3-padding-small ").f().g("i");
									{ e("span").f();
										sx(o.strAccountCompleteName());
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

		if(listBankAccount != null && listBankAccount.size() == 1 && params.getJsonObject("query").getString("q").equals("*:*")) {
			BankAccount o = listBankAccount.first();

			{ e("div").a("class", "").f();

				if(o.getPk() != null) {
					{ e("form").a("action", "").a("id", "BankAccountForm").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
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
					htmlFormPageBankAccount(o);
				}

				if(o != null)
					o.htmlBody();

			} g("div");

		}
		htmlBodyFormsAccountGenPage();
		htmlSuggestAccountGenPage(this, null);
		g("div");
	}

	public void htmlBodyFormsAccountGenPage() {
		e("div").a("class", "w3-margin-top ").f();

		{ e("button")
			.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-gray ")
				.a("id", "refreshThisAccountGenPage")
				.a("onclick", "patchBankAccountVals( [ {name: 'fq', value: 'pk:' + " + siteRequest_.getRequestPk() + " } ], {}, function() { addGlow($('#refreshThisAccountGenPage')); }, function() { addError($('#refreshThisAccountGenPage')); }); return false; ").f();
				e("i").a("class", "fas fa-sync-alt w3-padding-small ").f().g("i");
			sx("refresh this account");
		} g("button");

		e("button")
			.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-gray ")
			.a("onclick", "$('#postBankAccountModal').show(); ")
			.f().sx("Create an account")
		.g("button");
		{ e("div").a("id", "postBankAccountModal").a("class", "w3-modal ").f();
			{ e("div").a("class", "w3-modal-content w3-card-4 ").f();
				{ e("header").a("class", "w3-container w3-gray ").f();
					e("span").a("class", "w3-button w3-display-topright ").a("onclick", "$('#postBankAccountModal').hide(); ").f().sx("×").g("span");
					e("h2").a("class", "w3-padding ").f().sx("Create an account").g("h2");
				} g("header");
				{ e("div").a("class", "w3-container ").f();
					BankAccount o = new BankAccount();
					o.setSiteRequest_(siteRequest_);

					// Form POST
					{ e("div").a("id", "postBankAccountForm").f();
						htmlFormPOSTBankAccount(o);
					} g("div");
					e("button")
						.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-gray ")
						.a("onclick", "postBankAccount($('#postBankAccountForm')); ")
						.f().sx("Create an account")
					.g("button");

				} g("div");
			} g("div");
		} g("div");


		e("button")
			.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-gray ")
			.a("onclick", "$('#patchBankAccountModal').show(); ")
			.f().sx("Modify the accounts")
		.g("button");
		{ e("div").a("id", "patchBankAccountModal").a("class", "w3-modal ").f();
			{ e("div").a("class", "w3-modal-content w3-card-4 ").f();
				{ e("header").a("class", "w3-container w3-gray ").f();
					e("span").a("class", "w3-button w3-display-topright ").a("onclick", "$('#patchBankAccountModal').hide(); ").f().sx("×").g("span");
					e("h2").a("class", "w3-padding ").f().sx("Modify the accounts").g("h2");
				} g("header");
				{ e("div").a("class", "w3-container ").f();
					BankAccount o = new BankAccount();
					o.setSiteRequest_(siteRequest_);

					// FormFilters PATCH
					{ e("form").a("action", "").a("id", "patchBankAccountFormFilters").a("onsubmit", "event.preventDefault(); return false; ").f();
						htmlFormSearchBankAccount(o);
					} g("form");
					e("button")
						.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-gray ")
						.a("onclick", "aSearchBankAccount($('#patchBankAccountFormFilters')); ")
						.f().sx("Search the an account")
					.g("button");


					// FormValues PATCH
					{ e("form").a("action", "").a("id", "patchBankAccountFormValues").a("onsubmit", "event.preventDefault(); return false; ").f();
						htmlFormPATCHBankAccount(o);
					} g("form");
					e("button")
						.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-gray ")
						.a("onclick", "patchBankAccount($('#patchBankAccountFormFilters'), $('#patchBankAccountFormValues'), function() {}, function() {}); ")
						.f().sx("Modify the accounts")
					.g("button");

				} g("div");
			} g("div");
		} g("div");


		if(listBankAccount != null && listBankAccount.size() == 1) {
			e("button")
				.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-gray ")
				.a("onclick", "$('#deleteBankAccountModal').show(); ")
				.f().sx("Delete the accounts")
			.g("button");
			{ e("div").a("id", "deleteBankAccountModal").a("class", "w3-modal ").f();
				{ e("div").a("class", "w3-modal-content w3-card-4 ").f();
					{ e("header").a("class", "w3-container w3-gray ").f();
						e("span").a("class", "w3-button w3-display-topright ").a("onclick", "$('#deleteBankAccountModal').hide(); ").f().sx("×").g("span");
						e("h2").a("class", "w3-padding ").f().sx("Delete the accounts").g("h2");
					} g("header");
					{ e("div").a("class", "w3-container ").f();
						BankAccount o = new BankAccount();
						o.setSiteRequest_(siteRequest_);

						// Form DELETE
						{ e("div").a("id", "deleteBankAccountForm").f();
							htmlFormPATCHBankAccount(o);
						} g("div");
						e("button")
							.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-gray ")
							.a("onclick", "deleteBankAccount(", o.getPk(), "); ")
							.f().sx("Delete the accounts")
						.g("button");

					} g("div");
				} g("div");
			} g("div");

		}
		g("div");
	}

	/**
	**/
	public static void htmlSuggestAccountGenPage(PageLayout p, String id) {
		{ p.e("div").a("class", "w3-cell-row ").f();
			{ p.e("div").a("class", "w3-cell ").f();
				{ p.e("a").a("href", "/account").a("class", "").f();
					p.e("i").a("class", "fad fa-money-check w3-padding-small ").f().g("i");
					p.sx("see all the accounts");
				} p.g("a");
			} p.g("div");
			{ p.e("div").a("class", "w3-cell ").f();
				{ p.e("a").a("id", "refreshAllAccountGenPage", id).a("href", "/account").a("class", "").a("onclick", "patchBankAccountVals([], {}, function() { addGlow($('#refreshAllAccountGenPage", id, "')); }, function() { addError($('#refreshAllAccountGenPage", id, "')); }); return false; ").f();
					p.e("i").a("class", "fas fa-sync-alt w3-padding-small ").f().g("i");
					p.sx("refresh all the accounts");
				} p.g("a");
			} p.g("div");
		} p.g("div");
		{ p.e("div").a("class", "w3-cell-row w3-padding ").f();
			{ p.e("div").a("class", "w3-cell ").f();
				{ p.e("span").f();
					p.sx("search bank accounts: ");
				} p.g("span");
			} p.g("div");
		} p.g("div");
		{ p.e("div").a("class", "w3-cell-row w3-padding ").f();
			{ p.e("div").a("class", "w3-cell ").f();
				{ p.e("div").a("class", "w3-cell-row ").f();

					p.e("i").a("class", "far fa-search w3-xxlarge w3-cell w3-cell-middle ").f().g("i");
					{ p.e("form").a("action", "").a("id", "suggestFormBankAccount", id).a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); window.location.href='/account?q=objectSuggest:' + encodeURIComponent($('#suggestBankAccount", id, "').val()); return false; ").f();
						p.e("input")
							.a("type", "text")
							.a("class", "suggestBankAccount w3-input w3-border w3-cell w3-cell-middle ")
							.a("name", "suggestBankAccount")
							.a("id", "suggestBankAccount", id)
							.a("autocomplete", "off")
							.a("oninput", "suggestBankAccountObjectSuggest( [ { 'name': 'q', 'value': 'objectSuggest:' + $(this).val() } ], $('#suggestListBankAccount", id, "'), ", p.getSiteRequest_().getRequestPk(), "); ")
							.fg();

					} p.g("form");
				} p.g("div");
			} p.g("div");
		} p.g("div");
		{ p.e("div").a("class", "w3-cell-row w3-padding ").f();
			{ p.e("div").a("class", "w3-cell w3-left-align w3-cell-top ").f();
				{ p.e("ul").a("class", "w3-ul w3-hoverable ").a("id", "suggestListBankAccount", id).f();
				} p.g("ul");
			} p.g("div");
		} p.g("div");
	}

}
