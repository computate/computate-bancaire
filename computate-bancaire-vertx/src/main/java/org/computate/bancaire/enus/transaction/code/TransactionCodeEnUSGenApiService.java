package org.computate.bancaire.enus.transaction.code;

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
 * classCanonicalName.frFR: org.computate.bancaire.frfr.transaction.code.CodeTransactionFrFRGenApiService
 * Gen: false
 **/
@WebApiServiceGen
@ProxyGen
public interface TransactionCodeEnUSGenApiService {
	static void registerService(SiteContextEnUS siteContext, Vertx vertx) {
		new ServiceBinder(vertx).setAddress("computate-bancaire-commun-enUS-TransactionCode").register(TransactionCodeEnUSGenApiService.class, new TransactionCodeEnUSApiServiceImpl(siteContext));
	}

	static TransactionCodeEnUSGenApiService create(SiteContextEnUS siteContext, Vertx vertx) {
		return new TransactionCodeEnUSApiServiceImpl(siteContext);
	}

	// Une méthode d'usine pour créer une instance et un proxy. 
	static TransactionCodeEnUSGenApiService createProxy(Vertx vertx, String address) {
		return new TransactionCodeEnUSGenApiServiceVertxEBProxy(vertx, address);
	}

	public void postTransactionCode(JsonObject body, OperationRequest operationRequest, Handler<AsyncResult<OperationResponse>> eventHandler);
	public void patchTransactionCode(JsonObject body, OperationRequest operationRequest, Handler<AsyncResult<OperationResponse>> eventHandler);
	public void getTransactionCode(OperationRequest operationRequest, Handler<AsyncResult<OperationResponse>> eventHandler);
	public void deleteTransactionCode(OperationRequest operationRequest, Handler<AsyncResult<OperationResponse>> eventHandler);
	public void searchTransactionCode(OperationRequest operationRequest, Handler<AsyncResult<OperationResponse>> eventHandler);
	public void searchpageTransactionCodeId(OperationRequest operationRequest, Handler<AsyncResult<OperationResponse>> eventHandler);
	public void searchpageTransactionCode(OperationRequest operationRequest, Handler<AsyncResult<OperationResponse>> eventHandler);
}
