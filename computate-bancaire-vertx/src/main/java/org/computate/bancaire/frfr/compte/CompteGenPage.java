package org.computate.bancaire.frfr.compte;

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
 * NomCanonique.enUS: org.computate.bancaire.enus.account.AccountGenPage
 **/
public class CompteGenPage extends CompteGenPageGen<ClusterPage> {

	/**
	 * {@inheritDoc}
	 * 
	 **/
	protected void _listeCompteBancaire(Couverture<ListeRecherche<CompteBancaire>> c) {
	}

	protected void _compteBancaire(Couverture<CompteBancaire> c) {
		if(listeCompteBancaire != null && listeCompteBancaire.size() == 1)
			c.o(listeCompteBancaire.get(0));
	}

	@Override protected void _pageH1(Couverture<String> c) {
			c.o("comptes");
	}

	@Override protected void _pageH2(Couverture<String> c) {
		c.o("");
	}

	@Override protected void _pageH3(Couverture<String> c) {
		c.o("");
	}

	@Override protected void _pageTitre(Couverture<String> c) {
		if(compteBancaire != null && compteBancaire.getCompteNomComplet() != null)
			c.o(compteBancaire.getCompteNomComplet());
		else if(compteBancaire != null)
			c.o("");
		else if(listeCompteBancaire == null || listeCompteBancaire.size() == 0)
			c.o("aucun compte trouvé");
	}

	@Override protected void _pageUri(Couverture<String> c) {
		c.o("/compte");
	}

	@Override protected void _pageImageUri(Couverture<String> c) {
			c.o("/png/compte-999.png");
	}

	@Override protected void _contexteIconeGroupe(Couverture<String> c) {
			c.o("duotone");
	}

	@Override protected void _contexteIconeNom(Couverture<String> c) {
			c.o("money-check");
	}

	@Override public void initLoinCompteGenPage() {
		initCompteGenPage();
		super.initLoinMiseEnPage();
	}

	@Override public void htmlScriptsCompteGenPage() {
		e("script").a("src", statiqueUrlBase, "/js/frFR/ComptePage.js").f().g("script");
	}

	@Override public void htmlScriptCompteGenPage() {
		l("$(document).ready(function() {");
		tl(1, "window.eventBus = new EventBus('/eventbus');");
		tl(1, "var pk = ", requeteSite_.getRequetePk(), ";");
		tl(1, "websocketCompteBancaire(websocketCompteBancaireInner);");
		l("});");
	}

	public void htmlFormPageCompteBancaire(CompteBancaire o) {
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPk("Page");
			o.htmCree("Page");
			o.htmModifie("Page");
			o.htmObjetId("Page");
			o.htmCompteId("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmArchive("Page");
			o.htmSupprime("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmTransactionCles("Page");
			o.htmCompteNumero("Page");
			o.htmCompteAdministrateurNom("Page");
			o.htmCompteEmplacement("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmCompteNumeroTelephone("Page");
			o.htmCompteAddresse("Page");
		} g("div");
	}

	public void htmlFormPOSTCompteBancaire(CompteBancaire o) {
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPk("POST");
			o.htmCree("POST");
			o.htmModifie("POST");
			o.htmObjetId("POST");
			o.htmCompteId("POST");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmArchive("POST");
			o.htmSupprime("POST");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmTransactionCles("POST");
			o.htmCompteNumero("POST");
			o.htmCompteAdministrateurNom("POST");
			o.htmCompteEmplacement("POST");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmCompteNumeroTelephone("POST");
			o.htmCompteAddresse("POST");
		} g("div");
	}

	public void htmlFormPATCHCompteBancaire(CompteBancaire o) {
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPk("PATCH");
			o.htmCree("PATCH");
			o.htmModifie("PATCH");
			o.htmObjetId("PATCH");
			o.htmCompteId("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmArchive("PATCH");
			o.htmSupprime("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmTransactionCles("PATCH");
			o.htmCompteNumero("PATCH");
			o.htmCompteAdministrateurNom("PATCH");
			o.htmCompteEmplacement("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmCompteNumeroTelephone("PATCH");
			o.htmCompteAddresse("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmCompteNomComplet("PATCH");
		} g("div");
	}

	public void htmlFormRechercheCompteBancaire(CompteBancaire o) {
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPk("Recherche");
			o.htmCree("Recherche");
			o.htmModifie("Recherche");
			o.htmObjetId("Recherche");
			o.htmCompteId("Recherche");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmArchive("Recherche");
			o.htmSupprime("Recherche");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmTransactionCles("Recherche");
			o.htmCompteNumero("Recherche");
			o.htmCompteAdministrateurNom("Recherche");
			o.htmCompteEmplacement("Recherche");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmCompteNumeroTelephone("Recherche");
			o.htmCompteAddresse("Recherche");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmCompteNomComplet("Recherche");
		} g("div");
	}

	@Override public void htmlBodyCompteGenPage() {

		OperationRequest operationRequete = requeteSite_.getOperationRequete();
		JsonObject params = operationRequete.getParams();
		if(listeCompteBancaire == null || listeCompteBancaire.size() == 0) {

			{ e("h1").f();
				{ e("a").a("href", "/compte").a("class", "w3-bar-item w3-btn w3-center w3-block w3-gray w3-hover-gray ").f();
					if(contexteIconeClassesCss != null)
						e("i").a("class", contexteIconeClassesCss + " site-menu-icon ").f().g("i");
					e("span").a("class", " ").f().sx("comptes").g("span");
				} g("a");
			} g("h1");
			e("div").a("class", "w3-padding-16 w3-card-4 w3-light-grey ").f();
			{ e("h2").f();
				{ e("span").a("class", "w3-bar-item w3-padding w3-center w3-block w3-gray ").f();
					if(contexteIconeClassesCss != null)
						e("i").a("class", contexteIconeClassesCss + " site-menu-icon ").f().g("i");
					e("span").a("class", " ").f().sx("aucun compte trouvé").g("span");
				} g("span");
			} g("h2");
		} else if(listeCompteBancaire != null && listeCompteBancaire.size() == 1 && params.getJsonObject("query").getString("q").equals("*:*")) {
			CompteBancaire o = listeCompteBancaire.get(0);
			requeteSite_.setRequetePk(o.getPk());
			if(StringUtils.isNotEmpty(pageH1)) {
				{ e("h1").f();
					{ e("a").a("href", "/compte").a("class", "w3-bar-item w3-btn w3-center w3-block w3-gray w3-hover-gray ").f();
						if(contexteIconeClassesCss != null)
							e("i").a("class", contexteIconeClassesCss + " site-menu-icon ").f().g("i");
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
					{ e("a").a("href", "/compte").a("class", "w3-bar-item w3-btn w3-center w3-block w3-gray w3-hover-gray ").f();
						if(contexteIconeClassesCss != null)
							e("i").a("class", contexteIconeClassesCss + " site-menu-icon ").f().g("i");
						e("span").a("class", " ").f().sx(pageH1).g("span");
					} g("a");
				} g("h1");
			e("div").a("class", "").f();
				{ e("div").f();
					Long num = listeCompteBancaire.getQueryResponse().getResults().getNumFound();
					String query = StringUtils.replace(listeCompteBancaire.getQuery(), "_suggested", "");
					Integer rows1 = listeCompteBancaire.getRows();
					Integer start1 = listeCompteBancaire.getStart();
					Integer start2 = start1 - rows1;
					Integer start3 = start1 + rows1;
					Integer rows2 = rows1 / 2;
					Integer rows3 = rows1 * 2;
					start2 = start2 < 0 ? 0 : start2;

					if(start1 == 0) {
						e("i").a("class", "fas fa-arrow-square-left w3-opacity ").f().g("i");
					} else {
						{ e("a").a("href", "/compte?q=", query, "&start=", start2, "&rows=", rows1).f();
							e("i").a("class", "fas fa-arrow-square-left ").f().g("i");
						} g("a");
					}

					if(rows1 <= 1) {
						e("i").a("class", "fas fa-minus-square w3-opacity ").f().g("i");
					} else {
						{ e("a").a("href", "/compte?q=", query, "&start=", start1, "&rows=", rows2).f();
							e("i").a("class", "fas fa-minus-square ").f().g("i");
						} g("a");
					}

					{ e("a").a("href", "/compte?q=", query, "&start=", start1, "&rows=", rows3).f();
						e("i").a("class", "fas fa-plus-square ").f().g("i");
					} g("a");

					if(start3 >= num) {
						e("i").a("class", "fas fa-arrow-square-right w3-opacity ").f().g("i");
					} else {
						{ e("a").a("href", "/compte?q=", query, "&start=", start3, "&rows=", rows1).f();
							e("i").a("class", "fas fa-arrow-square-right ").f().g("i");
						} g("a");
					}
						e("span").f().sx((start1 + 1), " - ", (start1 + rows1), " de ", num).g("span");
				} g("div");
			{ e("table").a("class", "w3-table w3-bordered w3-striped w3-border w3-hoverable ").f();
				{ e("thead").a("class", "w3-gray w3-hover-gray ").f();
					{ e("tr").f();
						e("th").f().sx("nom").g("th");
						e("th").f().sx("crée").g("th");
					} g("tr");
				} g("thead");
				{ e("tbody").f();
					Map<String, Map<String, List<String>>> highlighting = listeCompteBancaire.getQueryResponse().getHighlighting();
					for(int i = 0; i < listeCompteBancaire.size(); i++) {
						CompteBancaire o = listeCompteBancaire.getList().get(i);
						Map<String, List<String>> highlights = highlighting == null ? null : highlighting.get(o.getId());
						List<String> highlightList = highlights == null ? null : highlights.get(highlights.keySet().stream().findFirst().orElse(null));
						String uri = "/compte/" + o.getPk();
						{ e("tr").f();
							{ e("td").f();
								{ e("a").a("href", uri).f();
									e("i").a("class", "fad fa-money-check w3-padding-small ").f().g("i");
									{ e("span").f();
										sx(o.strCompteNomComplet());
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

		if(listeCompteBancaire != null && listeCompteBancaire.size() == 1 && params.getJsonObject("query").getString("q").equals("*:*")) {
			CompteBancaire o = listeCompteBancaire.first();

			{ e("div").a("class", "").f();

				if(o.getPk() != null) {
					{ e("form").a("action", "").a("id", "CompteBancaireForm").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
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
					htmlFormPageCompteBancaire(o);
				}

				if(o != null)
					o.htmlBody();

			} g("div");

		}
		htmlBodyFormsCompteGenPage();
		htmlSuggereCompteGenPage(this, null);
		g("div");
	}

	public void htmlBodyFormsCompteGenPage() {
		e("div").a("class", "w3-margin-top ").f();

		{ e("button")
			.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-gray ")
				.a("id", "rechargerCeCompteGenPage")
				.a("onclick", "patchCompteBancaireVals( [ {name: 'fq', value: 'pk:' + " + requeteSite_.getRequetePk() + " } ], {}, function() { ajouterLueur($('#rechargerCeCompteGenPage')); }, function() { ajouterErreur($('#rechargerCeCompteGenPage')); }); return false; ").f();
				e("i").a("class", "fas fa-sync-alt w3-padding-small ").f().g("i");
			sx("recharger ce compte");
		} g("button");

		e("button")
			.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-gray ")
			.a("onclick", "$('#postCompteBancaireModale').show(); ")
			.f().sx("Créer un compte")
		.g("button");
		{ e("div").a("id", "postCompteBancaireModale").a("class", "w3-modal ").f();
			{ e("div").a("class", "w3-modal-content w3-card-4 ").f();
				{ e("header").a("class", "w3-container w3-gray ").f();
					e("span").a("class", "w3-button w3-display-topright ").a("onclick", "$('#postCompteBancaireModale').hide(); ").f().sx("×").g("span");
					e("h2").a("class", "w3-padding ").f().sx("Créer un compte").g("h2");
				} g("header");
				{ e("div").a("class", "w3-container ").f();
					CompteBancaire o = new CompteBancaire();
					o.setRequeteSite_(requeteSite_);

					// Form POST
					{ e("div").a("id", "postCompteBancaireForm").f();
						htmlFormPOSTCompteBancaire(o);
					} g("div");
					e("button")
						.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-gray ")
						.a("onclick", "postCompteBancaire($('#postCompteBancaireForm')); ")
						.f().sx("Créer un compte")
					.g("button");

				} g("div");
			} g("div");
		} g("div");


		e("button")
			.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-gray ")
			.a("onclick", "$('#patchCompteBancaireModale').show(); ")
			.f().sx("Modifier des comptes")
		.g("button");
		{ e("div").a("id", "patchCompteBancaireModale").a("class", "w3-modal ").f();
			{ e("div").a("class", "w3-modal-content w3-card-4 ").f();
				{ e("header").a("class", "w3-container w3-gray ").f();
					e("span").a("class", "w3-button w3-display-topright ").a("onclick", "$('#patchCompteBancaireModale').hide(); ").f().sx("×").g("span");
					e("h2").a("class", "w3-padding ").f().sx("Modifier des comptes").g("h2");
				} g("header");
				{ e("div").a("class", "w3-container ").f();
					CompteBancaire o = new CompteBancaire();
					o.setRequeteSite_(requeteSite_);

					// FormulaireFiltres PATCH
					{ e("form").a("action", "").a("id", "patchCompteBancaireFormulaireFiltres").a("onsubmit", "event.preventDefault(); return false; ").f();
						htmlFormRechercheCompteBancaire(o);
					} g("form");
					e("button")
						.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-gray ")
						.a("onclick", "rechercheCompteBancaire($('#patchCompteBancaireFormulaireFiltres')); ")
						.f().sx("Rechercher des un compte")
					.g("button");


					// FormulaireValeurs PATCH
					{ e("form").a("action", "").a("id", "patchCompteBancaireFormulaireValeurs").a("onsubmit", "event.preventDefault(); return false; ").f();
						htmlFormPATCHCompteBancaire(o);
					} g("form");
					e("button")
						.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-gray ")
						.a("onclick", "patchCompteBancaire($('#patchCompteBancaireFormulaireFiltres'), $('#patchCompteBancaireFormulaireValeurs'), function() {}, function() {}); ")
						.f().sx("Modifier des comptes")
					.g("button");

				} g("div");
			} g("div");
		} g("div");


		if(listeCompteBancaire != null && listeCompteBancaire.size() == 1) {
			e("button")
				.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-gray ")
				.a("onclick", "$('#deleteCompteBancaireModale').show(); ")
				.f().sx("Supprimer des comptes")
			.g("button");
			{ e("div").a("id", "deleteCompteBancaireModale").a("class", "w3-modal ").f();
				{ e("div").a("class", "w3-modal-content w3-card-4 ").f();
					{ e("header").a("class", "w3-container w3-gray ").f();
						e("span").a("class", "w3-button w3-display-topright ").a("onclick", "$('#deleteCompteBancaireModale').hide(); ").f().sx("×").g("span");
						e("h2").a("class", "w3-padding ").f().sx("Supprimer des comptes").g("h2");
					} g("header");
					{ e("div").a("class", "w3-container ").f();
						CompteBancaire o = new CompteBancaire();
						o.setRequeteSite_(requeteSite_);

						// Form DELETE
						{ e("div").a("id", "deleteCompteBancaireForm").f();
							htmlFormPATCHCompteBancaire(o);
						} g("div");
						e("button")
							.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-gray ")
							.a("onclick", "deleteCompteBancaire(", o.getPk(), "); ")
							.f().sx("Supprimer des comptes")
						.g("button");

					} g("div");
				} g("div");
			} g("div");

		}
		g("div");
	}

	/**
	 * Var.enUS: htmlSuggestAccountGenPage
	 * r: "/compte"
	 * r.enUS: "/account"
	 * r: "voir tous les comptes"
	 * r.enUS: "see all the accounts"
	 * r: "rechargerCompteGenPage"
	 * r.enUS: "refreshAccountGenPage"
	 * r: "recharger tous les comptes"
	 * r.enUS: "refresh all the accounts"
	 * r: "rechercher comptes : "
	 * r.enUS: "search bank accounts: "
	 * r: "suggereFormCompteBancaire"
	 * r.enUS: "suggestFormBankAccount"
	 * r: "rechercher comptes"
	 * r.enUS: "search bank accounts"
	 * r: "suggereCompteBancaire w3-input w3-border w3-cell w3-cell-middle "
	 * r.enUS: "suggestBankAccount w3-input w3-border w3-cell w3-cell-middle "
	 * r: "suggereCompteBancaire"
	 * r.enUS: "suggestBankAccount"
	 * r: patchCompteBancaireVals
	 * r.enUS: patchBankAccountVals
	 * r: ajouterLueur
	 * r.enUS: addGlow
	 * r: rechargerCompteGenPage
	 * r.enUS: refreshAccountGenPage
	 * r: ajouterErreur
	 * r.enUS: addError
	 * r: suggereCompteBancaireObjetSuggere
	 * r.enUS: suggestBankAccountObjectSuggest
	 * r: 'objetSuggere:'
	 * r.enUS: 'objectSuggest:'
	 * r: '#suggereListCompteBancaire'
	 * r.enUS: '#suggestListBankAccount'
	 * r: "suggereListCompteBancaire"
	 * r.enUS: "suggestListBankAccount"
	**/
	public static void htmlSuggereCompteGenPage(MiseEnPage p, String id) {
		{ p.e("div").a("class", "w3-cell-row ").f();
			{ p.e("div").a("class", "w3-cell ").f();
				{ p.e("a").a("href", "/compte").a("class", "").f();
					p.e("i").a("class", "fad fa-money-check w3-padding-small ").f().g("i");
					p.sx("voir tous les comptes");
				} p.g("a");
			} p.g("div");
			{ p.e("div").a("class", "w3-cell ").f();
				{ p.e("a").a("id", "rechargerTousCompteGenPage", id).a("href", "/compte").a("class", "").a("onclick", "patchCompteBancaireVals([], {}, function() { ajouterLueur($('#rechargerTousCompteGenPage", id, "')); }, function() { ajouterErreur($('#rechargerTousCompteGenPage", id, "')); }); return false; ").f();
					p.e("i").a("class", "fas fa-sync-alt w3-padding-small ").f().g("i");
					p.sx("recharger tous les comptes");
				} p.g("a");
			} p.g("div");
		} p.g("div");
		{ p.e("div").a("class", "w3-cell-row w3-padding ").f();
			{ p.e("div").a("class", "w3-cell ").f();
				{ p.e("span").f();
					p.sx("rechercher comptes : ");
				} p.g("span");
			} p.g("div");
		} p.g("div");
		{ p.e("div").a("class", "w3-cell-row w3-padding ").f();
			{ p.e("div").a("class", "w3-cell ").f();
				{ p.e("div").a("class", "w3-cell-row ").f();

					p.e("i").a("class", "far fa-search w3-xxlarge w3-cell w3-cell-middle ").f().g("i");
					{ p.e("form").a("action", "").a("id", "suggereFormCompteBancaire", id).a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); window.location.href='/compte?q=objetSuggere:' + encodeURIComponent($('#suggereCompteBancaire", id, "').val()); return false; ").f();
						p.e("input")
							.a("type", "text")
							.a("placeholder", "rechercher comptes")
							.a("class", "suggereCompteBancaire w3-input w3-border w3-cell w3-cell-middle ")
							.a("name", "suggereCompteBancaire")
							.a("id", "suggereCompteBancaire", id)
							.a("autocomplete", "off")
							.a("oninput", "suggereCompteBancaireObjetSuggere( [ { 'name': 'q', 'value': 'objetSuggere:' + $(this).val() } ], $('#suggereListCompteBancaire", id, "'), ", p.getRequeteSite_().getRequetePk(), "); ")
							.fg();

					} p.g("form");
				} p.g("div");
			} p.g("div");
		} p.g("div");
		{ p.e("div").a("class", "w3-cell-row w3-padding ").f();
			{ p.e("div").a("class", "w3-cell w3-left-align w3-cell-top ").f();
				{ p.e("ul").a("class", "w3-ul w3-hoverable ").a("id", "suggereListCompteBancaire", id).f();
				} p.g("ul");
			} p.g("div");
		} p.g("div");
	}

}
