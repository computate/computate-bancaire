package org.computate.bancaire.frfr.ajustement;

import org.computate.bancaire.frfr.contexte.SiteContexteFrFR;
import io.vertx.codegen.annotations.ProxyGen;
import io.vertx.ext.web.api.generator.WebApiServiceGen;
import io.vertx.serviceproxy.ServiceBinder;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.core.json.JsonArray;
import io.vertx.ext.web.api.OperationRequest;
import io.vertx.ext.web.api.OperationResponse;

/**
 * Traduire: false
 * classeNomCanonique.enUS: org.computate.bancaire.enus.adjustment.BankAdjustmentEnUSGenApiService
 * Gen: false
 **/
@WebApiServiceGen
@ProxyGen
public interface AjustementBancaireFrFRGenApiService {
	static void enregistrerService(SiteContexteFrFR siteContexte, Vertx vertx) {
		new ServiceBinder(vertx).setAddress("frFRAjustementBancaire").register(AjustementBancaireFrFRGenApiService.class, new AjustementBancaireFrFRApiServiceImpl(siteContexte));
	}

	static AjustementBancaireFrFRGenApiService creer(SiteContexteFrFR siteContexte, Vertx vertx) {
		return new AjustementBancaireFrFRApiServiceImpl(siteContexte);
	}

	// Une méthode d'usine pour créer une instance et un proxy. 
	static AjustementBancaireFrFRGenApiService creerProxy(Vertx vertx, String addresse) {
		return new AjustementBancaireFrFRGenApiServiceVertxEBProxy(vertx, addresse);
	}

	public void postAjustementBancaire(JsonObject body, OperationRequest operationRequete, Handler<AsyncResult<OperationResponse>> gestionnaireEvenements);
	public void patchAjustementBancaire(JsonObject body, OperationRequest operationRequete, Handler<AsyncResult<OperationResponse>> gestionnaireEvenements);
	public void getAjustementBancaire(OperationRequest operationRequete, Handler<AsyncResult<OperationResponse>> gestionnaireEvenements);
	public void deleteAjustementBancaire(OperationRequest operationRequete, Handler<AsyncResult<OperationResponse>> gestionnaireEvenements);
	public void rechercheAjustementBancaire(OperationRequest operationRequete, Handler<AsyncResult<OperationResponse>> gestionnaireEvenements);
	public void pagerechercheAjustementBancaireId(OperationRequest operationRequete, Handler<AsyncResult<OperationResponse>> gestionnaireEvenements);
	public void pagerechercheAjustementBancaire(OperationRequest operationRequete, Handler<AsyncResult<OperationResponse>> gestionnaireEvenements);
}
