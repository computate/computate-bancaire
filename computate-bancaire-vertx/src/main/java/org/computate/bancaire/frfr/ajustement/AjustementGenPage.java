package org.computate.bancaire.frfr.ajustement;

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
 * NomCanonique.enUS: org.computate.bancaire.enus.adjustment.AdjustmentGenPage
 **/
public class AjustementGenPage extends AjustementGenPageGen<ClusterPage> {

	/**
	 * {@inheritDoc}
	 * 
	 **/
	protected void _listeAjustementBancaire(Couverture<ListeRecherche<AjustementBancaire>> c) {
	}

	protected void _ajustementBancaire(Couverture<AjustementBancaire> c) {
		if(listeAjustementBancaire != null && listeAjustementBancaire.size() == 1)
			c.o(listeAjustementBancaire.get(0));
	}

	@Override protected void _pageH1(Couverture<String> c) {
			c.o("ajustements");
	}

	@Override protected void _pageH2(Couverture<String> c) {
		c.o("");
	}

	@Override protected void _pageH3(Couverture<String> c) {
		c.o("");
	}

	@Override protected void _pageTitre(Couverture<String> c) {
		if(ajustementBancaire != null && ajustementBancaire.getAjustementNomComplet() != null)
			c.o(ajustementBancaire.getAjustementNomComplet());
		else if(ajustementBancaire != null)
			c.o("");
		else if(listeAjustementBancaire == null || listeAjustementBancaire.size() == 0)
			c.o("aucun ajustement trouvé");
	}

	@Override protected void _pageUri(Couverture<String> c) {
		c.o("/ajustement");
	}

	@Override protected void _pageImageUri(Couverture<String> c) {
			c.o("/png/ajustement-999.png");
	}

	@Override protected void _contexteIconeGroupe(Couverture<String> c) {
			c.o("duotone");
	}

	@Override protected void _contexteIconeNom(Couverture<String> c) {
			c.o("cash-register");
	}

	@Override public void initLoinAjustementGenPage() {
		initAjustementGenPage();
		super.initLoinMiseEnPage();
	}

	@Override public void htmlScriptsAjustementGenPage() {
		e("script").a("src", statiqueUrlBase, "/js/frFR/AjustementPage.js").f().g("script");
	}

	@Override public void htmlScriptAjustementGenPage() {
		l("$(document).ready(function() {");
		tl(1, "window.eventBus = new EventBus('/eventbus');");
		tl(1, "var pk = ", requeteSite_.getRequetePk(), ";");
		tl(1, "websocketAjustementBancaire(websocketAjustementBancaireInner);");
		l("});");
	}

	public void htmlFormPageAjustementBancaire(AjustementBancaire o) {
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPk("Page");
			o.htmCree("Page");
			o.htmModifie("Page");
			o.htmObjetId("Page");
			o.htmAjustementId("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmArchive("Page");
			o.htmSupprime("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmCompteCle("Page");
			o.htmTransactionCle("Page");
			o.htmAjustementNomAffichage("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmAgentZones("Page");
			o.htmAgentRoles("Page");
			o.htmAgentPasserOutre("Page");
			o.htmDroitEligible("Page");
			o.htmPartenaireNom("Page");
		} g("div");
	}

	public void htmlFormPOSTAjustementBancaire(AjustementBancaire o) {
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPk("POST");
			o.htmCree("POST");
			o.htmModifie("POST");
			o.htmObjetId("POST");
			o.htmAjustementId("POST");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmArchive("POST");
			o.htmSupprime("POST");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmCompteCle("POST");
			o.htmTransactionCle("POST");
			o.htmAjustementNomAffichage("POST");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmAgentZones("POST");
			o.htmAgentRoles("POST");
			o.htmAgentPasserOutre("POST");
			o.htmDroitEligible("POST");
			o.htmPartenaireNom("POST");
		} g("div");
	}

	public void htmlFormPATCHAjustementBancaire(AjustementBancaire o) {
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPk("PATCH");
			o.htmCree("PATCH");
			o.htmModifie("PATCH");
			o.htmObjetId("PATCH");
			o.htmAjustementId("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmArchive("PATCH");
			o.htmSupprime("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmCompteCle("PATCH");
			o.htmTransactionCle("PATCH");
			o.htmAjustementNomAffichage("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmAgentZones("PATCH");
			o.htmAgentRoles("PATCH");
			o.htmAgentPasserOutre("PATCH");
			o.htmDroitEligible("PATCH");
			o.htmPartenaireNom("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmAjustementNomComplet("PATCH");
		} g("div");
	}

	public void htmlFormRechercheAjustementBancaire(AjustementBancaire o) {
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPk("Recherche");
			o.htmCree("Recherche");
			o.htmModifie("Recherche");
			o.htmObjetId("Recherche");
			o.htmAjustementId("Recherche");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmArchive("Recherche");
			o.htmSupprime("Recherche");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmCompteCle("Recherche");
			o.htmTransactionCle("Recherche");
			o.htmAjustementNomAffichage("Recherche");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmAgentZones("Recherche");
			o.htmAgentRoles("Recherche");
			o.htmAgentPasserOutre("Recherche");
			o.htmDroitEligible("Recherche");
			o.htmPartenaireNom("Recherche");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmAjustementNomComplet("Recherche");
		} g("div");
	}

	@Override public void htmlBodyAjustementGenPage() {

		OperationRequest operationRequete = requeteSite_.getOperationRequete();
		JsonObject params = operationRequete.getParams();
		if(listeAjustementBancaire == null || listeAjustementBancaire.size() == 0) {

			{ e("h1").f();
				{ e("a").a("href", "/ajustement").a("class", "w3-bar-item w3-btn w3-center w3-block w3-yellow w3-hover-yellow ").f();
					if(contexteIconeClassesCss != null)
						e("i").a("class", contexteIconeClassesCss + " site-menu-icon ").f().g("i");
					e("span").a("class", " ").f().sx("ajustements").g("span");
				} g("a");
			} g("h1");
			e("div").a("class", "w3-padding-16 w3-card-4 w3-light-grey ").f();
			{ e("h2").f();
				{ e("span").a("class", "w3-bar-item w3-padding w3-center w3-block w3-yellow ").f();
					if(contexteIconeClassesCss != null)
						e("i").a("class", contexteIconeClassesCss + " site-menu-icon ").f().g("i");
					e("span").a("class", " ").f().sx("aucun ajustement trouvé").g("span");
				} g("span");
			} g("h2");
		} else if(listeAjustementBancaire != null && listeAjustementBancaire.size() == 1 && params.getJsonObject("query").getString("q").equals("*:*")) {
			AjustementBancaire o = listeAjustementBancaire.get(0);
			requeteSite_.setRequetePk(o.getPk());
			if(StringUtils.isNotEmpty(pageH1)) {
				{ e("h1").f();
					{ e("a").a("href", "/ajustement").a("class", "w3-bar-item w3-btn w3-center w3-block w3-yellow w3-hover-yellow ").f();
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
					{ e("a").a("href", "/ajustement").a("class", "w3-bar-item w3-btn w3-center w3-block w3-yellow w3-hover-yellow ").f();
						if(contexteIconeClassesCss != null)
							e("i").a("class", contexteIconeClassesCss + " site-menu-icon ").f().g("i");
						e("span").a("class", " ").f().sx(pageH1).g("span");
					} g("a");
				} g("h1");
			e("div").a("class", "").f();
				{ e("div").f();
					Long num = listeAjustementBancaire.getQueryResponse().getResults().getNumFound();
					String query = StringUtils.replace(listeAjustementBancaire.getQuery(), "_suggested", "");
					Integer rows1 = listeAjustementBancaire.getRows();
					Integer start1 = listeAjustementBancaire.getStart();
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
					Map<String, Map<String, List<String>>> highlighting = listeAjustementBancaire.getQueryResponse().getHighlighting();
					for(int i = 0; i < listeAjustementBancaire.size(); i++) {
						AjustementBancaire o = listeAjustementBancaire.getList().get(i);
						Map<String, List<String>> highlights = highlighting == null ? null : highlighting.get(o.getId());
						List<String> highlightList = highlights == null ? null : highlights.get(highlights.keySet().stream().findFirst().orElse(null));
						String uri = "/ajustement/" + o.getPk();
						{ e("tr").f();
							{ e("td").f();
								{ e("a").a("href", uri).f();
									e("i").a("class", "fad fa-cash-register w3-padding-small ").f().g("i");
									{ e("span").f();
										sx(o.strAjustementNomComplet());
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

		if(listeAjustementBancaire != null && listeAjustementBancaire.size() == 1 && params.getJsonObject("query").getString("q").equals("*:*")) {
			AjustementBancaire o = listeAjustementBancaire.first();

			{ e("div").a("class", "").f();

				if(o.getPk() != null) {
					{ e("form").a("action", "").a("id", "AjustementBancaireForm").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
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
					htmlFormPageAjustementBancaire(o);
				}

			} g("div");

		}
		htmlBodyFormsAjustementGenPage();
		htmlSuggereAjustementGenPage(this, null);
		g("div");
	}

	public void htmlBodyFormsAjustementGenPage() {
		e("div").a("class", "w3-margin-top ").f();

		{ e("button")
			.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-yellow ")
				.a("id", "rechargerCeAjustementGenPage")
				.a("onclick", "patchAjustementBancaireVals( [ {name: 'fq', value: 'pk:' + " + requeteSite_.getRequetePk() + " } ], {}, function() { ajouterLueur($('#rechargerCeAjustementGenPage')); }, function() { ajouterErreur($('#rechargerCeAjustementGenPage')); }); return false; ").f();
				e("i").a("class", "fas fa-sync-alt w3-padding-small ").f().g("i");
			sx("recharger cet ajustement");
		} g("button");

		e("button")
			.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-yellow ")
			.a("onclick", "$('#postAjustementBancaireModale').show(); ")
			.f().sx("Créer un ajustement")
		.g("button");
		{ e("div").a("id", "postAjustementBancaireModale").a("class", "w3-modal ").f();
			{ e("div").a("class", "w3-modal-content w3-card-4 ").f();
				{ e("header").a("class", "w3-container w3-yellow ").f();
					e("span").a("class", "w3-button w3-display-topright ").a("onclick", "$('#postAjustementBancaireModale').hide(); ").f().sx("×").g("span");
					e("h2").a("class", "w3-padding ").f().sx("Créer un ajustement").g("h2");
				} g("header");
				{ e("div").a("class", "w3-container ").f();
					AjustementBancaire o = new AjustementBancaire();
					o.setRequeteSite_(requeteSite_);

					// Form POST
					{ e("div").a("id", "postAjustementBancaireForm").f();
						htmlFormPOSTAjustementBancaire(o);
					} g("div");
					e("button")
						.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-yellow ")
						.a("onclick", "postAjustementBancaire($('#postAjustementBancaireForm')); ")
						.f().sx("Créer un ajustement")
					.g("button");

				} g("div");
			} g("div");
		} g("div");


		e("button")
			.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-yellow ")
			.a("onclick", "$('#patchAjustementBancaireModale').show(); ")
			.f().sx("Modifier des ajustements")
		.g("button");
		{ e("div").a("id", "patchAjustementBancaireModale").a("class", "w3-modal ").f();
			{ e("div").a("class", "w3-modal-content w3-card-4 ").f();
				{ e("header").a("class", "w3-container w3-yellow ").f();
					e("span").a("class", "w3-button w3-display-topright ").a("onclick", "$('#patchAjustementBancaireModale').hide(); ").f().sx("×").g("span");
					e("h2").a("class", "w3-padding ").f().sx("Modifier des ajustements").g("h2");
				} g("header");
				{ e("div").a("class", "w3-container ").f();
					AjustementBancaire o = new AjustementBancaire();
					o.setRequeteSite_(requeteSite_);

					// FormulaireFiltres PATCH
					{ e("form").a("action", "").a("id", "patchAjustementBancaireFormulaireFiltres").a("onsubmit", "event.preventDefault(); return false; ").f();
						htmlFormRechercheAjustementBancaire(o);
					} g("form");
					e("button")
						.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-yellow ")
						.a("onclick", "rechercheAjustementBancaire($('#patchAjustementBancaireFormulaireFiltres')); ")
						.f().sx("Rechercher des un ajustement")
					.g("button");


					// FormulaireValeurs PATCH
					{ e("form").a("action", "").a("id", "patchAjustementBancaireFormulaireValeurs").a("onsubmit", "event.preventDefault(); return false; ").f();
						htmlFormPATCHAjustementBancaire(o);
					} g("form");
					e("button")
						.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-yellow ")
						.a("onclick", "patchAjustementBancaire($('#patchAjustementBancaireFormulaireFiltres'), $('#patchAjustementBancaireFormulaireValeurs'), function() {}, function() {}); ")
						.f().sx("Modifier des ajustements")
					.g("button");

				} g("div");
			} g("div");
		} g("div");


		if(listeAjustementBancaire != null && listeAjustementBancaire.size() == 1) {
			e("button")
				.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-yellow ")
				.a("onclick", "$('#deleteAjustementBancaireModale').show(); ")
				.f().sx("Supprimer des ajustements")
			.g("button");
			{ e("div").a("id", "deleteAjustementBancaireModale").a("class", "w3-modal ").f();
				{ e("div").a("class", "w3-modal-content w3-card-4 ").f();
					{ e("header").a("class", "w3-container w3-yellow ").f();
						e("span").a("class", "w3-button w3-display-topright ").a("onclick", "$('#deleteAjustementBancaireModale').hide(); ").f().sx("×").g("span");
						e("h2").a("class", "w3-padding ").f().sx("Supprimer des ajustements").g("h2");
					} g("header");
					{ e("div").a("class", "w3-container ").f();
						AjustementBancaire o = new AjustementBancaire();
						o.setRequeteSite_(requeteSite_);

						// Form DELETE
						{ e("div").a("id", "deleteAjustementBancaireForm").f();
							htmlFormPATCHAjustementBancaire(o);
						} g("div");
						e("button")
							.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-yellow ")
							.a("onclick", "deleteAjustementBancaire(", o.getPk(), "); ")
							.f().sx("Supprimer des ajustements")
						.g("button");

					} g("div");
				} g("div");
			} g("div");

		}
		g("div");
	}

	/**
	 * Var.enUS: htmlSuggestAdjustmentGenPage
	 * r: "/ajustement"
	 * r.enUS: "/ajustement"
	 * r: "voir tous les ajustements"
	 * r.enUS: "see all the adjustments"
	 * r: "rechargerAjustementGenPage"
	 * r.enUS: "refreshAdjustmentGenPage"
	 * r: "recharger tous les ajustements"
	 * r.enUS: "refresh all the adjustments"
	 * r: "rechercher ajustements : "
	 * r.enUS: "search adjustments: "
	 * r: "suggereFormAjustementBancaire"
	 * r.enUS: "suggestFormBankAdjustment"
	 * r: "rechercher ajustements"
	 * r.enUS: "search adjustments"
	 * r: "suggereAjustementBancaire w3-input w3-border w3-cell w3-cell-middle "
	 * r.enUS: "suggestBankAdjustment w3-input w3-border w3-cell w3-cell-middle "
	 * r: "suggereAjustementBancaire"
	 * r.enUS: "suggestBankAdjustment"
	 * r: patchAjustementBancaireVals
	 * r.enUS: patchBankAdjustmentVals
	 * r: ajouterLueur
	 * r.enUS: addGlow
	 * r: rechargerAjustementGenPage
	 * r.enUS: refreshAdjustmentGenPage
	 * r: ajouterErreur
	 * r.enUS: addError
	 * r: suggereAjustementBancaireObjetSuggere
	 * r.enUS: suggestBankAdjustmentObjectSuggest
	 * r: 'objetSuggere:'
	 * r.enUS: 'objectSuggest:'
	 * r: '#suggereListAjustementBancaire'
	 * r.enUS: '#suggestListBankAdjustment'
	 * r: "suggereListAjustementBancaire"
	 * r.enUS: "suggestListBankAdjustment"
	**/
	public static void htmlSuggereAjustementGenPage(MiseEnPage p, String id) {
		{ p.e("div").a("class", "w3-cell-row ").f();
			{ p.e("div").a("class", "w3-cell ").f();
				{ p.e("a").a("href", "/ajustement").a("class", "").f();
					p.e("i").a("class", "fad fa-cash-register w3-padding-small ").f().g("i");
					p.sx("voir tous les ajustements");
				} p.g("a");
			} p.g("div");
			{ p.e("div").a("class", "w3-cell ").f();
				{ p.e("a").a("id", "rechargerTousAjustementGenPage", id).a("href", "/ajustement").a("class", "").a("onclick", "patchAjustementBancaireVals([], {}, function() { ajouterLueur($('#rechargerTousAjustementGenPage", id, "')); }, function() { ajouterErreur($('#rechargerTousAjustementGenPage", id, "')); }); return false; ").f();
					p.e("i").a("class", "fas fa-sync-alt w3-padding-small ").f().g("i");
					p.sx("recharger tous les ajustements");
				} p.g("a");
			} p.g("div");
		} p.g("div");
		{ p.e("div").a("class", "w3-cell-row w3-padding ").f();
			{ p.e("div").a("class", "w3-cell ").f();
				{ p.e("span").f();
					p.sx("rechercher ajustements : ");
				} p.g("span");
			} p.g("div");
		} p.g("div");
		{ p.e("div").a("class", "w3-cell-row w3-padding ").f();
			{ p.e("div").a("class", "w3-cell ").f();
				{ p.e("div").a("class", "w3-cell-row ").f();

					p.e("i").a("class", "far fa-search w3-xxlarge w3-cell w3-cell-middle ").f().g("i");
					{ p.e("form").a("action", "").a("id", "suggereFormAjustementBancaire", id).a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); window.location.href='/ajustement?q=objetSuggere:' + encodeURIComponent($('#suggereAjustementBancaire", id, "').val()); return false; ").f();
						p.e("input")
							.a("type", "text")
							.a("placeholder", "rechercher ajustements")
							.a("class", "suggereAjustementBancaire w3-input w3-border w3-cell w3-cell-middle ")
							.a("name", "suggereAjustementBancaire")
							.a("id", "suggereAjustementBancaire", id)
							.a("autocomplete", "off")
							.a("oninput", "suggereAjustementBancaireObjetSuggere( [ { 'name': 'q', 'value': 'objetSuggere:' + $(this).val() } ], $('#suggereListAjustementBancaire", id, "'), ", p.getRequeteSite_().getRequetePk(), "); ")
							.fg();

					} p.g("form");
				} p.g("div");
			} p.g("div");
		} p.g("div");
		{ p.e("div").a("class", "w3-cell-row w3-padding ").f();
			{ p.e("div").a("class", "w3-cell w3-left-align w3-cell-top ").f();
				{ p.e("ul").a("class", "w3-ul w3-hoverable ").a("id", "suggereListAjustementBancaire", id).f();
				} p.g("ul");
			} p.g("div");
		} p.g("div");
	}

}
