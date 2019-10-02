package org.computate.bancaire.frfr.transaction;

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
 * classeNomCanonique.enUS: org.computate.bancaire.enus.transaction.BankTransactionEnUSGenApiService
 * Gen: false
 **/
@WebApiServiceGen
@ProxyGen
public interface TransactionBancaireFrFRGenApiService {
	static void enregistrerService(SiteContexteFrFR siteContexte, Vertx vertx) {
		new ServiceBinder(vertx).setAddress("frFRTransactionBancaire").register(TransactionBancaireFrFRGenApiService.class, new TransactionBancaireFrFRApiServiceImpl(siteContexte));
	}

	static TransactionBancaireFrFRGenApiService creer(SiteContexteFrFR siteContexte, Vertx vertx) {
		return new TransactionBancaireFrFRApiServiceImpl(siteContexte);
	}

	// Une méthode d'usine pour créer une instance et un proxy. 
	static TransactionBancaireFrFRGenApiService creerProxy(Vertx vertx, String addresse) {
		return new TransactionBancaireFrFRGenApiServiceVertxEBProxy(vertx, addresse);
	}

	public void postTransactionBancaire(JsonObject body, OperationRequest operationRequete, Handler<AsyncResult<OperationResponse>> gestionnaireEvenements);
	public void patchTransactionBancaire(JsonObject body, OperationRequest operationRequete, Handler<AsyncResult<OperationResponse>> gestionnaireEvenements);
	public void getTransactionBancaire(OperationRequest operationRequete, Handler<AsyncResult<OperationResponse>> gestionnaireEvenements);
	public void deleteTransactionBancaire(OperationRequest operationRequete, Handler<AsyncResult<OperationResponse>> gestionnaireEvenements);
	public void rechercheTransactionBancaire(OperationRequest operationRequete, Handler<AsyncResult<OperationResponse>> gestionnaireEvenements);
	public void pagerechercheTransactionBancaireId(OperationRequest operationRequete, Handler<AsyncResult<OperationResponse>> gestionnaireEvenements);
	public void pagerechercheTransactionBancaire(OperationRequest operationRequete, Handler<AsyncResult<OperationResponse>> gestionnaireEvenements);
}
