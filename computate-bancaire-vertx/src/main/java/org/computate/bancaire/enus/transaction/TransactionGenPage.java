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
		tl(1, "suggestBankTransactionAccountKey($('#formBankTransactionAccountKey'), $('#listBankTransactionAccountKey')); ");
		l("});");
	}

	public void htmlFormPageBankTransaction(BankTransaction o) {
		{ e("div").a("class", "w3-cell-row ").f();
			{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
				{ e("div").a("class", "w3-padding ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-yellow ").f();
							e("label").a("class", "").f().sx("primary key").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row  ").f();
							{ e("div").a("class", "w3-cell ").f();
								{ e("div").a("class", "w3-rest ").f();
									e("span").f().sx(o.strPk()).g("span");
								} g("div");
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			} g("div");
			{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
				{ e("div").a("class", "w3-padding ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-yellow ").f();
							e("label").a("class", "").f().sx("created").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row  ").f();
							{ e("div").a("class", "w3-cell ").f();
								{ e("div").a("class", "w3-rest ").f();
									e("span").f().sx(o.strCreated()).g("span");
								} g("div");
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			} g("div");
			{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
				{ e("div").a("class", "w3-padding ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-yellow ").f();
							e("label").a("class", "").f().sx("modified").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row  ").f();
							{ e("div").a("class", "w3-cell ").f();
								{ e("div").a("class", "w3-rest ").f();
									e("span").f().sx(o.strModified()).g("span");
								} g("div");
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			} g("div");
			{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
				{ e("div").a("class", "w3-padding ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-yellow ").f();
							e("label").a("class", "").f().sx("ID").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row  ").f();
							{ e("div").a("class", "w3-cell ").f();
								{ e("div").a("class", "w3-rest ").f();
									e("span").f().sx(o.strTransactionId()).g("span");
								} g("div");
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			} g("div");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
				{ e("div").a("class", "w3-padding ").f();
					{ e("form").a("action", "").a("id", "formBankTransactionAccountKey").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
						e("input")
							.a("type", "hidden")
							.a("name", "valueYearKeys")
							.a("class", "valueYearKeys ")
							.a("value", siteRequest_.getRequestPk())
							.fg();
					} g("form");
					{ e("form").a("action", "").a("id", "suggestBankTransactionAccountKey").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
						{ e("div").a("class", "w3-card ").f();
							{ e("div").a("class", "w3-cell-row ").f();
								{ e("a").a("href", "/account").a("class", "w3-cell w3-btn w3-center h4 w3-block h4 w3-gray w3-hover-gray ").f();
									e("i").a("class", "fad fa-money-check w3-padding-small ").f().g("i");
									sx("account");
								} g("a");
							} g("div");
							{ e("div").a("class", "w3-cell-row ").f();
								{ e("h5").a("class", "w3-cell ").f();
									sx("relate an account to this transaction");
								} g("h5");
							} g("div");
							{ e("div").a("class", "w3-cell-row w3-padding ").f();
								{ e("div").a("class", "w3-cell ").f();
									{ e("div").a("class", "w3-cell-row ").f();

									e("i").a("class", "far fa-search w3-xxlarge w3-cell w3-cell-middle ").f().g("i");
										e("input")
											.a("type", "text")
											.a("placeholder", "account")
											.a("class", "valueObjectSuggest suggestAccountKey w3-input w3-border w3-cell w3-cell-middle ")
											.a("name", "setAccountKey")
											.a("id", "Page_accountKey")
											.a("autocomplete", "off")
											.a("oninput", "suggestBankTransactionAccountKey($('#' + ($(this).val() ? 'suggest' : 'form') + 'BankTransactionAccountKey'), $('#listBankTransactionAccountKey')); ")
										.fg();

									} g("div");
								} g("div");
							} g("div");
							{ e("div").a("class", "w3-cell-row w3-padding ").f();
								{ e("div").a("class", "w3-cell w3-left-align w3-cell-top ").f();
									{ e("ul").a("class", "w3-ul w3-hoverable ").a("id", "listBankTransactionAccountKey").f();
									} g("ul");
									{ e("div").a("class", "w3-cell-row ").f();
										e("button")
											.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-gray ")
											.a("onclick", "postBankAccountVals({ yearKeys: [ \"", o.getPk(), "\" ] }, function() { patchBankTransactionVals([{ name: 'fq', value: 'pk:", o.getPk(), "' }], {}, function() { suggestBankTransactionAccountKey($('#' + ($('#Page_accountKey').val() ? 'suggest' : 'form') + 'BankTransactionAccountKey'), $('#listBankTransactionAccountKey')); var $e = $('#Page_accountKey'); $e.html($e.val()); }, function() { addError($('#Page_accountKey')); }); }, function() { addError($('#Page_accountKey')); });")
											.f().sx("add an account")
										.g("button");
									} g("div");
								} g("div");
							} g("div");
						} g("div");
					} g("form");
				} g("div");
			} g("div");
			{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
				{ e("div").a("class", "w3-padding ").f();
					{ e("form").a("action", "").a("id", "formBankTransactionTransactionCode").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
						e("input")
							.a("type", "hidden")
							.a("name", "value")
							.a("class", "value ")
							.a("value", siteRequest_.getRequestPk())
							.fg();
					} g("form");
					{ e("form").a("action", "").a("id", "suggestBankTransactionTransactionCode").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
						{ e("div").a("class", "w3-card ").f();
							{ e("div").a("class", "w3-cell-row w3-yellow ").f();
								e("label").a("for", "Page_transactionCode").a("class", "").f().sx("transaction code").g("label");
							} g("div");
							{ e("div").a("class", "w3-cell-row w3-padding ").f();
								{ e("div").a("class", "w3-cell ").f();

									e("input")
										.a("type", "text")
										.a("placeholder", "transaction code")
										.a("class", "setTransactionCode w3-input w3-border ")
										.a("name", "setTransactionCode")
										.a("id", "Page_transactionCode")
										.a("onclick", "removeGlow($(this)); ")
										.a("onchange", "patchBankTransactionVal([{ name: 'fq', value: 'pk:' + $('#BankTransactionForm :input[name=\"pk\"]').val() }], 'setTransactionCode', $(this).val(), function() { addGlow($('#Page_transactionCode')); }, function() { addError($('#Page_transactionCode')); }); ")
										.a("value", o.strTransactionCode())
									.fg();

								} g("div");
								{ e("div").a("class", "w3-cell w3-left-align w3-cell-top ").f();
									{ e("button")
										.a("tabindex", "-1")
										.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-bar-item w3-yellow ")
									.a("onclick", "removeGlow($('#Page_transactionCode')); $('#Page_transactionCode').val(null); patchBankTransactionVal([{ name: 'fq', value: 'pk:' + $('#BankTransactionForm :input[name=\"pk\"]').val() }], 'setTransactionCode', null, function() { addGlow($('#Page_transactionCode')); }, function() { addError($('#Page_transactionCode')); }); ")
										.f();
										e("i").a("class", "far fa-eraser ").f().g("i");
									} g("button");
								} g("div");
							} g("div");
						} g("div");
					} g("form");
				} g("div");
			} g("div");
			{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
				{ e("div").a("class", "w3-padding ").f();
					{ e("form").a("action", "").a("id", "formBankTransactionTransactionFee").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
						e("input")
							.a("type", "hidden")
							.a("name", "value")
							.a("class", "value ")
							.a("value", siteRequest_.getRequestPk())
							.fg();
					} g("form");
					{ e("form").a("action", "").a("id", "suggestBankTransactionTransactionFee").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
						{ e("div").a("class", "w3-card ").f();
							{ e("div").a("class", "w3-cell-row w3-yellow ").f();
								e("label").a("for", "Page_transactionFee").a("class", "").f().sx("fee transaction").g("label");
							} g("div");
							{ e("div").a("class", "w3-cell-row w3-padding ").f();
								{ e("div").a("class", "w3-cell ").f();

									e("input")
										.a("type", "checkbox")
										.a("value", "true")
										.a("class", "setTransactionFee")
										.a("name", "setTransactionFee")
										.a("id", "Page_transactionFee")
										.a("onchange", "patchBankTransactionVal([{ name: 'fq', value: 'pk:' + $('#BankTransactionForm :input[name=\"pk\"]').val() }], 'setTransactionFee', $(this).prop('checked'), function() { addGlow($('#Page_transactionFee')); }, function() { addError($('#Page_transactionFee')); }); ")
										;
										if(o.getTransactionFee() != null && o.getTransactionFee())
											a("checked", "checked");
									fg();

								} g("div");
							} g("div");
						} g("div");
					} g("form");
				} g("div");
			} g("div");
			{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
				{ e("div").a("class", "w3-padding ").f();
					{ e("form").a("action", "").a("id", "formBankTransactionTransactionDisplayName").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
						e("input")
							.a("type", "hidden")
							.a("name", "value")
							.a("class", "value ")
							.a("value", siteRequest_.getRequestPk())
							.fg();
					} g("form");
					{ e("form").a("action", "").a("id", "suggestBankTransactionTransactionDisplayName").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
						{ e("div").a("class", "w3-card ").f();
							{ e("div").a("class", "w3-cell-row w3-yellow ").f();
								e("label").a("for", "Page_transactionDisplayName").a("class", "").f().sx("display name").g("label");
							} g("div");
							{ e("div").a("class", "w3-cell-row w3-padding ").f();
								{ e("div").a("class", "w3-cell ").f();

									e("input")
										.a("type", "text")
										.a("placeholder", "display name")
										.a("class", "setTransactionDisplayName w3-input w3-border ")
										.a("name", "setTransactionDisplayName")
										.a("id", "Page_transactionDisplayName")
										.a("onclick", "removeGlow($(this)); ")
										.a("onchange", "patchBankTransactionVal([{ name: 'fq', value: 'pk:' + $('#BankTransactionForm :input[name=\"pk\"]').val() }], 'setTransactionDisplayName', $(this).val(), function() { addGlow($('#Page_transactionDisplayName')); }, function() { addError($('#Page_transactionDisplayName')); }); ")
										.a("value", o.strTransactionDisplayName())
									.fg();

								} g("div");
								{ e("div").a("class", "w3-cell w3-left-align w3-cell-top ").f();
									{ e("button")
										.a("tabindex", "-1")
										.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-bar-item w3-yellow ")
									.a("onclick", "removeGlow($('#Page_transactionDisplayName')); $('#Page_transactionDisplayName').val(null); patchBankTransactionVal([{ name: 'fq', value: 'pk:' + $('#BankTransactionForm :input[name=\"pk\"]').val() }], 'setTransactionDisplayName', null, function() { addGlow($('#Page_transactionDisplayName')); }, function() { addError($('#Page_transactionDisplayName')); }); ")
										.f();
										e("i").a("class", "far fa-eraser ").f().g("i");
									} g("button");
								} g("div");
							} g("div");
						} g("div");
					} g("form");
				} g("div");
			} g("div");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
				{ e("div").a("class", "w3-padding ").f();
					{ e("form").a("action", "").a("id", "formBankTransactionTransactionReferenceId").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
						e("input")
							.a("type", "hidden")
							.a("name", "value")
							.a("class", "value ")
							.a("value", siteRequest_.getRequestPk())
							.fg();
					} g("form");
					{ e("form").a("action", "").a("id", "suggestBankTransactionTransactionReferenceId").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
						{ e("div").a("class", "w3-card ").f();
							{ e("div").a("class", "w3-cell-row w3-yellow ").f();
								e("label").a("for", "Page_transactionReferenceId").a("class", "").f().sx("transaction reference ID").g("label");
							} g("div");
							{ e("div").a("class", "w3-cell-row w3-padding ").f();
								{ e("div").a("class", "w3-cell ").f();

									e("input")
										.a("type", "text")
										.a("placeholder", "transaction reference ID")
										.a("class", "setTransactionReferenceId w3-input w3-border ")
										.a("name", "setTransactionReferenceId")
										.a("id", "Page_transactionReferenceId")
										.a("onclick", "removeGlow($(this)); ")
										.a("onchange", "patchBankTransactionVal([{ name: 'fq', value: 'pk:' + $('#BankTransactionForm :input[name=\"pk\"]').val() }], 'setTransactionReferenceId', $(this).val(), function() { addGlow($('#Page_transactionReferenceId')); }, function() { addError($('#Page_transactionReferenceId')); }); ")
										.a("value", o.strTransactionReferenceId())
									.fg();

								} g("div");
								{ e("div").a("class", "w3-cell w3-left-align w3-cell-top ").f();
									{ e("button")
										.a("tabindex", "-1")
										.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-bar-item w3-yellow ")
									.a("onclick", "removeGlow($('#Page_transactionReferenceId')); $('#Page_transactionReferenceId').val(null); patchBankTransactionVal([{ name: 'fq', value: 'pk:' + $('#BankTransactionForm :input[name=\"pk\"]').val() }], 'setTransactionReferenceId', null, function() { addGlow($('#Page_transactionReferenceId')); }, function() { addError($('#Page_transactionReferenceId')); }); ")
										.f();
										e("i").a("class", "far fa-eraser ").f().g("i");
									} g("button");
								} g("div");
							} g("div");
						} g("div");
					} g("form");
				} g("div");
			} g("div");
			{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
				{ e("div").a("class", "w3-padding ").f();
					{ e("form").a("action", "").a("id", "formBankTransactionTransactionAmount").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
						e("input")
							.a("type", "hidden")
							.a("name", "value")
							.a("class", "value ")
							.a("value", siteRequest_.getRequestPk())
							.fg();
					} g("form");
					{ e("form").a("action", "").a("id", "suggestBankTransactionTransactionAmount").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
						{ e("div").a("class", "w3-card ").f();
							{ e("div").a("class", "w3-cell-row w3-yellow ").f();
								e("label").a("for", "Page_transactionAmount").a("class", "").f().sx("date and time of the transaction").g("label");
							} g("div");
							{ e("div").a("class", "w3-cell-row w3-padding ").f();
								{ e("div").a("class", "w3-cell ").f();

									e("input")
										.a("type", "text")
										.a("placeholder", "date and time of the transaction")
										.a("class", "setTransactionAmount w3-input w3-border ")
										.a("name", "setTransactionAmount")
										.a("id", "Page_transactionAmount")
										.a("onclick", "removeGlow($(this)); ")
										.a("onchange", "patchBankTransactionVal([{ name: 'fq', value: 'pk:' + $('#BankTransactionForm :input[name=\"pk\"]').val() }], 'setTransactionAmount', $(this).val(), function() { addGlow($('#Page_transactionAmount')); }, function() { addError($('#Page_transactionAmount')); }); ")
										.a("value", o.strTransactionAmount())
									.fg();

								} g("div");
								{ e("div").a("class", "w3-cell w3-left-align w3-cell-top ").f();
									{ e("button")
										.a("tabindex", "-1")
										.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-bar-item w3-yellow ")
									.a("onclick", "removeGlow($('#Page_transactionAmount')); $('#Page_transactionAmount').val(null); patchBankTransactionVal([{ name: 'fq', value: 'pk:' + $('#BankTransactionForm :input[name=\"pk\"]').val() }], 'setTransactionAmount', null, function() { addGlow($('#Page_transactionAmount')); }, function() { addError($('#Page_transactionAmount')); }); ")
										.f();
										e("i").a("class", "far fa-eraser ").f().g("i");
									} g("button");
								} g("div");
							} g("div");
						} g("div");
					} g("form");
				} g("div");
			} g("div");
			{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
				{ e("div").a("class", "w3-padding ").f();
					{ e("form").a("action", "").a("id", "formBankTransactionTransactionDateTime").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
						e("input")
							.a("type", "hidden")
							.a("name", "value")
							.a("class", "value ")
							.a("value", siteRequest_.getRequestPk())
							.fg();
					} g("form");
					{ e("form").a("action", "").a("id", "suggestBankTransactionTransactionDateTime").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
						{ e("div").a("class", "w3-card ").f();
							ZonedDateTime val = o.getTransactionDateTime();

							{ e("div").a("class", "w3-cell-row w3-yellow ").f();
								e("label").a("for", "Page_transactionDateTime").a("class", "").f().sx("date and time of the transaction").g("label");
							} g("div");
							{ e("div").a("class", "w3-cell-row w3-padding ").f();
								{ e("div").a("class", "w3-cell ").f();
									e("input")
										.a("type", "text")
										.a("class", "w3-input w3-border datepicker ")
										.a("placeholder", "MM/DD/YYYY")
										.a("data-timeformat", "MM/DD/YYYY")
										.a("id", "Page_transactionDateTime")
										.a("onclick", "removeGlow($(this)); ")
										.a("value", val == null ? "" : DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.forLanguageTag("en-US")).format(val))
										.a("onchange", "var t = moment(this.value, 'MM/DD/YYYY'); if(t) { var s = t.format('MM/DD/YYYY'); patchBankTransactionVal([{ name: 'fq', value: 'pk:' + $('#BankTransactionForm :input[name=\"pk\"]').val() }], 'setTransactionDateTime', s, function() { addGlow($('#Page_transactionDateTime')); }, function() { addError($('#Page_transactionDateTime')); }); } ")
										.fg();
										} g("div");
								{ e("div").a("class", "w3-cell w3-left-align w3-cell-top ").f();
									{ e("button")
										.a("tabindex", "-1")
										.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-bar-item w3-yellow ")
									.a("onclick", "removeGlow($('#Page_transactionDateTime')); $('#Page_transactionDateTime').val(null); patchBankTransactionVal([{ name: 'fq', value: 'pk:' + $('#BankTransactionForm :input[name=\"pk\"]').val() }], 'setTransactionDateTime', null, function() { addGlow($('#Page_transactionDateTime')); }, function() { addError($('#Page_transactionDateTime')); }); ")
										.f();
										e("i").a("class", "far fa-eraser ").f().g("i");
									} g("button");
								} g("div");
							} g("div");
						} g("div");
					} g("form");
				} g("div");
			} g("div");
		} g("div");
	}

	public void htmlFormPOSTBankTransaction(BankTransaction o) {
		{ e("div").a("class", "w3-cell-row ").f();
			{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("class", "w3-card ").f();
					{ e("div").a("class", "w3-cell-row w3-yellow ").f();
						e("label").a("class", "").f().sx("primary key").g("label");
					} g("div");
					{ e("div").a("class", "w3-cell-row  ").f();
						{ e("div").a("class", "w3-cell ").f();
							{ e("div").a("class", "w3-rest ").f();
								e("span").f().sx(o.strPk()).g("span");
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			} g("div");
			} g("div");
			{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("class", "w3-card ").f();
					{ e("div").a("class", "w3-cell-row w3-yellow ").f();
						e("label").a("class", "").f().sx("created").g("label");
					} g("div");
					{ e("div").a("class", "w3-cell-row  ").f();
						{ e("div").a("class", "w3-cell ").f();
							{ e("div").a("class", "w3-rest ").f();
								e("span").f().sx(o.strCreated()).g("span");
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			} g("div");
			} g("div");
			{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("class", "w3-card ").f();
					{ e("div").a("class", "w3-cell-row w3-yellow ").f();
						e("label").a("class", "").f().sx("modified").g("label");
					} g("div");
					{ e("div").a("class", "w3-cell-row  ").f();
						{ e("div").a("class", "w3-cell ").f();
							{ e("div").a("class", "w3-rest ").f();
								e("span").f().sx(o.strModified()).g("span");
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			} g("div");
			} g("div");
			{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("class", "w3-card ").f();
					{ e("div").a("class", "w3-cell-row w3-yellow ").f();
						e("label").a("class", "").f().sx("ID").g("label");
					} g("div");
					{ e("div").a("class", "w3-cell-row  ").f();
						{ e("div").a("class", "w3-cell ").f();
							{ e("div").a("class", "w3-rest ").f();
								e("span").f().sx(o.strTransactionId()).g("span");
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			} g("div");
			} g("div");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("form").a("action", "").a("id", "formBankTransactionAccountKey").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
					e("input")
						.a("type", "hidden")
						.a("name", "valueYearKeys")
						.a("class", "valueYearKeys ")
						.a("value", siteRequest_.getRequestPk())
						.fg();
				} g("form");
				{ e("form").a("action", "").a("id", "suggestBankTransactionAccountKey").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row ").f();
							{ e("a").a("href", "/account").a("class", "w3-cell w3-btn w3-center h4 w3-block h4 w3-gray w3-hover-gray ").f();
								e("i").a("class", "fad fa-money-check w3-padding-small ").f().g("i");
								sx("account");
							} g("a");
						} g("div");
						{ e("div").a("class", "w3-cell-row ").f();
							{ e("h5").a("class", "w3-cell ").f();
								sx("relate an account to this transaction");
							} g("h5");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();
								{ e("div").a("class", "w3-cell-row ").f();

								e("i").a("class", "far fa-search w3-xxlarge w3-cell w3-cell-middle ").f().g("i");
									e("input")
										.a("type", "text")
										.a("placeholder", "account")
										.a("class", "valueObjectSuggest suggestAccountKey w3-input w3-border w3-cell w3-cell-middle ")
										.a("name", "setAccountKey")
										.a("id", "POST_accountKey")
										.a("autocomplete", "off")
										.a("oninput", "suggestBankTransactionAccountKey($('#' + ($(this).val() ? 'suggest' : 'form') + 'BankTransactionAccountKey'), $('#listBankTransactionAccountKey')); ")
									.fg();

								} g("div");
							} g("div");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell w3-left-align w3-cell-top ").f();
								{ e("ul").a("class", "w3-ul w3-hoverable ").a("id", "listBankTransactionAccountKey").f();
								} g("ul");
								{ e("div").a("class", "w3-cell-row ").f();
									e("button")
										.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-gray ")
										.a("onclick", "postBankAccountVals({ yearKeys: [ \"", o.getPk(), "\" ] }, function() { patchBankTransactionVals([{ name: 'fq', value: 'pk:", o.getPk(), "' }], {}, function() { suggestBankTransactionAccountKey($('#' + ($('#POST_accountKey').val() ? 'suggest' : 'form') + 'BankTransactionAccountKey'), $('#listBankTransactionAccountKey')); var $e = $('#POST_accountKey'); $e.html($e.val()); }, function() { addError($('#POST_accountKey')); }); }, function() { addError($('#POST_accountKey')); });")
										.f().sx("add an account")
									.g("button");
								} g("div");
							} g("div");
						} g("div");
					} g("div");
				} g("form");
			} g("div");
			} g("div");
			{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("form").a("action", "").a("id", "formBankTransactionTransactionCode").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
					e("input")
						.a("type", "hidden")
						.a("name", "value")
						.a("class", "value ")
						.a("value", siteRequest_.getRequestPk())
						.fg();
				} g("form");
				{ e("form").a("action", "").a("id", "suggestBankTransactionTransactionCode").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-yellow ").f();
							e("label").a("for", "POST_transactionCode").a("class", "").f().sx("transaction code").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								e("input")
									.a("type", "text")
									.a("placeholder", "transaction code")
									.a("class", "valueTransactionCode w3-input w3-border ")
									.a("name", "transactionCode")
									.a("id", "POST_transactionCode")
									.a("value", o.strTransactionCode())
								.fg();

							} g("div");
						} g("div");
					} g("div");
				} g("form");
			} g("div");
			} g("div");
			{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("form").a("action", "").a("id", "formBankTransactionTransactionFee").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
					e("input")
						.a("type", "hidden")
						.a("name", "value")
						.a("class", "value ")
						.a("value", siteRequest_.getRequestPk())
						.fg();
				} g("form");
				{ e("form").a("action", "").a("id", "suggestBankTransactionTransactionFee").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-yellow ").f();
							e("label").a("for", "POST_transactionFee").a("class", "").f().sx("fee transaction").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								e("input")
									.a("type", "checkbox")
									.a("value", "true")
									.a("class", "valueTransactionFee")
									.a("name", "transactionFee")
									.a("id", "POST_transactionFee")
									;
									if(o.getTransactionFee() != null && o.getTransactionFee())
										a("checked", "checked");
								fg();

							} g("div");
						} g("div");
					} g("div");
				} g("form");
			} g("div");
			} g("div");
			{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("form").a("action", "").a("id", "formBankTransactionTransactionDisplayName").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
					e("input")
						.a("type", "hidden")
						.a("name", "value")
						.a("class", "value ")
						.a("value", siteRequest_.getRequestPk())
						.fg();
				} g("form");
				{ e("form").a("action", "").a("id", "suggestBankTransactionTransactionDisplayName").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-yellow ").f();
							e("label").a("for", "POST_transactionDisplayName").a("class", "").f().sx("display name").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								e("input")
									.a("type", "text")
									.a("placeholder", "display name")
									.a("class", "valueTransactionDisplayName w3-input w3-border ")
									.a("name", "transactionDisplayName")
									.a("id", "POST_transactionDisplayName")
									.a("value", o.strTransactionDisplayName())
								.fg();

							} g("div");
						} g("div");
					} g("div");
				} g("form");
			} g("div");
			} g("div");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("form").a("action", "").a("id", "formBankTransactionTransactionReferenceId").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
					e("input")
						.a("type", "hidden")
						.a("name", "value")
						.a("class", "value ")
						.a("value", siteRequest_.getRequestPk())
						.fg();
				} g("form");
				{ e("form").a("action", "").a("id", "suggestBankTransactionTransactionReferenceId").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-yellow ").f();
							e("label").a("for", "POST_transactionReferenceId").a("class", "").f().sx("transaction reference ID").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								e("input")
									.a("type", "text")
									.a("placeholder", "transaction reference ID")
									.a("class", "valueTransactionReferenceId w3-input w3-border ")
									.a("name", "transactionReferenceId")
									.a("id", "POST_transactionReferenceId")
									.a("value", o.strTransactionReferenceId())
								.fg();

							} g("div");
						} g("div");
					} g("div");
				} g("form");
			} g("div");
			} g("div");
			{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("form").a("action", "").a("id", "formBankTransactionTransactionAmount").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
					e("input")
						.a("type", "hidden")
						.a("name", "value")
						.a("class", "value ")
						.a("value", siteRequest_.getRequestPk())
						.fg();
				} g("form");
				{ e("form").a("action", "").a("id", "suggestBankTransactionTransactionAmount").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-yellow ").f();
							e("label").a("for", "POST_transactionAmount").a("class", "").f().sx("date and time of the transaction").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								e("input")
									.a("type", "text")
									.a("placeholder", "date and time of the transaction")
									.a("class", "valueTransactionAmount w3-input w3-border ")
									.a("name", "transactionAmount")
									.a("id", "POST_transactionAmount")
									.a("value", o.strTransactionAmount())
								.fg();

							} g("div");
						} g("div");
					} g("div");
				} g("form");
			} g("div");
			} g("div");
			{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("form").a("action", "").a("id", "formBankTransactionTransactionDateTime").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
					e("input")
						.a("type", "hidden")
						.a("name", "value")
						.a("class", "value ")
						.a("value", siteRequest_.getRequestPk())
						.fg();
				} g("form");
				{ e("form").a("action", "").a("id", "suggestBankTransactionTransactionDateTime").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
					{ e("div").a("class", "w3-card ").f();
						ZonedDateTime val = o.getTransactionDateTime();

						{ e("div").a("class", "w3-cell-row w3-yellow ").f();
							e("label").a("for", "POST_transactionDateTime").a("class", "").f().sx("date and time of the transaction").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();
								e("input")
									.a("type", "text")
									.a("class", "w3-input w3-border datepicker ")
									.a("placeholder", "MM/DD/YYYY")
									.a("data-timeformat", "MM/DD/YYYY")
									.a("id", "POST_transactionDateTime")
									.a("onclick", "removeGlow($(this)); ")
									.a("value", val == null ? "" : DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.forLanguageTag("en-US")).format(val))
									.a("onchange", "var t = moment(this.value, 'MM/DD/YYYY'); if(t) { var s = t.format('MM/DD/YYYY'); patchBankTransactionVal([{ name: 'fq', value: 'pk:' + $('#BankTransactionForm :input[name=\"pk\"]').val() }], 'setTransactionDateTime', s, function() { addGlow($('#POST_transactionDateTime')); }, function() { addError($('#POST_transactionDateTime')); }); } ")
									.fg();
									} g("div");
						} g("div");
					} g("div");
				} g("form");
			} g("div");
			} g("div");
		} g("div");
	}

	public void htmlFormPATCHBankTransaction(BankTransaction o) {
		{ e("div").a("class", "w3-cell-row ").f();
			{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("class", "w3-card ").f();
					{ e("div").a("class", "w3-cell-row w3-yellow ").f();
						e("label").a("class", "").f().sx("primary key").g("label");
					} g("div");
					{ e("div").a("class", "w3-cell-row  ").f();
						{ e("div").a("class", "w3-cell ").f();
							{ e("div").a("class", "w3-rest ").f();
								e("span").f().sx(o.strPk()).g("span");
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			} g("div");
			} g("div");
			{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("class", "w3-card ").f();
					{ e("div").a("class", "w3-cell-row w3-yellow ").f();
						e("label").a("class", "").f().sx("created").g("label");
					} g("div");
					{ e("div").a("class", "w3-cell-row  ").f();
						{ e("div").a("class", "w3-cell ").f();
							{ e("div").a("class", "w3-rest ").f();
								e("span").f().sx(o.strCreated()).g("span");
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			} g("div");
			} g("div");
			{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("class", "w3-card ").f();
					{ e("div").a("class", "w3-cell-row w3-yellow ").f();
						e("label").a("class", "").f().sx("modified").g("label");
					} g("div");
					{ e("div").a("class", "w3-cell-row  ").f();
						{ e("div").a("class", "w3-cell ").f();
							{ e("div").a("class", "w3-rest ").f();
								e("span").f().sx(o.strModified()).g("span");
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			} g("div");
			} g("div");
			{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("class", "w3-card ").f();
					{ e("div").a("class", "w3-cell-row w3-yellow ").f();
						e("label").a("class", "").f().sx("ID").g("label");
					} g("div");
					{ e("div").a("class", "w3-cell-row  ").f();
						{ e("div").a("class", "w3-cell ").f();
							{ e("div").a("class", "w3-rest ").f();
								e("span").f().sx(o.strTransactionId()).g("span");
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			} g("div");
			} g("div");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("form").a("action", "").a("id", "formBankTransactionAccountKey").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
					e("input")
						.a("type", "hidden")
						.a("name", "valueYearKeys")
						.a("class", "valueYearKeys ")
						.a("value", siteRequest_.getRequestPk())
						.fg();
				} g("form");
				{ e("form").a("action", "").a("id", "suggestBankTransactionAccountKey").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row ").f();
							{ e("a").a("href", "/account").a("class", "w3-cell w3-btn w3-center h4 w3-block h4 w3-gray w3-hover-gray ").f();
								e("i").a("class", "fad fa-money-check w3-padding-small ").f().g("i");
								sx("account");
							} g("a");
						} g("div");
						{ e("div").a("class", "w3-cell-row ").f();
							{ e("h5").a("class", "w3-cell ").f();
								sx("relate an account to this transaction");
							} g("h5");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();
								{ e("div").a("class", "w3-cell-row ").f();

								e("i").a("class", "far fa-search w3-xxlarge w3-cell w3-cell-middle ").f().g("i");
									e("input")
										.a("type", "text")
										.a("placeholder", "account")
										.a("class", "valueObjectSuggest suggestAccountKey w3-input w3-border w3-cell w3-cell-middle ")
										.a("name", "setAccountKey")
										.a("id", "PATCH_accountKey")
										.a("autocomplete", "off")
										.a("oninput", "suggestBankTransactionAccountKey($('#' + ($(this).val() ? 'suggest' : 'form') + 'BankTransactionAccountKey'), $('#listBankTransactionAccountKey')); ")
									.fg();

								} g("div");
							} g("div");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell w3-left-align w3-cell-top ").f();
								{ e("ul").a("class", "w3-ul w3-hoverable ").a("id", "listBankTransactionAccountKey").f();
								} g("ul");
								{ e("div").a("class", "w3-cell-row ").f();
									e("button")
										.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-gray ")
										.a("onclick", "postBankAccountVals({ yearKeys: [ \"", o.getPk(), "\" ] }, function() { patchBankTransactionVals([{ name: 'fq', value: 'pk:", o.getPk(), "' }], {}, function() { suggestBankTransactionAccountKey($('#' + ($('#PATCH_accountKey').val() ? 'suggest' : 'form') + 'BankTransactionAccountKey'), $('#listBankTransactionAccountKey')); var $e = $('#PATCH_accountKey'); $e.html($e.val()); }, function() { addError($('#PATCH_accountKey')); }); }, function() { addError($('#PATCH_accountKey')); });")
										.f().sx("add an account")
									.g("button");
								} g("div");
							} g("div");
						} g("div");
					} g("div");
				} g("form");
			} g("div");
			} g("div");
			{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("form").a("action", "").a("id", "formBankTransactionTransactionCode").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
					e("input")
						.a("type", "hidden")
						.a("name", "value")
						.a("class", "value ")
						.a("value", siteRequest_.getRequestPk())
						.fg();
				} g("form");
				{ e("form").a("action", "").a("id", "suggestBankTransactionTransactionCode").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-yellow ").f();
							e("label").a("for", "PATCH_transactionCode").a("class", "").f().sx("transaction code").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								e("input")
									.a("type", "text")
									.a("placeholder", "transaction code")
									.a("class", "setTransactionCode w3-input w3-border ")
									.a("name", "setTransactionCode")
									.a("id", "PATCH_transactionCode")
									.a("value", o.strTransactionCode())
								.fg();

							} g("div");
						} g("div");
					} g("div");
				} g("form");
			} g("div");
			} g("div");
			{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("form").a("action", "").a("id", "formBankTransactionTransactionFee").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
					e("input")
						.a("type", "hidden")
						.a("name", "value")
						.a("class", "value ")
						.a("value", siteRequest_.getRequestPk())
						.fg();
				} g("form");
				{ e("form").a("action", "").a("id", "suggestBankTransactionTransactionFee").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-yellow ").f();
							e("label").a("for", "PATCH_transactionFee").a("class", "").f().sx("fee transaction").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								e("input")
									.a("type", "checkbox")
									.a("value", "true")
									.a("class", "setTransactionFee")
									.a("name", "setTransactionFee")
									.a("id", "PATCH_transactionFee")
									;
									if(o.getTransactionFee() != null && o.getTransactionFee())
										a("checked", "checked");
								fg();

							} g("div");
						} g("div");
					} g("div");
				} g("form");
			} g("div");
			} g("div");
			{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("form").a("action", "").a("id", "formBankTransactionTransactionDisplayName").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
					e("input")
						.a("type", "hidden")
						.a("name", "value")
						.a("class", "value ")
						.a("value", siteRequest_.getRequestPk())
						.fg();
				} g("form");
				{ e("form").a("action", "").a("id", "suggestBankTransactionTransactionDisplayName").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-yellow ").f();
							e("label").a("for", "PATCH_transactionDisplayName").a("class", "").f().sx("display name").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								e("input")
									.a("type", "text")
									.a("placeholder", "display name")
									.a("class", "setTransactionDisplayName w3-input w3-border ")
									.a("name", "setTransactionDisplayName")
									.a("id", "PATCH_transactionDisplayName")
									.a("value", o.strTransactionDisplayName())
								.fg();

							} g("div");
						} g("div");
					} g("div");
				} g("form");
			} g("div");
			} g("div");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("form").a("action", "").a("id", "formBankTransactionTransactionReferenceId").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
					e("input")
						.a("type", "hidden")
						.a("name", "value")
						.a("class", "value ")
						.a("value", siteRequest_.getRequestPk())
						.fg();
				} g("form");
				{ e("form").a("action", "").a("id", "suggestBankTransactionTransactionReferenceId").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-yellow ").f();
							e("label").a("for", "PATCH_transactionReferenceId").a("class", "").f().sx("transaction reference ID").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								e("input")
									.a("type", "text")
									.a("placeholder", "transaction reference ID")
									.a("class", "setTransactionReferenceId w3-input w3-border ")
									.a("name", "setTransactionReferenceId")
									.a("id", "PATCH_transactionReferenceId")
									.a("value", o.strTransactionReferenceId())
								.fg();

							} g("div");
						} g("div");
					} g("div");
				} g("form");
			} g("div");
			} g("div");
			{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("form").a("action", "").a("id", "formBankTransactionTransactionAmount").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
					e("input")
						.a("type", "hidden")
						.a("name", "value")
						.a("class", "value ")
						.a("value", siteRequest_.getRequestPk())
						.fg();
				} g("form");
				{ e("form").a("action", "").a("id", "suggestBankTransactionTransactionAmount").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-yellow ").f();
							e("label").a("for", "PATCH_transactionAmount").a("class", "").f().sx("date and time of the transaction").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								e("input")
									.a("type", "text")
									.a("placeholder", "date and time of the transaction")
									.a("class", "setTransactionAmount w3-input w3-border ")
									.a("name", "setTransactionAmount")
									.a("id", "PATCH_transactionAmount")
									.a("value", o.strTransactionAmount())
								.fg();

							} g("div");
						} g("div");
					} g("div");
				} g("form");
			} g("div");
			} g("div");
			{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("form").a("action", "").a("id", "formBankTransactionTransactionDateTime").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
					e("input")
						.a("type", "hidden")
						.a("name", "value")
						.a("class", "value ")
						.a("value", siteRequest_.getRequestPk())
						.fg();
				} g("form");
				{ e("form").a("action", "").a("id", "suggestBankTransactionTransactionDateTime").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
					{ e("div").a("class", "w3-card ").f();
						ZonedDateTime val = o.getTransactionDateTime();

						{ e("div").a("class", "w3-cell-row w3-yellow ").f();
							e("label").a("for", "PATCH_transactionDateTime").a("class", "").f().sx("date and time of the transaction").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();
								e("input")
									.a("type", "text")
									.a("class", "w3-input w3-border datepicker ")
									.a("placeholder", "MM/DD/YYYY")
									.a("data-timeformat", "MM/DD/YYYY")
									.a("id", "PATCH_transactionDateTime")
									.a("onclick", "removeGlow($(this)); ")
									.a("value", val == null ? "" : DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.forLanguageTag("en-US")).format(val))
									.a("onchange", "var t = moment(this.value, 'MM/DD/YYYY'); if(t) { var s = t.format('MM/DD/YYYY'); patchBankTransactionVal([{ name: 'fq', value: 'pk:' + $('#BankTransactionForm :input[name=\"pk\"]').val() }], 'setTransactionDateTime', s, function() { addGlow($('#PATCH_transactionDateTime')); }, function() { addError($('#PATCH_transactionDateTime')); }); } ")
									.fg();
									} g("div");
						} g("div");
					} g("div");
				} g("form");
			} g("div");
			} g("div");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("class", "w3-card ").f();
					{ e("div").a("class", "w3-cell-row  ").f();
						{ e("div").a("class", "w3-cell ").f();
							{ e("div").a("class", "w3-rest ").f();
								e("span").f().sx(o.strTransactionCompleteName()).g("span");
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			} g("div");
			} g("div");
		} g("div");
	}

	public void htmlFormSearchBankTransaction(BankTransaction o) {
		{ e("div").a("class", "w3-cell-row ").f();
			{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("class", "w3-card ").f();
					{ e("div").a("class", "w3-cell-row w3-yellow ").f();
						e("label").a("class", "").f().sx("primary key").g("label");
					} g("div");
					{ e("div").a("class", "w3-cell-row  ").f();
						{ e("div").a("class", "w3-cell ").f();
							{ e("div").a("class", "w3-rest ").f();
								e("span").f().sx(o.strPk()).g("span");
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			} g("div");
			} g("div");
			{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("class", "w3-card ").f();
					{ e("div").a("class", "w3-cell-row w3-yellow ").f();
						e("label").a("class", "").f().sx("created").g("label");
					} g("div");
					{ e("div").a("class", "w3-cell-row  ").f();
						{ e("div").a("class", "w3-cell ").f();
							{ e("div").a("class", "w3-rest ").f();
								e("span").f().sx(o.strCreated()).g("span");
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			} g("div");
			} g("div");
			{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("class", "w3-card ").f();
					{ e("div").a("class", "w3-cell-row w3-yellow ").f();
						e("label").a("class", "").f().sx("modified").g("label");
					} g("div");
					{ e("div").a("class", "w3-cell-row  ").f();
						{ e("div").a("class", "w3-cell ").f();
							{ e("div").a("class", "w3-rest ").f();
								e("span").f().sx(o.strModified()).g("span");
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			} g("div");
			} g("div");
			{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("class", "w3-card ").f();
					{ e("div").a("class", "w3-cell-row w3-yellow ").f();
						e("label").a("class", "").f().sx("ID").g("label");
					} g("div");
					{ e("div").a("class", "w3-cell-row  ").f();
						{ e("div").a("class", "w3-cell ").f();
							{ e("div").a("class", "w3-rest ").f();
								e("span").f().sx(o.strTransactionId()).g("span");
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			} g("div");
			} g("div");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("form").a("action", "").a("id", "formBankTransactionAccountKey").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
					e("input")
						.a("type", "hidden")
						.a("name", "valueYearKeys")
						.a("class", "valueYearKeys ")
						.a("value", siteRequest_.getRequestPk())
						.fg();
				} g("form");
				{ e("form").a("action", "").a("id", "suggestBankTransactionAccountKey").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row ").f();
							{ e("a").a("href", "/account").a("class", "w3-cell w3-btn w3-center h4 w3-block h4 w3-gray w3-hover-gray ").f();
								e("i").a("class", "fad fa-money-check w3-padding-small ").f().g("i");
								sx("account");
							} g("a");
						} g("div");
						{ e("div").a("class", "w3-cell-row ").f();
							{ e("h5").a("class", "w3-cell ").f();
								sx("relate an account to this transaction");
							} g("h5");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();
								{ e("div").a("class", "w3-cell-row ").f();

								e("i").a("class", "far fa-search w3-xxlarge w3-cell w3-cell-middle ").f().g("i");
									e("input")
										.a("type", "text")
										.a("placeholder", "account")
										.a("class", "valueObjectSuggest suggestAccountKey w3-input w3-border w3-cell w3-cell-middle ")
										.a("name", "setAccountKey")
										.a("id", "Recherche_accountKey")
										.a("autocomplete", "off")
										.a("oninput", "suggestBankTransactionAccountKey($('#' + ($(this).val() ? 'suggest' : 'form') + 'BankTransactionAccountKey'), $('#listBankTransactionAccountKey')); ")
									.fg();

								} g("div");
							} g("div");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell w3-left-align w3-cell-top ").f();
								{ e("ul").a("class", "w3-ul w3-hoverable ").a("id", "listBankTransactionAccountKey").f();
								} g("ul");
								{ e("div").a("class", "w3-cell-row ").f();
									e("button")
										.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-gray ")
										.a("onclick", "postBankAccountVals({ yearKeys: [ \"", o.getPk(), "\" ] }, function() { patchBankTransactionVals([{ name: 'fq', value: 'pk:", o.getPk(), "' }], {}, function() { suggestBankTransactionAccountKey($('#' + ($('#Recherche_accountKey').val() ? 'suggest' : 'form') + 'BankTransactionAccountKey'), $('#listBankTransactionAccountKey')); var $e = $('#Recherche_accountKey'); $e.html($e.val()); }, function() { addError($('#Recherche_accountKey')); }); }, function() { addError($('#Recherche_accountKey')); });")
										.f().sx("add an account")
									.g("button");
								} g("div");
							} g("div");
						} g("div");
					} g("div");
				} g("form");
			} g("div");
			} g("div");
			{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("form").a("action", "").a("id", "formBankTransactionTransactionCode").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
					e("input")
						.a("type", "hidden")
						.a("name", "value")
						.a("class", "value ")
						.a("value", siteRequest_.getRequestPk())
						.fg();
				} g("form");
				{ e("form").a("action", "").a("id", "suggestBankTransactionTransactionCode").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-yellow ").f();
							e("label").a("for", "Recherche_transactionCode").a("class", "").f().sx("transaction code").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								e("input")
									.a("type", "text")
									.a("placeholder", "transaction code")
									.a("class", "valueTransactionCode w3-input w3-border ")
									.a("name", "transactionCode")
									.a("id", "Recherche_transactionCode")
									.a("value", o.strTransactionCode())
								.fg();

							} g("div");
						} g("div");
					} g("div");
				} g("form");
			} g("div");
			} g("div");
			{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("form").a("action", "").a("id", "formBankTransactionTransactionFee").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
					e("input")
						.a("type", "hidden")
						.a("name", "value")
						.a("class", "value ")
						.a("value", siteRequest_.getRequestPk())
						.fg();
				} g("form");
				{ e("form").a("action", "").a("id", "suggestBankTransactionTransactionFee").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-yellow ").f();
							e("label").a("for", "Recherche_transactionFee").a("class", "").f().sx("fee transaction").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								e("input")
									.a("type", "checkbox")
									.a("value", "true")
									.a("class", "valueTransactionFee")
									.a("name", "transactionFee")
									.a("id", "Recherche_transactionFee")
									;
									if(o.getTransactionFee() != null && o.getTransactionFee())
										a("checked", "checked");
								fg();

							} g("div");
						} g("div");
					} g("div");
				} g("form");
			} g("div");
			} g("div");
			{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("form").a("action", "").a("id", "formBankTransactionTransactionDisplayName").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
					e("input")
						.a("type", "hidden")
						.a("name", "value")
						.a("class", "value ")
						.a("value", siteRequest_.getRequestPk())
						.fg();
				} g("form");
				{ e("form").a("action", "").a("id", "suggestBankTransactionTransactionDisplayName").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-yellow ").f();
							e("label").a("for", "Recherche_transactionDisplayName").a("class", "").f().sx("display name").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								e("input")
									.a("type", "text")
									.a("placeholder", "display name")
									.a("class", "valueTransactionDisplayName w3-input w3-border ")
									.a("name", "transactionDisplayName")
									.a("id", "Recherche_transactionDisplayName")
									.a("value", o.strTransactionDisplayName())
								.fg();

							} g("div");
						} g("div");
					} g("div");
				} g("form");
			} g("div");
			} g("div");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("form").a("action", "").a("id", "formBankTransactionTransactionReferenceId").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
					e("input")
						.a("type", "hidden")
						.a("name", "value")
						.a("class", "value ")
						.a("value", siteRequest_.getRequestPk())
						.fg();
				} g("form");
				{ e("form").a("action", "").a("id", "suggestBankTransactionTransactionReferenceId").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-yellow ").f();
							e("label").a("for", "Recherche_transactionReferenceId").a("class", "").f().sx("transaction reference ID").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								e("input")
									.a("type", "text")
									.a("placeholder", "transaction reference ID")
									.a("class", "valueTransactionReferenceId w3-input w3-border ")
									.a("name", "transactionReferenceId")
									.a("id", "Recherche_transactionReferenceId")
									.a("value", o.strTransactionReferenceId())
								.fg();

							} g("div");
						} g("div");
					} g("div");
				} g("form");
			} g("div");
			} g("div");
			{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("form").a("action", "").a("id", "formBankTransactionTransactionAmount").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
					e("input")
						.a("type", "hidden")
						.a("name", "value")
						.a("class", "value ")
						.a("value", siteRequest_.getRequestPk())
						.fg();
				} g("form");
				{ e("form").a("action", "").a("id", "suggestBankTransactionTransactionAmount").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-yellow ").f();
							e("label").a("for", "Recherche_transactionAmount").a("class", "").f().sx("date and time of the transaction").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								e("input")
									.a("type", "text")
									.a("placeholder", "date and time of the transaction")
									.a("class", "valueTransactionAmount w3-input w3-border ")
									.a("name", "transactionAmount")
									.a("id", "Recherche_transactionAmount")
									.a("value", o.strTransactionAmount())
								.fg();

							} g("div");
						} g("div");
					} g("div");
				} g("form");
			} g("div");
			} g("div");
			{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("form").a("action", "").a("id", "formBankTransactionTransactionDateTime").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
					e("input")
						.a("type", "hidden")
						.a("name", "value")
						.a("class", "value ")
						.a("value", siteRequest_.getRequestPk())
						.fg();
				} g("form");
				{ e("form").a("action", "").a("id", "suggestBankTransactionTransactionDateTime").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
					{ e("div").a("class", "w3-card ").f();
						ZonedDateTime val = o.getTransactionDateTime();

						{ e("div").a("class", "w3-cell-row w3-yellow ").f();
							e("label").a("for", "Recherche_transactionDateTime").a("class", "").f().sx("date and time of the transaction").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();
								e("input")
									.a("type", "text")
									.a("class", "w3-input w3-border datepicker ")
									.a("placeholder", "MM/DD/YYYY")
									.a("data-timeformat", "MM/DD/YYYY")
									.a("id", "Recherche_transactionDateTime")
									.a("onclick", "removeGlow($(this)); ")
									.a("value", val == null ? "" : DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.forLanguageTag("en-US")).format(val))
									.a("onchange", "var t = moment(this.value, 'MM/DD/YYYY'); if(t) { var s = t.format('MM/DD/YYYY'); patchBankTransactionVal([{ name: 'fq', value: 'pk:' + $('#BankTransactionForm :input[name=\"pk\"]').val() }], 'setTransactionDateTime', s, function() { addGlow($('#Recherche_transactionDateTime')); }, function() { addError($('#Recherche_transactionDateTime')); }); } ")
									.fg();
									} g("div");
						} g("div");
					} g("div");
				} g("form");
			} g("div");
			} g("div");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("class", "w3-card ").f();
					{ e("div").a("class", "w3-cell-row  ").f();
						{ e("div").a("class", "w3-cell ").f();
							{ e("div").a("class", "w3-rest ").f();
								e("span").f().sx(o.strTransactionCompleteName()).g("span");
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			} g("div");
			} g("div");
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
				if(contextIconCssClasses != null)
					e("i").a("class", contextIconCssClasses + " site-menu-icon ").f().g("i");
				e("span").a("class", " ").f().sx("transactions").g("span");
			} g("h1");
			e("div").a("class", "w3-padding-16 w3-card-4 w3-light-grey ").f();
			{ e("table").a("class", "w3-table w3-bordered w3-striped w3-border w3-hoverable ").f();
				{ e("thead").f();
					{ e("tr").f();
						e("th").f().sx("").g("th");
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
										sx(o.getTransactionCompleteName());
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
					} g("form");
					htmlFormPageBankTransaction(o);
				}

			} g("div");

		}
		htmlBodyFormsTransactionGenPage();
		htmlSuggestTransactionGenPage();
		g("div");
	}

	public void htmlBodyFormsTransactionGenPage() {
		e("div").f();


		e("button")
			.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-yellow ")
			.a("onclick", "$('#postBankTransactionModal').show(); ")
			.f().sx("Create a transaction")
		.g("button");
		{ e("div").a("id", "postBankTransactionModal").a("class", "w3-modal ").f();
			{ e("div").a("class", "w3-modal-content w3-card-4 ").f();
				{ e("header").a("class", "w3-container w3-yellow ").f();
					e("span").a("class", "w3-button w3-display-topright ").a("onclick", "$('#postBankTransactionModal').hide(); ").f().sx("×").g("span");
					e("h2").a("class", "").f().sx("Create a transaction").g("h2");
				} g("header");
				{ e("div").a("class", "w3-container ").f();
					BankTransaction o = new BankTransaction();

					// Form POST
					{ e("form").a("action", "").a("id", "postBankTransactionForm").a("onsubmit", "event.preventDefault(); return false; ").f();
						htmlFormPOSTBankTransaction(o);
					} g("form");
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
					e("h2").a("class", "").f().sx("Modify the transactions").g("h2");
				} g("header");
				{ e("div").a("class", "w3-container ").f();
					BankTransaction o = new BankTransaction();

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


		e("button")
			.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-yellow ")
			.a("onclick", "$('#deleteBankTransactionModal').show(); ")
			.f().sx("Delete the transactions")
		.g("button");
		{ e("div").a("id", "deleteBankTransactionModal").a("class", "w3-modal ").f();
			{ e("div").a("class", "w3-modal-content w3-card-4 ").f();
				{ e("header").a("class", "w3-container w3-yellow ").f();
					e("span").a("class", "w3-button w3-display-topright ").a("onclick", "$('#deleteBankTransactionModal').hide(); ").f().sx("×").g("span");
					e("h2").a("class", "").f().sx("Delete the transactions").g("h2");
				} g("header");
				{ e("div").a("class", "w3-container ").f();
					BankTransaction o = new BankTransaction();

					// Form DELETE
					{ e("form").a("action", "").a("id", "deleteBankTransactionForm").a("onsubmit", "event.preventDefault(); return false; ").f();
						htmlFormPATCHBankTransaction(o);
					} g("form");
					e("button")
						.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-yellow ")
						.a("onclick", "deleteBankTransaction(); ")
						.f().sx("Delete the transactions")
					.g("button");

				} g("div");
			} g("div");
		} g("div");

		g("div");
	}

	/**
	**/
	public void htmlSuggestTransactionGenPage() {
		{ e("div").a("class", "w3-cell-row ").f();
			{ e("div").a("class", "w3-cell ").f();
				{ e("a").a("href", "/transaction").a("class", "").f();
					e("i").a("class", "fad fa-cash-register w3-padding-small ").f().g("i");
					sx("see all the transactions");
				} g("a");
			} g("div");
			{ e("div").a("class", "w3-cell ").f();
				{ e("a").a("id", "refreshTransactionGenPage").a("href", "/transaction").a("class", "").a("onclick", "patchBankTransactionVals([], {}, function() { addGlow($('#refreshTransactionGenPage')); }, function() { addError($('#refreshTransactionGenPage')); }); return false; ").f();
					e("i").a("class", "fas fa-sync-alt w3-padding-small ").f().g("i");
					sx("refresh all the transactions");
				} g("a");
			} g("div");
		} g("div");
		{ e("div").a("class", "w3-cell-row w3-padding ").f();
			{ e("div").a("class", "w3-cell ").f();
				{ e("span").f();
					sx("search transactions: ");
				} g("span");
			} g("div");
		} g("div");
		{ e("div").a("class", "w3-cell-row w3-padding ").f();
			{ e("div").a("class", "w3-cell ").f();
				{ e("div").a("class", "w3-cell-row ").f();

					e("i").a("class", "far fa-search w3-xxlarge w3-cell w3-cell-middle ").f().g("i");
					{ e("form").a("action", "").a("id", "suggestFormBankTransaction").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
						e("input")
							.a("type", "text")
							.a("class", "suggestBankTransaction w3-input w3-border w3-cell w3-cell-middle ")
							.a("name", "suggestBankTransaction")
							.a("id", "suggestBankTransaction")
							.a("autocomplete", "off")
							.a("oninput", "suggestBankTransactionObjectSuggest( [ { 'name': 'q', 'value': 'objectSuggest:' + $(this).val() } ], $('#suggestListBankTransaction')); ")
							.fg();

					} g("form");
				} g("div");
			} g("div");
		} g("div");
		{ e("div").a("class", "w3-cell-row w3-padding ").f();
			{ e("div").a("class", "w3-cell w3-left-align w3-cell-top ").f();
				{ e("ul").a("class", "w3-ul w3-hoverable ").a("id", "suggestListBankTransaction").f();
				} g("ul");
			} g("div");
		} g("div");
	}

}
