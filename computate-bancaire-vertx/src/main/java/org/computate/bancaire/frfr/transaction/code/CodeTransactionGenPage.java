package org.computate.bancaire.frfr.transaction.code;

import org.computate.bancaire.frfr.cluster.ClusterPage;
import org.computate.bancaire.frfr.config.ConfigSite;
import org.computate.bancaire.frfr.requete.RequeteSiteFrFR;
import org.computate.bancaire.frfr.contexte.SiteContexteFrFR;
import org.computate.bancaire.frfr.utilisateur.UtilisateurSite;
import java.io.IOException;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.core.http.HttpServerResponse;
import org.computate.bancaire.frfr.recherche.ListeRecherche;
import org.computate.bancaire.frfr.couverture.Couverture;
import org.computate.bancaire.frfr.page.MiseEnPage;
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
 * Traduire: false
 * NomCanonique.enUS: org.computate.bancaire.enus.transaction.code.CodeTransactionGenPage
 **/
public class CodeTransactionGenPage extends CodeTransactionGenPageGen<ClusterPage> {

	/**
	 * {@inheritDoc}
	 * 
	 **/
	protected void _listeCodeTransaction(Couverture<ListeRecherche<CodeTransaction>> c) {
	}

	protected void _codeTransaction(Couverture<CodeTransaction> c) {
		if(listeCodeTransaction != null && listeCodeTransaction.size() == 1)
			c.o(listeCodeTransaction.get(0));
	}

	@Override protected void _pageH1(Couverture<String> c) {
			c.o("code de transactions");
	}

	@Override protected void _pageH2(Couverture<String> c) {
		c.o("");
	}

	@Override protected void _pageH3(Couverture<String> c) {
		c.o("");
	}

	@Override protected void _pageTitre(Couverture<String> c) {
		if(codeTransaction != null && codeTransaction.getCodeTransactionNomComplet() != null)
			c.o(codeTransaction.getCodeTransactionNomComplet());
		else if(codeTransaction != null)
			c.o("");
		else if(listeCodeTransaction == null || listeCodeTransaction.size() == 0)
			c.o("aucun code de transaction trouvé");
	}

	@Override protected void _pageUri(Couverture<String> c) {
		c.o("/code-transaction");
	}

	@Override protected void _pageImageUri(Couverture<String> c) {
			c.o("/png/code-transaction-999.png");
	}

	@Override protected void _contexteIconeGroupe(Couverture<String> c) {
			c.o("duotone");
	}

	@Override protected void _contexteIconeNom(Couverture<String> c) {
			c.o("code-commit");
	}

	@Override public void initLoinCodeTransactionGenPage() {
		initCodeTransactionGenPage();
		super.initLoinMiseEnPage();
	}

	@Override public void htmlScriptsCodeTransactionGenPage() {
		e("script").a("src", statiqueUrlBase, "/js/frFR/CodeTransactionPage.js").f().g("script");
	}

	@Override public void htmlScriptCodeTransactionGenPage() {
		l("$(document).ready(function() {");
		tl(1, "window.eventBus = new EventBus('/eventbus');");
		tl(1, "var pk = ", requeteSite_.getRequetePk(), ";");
		tl(1, "websocketCodeTransaction(websocketCodeTransactionInner);");
		l("});");
	}

	public void htmlFormPageCodeTransaction(CodeTransaction o) {
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPk("Page");
			o.htmCree("Page");
			o.htmModifie("Page");
			o.htmObjetId("Page");
			o.htmCodeTransactionId("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmArchive("Page");
			o.htmSupprime("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmTransactionCode("Page");
			o.htmCodeTransactionNomAffichage("Page");
		} g("div");
	}

	public void htmlFormPOSTCodeTransaction(CodeTransaction o) {
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPk("POST");
			o.htmCree("POST");
			o.htmModifie("POST");
			o.htmObjetId("POST");
			o.htmCodeTransactionId("POST");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmArchive("POST");
			o.htmSupprime("POST");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmTransactionCode("POST");
			o.htmCodeTransactionNomAffichage("POST");
		} g("div");
	}

	public void htmlFormPATCHCodeTransaction(CodeTransaction o) {
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPk("PATCH");
			o.htmCree("PATCH");
			o.htmModifie("PATCH");
			o.htmObjetId("PATCH");
			o.htmCodeTransactionId("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmArchive("PATCH");
			o.htmSupprime("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmTransactionCode("PATCH");
			o.htmCodeTransactionNomAffichage("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmCodeTransactionNomComplet("PATCH");
		} g("div");
	}

	public void htmlFormRechercheCodeTransaction(CodeTransaction o) {
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPk("Recherche");
			o.htmCree("Recherche");
			o.htmModifie("Recherche");
			o.htmObjetId("Recherche");
			o.htmCodeTransactionId("Recherche");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmArchive("Recherche");
			o.htmSupprime("Recherche");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmTransactionCode("Recherche");
			o.htmCodeTransactionNomAffichage("Recherche");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmCodeTransactionNomComplet("Recherche");
		} g("div");
	}

	@Override public void htmlBodyCodeTransactionGenPage() {

		OperationRequest operationRequete = requeteSite_.getOperationRequete();
		JsonObject params = operationRequete.getParams();
		if(listeCodeTransaction == null || listeCodeTransaction.size() == 0) {

			{ e("h1").f();
				{ e("a").a("href", "/code-transaction").a("class", "w3-bar-item w3-btn w3-center w3-block w3-yellow w3-hover-yellow ").f();
					if(contexteIconeClassesCss != null)
						e("i").a("class", contexteIconeClassesCss + " site-menu-icon ").f().g("i");
					e("span").a("class", " ").f().sx("code de transactions").g("span");
				} g("a");
			} g("h1");
			e("div").a("class", "w3-padding-16 w3-card-4 w3-light-grey ").f();
			{ e("h2").f();
				{ e("span").a("class", "w3-bar-item w3-padding w3-center w3-block w3-yellow ").f();
					if(contexteIconeClassesCss != null)
						e("i").a("class", contexteIconeClassesCss + " site-menu-icon ").f().g("i");
					e("span").a("class", " ").f().sx("aucun code de transaction trouvé").g("span");
				} g("span");
			} g("h2");
		} else if(listeCodeTransaction != null && listeCodeTransaction.size() == 1 && params.getJsonObject("query").getString("q").equals("*:*")) {
			CodeTransaction o = listeCodeTransaction.get(0);
			requeteSite_.setRequetePk(o.getPk());
			if(StringUtils.isNotEmpty(pageH1)) {
				{ e("h1").f();
					{ e("a").a("href", "/code-transaction").a("class", "w3-bar-item w3-btn w3-center w3-block w3-yellow w3-hover-yellow ").f();
						if(contexteIconeClassesCss != null)
							e("i").a("class", contexteIconeClassesCss + " site-menu-icon ").f().g("i");
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
					{ e("a").a("href", "/code-transaction").a("class", "w3-bar-item w3-btn w3-center w3-block w3-yellow w3-hover-yellow ").f();
						if(contexteIconeClassesCss != null)
							e("i").a("class", contexteIconeClassesCss + " site-menu-icon ").f().g("i");
						e("span").a("class", " ").f().sx(pageH1).g("span");
					} g("a");
				} g("h1");
			e("div").a("class", "").f();
				{ e("div").f();
					Long num = listeCodeTransaction.getQueryResponse().getResults().getNumFound();
					String query = StringUtils.replace(listeCodeTransaction.getQuery(), "_suggested", "");
					Integer rows1 = listeCodeTransaction.getRows();
					Integer start1 = listeCodeTransaction.getStart();
					Integer start2 = start1 - rows1;
					Integer start3 = start1 + rows1;
					Integer rows2 = rows1 / 2;
					Integer rows3 = rows1 * 2;
					start2 = start2 < 0 ? 0 : start2;

					if(start1 == 0) {
						e("i").a("class", "fas fa-arrow-square-left w3-opacity ").f().g("i");
					} else {
						{ e("a").a("href", "/code-transaction?q=", query, "&start=", start2, "&rows=", rows1).f();
							e("i").a("class", "fas fa-arrow-square-left ").f().g("i");
						} g("a");
					}

					if(rows1 <= 1) {
						e("i").a("class", "fas fa-minus-square w3-opacity ").f().g("i");
					} else {
						{ e("a").a("href", "/code-transaction?q=", query, "&start=", start1, "&rows=", rows2).f();
							e("i").a("class", "fas fa-minus-square ").f().g("i");
						} g("a");
					}

					{ e("a").a("href", "/code-transaction?q=", query, "&start=", start1, "&rows=", rows3).f();
						e("i").a("class", "fas fa-plus-square ").f().g("i");
					} g("a");

					if(start3 >= num) {
						e("i").a("class", "fas fa-arrow-square-right w3-opacity ").f().g("i");
					} else {
						{ e("a").a("href", "/code-transaction?q=", query, "&start=", start3, "&rows=", rows1).f();
							e("i").a("class", "fas fa-arrow-square-right ").f().g("i");
						} g("a");
					}
						e("span").f().sx((start1 + 1), " - ", (start1 + rows1), " de ", num).g("span");
				} g("div");
			{ e("table").a("class", "w3-table w3-bordered w3-striped w3-border w3-hoverable ").f();
				{ e("thead").a("class", "w3-yellow w3-hover-yellow ").f();
					{ e("tr").f();
						e("th").f().sx("").g("th");
						e("th").f().sx("crée").g("th");
					} g("tr");
				} g("thead");
				{ e("tbody").f();
					Map<String, Map<String, List<String>>> highlighting = listeCodeTransaction.getQueryResponse().getHighlighting();
					for(int i = 0; i < listeCodeTransaction.size(); i++) {
						CodeTransaction o = listeCodeTransaction.getList().get(i);
						Map<String, List<String>> highlights = highlighting == null ? null : highlighting.get(o.getId());
						List<String> highlightList = highlights == null ? null : highlights.get(highlights.keySet().stream().findFirst().orElse(null));
						String uri = "/code-transaction/" + o.getPk();
						{ e("tr").f();
							{ e("td").f();
								{ e("a").a("href", uri).f();
									e("i").a("class", "fad fa-code-commit w3-padding-small ").f().g("i");
									{ e("span").f();
										sx(o.strCodeTransactionNomComplet());
									} g("span");
								} g("a");
							} g("td");
							{ e("td").f();
								{ e("a").a("href", uri).f();
									{ e("span").f();
										sx(o.strCree());
									} g("span");
								} g("a");
							} g("td");
						} g("tr");
					}
				} g("tbody");
			} g("table");
		}

		if(listeCodeTransaction != null && listeCodeTransaction.size() == 1 && params.getJsonObject("query").getString("q").equals("*:*")) {
			CodeTransaction o = listeCodeTransaction.first();

			{ e("div").a("class", "").f();

				if(o.getPk() != null) {
					{ e("form").a("action", "").a("id", "CodeTransactionForm").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
						e("input")
						.a("name", "pk")
						.a("class", "valeurPk")
						.a("type", "hidden")
						.a("value", o.getPk())
						.fg();
						e("input")
						.a("name", "focusId")
						.a("type", "hidden")
						.fg();
					} g("form");
					htmlFormPageCodeTransaction(o);
				}

			} g("div");

		}
		htmlBodyFormsCodeTransactionGenPage();
		htmlSuggereCodeTransactionGenPage(this, null);
		g("div");
	}

	public void htmlBodyFormsCodeTransactionGenPage() {
		e("div").a("class", "w3-margin-top ").f();

		{ e("button")
			.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-yellow ")
				.a("id", "rechargerCeCodeTransactionGenPage")
				.a("onclick", "patchCodeTransactionVals( [ {name: 'fq', value: 'pk:' + " + requeteSite_.getRequetePk() + " } ], {}, function() { ajouterLueur($('#rechargerCeCodeTransactionGenPage')); }, function() { ajouterErreur($('#rechargerCeCodeTransactionGenPage')); }); return false; ").f();
				e("i").a("class", "fas fa-sync-alt w3-padding-small ").f().g("i");
			sx("recharger ce code de transaction");
		} g("button");

		e("button")
			.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-yellow ")
			.a("onclick", "$('#postCodeTransactionModale').show(); ")
			.f().sx("Créer un code de transaction")
		.g("button");
		{ e("div").a("id", "postCodeTransactionModale").a("class", "w3-modal ").f();
			{ e("div").a("class", "w3-modal-content w3-card-4 ").f();
				{ e("header").a("class", "w3-container w3-yellow ").f();
					e("span").a("class", "w3-button w3-display-topright ").a("onclick", "$('#postCodeTransactionModale').hide(); ").f().sx("×").g("span");
					e("h2").a("class", "w3-padding ").f().sx("Créer un code de transaction").g("h2");
				} g("header");
				{ e("div").a("class", "w3-container ").f();
					CodeTransaction o = new CodeTransaction();
					o.setRequeteSite_(requeteSite_);

					// Form POST
					{ e("div").a("id", "postCodeTransactionForm").f();
						htmlFormPOSTCodeTransaction(o);
					} g("div");
					e("button")
						.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-yellow ")
						.a("onclick", "postCodeTransaction($('#postCodeTransactionForm')); ")
						.f().sx("Créer un code de transaction")
					.g("button");

				} g("div");
			} g("div");
		} g("div");


		e("button")
			.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-yellow ")
			.a("onclick", "$('#patchCodeTransactionModale').show(); ")
			.f().sx("Modifier des code de transactions")
		.g("button");
		{ e("div").a("id", "patchCodeTransactionModale").a("class", "w3-modal ").f();
			{ e("div").a("class", "w3-modal-content w3-card-4 ").f();
				{ e("header").a("class", "w3-container w3-yellow ").f();
					e("span").a("class", "w3-button w3-display-topright ").a("onclick", "$('#patchCodeTransactionModale').hide(); ").f().sx("×").g("span");
					e("h2").a("class", "w3-padding ").f().sx("Modifier des code de transactions").g("h2");
				} g("header");
				{ e("div").a("class", "w3-container ").f();
					CodeTransaction o = new CodeTransaction();
					o.setRequeteSite_(requeteSite_);

					// FormulaireFiltres PATCH
					{ e("form").a("action", "").a("id", "patchCodeTransactionFormulaireFiltres").a("onsubmit", "event.preventDefault(); return false; ").f();
						htmlFormRechercheCodeTransaction(o);
					} g("form");
					e("button")
						.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-yellow ")
						.a("onclick", "rechercheCodeTransaction($('#patchCodeTransactionFormulaireFiltres')); ")
						.f().sx("Rechercher des un code de transaction")
					.g("button");


					// FormulaireValeurs PATCH
					{ e("form").a("action", "").a("id", "patchCodeTransactionFormulaireValeurs").a("onsubmit", "event.preventDefault(); return false; ").f();
						htmlFormPATCHCodeTransaction(o);
					} g("form");
					e("button")
						.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-yellow ")
						.a("onclick", "patchCodeTransaction($('#patchCodeTransactionFormulaireFiltres'), $('#patchCodeTransactionFormulaireValeurs'), function() {}, function() {}); ")
						.f().sx("Modifier des code de transactions")
					.g("button");

				} g("div");
			} g("div");
		} g("div");


		if(listeCodeTransaction != null && listeCodeTransaction.size() == 1) {
			e("button")
				.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-yellow ")
				.a("onclick", "$('#deleteCodeTransactionModale').show(); ")
				.f().sx("Supprimer des code de transactions")
			.g("button");
			{ e("div").a("id", "deleteCodeTransactionModale").a("class", "w3-modal ").f();
				{ e("div").a("class", "w3-modal-content w3-card-4 ").f();
					{ e("header").a("class", "w3-container w3-yellow ").f();
						e("span").a("class", "w3-button w3-display-topright ").a("onclick", "$('#deleteCodeTransactionModale').hide(); ").f().sx("×").g("span");
						e("h2").a("class", "w3-padding ").f().sx("Supprimer des code de transactions").g("h2");
					} g("header");
					{ e("div").a("class", "w3-container ").f();
						CodeTransaction o = new CodeTransaction();
						o.setRequeteSite_(requeteSite_);

						// Form DELETE
						{ e("div").a("id", "deleteCodeTransactionForm").f();
							htmlFormPATCHCodeTransaction(o);
						} g("div");
						e("button")
							.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-yellow ")
							.a("onclick", "deleteCodeTransaction(", o.getPk(), "); ")
							.f().sx("Supprimer des code de transactions")
						.g("button");

					} g("div");
				} g("div");
			} g("div");

		}
		g("div");
	}

	/**
	 * Var.enUS: htmlSuggestCodeTransactionGenPage
	 * r: "/code-transaction"
	 * r.enUS: "/transaction-code"
	 * r: "voir tous les code de transactions"
	 * r.enUS: "see all the transaction codes"
	 * r: "rechargerCodeTransactionGenPage"
	 * r.enUS: "refreshCodeTransactionGenPage"
	 * r: "recharger tous les code de transactions"
	 * r.enUS: "refresh all the transaction codes"
	 * r: "rechercher code de transactions : "
	 * r.enUS: "search bank transaction codes: "
	 * r: "suggereFormCodeTransaction"
	 * r.enUS: "suggestFormTransactionCode"
	 * r: "rechercher code de transactions"
	 * r.enUS: "search bank transaction codes"
	 * r: "suggereCodeTransaction w3-input w3-border w3-cell w3-cell-middle "
	 * r.enUS: "suggestTransactionCode w3-input w3-border w3-cell w3-cell-middle "
	 * r: "suggereCodeTransaction"
	 * r.enUS: "suggestTransactionCode"
	 * r: patchCodeTransactionVals
	 * r.enUS: patchTransactionCodeVals
	 * r: ajouterLueur
	 * r.enUS: addGlow
	 * r: rechargerCodeTransactionGenPage
	 * r.enUS: refreshCodeTransactionGenPage
	 * r: ajouterErreur
	 * r.enUS: addError
	 * r: suggereCodeTransactionObjetSuggere
	 * r.enUS: suggestTransactionCodeObjectSuggest
	 * r: 'objetSuggere:'
	 * r.enUS: 'objectSuggest:'
	 * r: '#suggereListCodeTransaction'
	 * r.enUS: '#suggestListTransactionCode'
	 * r: "suggereListCodeTransaction"
	 * r.enUS: "suggestListTransactionCode"
	**/
	public static void htmlSuggereCodeTransactionGenPage(MiseEnPage p, String id) {
		{ p.e("div").a("class", "w3-cell-row ").f();
			{ p.e("div").a("class", "w3-cell ").f();
				{ p.e("a").a("href", "/code-transaction").a("class", "").f();
					p.e("i").a("class", "fad fa-code-commit w3-padding-small ").f().g("i");
					p.sx("voir tous les code de transactions");
				} p.g("a");
			} p.g("div");
			{ p.e("div").a("class", "w3-cell ").f();
				{ p.e("a").a("id", "rechargerTousCodeTransactionGenPage", id).a("href", "/code-transaction").a("class", "").a("onclick", "patchCodeTransactionVals([], {}, function() { ajouterLueur($('#rechargerTousCodeTransactionGenPage", id, "')); }, function() { ajouterErreur($('#rechargerTousCodeTransactionGenPage", id, "')); }); return false; ").f();
					p.e("i").a("class", "fas fa-sync-alt w3-padding-small ").f().g("i");
					p.sx("recharger tous les code de transactions");
				} p.g("a");
			} p.g("div");
		} p.g("div");
		{ p.e("div").a("class", "w3-cell-row w3-padding ").f();
			{ p.e("div").a("class", "w3-cell ").f();
				{ p.e("span").f();
					p.sx("rechercher code de transactions : ");
				} p.g("span");
			} p.g("div");
		} p.g("div");
		{ p.e("div").a("class", "w3-cell-row w3-padding ").f();
			{ p.e("div").a("class", "w3-cell ").f();
				{ p.e("div").a("class", "w3-cell-row ").f();

					p.e("i").a("class", "far fa-search w3-xxlarge w3-cell w3-cell-middle ").f().g("i");
					{ p.e("form").a("action", "").a("id", "suggereFormCodeTransaction", id).a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); window.location.href='/code-transaction?q=objetSuggere:' + encodeURIComponent($('#suggereCodeTransaction", id, "').val()); return false; ").f();
						p.e("input")
							.a("type", "text")
							.a("placeholder", "rechercher code de transactions")
							.a("class", "suggereCodeTransaction w3-input w3-border w3-cell w3-cell-middle ")
							.a("name", "suggereCodeTransaction")
							.a("id", "suggereCodeTransaction", id)
							.a("autocomplete", "off")
							.a("oninput", "suggereCodeTransactionObjetSuggere( [ { 'name': 'q', 'value': 'objetSuggere:' + $(this).val() } ], $('#suggereListCodeTransaction", id, "'), ", p.getRequeteSite_().getRequetePk(), "); ")
							.fg();

					} p.g("form");
				} p.g("div");
			} p.g("div");
		} p.g("div");
		{ p.e("div").a("class", "w3-cell-row w3-padding ").f();
			{ p.e("div").a("class", "w3-cell w3-left-align w3-cell-top ").f();
				{ p.e("ul").a("class", "w3-ul w3-hoverable ").a("id", "suggereListCodeTransaction", id).f();
				} p.g("ul");
			} p.g("div");
		} p.g("div");
	}

}
