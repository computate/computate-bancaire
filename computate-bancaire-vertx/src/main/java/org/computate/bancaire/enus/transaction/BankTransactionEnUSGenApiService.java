package org.computate.bancaire.enus.transaction;

import org.computate.bancaire.enus.contexte.SiteContextEnUS;
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
 * Translate: false
 * classCanonicalName.frFR: org.computate.bancaire.frfr.transaction.TransactionBancaireFrFRGenApiService
 * Gen: false
 **/
@WebApiServiceGen
@ProxyGen
public interface BankTransactionEnUSGenApiService {
	static void registerService(SiteContextEnUS siteContext, Vertx vertx) {
		new ServiceBinder(vertx).setAddress("computate-bancaire-commun-enUS-BankTransaction").register(BankTransactionEnUSGenApiService.class, new BankTransactionEnUSApiServiceImpl(siteContext));
	}

	static BankTransactionEnUSGenApiService create(SiteContextEnUS siteContext, Vertx vertx) {
		return new BankTransactionEnUSApiServiceImpl(siteContext);
	}

	// Une méthode d'usine pour créer une instance et un proxy. 
	static BankTransactionEnUSGenApiService createProxy(Vertx vertx, String address) {
		return new BankTransactionEnUSGenApiServiceVertxEBProxy(vertx, address);
	}

	public void postBankTransaction(JsonObject body, OperationRequest operationRequest, Handler<AsyncResult<OperationResponse>> eventHandler);
	public void patchBankTransaction(JsonObject body, OperationRequest operationRequest, Handler<AsyncResult<OperationResponse>> eventHandler);
	public void getBankTransaction(OperationRequest operationRequest, Handler<AsyncResult<OperationResponse>> eventHandler);
	public void deleteBankTransaction(OperationRequest operationRequest, Handler<AsyncResult<OperationResponse>> eventHandler);
	public void searchBankTransaction(OperationRequest operationRequest, Handler<AsyncResult<OperationResponse>> eventHandler);
	public void searchpageBankTransactionId(OperationRequest operationRequest, Handler<AsyncResult<OperationResponse>> eventHandler);
	public void searchpageBankTransaction(OperationRequest operationRequest, Handler<AsyncResult<OperationResponse>> eventHandler);
}
