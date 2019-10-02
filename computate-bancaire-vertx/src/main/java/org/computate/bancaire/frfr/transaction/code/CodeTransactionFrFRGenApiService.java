package org.computate.bancaire.frfr.transaction.code;

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
 * classeNomCanonique.enUS: org.computate.bancaire.enus.transaction.code.TransactionCodeEnUSGenApiService
 * Gen: false
 **/
@WebApiServiceGen
@ProxyGen
public interface CodeTransactionFrFRGenApiService {
	static void enregistrerService(SiteContexteFrFR siteContexte, Vertx vertx) {
		new ServiceBinder(vertx).setAddress("frFRCodeTransaction").register(CodeTransactionFrFRGenApiService.class, new CodeTransactionFrFRApiServiceImpl(siteContexte));
	}

	static CodeTransactionFrFRGenApiService creer(SiteContexteFrFR siteContexte, Vertx vertx) {
		return new CodeTransactionFrFRApiServiceImpl(siteContexte);
	}

	// Une méthode d'usine pour créer une instance et un proxy. 
	static CodeTransactionFrFRGenApiService creerProxy(Vertx vertx, String addresse) {
		return new CodeTransactionFrFRGenApiServiceVertxEBProxy(vertx, addresse);
	}

	public void postCodeTransaction(JsonObject body, OperationRequest operationRequete, Handler<AsyncResult<OperationResponse>> gestionnaireEvenements);
	public void patchCodeTransaction(JsonObject body, OperationRequest operationRequete, Handler<AsyncResult<OperationResponse>> gestionnaireEvenements);
	public void getCodeTransaction(OperationRequest operationRequete, Handler<AsyncResult<OperationResponse>> gestionnaireEvenements);
	public void deleteCodeTransaction(OperationRequest operationRequete, Handler<AsyncResult<OperationResponse>> gestionnaireEvenements);
	public void rechercheCodeTransaction(OperationRequest operationRequete, Handler<AsyncResult<OperationResponse>> gestionnaireEvenements);
	public void pagerechercheCodeTransactionId(OperationRequest operationRequete, Handler<AsyncResult<OperationResponse>> gestionnaireEvenements);
	public void pagerechercheCodeTransaction(OperationRequest operationRequete, Handler<AsyncResult<OperationResponse>> gestionnaireEvenements);
}
