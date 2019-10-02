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
		l("});");
	}

	public void htmlFormPageCompteBancaire(CompteBancaire o) {
		{ e("div").a("class", "w3-cell-row ").f();
			{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
				{ e("div").a("class", "w3-padding ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-gray ").f();
							e("label").a("class", "").f().sx("clé primaire").g("label");
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
						{ e("div").a("class", "w3-cell-row w3-gray ").f();
							e("label").a("class", "").f().sx("crée").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row  ").f();
							{ e("div").a("class", "w3-cell ").f();
								{ e("div").a("class", "w3-rest ").f();
									e("span").f().sx(o.strCree()).g("span");
								} g("div");
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			} g("div");
			{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
				{ e("div").a("class", "w3-padding ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-gray ").f();
							e("label").a("class", "").f().sx("modifié").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row  ").f();
							{ e("div").a("class", "w3-cell ").f();
								{ e("div").a("class", "w3-rest ").f();
									e("span").f().sx(o.strModifie()).g("span");
								} g("div");
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			} g("div");
			{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
				{ e("div").a("class", "w3-padding ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-gray ").f();
							e("label").a("class", "").f().sx("ID").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row  ").f();
							{ e("div").a("class", "w3-cell ").f();
								{ e("div").a("class", "w3-rest ").f();
									e("span").f().sx(o.strCompteId()).g("span");
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
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-gray ").f();
							e("label").a("class", "").f().sx("transactions").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row  ").f();
							{ e("div").a("class", "w3-cell ").f();
								{ e("div").a("class", "w3-rest ").f();
									e("span").f().sx(o.strTransactionCles()).g("span");
								} g("div");
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			} g("div");
			{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
				{ e("div").a("class", "w3-padding ").f();
					{ e("form").a("action", "").a("id", "formCompteBancaireCompteNumero").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
						e("input")
							.a("type", "hidden")
							.a("name", "valeur")
							.a("class", "valeur ")
							.a("value", requeteSite_.getRequetePk())
							.fg();
					} g("form");
					{ e("form").a("action", "").a("id", "suggereCompteBancaireCompteNumero").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
						{ e("div").a("class", "w3-card ").f();
							{ e("div").a("class", "w3-cell-row w3-gray ").f();
								e("label").a("for", "Page_compteNumero").a("class", "").f().sx("numéro de compte").g("label");
							} g("div");
							{ e("div").a("class", "w3-cell-row w3-padding ").f();
								{ e("div").a("class", "w3-cell ").f();

									e("input")
										.a("type", "text")
										.a("placeholder", "numéro de compte")
										.a("class", "setCompteNumero w3-input w3-border ")
										.a("name", "setCompteNumero")
										.a("id", "Page_compteNumero")
										.a("onclick", "enleverLueur($(this)); ")
										.a("onchange", "patchCompteBancaireVal([{ name: 'fq', value: 'pk:' + $('#CompteBancaireForm :input[name=\"pk\"]').val() }], 'setCompteNumero', $(this).val(), function() { ajouterLueur($('#Page_compteNumero')); }, function() { ajouterErreur($('#Page_compteNumero')); }); ")
										.a("value", o.strCompteNumero())
									.fg();

								} g("div");
								{ e("div").a("class", "w3-cell w3-left-align w3-cell-top ").f();
									{ e("button")
										.a("tabindex", "-1")
										.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-bar-item w3-gray ")
									.a("onclick", "enleverLueur($('#Page_compteNumero')); $('#Page_compteNumero').val(null); patchCompteBancaireVal([{ name: 'fq', value: 'pk:' + $('#CompteBancaireForm :input[name=\"pk\"]').val() }], 'setCompteNumero', null, function() { ajouterLueur($('#Page_compteNumero')); }, function() { ajouterErreur($('#Page_compteNumero')); }); ")
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
					{ e("form").a("action", "").a("id", "formCompteBancaireCompteAdministrateurNom").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
						e("input")
							.a("type", "hidden")
							.a("name", "valeur")
							.a("class", "valeur ")
							.a("value", requeteSite_.getRequetePk())
							.fg();
					} g("form");
					{ e("form").a("action", "").a("id", "suggereCompteBancaireCompteAdministrateurNom").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
						{ e("div").a("class", "w3-card ").f();
							{ e("div").a("class", "w3-cell-row w3-gray ").f();
								e("label").a("for", "Page_compteAdministrateurNom").a("class", "").f().sx("administrateur de l'école").g("label");
							} g("div");
							{ e("div").a("class", "w3-cell-row w3-padding ").f();
								{ e("div").a("class", "w3-cell ").f();

									e("input")
										.a("type", "text")
										.a("placeholder", "administrateur de l'école")
										.a("title", "Description.enUS: ")
										.a("class", "setCompteAdministrateurNom w3-input w3-border ")
										.a("name", "setCompteAdministrateurNom")
										.a("id", "Page_compteAdministrateurNom")
										.a("onclick", "enleverLueur($(this)); ")
										.a("onchange", "patchCompteBancaireVal([{ name: 'fq', value: 'pk:' + $('#CompteBancaireForm :input[name=\"pk\"]').val() }], 'setCompteAdministrateurNom', $(this).val(), function() { ajouterLueur($('#Page_compteAdministrateurNom')); }, function() { ajouterErreur($('#Page_compteAdministrateurNom')); }); ")
										.a("value", o.strCompteAdministrateurNom())
									.fg();

								} g("div");
								{ e("div").a("class", "w3-cell w3-left-align w3-cell-top ").f();
									{ e("button")
										.a("tabindex", "-1")
										.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-bar-item w3-gray ")
									.a("onclick", "enleverLueur($('#Page_compteAdministrateurNom')); $('#Page_compteAdministrateurNom').val(null); patchCompteBancaireVal([{ name: 'fq', value: 'pk:' + $('#CompteBancaireForm :input[name=\"pk\"]').val() }], 'setCompteAdministrateurNom', null, function() { ajouterLueur($('#Page_compteAdministrateurNom')); }, function() { ajouterErreur($('#Page_compteAdministrateurNom')); }); ")
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
					{ e("form").a("action", "").a("id", "formCompteBancaireCompteEmplacement").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
						e("input")
							.a("type", "hidden")
							.a("name", "valeur")
							.a("class", "valeur ")
							.a("value", requeteSite_.getRequetePk())
							.fg();
					} g("form");
					{ e("form").a("action", "").a("id", "suggereCompteBancaireCompteEmplacement").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
						{ e("div").a("class", "w3-card ").f();
							{ e("div").a("class", "w3-cell-row w3-gray ").f();
								e("label").a("for", "Page_compteEmplacement").a("class", "").f().sx("l'emplacement").g("label");
							} g("div");
							{ e("div").a("class", "w3-cell-row w3-padding ").f();
								{ e("div").a("class", "w3-cell ").f();

									e("input")
										.a("type", "text")
										.a("placeholder", "l'emplacement")
										.a("title", "Description.enUS: ")
										.a("class", "setCompteEmplacement w3-input w3-border ")
										.a("name", "setCompteEmplacement")
										.a("id", "Page_compteEmplacement")
										.a("onclick", "enleverLueur($(this)); ")
										.a("onchange", "patchCompteBancaireVal([{ name: 'fq', value: 'pk:' + $('#CompteBancaireForm :input[name=\"pk\"]').val() }], 'setCompteEmplacement', $(this).val(), function() { ajouterLueur($('#Page_compteEmplacement')); }, function() { ajouterErreur($('#Page_compteEmplacement')); }); ")
										.a("value", o.strCompteEmplacement())
									.fg();

								} g("div");
								{ e("div").a("class", "w3-cell w3-left-align w3-cell-top ").f();
									{ e("button")
										.a("tabindex", "-1")
										.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-bar-item w3-gray ")
									.a("onclick", "enleverLueur($('#Page_compteEmplacement')); $('#Page_compteEmplacement').val(null); patchCompteBancaireVal([{ name: 'fq', value: 'pk:' + $('#CompteBancaireForm :input[name=\"pk\"]').val() }], 'setCompteEmplacement', null, function() { ajouterLueur($('#Page_compteEmplacement')); }, function() { ajouterErreur($('#Page_compteEmplacement')); }); ")
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
					{ e("form").a("action", "").a("id", "formCompteBancaireCompteNumeroTelephone").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
						e("input")
							.a("type", "hidden")
							.a("name", "valeur")
							.a("class", "valeur ")
							.a("value", requeteSite_.getRequetePk())
							.fg();
					} g("form");
					{ e("form").a("action", "").a("id", "suggereCompteBancaireCompteNumeroTelephone").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
						{ e("div").a("class", "w3-card ").f();
							{ e("div").a("class", "w3-cell-row w3-gray ").f();
								e("label").a("for", "Page_compteNumeroTelephone").a("class", "").f().sx("numéro de téléphone").g("label");
							} g("div");
							{ e("div").a("class", "w3-cell-row w3-padding ").f();
								{ e("div").a("class", "w3-cell ").f();

									e("input")
										.a("type", "text")
										.a("placeholder", "numéro de téléphone")
										.a("title", "Numéro de téléphone de l'école. ")
										.a("class", "setCompteNumeroTelephone w3-input w3-border ")
										.a("name", "setCompteNumeroTelephone")
										.a("id", "Page_compteNumeroTelephone")
										.a("onclick", "enleverLueur($(this)); ")
										.a("onchange", "patchCompteBancaireVal([{ name: 'fq', value: 'pk:' + $('#CompteBancaireForm :input[name=\"pk\"]').val() }], 'setCompteNumeroTelephone', $(this).val(), function() { ajouterLueur($('#Page_compteNumeroTelephone')); }, function() { ajouterErreur($('#Page_compteNumeroTelephone')); }); ")
										.a("value", o.strCompteNumeroTelephone())
									.fg();

								} g("div");
								{ e("div").a("class", "w3-cell w3-left-align w3-cell-top ").f();
									{ e("button")
										.a("tabindex", "-1")
										.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-bar-item w3-gray ")
									.a("onclick", "enleverLueur($('#Page_compteNumeroTelephone')); $('#Page_compteNumeroTelephone').val(null); patchCompteBancaireVal([{ name: 'fq', value: 'pk:' + $('#CompteBancaireForm :input[name=\"pk\"]').val() }], 'setCompteNumeroTelephone', null, function() { ajouterLueur($('#Page_compteNumeroTelephone')); }, function() { ajouterErreur($('#Page_compteNumeroTelephone')); }); ")
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
					{ e("form").a("action", "").a("id", "formCompteBancaireCompteAddresse").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
						e("input")
							.a("type", "hidden")
							.a("name", "valeur")
							.a("class", "valeur ")
							.a("value", requeteSite_.getRequetePk())
							.fg();
					} g("form");
					{ e("form").a("action", "").a("id", "suggereCompteBancaireCompteAddresse").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
						{ e("div").a("class", "w3-card ").f();
							{ e("div").a("class", "w3-cell-row w3-gray ").f();
								e("label").a("for", "Page_compteAddresse").a("class", "").f().sx("addresse").g("label");
							} g("div");
							{ e("div").a("class", "w3-cell-row w3-padding ").f();
								{ e("div").a("class", "w3-cell ").f();

									e("textarea")
										.a("placeholder", "addresse")
										.a("title", "Description.enUS: ")
										.a("class", "setCompteAddresse w3-input w3-border ")
										.a("name", "setCompteAddresse")
										.a("id", "Page_compteAddresse")
										.a("onclick", "enleverLueur($(this)); ")
										.a("onchange", "patchCompteBancaireVal([{ name: 'fq', value: 'pk:' + $('#CompteBancaireForm :input[name=\"pk\"]').val() }], 'setCompteAddresse', $(this).val(), function() { ajouterLueur($('#Page_compteAddresse')); }, function() { ajouterErreur($('#Page_compteAddresse')); }); ")
									.f().sx(o.strCompteAddresse()).g("textarea");

								} g("div");
								{ e("div").a("class", "w3-cell w3-left-align w3-cell-top ").f();
									{ e("button")
										.a("tabindex", "-1")
										.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-bar-item w3-gray ")
									.a("onclick", "enleverLueur($('#Page_compteAddresse')); $('#Page_compteAddresse').val(null); patchCompteBancaireVal([{ name: 'fq', value: 'pk:' + $('#CompteBancaireForm :input[name=\"pk\"]').val() }], 'setCompteAddresse', null, function() { ajouterLueur($('#Page_compteAddresse')); }, function() { ajouterErreur($('#Page_compteAddresse')); }); ")
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

	public void htmlFormPOSTCompteBancaire(CompteBancaire o) {
		{ e("div").a("class", "w3-cell-row ").f();
			{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("class", "w3-card ").f();
					{ e("div").a("class", "w3-cell-row w3-gray ").f();
						e("label").a("class", "").f().sx("clé primaire").g("label");
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
					{ e("div").a("class", "w3-cell-row w3-gray ").f();
						e("label").a("class", "").f().sx("crée").g("label");
					} g("div");
					{ e("div").a("class", "w3-cell-row  ").f();
						{ e("div").a("class", "w3-cell ").f();
							{ e("div").a("class", "w3-rest ").f();
								e("span").f().sx(o.strCree()).g("span");
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			} g("div");
			} g("div");
			{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("class", "w3-card ").f();
					{ e("div").a("class", "w3-cell-row w3-gray ").f();
						e("label").a("class", "").f().sx("modifié").g("label");
					} g("div");
					{ e("div").a("class", "w3-cell-row  ").f();
						{ e("div").a("class", "w3-cell ").f();
							{ e("div").a("class", "w3-rest ").f();
								e("span").f().sx(o.strModifie()).g("span");
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			} g("div");
			} g("div");
			{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("class", "w3-card ").f();
					{ e("div").a("class", "w3-cell-row w3-gray ").f();
						e("label").a("class", "").f().sx("ID").g("label");
					} g("div");
					{ e("div").a("class", "w3-cell-row  ").f();
						{ e("div").a("class", "w3-cell ").f();
							{ e("div").a("class", "w3-rest ").f();
								e("span").f().sx(o.strCompteId()).g("span");
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
				{ e("div").a("class", "w3-card ").f();
					{ e("div").a("class", "w3-cell-row w3-gray ").f();
						e("label").a("class", "").f().sx("transactions").g("label");
					} g("div");
					{ e("div").a("class", "w3-cell-row  ").f();
						{ e("div").a("class", "w3-cell ").f();
							{ e("div").a("class", "w3-rest ").f();
								e("span").f().sx(o.strTransactionCles()).g("span");
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			} g("div");
			} g("div");
			{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("form").a("action", "").a("id", "formCompteBancaireCompteNumero").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
					e("input")
						.a("type", "hidden")
						.a("name", "valeur")
						.a("class", "valeur ")
						.a("value", requeteSite_.getRequetePk())
						.fg();
				} g("form");
				{ e("form").a("action", "").a("id", "suggereCompteBancaireCompteNumero").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-gray ").f();
							e("label").a("for", "POST_compteNumero").a("class", "").f().sx("numéro de compte").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								e("input")
									.a("type", "text")
									.a("placeholder", "numéro de compte")
									.a("class", "valeurCompteNumero w3-input w3-border ")
									.a("name", "compteNumero")
									.a("id", "POST_compteNumero")
									.a("value", o.strCompteNumero())
								.fg();

							} g("div");
						} g("div");
					} g("div");
				} g("form");
			} g("div");
			} g("div");
			{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("form").a("action", "").a("id", "formCompteBancaireCompteAdministrateurNom").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
					e("input")
						.a("type", "hidden")
						.a("name", "valeur")
						.a("class", "valeur ")
						.a("value", requeteSite_.getRequetePk())
						.fg();
				} g("form");
				{ e("form").a("action", "").a("id", "suggereCompteBancaireCompteAdministrateurNom").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-gray ").f();
							e("label").a("for", "POST_compteAdministrateurNom").a("class", "").f().sx("administrateur de l'école").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								e("input")
									.a("type", "text")
									.a("placeholder", "administrateur de l'école")
									.a("title", "Description.enUS: ")
									.a("class", "valeurCompteAdministrateurNom w3-input w3-border ")
									.a("name", "compteAdministrateurNom")
									.a("id", "POST_compteAdministrateurNom")
									.a("value", o.strCompteAdministrateurNom())
								.fg();

							} g("div");
						} g("div");
					} g("div");
				} g("form");
			} g("div");
			} g("div");
			{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("form").a("action", "").a("id", "formCompteBancaireCompteEmplacement").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
					e("input")
						.a("type", "hidden")
						.a("name", "valeur")
						.a("class", "valeur ")
						.a("value", requeteSite_.getRequetePk())
						.fg();
				} g("form");
				{ e("form").a("action", "").a("id", "suggereCompteBancaireCompteEmplacement").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-gray ").f();
							e("label").a("for", "POST_compteEmplacement").a("class", "").f().sx("l'emplacement").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								e("input")
									.a("type", "text")
									.a("placeholder", "l'emplacement")
									.a("title", "Description.enUS: ")
									.a("class", "valeurCompteEmplacement w3-input w3-border ")
									.a("name", "compteEmplacement")
									.a("id", "POST_compteEmplacement")
									.a("value", o.strCompteEmplacement())
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
				{ e("form").a("action", "").a("id", "formCompteBancaireCompteNumeroTelephone").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
					e("input")
						.a("type", "hidden")
						.a("name", "valeur")
						.a("class", "valeur ")
						.a("value", requeteSite_.getRequetePk())
						.fg();
				} g("form");
				{ e("form").a("action", "").a("id", "suggereCompteBancaireCompteNumeroTelephone").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-gray ").f();
							e("label").a("for", "POST_compteNumeroTelephone").a("class", "").f().sx("numéro de téléphone").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								e("input")
									.a("type", "text")
									.a("placeholder", "numéro de téléphone")
									.a("title", "Numéro de téléphone de l'école. ")
									.a("class", "valeurCompteNumeroTelephone w3-input w3-border ")
									.a("name", "compteNumeroTelephone")
									.a("id", "POST_compteNumeroTelephone")
									.a("value", o.strCompteNumeroTelephone())
								.fg();

							} g("div");
						} g("div");
					} g("div");
				} g("form");
			} g("div");
			} g("div");
			{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("form").a("action", "").a("id", "formCompteBancaireCompteAddresse").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
					e("input")
						.a("type", "hidden")
						.a("name", "valeur")
						.a("class", "valeur ")
						.a("value", requeteSite_.getRequetePk())
						.fg();
				} g("form");
				{ e("form").a("action", "").a("id", "suggereCompteBancaireCompteAddresse").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-gray ").f();
							e("label").a("for", "POST_compteAddresse").a("class", "").f().sx("addresse").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								e("textarea")
									.a("placeholder", "addresse")
									.a("title", "Description.enUS: ")
									.a("class", "valeurCompteAddresse w3-input w3-border ")
									.a("name", "compteAddresse")
									.a("id", "POST_compteAddresse")
								.f().sx(o.strCompteAddresse()).g("textarea");

							} g("div");
						} g("div");
					} g("div");
				} g("form");
			} g("div");
			} g("div");
		} g("div");
	}

	public void htmlFormPATCHCompteBancaire(CompteBancaire o) {
		{ e("div").a("class", "w3-cell-row ").f();
			{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("class", "w3-card ").f();
					{ e("div").a("class", "w3-cell-row w3-gray ").f();
						e("label").a("class", "").f().sx("clé primaire").g("label");
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
					{ e("div").a("class", "w3-cell-row w3-gray ").f();
						e("label").a("class", "").f().sx("crée").g("label");
					} g("div");
					{ e("div").a("class", "w3-cell-row  ").f();
						{ e("div").a("class", "w3-cell ").f();
							{ e("div").a("class", "w3-rest ").f();
								e("span").f().sx(o.strCree()).g("span");
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			} g("div");
			} g("div");
			{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("class", "w3-card ").f();
					{ e("div").a("class", "w3-cell-row w3-gray ").f();
						e("label").a("class", "").f().sx("modifié").g("label");
					} g("div");
					{ e("div").a("class", "w3-cell-row  ").f();
						{ e("div").a("class", "w3-cell ").f();
							{ e("div").a("class", "w3-rest ").f();
								e("span").f().sx(o.strModifie()).g("span");
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			} g("div");
			} g("div");
			{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("class", "w3-card ").f();
					{ e("div").a("class", "w3-cell-row w3-gray ").f();
						e("label").a("class", "").f().sx("ID").g("label");
					} g("div");
					{ e("div").a("class", "w3-cell-row  ").f();
						{ e("div").a("class", "w3-cell ").f();
							{ e("div").a("class", "w3-rest ").f();
								e("span").f().sx(o.strCompteId()).g("span");
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
				{ e("div").a("class", "w3-card ").f();
					{ e("div").a("class", "w3-cell-row w3-gray ").f();
						e("label").a("class", "").f().sx("transactions").g("label");
					} g("div");
					{ e("div").a("class", "w3-cell-row  ").f();
						{ e("div").a("class", "w3-cell ").f();
							{ e("div").a("class", "w3-rest ").f();
								e("span").f().sx(o.strTransactionCles()).g("span");
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			} g("div");
			} g("div");
			{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("form").a("action", "").a("id", "formCompteBancaireCompteNumero").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
					e("input")
						.a("type", "hidden")
						.a("name", "valeur")
						.a("class", "valeur ")
						.a("value", requeteSite_.getRequetePk())
						.fg();
				} g("form");
				{ e("form").a("action", "").a("id", "suggereCompteBancaireCompteNumero").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-gray ").f();
							e("label").a("for", "PATCH_compteNumero").a("class", "").f().sx("numéro de compte").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								e("input")
									.a("type", "text")
									.a("placeholder", "numéro de compte")
									.a("class", "setCompteNumero w3-input w3-border ")
									.a("name", "setCompteNumero")
									.a("id", "PATCH_compteNumero")
									.a("value", o.strCompteNumero())
								.fg();

							} g("div");
						} g("div");
					} g("div");
				} g("form");
			} g("div");
			} g("div");
			{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("form").a("action", "").a("id", "formCompteBancaireCompteAdministrateurNom").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
					e("input")
						.a("type", "hidden")
						.a("name", "valeur")
						.a("class", "valeur ")
						.a("value", requeteSite_.getRequetePk())
						.fg();
				} g("form");
				{ e("form").a("action", "").a("id", "suggereCompteBancaireCompteAdministrateurNom").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-gray ").f();
							e("label").a("for", "PATCH_compteAdministrateurNom").a("class", "").f().sx("administrateur de l'école").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								e("input")
									.a("type", "text")
									.a("placeholder", "administrateur de l'école")
									.a("title", "Description.enUS: ")
									.a("class", "setCompteAdministrateurNom w3-input w3-border ")
									.a("name", "setCompteAdministrateurNom")
									.a("id", "PATCH_compteAdministrateurNom")
									.a("value", o.strCompteAdministrateurNom())
								.fg();

							} g("div");
						} g("div");
					} g("div");
				} g("form");
			} g("div");
			} g("div");
			{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("form").a("action", "").a("id", "formCompteBancaireCompteEmplacement").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
					e("input")
						.a("type", "hidden")
						.a("name", "valeur")
						.a("class", "valeur ")
						.a("value", requeteSite_.getRequetePk())
						.fg();
				} g("form");
				{ e("form").a("action", "").a("id", "suggereCompteBancaireCompteEmplacement").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-gray ").f();
							e("label").a("for", "PATCH_compteEmplacement").a("class", "").f().sx("l'emplacement").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								e("input")
									.a("type", "text")
									.a("placeholder", "l'emplacement")
									.a("title", "Description.enUS: ")
									.a("class", "setCompteEmplacement w3-input w3-border ")
									.a("name", "setCompteEmplacement")
									.a("id", "PATCH_compteEmplacement")
									.a("value", o.strCompteEmplacement())
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
				{ e("form").a("action", "").a("id", "formCompteBancaireCompteNumeroTelephone").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
					e("input")
						.a("type", "hidden")
						.a("name", "valeur")
						.a("class", "valeur ")
						.a("value", requeteSite_.getRequetePk())
						.fg();
				} g("form");
				{ e("form").a("action", "").a("id", "suggereCompteBancaireCompteNumeroTelephone").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-gray ").f();
							e("label").a("for", "PATCH_compteNumeroTelephone").a("class", "").f().sx("numéro de téléphone").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								e("input")
									.a("type", "text")
									.a("placeholder", "numéro de téléphone")
									.a("title", "Numéro de téléphone de l'école. ")
									.a("class", "setCompteNumeroTelephone w3-input w3-border ")
									.a("name", "setCompteNumeroTelephone")
									.a("id", "PATCH_compteNumeroTelephone")
									.a("value", o.strCompteNumeroTelephone())
								.fg();

							} g("div");
						} g("div");
					} g("div");
				} g("form");
			} g("div");
			} g("div");
			{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("form").a("action", "").a("id", "formCompteBancaireCompteAddresse").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
					e("input")
						.a("type", "hidden")
						.a("name", "valeur")
						.a("class", "valeur ")
						.a("value", requeteSite_.getRequetePk())
						.fg();
				} g("form");
				{ e("form").a("action", "").a("id", "suggereCompteBancaireCompteAddresse").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-gray ").f();
							e("label").a("for", "PATCH_compteAddresse").a("class", "").f().sx("addresse").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								e("textarea")
									.a("placeholder", "addresse")
									.a("title", "Description.enUS: ")
									.a("class", "setCompteAddresse w3-input w3-border ")
									.a("name", "setCompteAddresse")
									.a("id", "PATCH_compteAddresse")
								.f().sx(o.strCompteAddresse()).g("textarea");

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
					{ e("div").a("class", "w3-cell-row w3-gray ").f();
						e("label").a("class", "").f().sx("nom").g("label");
					} g("div");
					{ e("div").a("class", "w3-cell-row  ").f();
						{ e("div").a("class", "w3-cell ").f();
							{ e("div").a("class", "w3-rest ").f();
								e("span").f().sx(o.strCompteNomComplet()).g("span");
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			} g("div");
			} g("div");
		} g("div");
	}

	public void htmlFormRechercheCompteBancaire(CompteBancaire o) {
		{ e("div").a("class", "w3-cell-row ").f();
			{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("class", "w3-card ").f();
					{ e("div").a("class", "w3-cell-row w3-gray ").f();
						e("label").a("class", "").f().sx("clé primaire").g("label");
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
					{ e("div").a("class", "w3-cell-row w3-gray ").f();
						e("label").a("class", "").f().sx("crée").g("label");
					} g("div");
					{ e("div").a("class", "w3-cell-row  ").f();
						{ e("div").a("class", "w3-cell ").f();
							{ e("div").a("class", "w3-rest ").f();
								e("span").f().sx(o.strCree()).g("span");
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			} g("div");
			} g("div");
			{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("class", "w3-card ").f();
					{ e("div").a("class", "w3-cell-row w3-gray ").f();
						e("label").a("class", "").f().sx("modifié").g("label");
					} g("div");
					{ e("div").a("class", "w3-cell-row  ").f();
						{ e("div").a("class", "w3-cell ").f();
							{ e("div").a("class", "w3-rest ").f();
								e("span").f().sx(o.strModifie()).g("span");
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			} g("div");
			} g("div");
			{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("class", "w3-card ").f();
					{ e("div").a("class", "w3-cell-row w3-gray ").f();
						e("label").a("class", "").f().sx("ID").g("label");
					} g("div");
					{ e("div").a("class", "w3-cell-row  ").f();
						{ e("div").a("class", "w3-cell ").f();
							{ e("div").a("class", "w3-rest ").f();
								e("span").f().sx(o.strCompteId()).g("span");
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
				{ e("div").a("class", "w3-card ").f();
					{ e("div").a("class", "w3-cell-row w3-gray ").f();
						e("label").a("class", "").f().sx("transactions").g("label");
					} g("div");
					{ e("div").a("class", "w3-cell-row  ").f();
						{ e("div").a("class", "w3-cell ").f();
							{ e("div").a("class", "w3-rest ").f();
								e("span").f().sx(o.strTransactionCles()).g("span");
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			} g("div");
			} g("div");
			{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("form").a("action", "").a("id", "formCompteBancaireCompteNumero").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
					e("input")
						.a("type", "hidden")
						.a("name", "valeur")
						.a("class", "valeur ")
						.a("value", requeteSite_.getRequetePk())
						.fg();
				} g("form");
				{ e("form").a("action", "").a("id", "suggereCompteBancaireCompteNumero").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-gray ").f();
							e("label").a("for", "Recherche_compteNumero").a("class", "").f().sx("numéro de compte").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								e("input")
									.a("type", "text")
									.a("placeholder", "numéro de compte")
									.a("class", "valeurCompteNumero w3-input w3-border ")
									.a("name", "compteNumero")
									.a("id", "Recherche_compteNumero")
									.a("value", o.strCompteNumero())
								.fg();

							} g("div");
						} g("div");
					} g("div");
				} g("form");
			} g("div");
			} g("div");
			{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("form").a("action", "").a("id", "formCompteBancaireCompteAdministrateurNom").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
					e("input")
						.a("type", "hidden")
						.a("name", "valeur")
						.a("class", "valeur ")
						.a("value", requeteSite_.getRequetePk())
						.fg();
				} g("form");
				{ e("form").a("action", "").a("id", "suggereCompteBancaireCompteAdministrateurNom").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-gray ").f();
							e("label").a("for", "Recherche_compteAdministrateurNom").a("class", "").f().sx("administrateur de l'école").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								e("input")
									.a("type", "text")
									.a("placeholder", "administrateur de l'école")
									.a("title", "Description.enUS: ")
									.a("class", "valeurCompteAdministrateurNom w3-input w3-border ")
									.a("name", "compteAdministrateurNom")
									.a("id", "Recherche_compteAdministrateurNom")
									.a("value", o.strCompteAdministrateurNom())
								.fg();

							} g("div");
						} g("div");
					} g("div");
				} g("form");
			} g("div");
			} g("div");
			{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("form").a("action", "").a("id", "formCompteBancaireCompteEmplacement").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
					e("input")
						.a("type", "hidden")
						.a("name", "valeur")
						.a("class", "valeur ")
						.a("value", requeteSite_.getRequetePk())
						.fg();
				} g("form");
				{ e("form").a("action", "").a("id", "suggereCompteBancaireCompteEmplacement").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-gray ").f();
							e("label").a("for", "Recherche_compteEmplacement").a("class", "").f().sx("l'emplacement").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								e("input")
									.a("type", "text")
									.a("placeholder", "l'emplacement")
									.a("title", "Description.enUS: ")
									.a("class", "valeurCompteEmplacement w3-input w3-border ")
									.a("name", "compteEmplacement")
									.a("id", "Recherche_compteEmplacement")
									.a("value", o.strCompteEmplacement())
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
				{ e("form").a("action", "").a("id", "formCompteBancaireCompteNumeroTelephone").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
					e("input")
						.a("type", "hidden")
						.a("name", "valeur")
						.a("class", "valeur ")
						.a("value", requeteSite_.getRequetePk())
						.fg();
				} g("form");
				{ e("form").a("action", "").a("id", "suggereCompteBancaireCompteNumeroTelephone").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-gray ").f();
							e("label").a("for", "Recherche_compteNumeroTelephone").a("class", "").f().sx("numéro de téléphone").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								e("input")
									.a("type", "text")
									.a("placeholder", "numéro de téléphone")
									.a("title", "Numéro de téléphone de l'école. ")
									.a("class", "valeurCompteNumeroTelephone w3-input w3-border ")
									.a("name", "compteNumeroTelephone")
									.a("id", "Recherche_compteNumeroTelephone")
									.a("value", o.strCompteNumeroTelephone())
								.fg();

							} g("div");
						} g("div");
					} g("div");
				} g("form");
			} g("div");
			} g("div");
			{ e("div").a("class", "w3-cell w3-cell-middle w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("form").a("action", "").a("id", "formCompteBancaireCompteAddresse").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
					e("input")
						.a("type", "hidden")
						.a("name", "valeur")
						.a("class", "valeur ")
						.a("value", requeteSite_.getRequetePk())
						.fg();
				} g("form");
				{ e("form").a("action", "").a("id", "suggereCompteBancaireCompteAddresse").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-gray ").f();
							e("label").a("for", "Recherche_compteAddresse").a("class", "").f().sx("addresse").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								e("textarea")
									.a("placeholder", "addresse")
									.a("title", "Description.enUS: ")
									.a("class", "valeurCompteAddresse w3-input w3-border ")
									.a("name", "compteAddresse")
									.a("id", "Recherche_compteAddresse")
								.f().sx(o.strCompteAddresse()).g("textarea");

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
					{ e("div").a("class", "w3-cell-row w3-gray ").f();
						e("label").a("class", "").f().sx("nom").g("label");
					} g("div");
					{ e("div").a("class", "w3-cell-row  ").f();
						{ e("div").a("class", "w3-cell ").f();
							{ e("div").a("class", "w3-rest ").f();
								e("span").f().sx(o.strCompteNomComplet()).g("span");
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			} g("div");
			} g("div");
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
				if(contexteIconeClassesCss != null)
					e("i").a("class", contexteIconeClassesCss + " site-menu-icon ").f().g("i");
				e("span").a("class", " ").f().sx("comptes").g("span");
			} g("h1");
			e("div").a("class", "w3-padding-16 w3-card-4 w3-light-grey ").f();
			{ e("table").a("class", "w3-table w3-bordered w3-striped w3-border w3-hoverable ").f();
				{ e("thead").f();
					{ e("tr").f();
						e("th").f().sx("nom").g("th");
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
										sx(o.getCompteNomComplet());
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
					} g("form");
					htmlFormPageCompteBancaire(o);
				}

				if(o != null)
					o.htmlBody();

			} g("div");

		}
		htmlBodyFormsCompteGenPage();
		htmlSuggereCompteGenPage();
		g("div");
	}

	public void htmlBodyFormsCompteGenPage() {
		e("div").f();


		e("button")
			.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-gray ")
			.a("onclick", "$('#postCompteBancaireModale').show(); ")
			.f().sx("Créer un compte")
		.g("button");
		{ e("div").a("id", "postCompteBancaireModale").a("class", "w3-modal ").f();
			{ e("div").a("class", "w3-modal-content w3-card-4 ").f();
				{ e("header").a("class", "w3-container w3-gray ").f();
					e("span").a("class", "w3-button w3-display-topright ").a("onclick", "$('#postCompteBancaireModale').hide(); ").f().sx("×").g("span");
					e("h2").a("class", "").f().sx("Créer un compte").g("h2");
				} g("header");
				{ e("div").a("class", "w3-container ").f();
					CompteBancaire o = new CompteBancaire();

					// Form POST
					{ e("form").a("action", "").a("id", "postCompteBancaireForm").a("onsubmit", "event.preventDefault(); return false; ").f();
						htmlFormPOSTCompteBancaire(o);
					} g("form");
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
					e("h2").a("class", "").f().sx("Modifier des comptes").g("h2");
				} g("header");
				{ e("div").a("class", "w3-container ").f();
					CompteBancaire o = new CompteBancaire();

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


		e("button")
			.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-gray ")
			.a("onclick", "$('#deleteCompteBancaireModale').show(); ")
			.f().sx("Supprimer des comptes")
		.g("button");
		{ e("div").a("id", "deleteCompteBancaireModale").a("class", "w3-modal ").f();
			{ e("div").a("class", "w3-modal-content w3-card-4 ").f();
				{ e("header").a("class", "w3-container w3-gray ").f();
					e("span").a("class", "w3-button w3-display-topright ").a("onclick", "$('#deleteCompteBancaireModale').hide(); ").f().sx("×").g("span");
					e("h2").a("class", "").f().sx("Supprimer des comptes").g("h2");
				} g("header");
				{ e("div").a("class", "w3-container ").f();
					CompteBancaire o = new CompteBancaire();

					// Form DELETE
					{ e("form").a("action", "").a("id", "deleteCompteBancaireForm").a("onsubmit", "event.preventDefault(); return false; ").f();
						htmlFormPATCHCompteBancaire(o);
					} g("form");
					e("button")
						.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-gray ")
						.a("onclick", "deleteCompteBancaire(); ")
						.f().sx("Supprimer des comptes")
					.g("button");

				} g("div");
			} g("div");
		} g("div");

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
	public void htmlSuggereCompteGenPage() {
		{ e("div").a("class", "w3-cell-row ").f();
			{ e("div").a("class", "w3-cell ").f();
				{ e("a").a("href", "/compte").a("class", "").f();
					e("i").a("class", "fad fa-money-check w3-padding-small ").f().g("i");
					sx("voir tous les comptes");
				} g("a");
			} g("div");
			{ e("div").a("class", "w3-cell ").f();
				{ e("a").a("id", "rechargerCompteGenPage").a("href", "/compte").a("class", "").a("onclick", "patchCompteBancaireVals([], {}, function() { ajouterLueur($('#rechargerCompteGenPage')); }, function() { ajouterErreur($('#rechargerCompteGenPage')); }); return false; ").f();
					e("i").a("class", "fas fa-sync-alt w3-padding-small ").f().g("i");
					sx("recharger tous les comptes");
				} g("a");
			} g("div");
		} g("div");
		{ e("div").a("class", "w3-cell-row w3-padding ").f();
			{ e("div").a("class", "w3-cell ").f();
				{ e("span").f();
					sx("rechercher comptes : ");
				} g("span");
			} g("div");
		} g("div");
		{ e("div").a("class", "w3-cell-row w3-padding ").f();
			{ e("div").a("class", "w3-cell ").f();
				{ e("div").a("class", "w3-cell-row ").f();

					e("i").a("class", "far fa-search w3-xxlarge w3-cell w3-cell-middle ").f().g("i");
					{ e("form").a("action", "").a("id", "suggereFormCompteBancaire").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
						e("input")
							.a("type", "text")
							.a("placeholder", "rechercher comptes")
							.a("class", "suggereCompteBancaire w3-input w3-border w3-cell w3-cell-middle ")
							.a("name", "suggereCompteBancaire")
							.a("id", "suggereCompteBancaire")
							.a("autocomplete", "off")
							.a("oninput", "suggereCompteBancaireObjetSuggere( [ { 'name': 'q', 'value': 'objetSuggere:' + $(this).val() } ], $('#suggereListCompteBancaire')); ")
							.fg();

					} g("form");
				} g("div");
			} g("div");
		} g("div");
		{ e("div").a("class", "w3-cell-row w3-padding ").f();
			{ e("div").a("class", "w3-cell w3-left-align w3-cell-top ").f();
				{ e("ul").a("class", "w3-ul w3-hoverable ").a("id", "suggereListCompteBancaire").f();
				} g("ul");
			} g("div");
		} g("div");
	}

}
