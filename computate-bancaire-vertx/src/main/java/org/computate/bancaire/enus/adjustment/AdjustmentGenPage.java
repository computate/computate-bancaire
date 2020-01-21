package org.computate.bancaire.enus.adjustment;

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
public class AdjustmentGenPage extends AdjustmentGenPageGen<ClusterPage> {

	/**
	 * {@inheritDoc}
	 * 
	 **/
	protected void _listBankAdjustment(Wrap<SearchList<BankAdjustment>> c) {
	}

	protected void _bankAdjustment(Wrap<BankAdjustment> c) {
		if(listBankAdjustment != null && listBankAdjustment.size() == 1)
			c.o(listBankAdjustment.get(0));
	}

	@Override protected void _pageH1(Wrap<String> c) {
			c.o("adjustments");
	}

	@Override protected void _pageH2(Wrap<String> c) {
		c.o("");
	}

	@Override protected void _pageH3(Wrap<String> c) {
		c.o("");
	}

	@Override protected void _pageTitle(Wrap<String> c) {
		if(bankAdjustment != null && bankAdjustment.getAdjustmentCompleteName() != null)
			c.o(bankAdjustment.getAdjustmentCompleteName());
		else if(bankAdjustment != null)
			c.o("");
		else if(listBankAdjustment == null || listBankAdjustment.size() == 0)
			c.o("no adjustment found");
	}

	@Override protected void _pageUri(Wrap<String> c) {
		c.o("/ajustement");
	}

	@Override protected void _pageImageUri(Wrap<String> c) {
			c.o("/png/ajustement-999.png");
	}

	@Override protected void _contextIconGroup(Wrap<String> c) {
			c.o("duotone");
	}

	@Override protected void _contextIconName(Wrap<String> c) {
			c.o("cash-register");
	}

	@Override public void initDeepAdjustmentGenPage() {
		initAdjustmentGenPage();
		super.initDeepPageLayout();
	}

	@Override public void htmlScriptsAdjustmentGenPage() {
		e("script").a("src", staticBaseUrl, "/js/enUS/AdjustmentPage.js").f().g("script");
	}

	@Override public void htmlScriptAdjustmentGenPage() {
		l("$(document).ready(function() {");
		tl(1, "window.eventBus = new EventBus('/eventbus');");
		tl(1, "var pk = ", siteRequest_.getRequestPk(), ";");
		tl(1, "websocketBankAdjustment(websocketBankAdjustmentInner);");
		l("});");
	}

	public void htmlFormPageBankAdjustment(BankAdjustment o) {
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPk("Page");
			o.htmCreated("Page");
			o.htmModified("Page");
			o.htmObjectId("Page");
			o.htmAdjustmentId("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmArchived("Page");
			o.htmDeleted("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmAccountKey("Page");
			o.htmTransactionKey("Page");
			o.htmAdjustmentDisplayName("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmAgentAreas("Page");
			o.htmAgentRoles("Page");
			o.htmAgentOverride("Page");
			o.htmEligibleEntitlement("Page");
			o.htmPartnerName("Page");
		} g("div");
	}

	public void htmlFormPOSTBankAdjustment(BankAdjustment o) {
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPk("POST");
			o.htmCreated("POST");
			o.htmModified("POST");
			o.htmObjectId("POST");
			o.htmAdjustmentId("POST");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmArchived("POST");
			o.htmDeleted("POST");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmAccountKey("POST");
			o.htmTransactionKey("POST");
			o.htmAdjustmentDisplayName("POST");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmAgentAreas("POST");
			o.htmAgentRoles("POST");
			o.htmAgentOverride("POST");
			o.htmEligibleEntitlement("POST");
			o.htmPartnerName("POST");
		} g("div");
	}

	public void htmlFormPATCHBankAdjustment(BankAdjustment o) {
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPk("PATCH");
			o.htmCreated("PATCH");
			o.htmModified("PATCH");
			o.htmObjectId("PATCH");
			o.htmAdjustmentId("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmArchived("PATCH");
			o.htmDeleted("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmAccountKey("PATCH");
			o.htmTransactionKey("PATCH");
			o.htmAdjustmentDisplayName("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmAgentAreas("PATCH");
			o.htmAgentRoles("PATCH");
			o.htmAgentOverride("PATCH");
			o.htmEligibleEntitlement("PATCH");
			o.htmPartnerName("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmAdjustmentCompleteName("PATCH");
		} g("div");
	}

	public void htmlFormSearchBankAdjustment(BankAdjustment o) {
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPk("Recherche");
			o.htmCreated("Recherche");
			o.htmModified("Recherche");
			o.htmObjectId("Recherche");
			o.htmAdjustmentId("Recherche");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmArchived("Recherche");
			o.htmDeleted("Recherche");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmAccountKey("Recherche");
			o.htmTransactionKey("Recherche");
			o.htmAdjustmentDisplayName("Recherche");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmAgentAreas("Recherche");
			o.htmAgentRoles("Recherche");
			o.htmAgentOverride("Recherche");
			o.htmEligibleEntitlement("Recherche");
			o.htmPartnerName("Recherche");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmAdjustmentCompleteName("Recherche");
		} g("div");
	}

	@Override public void htmlBodyAdjustmentGenPage() {

		OperationRequest operationRequest = siteRequest_.getOperationRequest();
		JsonObject params = operationRequest.getParams();
		if(listBankAdjustment == null || listBankAdjustment.size() == 0) {

			{ e("h1").f();
				{ e("a").a("href", "/ajustement").a("class", "w3-bar-item w3-btn w3-center w3-block w3-yellow w3-hover-yellow ").f();
					if(contextIconCssClasses != null)
						e("i").a("class", contextIconCssClasses + " site-menu-icon ").f().g("i");
					e("span").a("class", " ").f().sx("adjustments").g("span");
				} g("a");
			} g("h1");
			e("div").a("class", "w3-padding-16 w3-card-4 w3-light-grey ").f();
			{ e("h2").f();
				{ e("span").a("class", "w3-bar-item w3-padding w3-center w3-block w3-yellow ").f();
					if(contextIconCssClasses != null)
						e("i").a("class", contextIconCssClasses + " site-menu-icon ").f().g("i");
					e("span").a("class", " ").f().sx("no adjustment found").g("span");
				} g("span");
			} g("h2");
		} else if(listBankAdjustment != null && listBankAdjustment.size() == 1 && params.getJsonObject("query").getString("q").equals("*:*")) {
			BankAdjustment o = listBankAdjustment.get(0);
			siteRequest_.setRequestPk(o.getPk());
			if(StringUtils.isNotEmpty(pageH1)) {
				{ e("h1").f();
					{ e("a").a("href", "/ajustement").a("class", "w3-bar-item w3-btn w3-center w3-block w3-yellow w3-hover-yellow ").f();
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
					{ e("a").a("href", "/ajustement").a("class", "w3-bar-item w3-btn w3-center w3-block w3-yellow w3-hover-yellow ").f();
						if(contextIconCssClasses != null)
							e("i").a("class", contextIconCssClasses + " site-menu-icon ").f().g("i");
						e("span").a("class", " ").f().sx(pageH1).g("span");
					} g("a");
				} g("h1");
			e("div").a("class", "").f();
				{ e("div").f();
					Long num = listBankAdjustment.getQueryResponse().getResults().getNumFound();
					String query = StringUtils.replace(listBankAdjustment.getQuery(), "_suggested", "");
					Integer rows1 = listBankAdjustment.getRows();
					Integer start1 = listBankAdjustment.getStart();
					Integer start2 = start1 - rows1;
					Integer start3 = start1 + rows1;
					Integer rows2 = rows1 / 2;
					Integer rows3 = rows1 * 2;
					start2 = start2 < 0 ? 0 : start2;

					if(start1 == 0) {
						e("i").a("class", "fas fa-arrow-square-left w3-opacity ").f().g("i");
					} else {
						{ e("a").a("href", "/ajustement?q=", query, "&start=", start2, "&rows=", rows1).f();
							e("i").a("class", "fas fa-arrow-square-left ").f().g("i");
						} g("a");
					}

					if(rows1 <= 1) {
						e("i").a("class", "fas fa-minus-square w3-opacity ").f().g("i");
					} else {
						{ e("a").a("href", "/ajustement?q=", query, "&start=", start1, "&rows=", rows2).f();
							e("i").a("class", "fas fa-minus-square ").f().g("i");
						} g("a");
					}

					{ e("a").a("href", "/ajustement?q=", query, "&start=", start1, "&rows=", rows3).f();
						e("i").a("class", "fas fa-plus-square ").f().g("i");
					} g("a");

					if(start3 >= num) {
						e("i").a("class", "fas fa-arrow-square-right w3-opacity ").f().g("i");
					} else {
						{ e("a").a("href", "/ajustement?q=", query, "&start=", start3, "&rows=", rows1).f();
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
					Map<String, Map<String, List<String>>> highlighting = listBankAdjustment.getQueryResponse().getHighlighting();
					for(int i = 0; i < listBankAdjustment.size(); i++) {
						BankAdjustment o = listBankAdjustment.getList().get(i);
						Map<String, List<String>> highlights = highlighting == null ? null : highlighting.get(o.getId());
						List<String> highlightList = highlights == null ? null : highlights.get(highlights.keySet().stream().findFirst().orElse(null));
						String uri = "/ajustement/" + o.getPk();
						{ e("tr").f();
							{ e("td").f();
								{ e("a").a("href", uri).f();
									e("i").a("class", "fad fa-cash-register w3-padding-small ").f().g("i");
									{ e("span").f();
										sx(o.strAdjustmentCompleteName());
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

		if(listBankAdjustment != null && listBankAdjustment.size() == 1 && params.getJsonObject("query").getString("q").equals("*:*")) {
			BankAdjustment o = listBankAdjustment.first();

			{ e("div").a("class", "").f();

				if(o.getPk() != null) {
					{ e("form").a("action", "").a("id", "BankAdjustmentForm").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
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
					htmlFormPageBankAdjustment(o);
				}

			} g("div");

		}
		htmlBodyFormsAdjustmentGenPage();
		htmlSuggestAdjustmentGenPage(this, null);
		g("div");
	}

	public void htmlBodyFormsAdjustmentGenPage() {
		e("div").a("class", "w3-margin-top ").f();

		{ e("button")
			.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-yellow ")
				.a("id", "refreshThisAdjustmentGenPage")
				.a("onclick", "patchBankAdjustmentVals( [ {name: 'fq', value: 'pk:' + " + siteRequest_.getRequestPk() + " } ], {}, function() { addGlow($('#refreshThisAdjustmentGenPage')); }, function() { addError($('#refreshThisAdjustmentGenPage')); }); return false; ").f();
				e("i").a("class", "fas fa-sync-alt w3-padding-small ").f().g("i");
			sx("refresh this adjustment");
		} g("button");

		e("button")
			.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-yellow ")
			.a("onclick", "$('#postBankAdjustmentModal').show(); ")
			.f().sx("Create an adjustment")
		.g("button");
		{ e("div").a("id", "postBankAdjustmentModal").a("class", "w3-modal ").f();
			{ e("div").a("class", "w3-modal-content w3-card-4 ").f();
				{ e("header").a("class", "w3-container w3-yellow ").f();
					e("span").a("class", "w3-button w3-display-topright ").a("onclick", "$('#postBankAdjustmentModal').hide(); ").f().sx("×").g("span");
					e("h2").a("class", "w3-padding ").f().sx("Create an adjustment").g("h2");
				} g("header");
				{ e("div").a("class", "w3-container ").f();
					BankAdjustment o = new BankAdjustment();
					o.setSiteRequest_(siteRequest_);

					// Form POST
					{ e("div").a("id", "postBankAdjustmentForm").f();
						htmlFormPOSTBankAdjustment(o);
					} g("div");
					e("button")
						.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-yellow ")
						.a("onclick", "postBankAdjustment($('#postBankAdjustmentForm')); ")
						.f().sx("Create an adjustment")
					.g("button");

				} g("div");
			} g("div");
		} g("div");


		e("button")
			.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-yellow ")
			.a("onclick", "$('#patchBankAdjustmentModal').show(); ")
			.f().sx("Modify the adjustments")
		.g("button");
		{ e("div").a("id", "patchBankAdjustmentModal").a("class", "w3-modal ").f();
			{ e("div").a("class", "w3-modal-content w3-card-4 ").f();
				{ e("header").a("class", "w3-container w3-yellow ").f();
					e("span").a("class", "w3-button w3-display-topright ").a("onclick", "$('#patchBankAdjustmentModal').hide(); ").f().sx("×").g("span");
					e("h2").a("class", "w3-padding ").f().sx("Modify the adjustments").g("h2");
				} g("header");
				{ e("div").a("class", "w3-container ").f();
					BankAdjustment o = new BankAdjustment();
					o.setSiteRequest_(siteRequest_);

					// FormFilters PATCH
					{ e("form").a("action", "").a("id", "patchBankAdjustmentFormFilters").a("onsubmit", "event.preventDefault(); return false; ").f();
						htmlFormSearchBankAdjustment(o);
					} g("form");
					e("button")
						.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-yellow ")
						.a("onclick", "aSearchBankAdjustment($('#patchBankAdjustmentFormFilters')); ")
						.f().sx("Search the an adjustment")
					.g("button");


					// FormValues PATCH
					{ e("form").a("action", "").a("id", "patchBankAdjustmentFormValues").a("onsubmit", "event.preventDefault(); return false; ").f();
						htmlFormPATCHBankAdjustment(o);
					} g("form");
					e("button")
						.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-yellow ")
						.a("onclick", "patchBankAdjustment($('#patchBankAdjustmentFormFilters'), $('#patchBankAdjustmentFormValues'), function() {}, function() {}); ")
						.f().sx("Modify the adjustments")
					.g("button");

				} g("div");
			} g("div");
		} g("div");


		if(listBankAdjustment != null && listBankAdjustment.size() == 1) {
			e("button")
				.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-yellow ")
				.a("onclick", "$('#deleteBankAdjustmentModal').show(); ")
				.f().sx("Delete the adjustments")
			.g("button");
			{ e("div").a("id", "deleteBankAdjustmentModal").a("class", "w3-modal ").f();
				{ e("div").a("class", "w3-modal-content w3-card-4 ").f();
					{ e("header").a("class", "w3-container w3-yellow ").f();
						e("span").a("class", "w3-button w3-display-topright ").a("onclick", "$('#deleteBankAdjustmentModal').hide(); ").f().sx("×").g("span");
						e("h2").a("class", "w3-padding ").f().sx("Delete the adjustments").g("h2");
					} g("header");
					{ e("div").a("class", "w3-container ").f();
						BankAdjustment o = new BankAdjustment();
						o.setSiteRequest_(siteRequest_);

						// Form DELETE
						{ e("div").a("id", "deleteBankAdjustmentForm").f();
							htmlFormPATCHBankAdjustment(o);
						} g("div");
						e("button")
							.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-yellow ")
							.a("onclick", "deleteBankAdjustment(", o.getPk(), "); ")
							.f().sx("Delete the adjustments")
						.g("button");

					} g("div");
				} g("div");
			} g("div");

		}
		g("div");
	}

	/**
	**/
	public static void htmlSuggestAdjustmentGenPage(PageLayout p, String id) {
		{ p.e("div").a("class", "w3-cell-row ").f();
			{ p.e("div").a("class", "w3-cell ").f();
				{ p.e("a").a("href", "/ajustement").a("class", "").f();
					p.e("i").a("class", "fad fa-cash-register w3-padding-small ").f().g("i");
					p.sx("see all the adjustments");
				} p.g("a");
			} p.g("div");
			{ p.e("div").a("class", "w3-cell ").f();
				{ p.e("a").a("id", "refreshAllAdjustmentGenPage", id).a("href", "/ajustement").a("class", "").a("onclick", "patchBankAdjustmentVals([], {}, function() { addGlow($('#refreshAllAdjustmentGenPage", id, "')); }, function() { addError($('#refreshAllAdjustmentGenPage", id, "')); }); return false; ").f();
					p.e("i").a("class", "fas fa-sync-alt w3-padding-small ").f().g("i");
					p.sx("refresh all the adjustments");
				} p.g("a");
			} p.g("div");
		} p.g("div");
		{ p.e("div").a("class", "w3-cell-row w3-padding ").f();
			{ p.e("div").a("class", "w3-cell ").f();
				{ p.e("span").f();
					p.sx("search adjustments: ");
				} p.g("span");
			} p.g("div");
		} p.g("div");
		{ p.e("div").a("class", "w3-cell-row w3-padding ").f();
			{ p.e("div").a("class", "w3-cell ").f();
				{ p.e("div").a("class", "w3-cell-row ").f();

					p.e("i").a("class", "far fa-search w3-xxlarge w3-cell w3-cell-middle ").f().g("i");
					{ p.e("form").a("action", "").a("id", "suggestFormBankAdjustment", id).a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); window.location.href='/ajustement?q=objectSuggest:' + encodeURIComponent($('#suggestBankAdjustment", id, "').val()); return false; ").f();
						p.e("input")
							.a("type", "text")
							.a("class", "suggestBankAdjustment w3-input w3-border w3-cell w3-cell-middle ")
							.a("name", "suggestBankAdjustment")
							.a("id", "suggestBankAdjustment", id)
							.a("autocomplete", "off")
							.a("oninput", "suggestBankAdjustmentObjectSuggest( [ { 'name': 'q', 'value': 'objectSuggest:' + $(this).val() } ], $('#suggestListBankAdjustment", id, "'), ", p.getSiteRequest_().getRequestPk(), "); ")
							.fg();

					} p.g("form");
				} p.g("div");
			} p.g("div");
		} p.g("div");
		{ p.e("div").a("class", "w3-cell-row w3-padding ").f();
			{ p.e("div").a("class", "w3-cell w3-left-align w3-cell-top ").f();
				{ p.e("ul").a("class", "w3-ul w3-hoverable ").a("id", "suggestListBankAdjustment", id).f();
				} p.g("ul");
			} p.g("div");
		} p.g("div");
	}

}
