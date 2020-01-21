package org.computate.bancaire.frfr.transaction;

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
 * NomCanonique.enUS: org.computate.bancaire.enus.transaction.TransactionGenPage
 **/
public class TransactionGenPage extends TransactionGenPageGen<ClusterPage> {

	/**
	 * {@inheritDoc}
	 * 
	 **/
	protected void _listeTransactionBancaire(Couverture<ListeRecherche<TransactionBancaire>> c) {
	}

	protected void _transactionBancaire(Couverture<TransactionBancaire> c) {
		if(listeTransactionBancaire != null && listeTransactionBancaire.size() == 1)
			c.o(listeTransactionBancaire.get(0));
	}

	@Override protected void _pageH1(Couverture<String> c) {
			c.o("transactions");
	}

	@Override protected void _pageH2(Couverture<String> c) {
		c.o("");
	}

	@Override protected void _pageH3(Couverture<String> c) {
		c.o("");
	}

	@Override protected void _pageTitre(Couverture<String> c) {
		if(transactionBancaire != null && transactionBancaire.getTransactionNomComplet() != null)
			c.o(transactionBancaire.getTransactionNomComplet());
		else if(transactionBancaire != null)
			c.o("");
		else if(listeTransactionBancaire == null || listeTransactionBancaire.size() == 0)
			c.o("aucune transaction trouvée");
	}

	@Override protected void _pageUri(Couverture<String> c) {
		c.o("/transaction");
	}

	@Override protected void _pageImageUri(Couverture<String> c) {
			c.o("/png/transaction-999.png");
	}

	@Override protected void _contexteIconeGroupe(Couverture<String> c) {
			c.o("duotone");
	}

	@Override protected void _contexteIconeNom(Couverture<String> c) {
			c.o("cash-register");
	}

	@Override public void initLoinTransactionGenPage() {
		initTransactionGenPage();
		super.initLoinMiseEnPage();
	}

	@Override public void htmlScriptsTransactionGenPage() {
		e("script").a("src", statiqueUrlBase, "/js/frFR/TransactionPage.js").f().g("script");
		e("script").a("src", statiqueUrlBase, "/js/frFR/ComptePage.js").f().g("script");
	}

	@Override public void htmlScriptTransactionGenPage() {
		l("$(document).ready(function() {");
		tl(1, "window.eventBus = new EventBus('/eventbus');");
		tl(1, "var pk = ", requeteSite_.getRequetePk(), ";");
		tl(1, "suggereTransactionBancaireCompteCle([{'name':'fq','value':'transactionCles:' + pk}], $('#listTransactionBancaireCompteCle_Page'), pk); ");
		tl(1, "websocketTransactionBancaire(websocketTransactionBancaireInner);");
		l("});");
	}

	public void htmlFormPageTransactionBancaire(TransactionBancaire o) {
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPk("Page");
			o.htmCree("Page");
			o.htmModifie("Page");
			o.htmObjetId("Page");
			o.htmTransactionId("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmArchive("Page");
			o.htmSupprime("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmCompteCle("Page");
			o.htmTransactionCode("Page");
			o.htmTransactionFrais("Page");
			o.htmTransactionNomAffichage("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmTransactionIdReference("Page");
			o.htmTransactionMontant("Page");
			o.htmTransactionDateHeure("Page");
		} g("div");
	}

	public void htmlFormPOSTTransactionBancaire(TransactionBancaire o) {
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPk("POST");
			o.htmCree("POST");
			o.htmModifie("POST");
			o.htmObjetId("POST");
			o.htmTransactionId("POST");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmArchive("POST");
			o.htmSupprime("POST");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmCompteCle("POST");
			o.htmTransactionCode("POST");
			o.htmTransactionFrais("POST");
			o.htmTransactionNomAffichage("POST");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmTransactionIdReference("POST");
			o.htmTransactionMontant("POST");
			o.htmTransactionDateHeure("POST");
		} g("div");
	}

	public void htmlFormPATCHTransactionBancaire(TransactionBancaire o) {
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPk("PATCH");
			o.htmCree("PATCH");
			o.htmModifie("PATCH");
			o.htmObjetId("PATCH");
			o.htmTransactionId("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmArchive("PATCH");
			o.htmSupprime("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmCompteCle("PATCH");
			o.htmTransactionCode("PATCH");
			o.htmTransactionFrais("PATCH");
			o.htmTransactionNomAffichage("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmTransactionIdReference("PATCH");
			o.htmTransactionMontant("PATCH");
			o.htmTransactionDateHeure("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmTransactionNomComplet("PATCH");
		} g("div");
	}

	public void htmlFormRechercheTransactionBancaire(TransactionBancaire o) {
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPk("Recherche");
			o.htmCree("Recherche");
			o.htmModifie("Recherche");
			o.htmObjetId("Recherche");
			o.htmTransactionId("Recherche");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmArchive("Recherche");
			o.htmSupprime("Recherche");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmCompteCle("Recherche");
			o.htmTransactionCode("Recherche");
			o.htmTransactionFrais("Recherche");
			o.htmTransactionNomAffichage("Recherche");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmTransactionIdReference("Recherche");
			o.htmTransactionMontant("Recherche");
			o.htmTransactionDateHeure("Recherche");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmTransactionNomComplet("Recherche");
		} g("div");
	}

	@Override public void htmlBodyTransactionGenPage() {

		OperationRequest operationRequete = requeteSite_.getOperationRequete();
		JsonObject params = operationRequete.getParams();
		if(listeTransactionBancaire == null || listeTransactionBancaire.size() == 0) {

			{ e("h1").f();
				{ e("a").a("href", "/transaction").a("class", "w3-bar-item w3-btn w3-center w3-block w3-yellow w3-hover-yellow ").f();
					if(contexteIconeClassesCss != null)
						e("i").a("class", contexteIconeClassesCss + " site-menu-icon ").f().g("i");
					e("span").a("class", " ").f().sx("transactions").g("span");
				} g("a");
			} g("h1");
			e("div").a("class", "w3-padding-16 w3-card-4 w3-light-grey ").f();
			{ e("h2").f();
				{ e("span").a("class", "w3-bar-item w3-padding w3-center w3-block w3-yellow ").f();
					if(contexteIconeClassesCss != null)
						e("i").a("class", contexteIconeClassesCss + " site-menu-icon ").f().g("i");
					e("span").a("class", " ").f().sx("aucune transaction trouvée").g("span");
				} g("span");
			} g("h2");
		} else if(listeTransactionBancaire != null && listeTransactionBancaire.size() == 1 && params.getJsonObject("query").getString("q").equals("*:*")) {
			TransactionBancaire o = listeTransactionBancaire.get(0);
			requeteSite_.setRequetePk(o.getPk());
			if(StringUtils.isNotEmpty(pageH1)) {
				{ e("h1").f();
					{ e("a").a("href", "/transaction").a("class", "w3-bar-item w3-btn w3-center w3-block w3-yellow w3-hover-yellow ").f();
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
					{ e("a").a("href", "/transaction").a("class", "w3-bar-item w3-btn w3-center w3-block w3-yellow w3-hover-yellow ").f();
						if(contexteIconeClassesCss != null)
							e("i").a("class", contexteIconeClassesCss + " site-menu-icon ").f().g("i");
						e("span").a("class", " ").f().sx(pageH1).g("span");
					} g("a");
				} g("h1");
			e("div").a("class", "").f();
				{ e("div").f();
					Long num = listeTransactionBancaire.getQueryResponse().getResults().getNumFound();
					String query = StringUtils.replace(listeTransactionBancaire.getQuery(), "_suggested", "");
					Integer rows1 = listeTransactionBancaire.getRows();
					Integer start1 = listeTransactionBancaire.getStart();
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
					Map<String, Map<String, List<String>>> highlighting = listeTransactionBancaire.getQueryResponse().getHighlighting();
					for(int i = 0; i < listeTransactionBancaire.size(); i++) {
						TransactionBancaire o = listeTransactionBancaire.getList().get(i);
						Map<String, List<String>> highlights = highlighting == null ? null : highlighting.get(o.getId());
						List<String> highlightList = highlights == null ? null : highlights.get(highlights.keySet().stream().findFirst().orElse(null));
						String uri = "/transaction/" + o.getPk();
						{ e("tr").f();
							{ e("td").f();
								{ e("a").a("href", uri).f();
									e("i").a("class", "fad fa-cash-register w3-padding-small ").f().g("i");
									{ e("span").f();
										sx(o.strTransactionNomComplet());
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

		if(listeTransactionBancaire != null && listeTransactionBancaire.size() == 1 && params.getJsonObject("query").getString("q").equals("*:*")) {
			TransactionBancaire o = listeTransactionBancaire.first();

			{ e("div").a("class", "").f();

				if(o.getPk() != null) {
					{ e("form").a("action", "").a("id", "TransactionBancaireForm").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
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
					htmlFormPageTransactionBancaire(o);
				}

			} g("div");

		}
		htmlBodyFormsTransactionGenPage();
		htmlSuggereTransactionGenPage(this, null);
		g("div");
	}

	public void htmlBodyFormsTransactionGenPage() {
		e("div").a("class", "w3-margin-top ").f();

		{ e("button")
			.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-yellow ")
				.a("id", "rechargerCetteTransactionGenPage")
				.a("onclick", "patchTransactionBancaireVals( [ {name: 'fq', value: 'pk:' + " + requeteSite_.getRequetePk() + " } ], {}, function() { ajouterLueur($('#rechargerCetteTransactionGenPage')); }, function() { ajouterErreur($('#rechargerCetteTransactionGenPage')); }); return false; ").f();
				e("i").a("class", "fas fa-sync-alt w3-padding-small ").f().g("i");
			sx("recharger cette transaction");
		} g("button");

		e("button")
			.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-yellow ")
			.a("onclick", "$('#postTransactionBancaireModale').show(); ")
			.f().sx("Créer une transaction")
		.g("button");
		{ e("div").a("id", "postTransactionBancaireModale").a("class", "w3-modal ").f();
			{ e("div").a("class", "w3-modal-content w3-card-4 ").f();
				{ e("header").a("class", "w3-container w3-yellow ").f();
					e("span").a("class", "w3-button w3-display-topright ").a("onclick", "$('#postTransactionBancaireModale').hide(); ").f().sx("×").g("span");
					e("h2").a("class", "w3-padding ").f().sx("Créer une transaction").g("h2");
				} g("header");
				{ e("div").a("class", "w3-container ").f();
					TransactionBancaire o = new TransactionBancaire();
					o.setRequeteSite_(requeteSite_);

					// Form POST
					{ e("div").a("id", "postTransactionBancaireForm").f();
						htmlFormPOSTTransactionBancaire(o);
					} g("div");
					e("button")
						.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-yellow ")
						.a("onclick", "postTransactionBancaire($('#postTransactionBancaireForm')); ")
						.f().sx("Créer une transaction")
					.g("button");

				} g("div");
			} g("div");
		} g("div");


		e("button")
			.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-yellow ")
			.a("onclick", "$('#patchTransactionBancaireModale').show(); ")
			.f().sx("Modifier des transactions")
		.g("button");
		{ e("div").a("id", "patchTransactionBancaireModale").a("class", "w3-modal ").f();
			{ e("div").a("class", "w3-modal-content w3-card-4 ").f();
				{ e("header").a("class", "w3-container w3-yellow ").f();
					e("span").a("class", "w3-button w3-display-topright ").a("onclick", "$('#patchTransactionBancaireModale').hide(); ").f().sx("×").g("span");
					e("h2").a("class", "w3-padding ").f().sx("Modifier des transactions").g("h2");
				} g("header");
				{ e("div").a("class", "w3-container ").f();
					TransactionBancaire o = new TransactionBancaire();
					o.setRequeteSite_(requeteSite_);

					// FormulaireFiltres PATCH
					{ e("form").a("action", "").a("id", "patchTransactionBancaireFormulaireFiltres").a("onsubmit", "event.preventDefault(); return false; ").f();
						htmlFormRechercheTransactionBancaire(o);
					} g("form");
					e("button")
						.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-yellow ")
						.a("onclick", "rechercheTransactionBancaire($('#patchTransactionBancaireFormulaireFiltres')); ")
						.f().sx("Rechercher des une transaction")
					.g("button");


					// FormulaireValeurs PATCH
					{ e("form").a("action", "").a("id", "patchTransactionBancaireFormulaireValeurs").a("onsubmit", "event.preventDefault(); return false; ").f();
						htmlFormPATCHTransactionBancaire(o);
					} g("form");
					e("button")
						.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-yellow ")
						.a("onclick", "patchTransactionBancaire($('#patchTransactionBancaireFormulaireFiltres'), $('#patchTransactionBancaireFormulaireValeurs'), function() {}, function() {}); ")
						.f().sx("Modifier des transactions")
					.g("button");

				} g("div");
			} g("div");
		} g("div");


		if(listeTransactionBancaire != null && listeTransactionBancaire.size() == 1) {
			e("button")
				.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-yellow ")
				.a("onclick", "$('#deleteTransactionBancaireModale').show(); ")
				.f().sx("Supprimer des transactions")
			.g("button");
			{ e("div").a("id", "deleteTransactionBancaireModale").a("class", "w3-modal ").f();
				{ e("div").a("class", "w3-modal-content w3-card-4 ").f();
					{ e("header").a("class", "w3-container w3-yellow ").f();
						e("span").a("class", "w3-button w3-display-topright ").a("onclick", "$('#deleteTransactionBancaireModale').hide(); ").f().sx("×").g("span");
						e("h2").a("class", "w3-padding ").f().sx("Supprimer des transactions").g("h2");
					} g("header");
					{ e("div").a("class", "w3-container ").f();
						TransactionBancaire o = new TransactionBancaire();
						o.setRequeteSite_(requeteSite_);

						// Form DELETE
						{ e("div").a("id", "deleteTransactionBancaireForm").f();
							htmlFormPATCHTransactionBancaire(o);
						} g("div");
						e("button")
							.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-yellow ")
							.a("onclick", "deleteTransactionBancaire(", o.getPk(), "); ")
							.f().sx("Supprimer des transactions")
						.g("button");

					} g("div");
				} g("div");
			} g("div");

		}
		g("div");
	}

	/**
	 * Var.enUS: htmlSuggestTransactionGenPage
	 * r: "/transaction"
	 * r.enUS: "/transaction"
	 * r: "voir toutes les transactions"
	 * r.enUS: "see all the transactions"
	 * r: "rechargerTransactionGenPage"
	 * r.enUS: "refreshTransactionGenPage"
	 * r: "recharger toutes les transactions"
	 * r.enUS: "refresh all the transactions"
	 * r: "rechercher transactions : "
	 * r.enUS: "search transactions: "
	 * r: "suggereFormTransactionBancaire"
	 * r.enUS: "suggestFormBankTransaction"
	 * r: "rechercher transactions"
	 * r.enUS: "search transactions"
	 * r: "suggereTransactionBancaire w3-input w3-border w3-cell w3-cell-middle "
	 * r.enUS: "suggestBankTransaction w3-input w3-border w3-cell w3-cell-middle "
	 * r: "suggereTransactionBancaire"
	 * r.enUS: "suggestBankTransaction"
	 * r: patchTransactionBancaireVals
	 * r.enUS: patchBankTransactionVals
	 * r: ajouterLueur
	 * r.enUS: addGlow
	 * r: rechargerTransactionGenPage
	 * r.enUS: refreshTransactionGenPage
	 * r: ajouterErreur
	 * r.enUS: addError
	 * r: suggereTransactionBancaireObjetSuggere
	 * r.enUS: suggestBankTransactionObjectSuggest
	 * r: 'objetSuggere:'
	 * r.enUS: 'objectSuggest:'
	 * r: '#suggereListTransactionBancaire'
	 * r.enUS: '#suggestListBankTransaction'
	 * r: "suggereListTransactionBancaire"
	 * r.enUS: "suggestListBankTransaction"
	**/
	public static void htmlSuggereTransactionGenPage(MiseEnPage p, String id) {
		{ p.e("div").a("class", "w3-cell-row ").f();
			{ p.e("div").a("class", "w3-cell ").f();
				{ p.e("a").a("href", "/transaction").a("class", "").f();
					p.e("i").a("class", "fad fa-cash-register w3-padding-small ").f().g("i");
					p.sx("voir toutes les transactions");
				} p.g("a");
			} p.g("div");
			{ p.e("div").a("class", "w3-cell ").f();
				{ p.e("a").a("id", "rechargerToutesTransactionGenPage", id).a("href", "/transaction").a("class", "").a("onclick", "patchTransactionBancaireVals([], {}, function() { ajouterLueur($('#rechargerToutesTransactionGenPage", id, "')); }, function() { ajouterErreur($('#rechargerToutesTransactionGenPage", id, "')); }); return false; ").f();
					p.e("i").a("class", "fas fa-sync-alt w3-padding-small ").f().g("i");
					p.sx("recharger toutes les transactions");
				} p.g("a");
			} p.g("div");
		} p.g("div");
		{ p.e("div").a("class", "w3-cell-row w3-padding ").f();
			{ p.e("div").a("class", "w3-cell ").f();
				{ p.e("span").f();
					p.sx("rechercher transactions : ");
				} p.g("span");
			} p.g("div");
		} p.g("div");
		{ p.e("div").a("class", "w3-cell-row w3-padding ").f();
			{ p.e("div").a("class", "w3-cell ").f();
				{ p.e("div").a("class", "w3-cell-row ").f();

					p.e("i").a("class", "far fa-search w3-xxlarge w3-cell w3-cell-middle ").f().g("i");
					{ p.e("form").a("action", "").a("id", "suggereFormTransactionBancaire", id).a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); window.location.href='/transaction?q=objetSuggere:' + encodeURIComponent($('#suggereTransactionBancaire", id, "').val()); return false; ").f();
						p.e("input")
							.a("type", "text")
							.a("placeholder", "rechercher transactions")
							.a("class", "suggereTransactionBancaire w3-input w3-border w3-cell w3-cell-middle ")
							.a("name", "suggereTransactionBancaire")
							.a("id", "suggereTransactionBancaire", id)
							.a("autocomplete", "off")
							.a("oninput", "suggereTransactionBancaireObjetSuggere( [ { 'name': 'q', 'value': 'objetSuggere:' + $(this).val() } ], $('#suggereListTransactionBancaire", id, "'), ", p.getRequeteSite_().getRequetePk(), "); ")
							.fg();

					} p.g("form");
				} p.g("div");
			} p.g("div");
		} p.g("div");
		{ p.e("div").a("class", "w3-cell-row w3-padding ").f();
			{ p.e("div").a("class", "w3-cell w3-left-align w3-cell-top ").f();
				{ p.e("ul").a("class", "w3-ul w3-hoverable ").a("id", "suggereListTransactionBancaire", id).f();
				} p.g("ul");
			} p.g("div");
		} p.g("div");
	}

}
