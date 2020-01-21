package org.computate.bancaire.enus.adjustment;

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
 * classCanonicalName.frFR: org.computate.bancaire.frfr.ajustement.AjustementBancaireFrFRGenApiService
 * Gen: false
 **/
@WebApiServiceGen
@ProxyGen
public interface BankAdjustmentEnUSGenApiService {
	static void registerService(SiteContextEnUS siteContext, Vertx vertx) {
		new ServiceBinder(vertx).setAddress("computate-bancaire-commun-enUS-BankAdjustment").register(BankAdjustmentEnUSGenApiService.class, new BankAdjustmentEnUSApiServiceImpl(siteContext));
	}

	static BankAdjustmentEnUSGenApiService create(SiteContextEnUS siteContext, Vertx vertx) {
		return new BankAdjustmentEnUSApiServiceImpl(siteContext);
	}

	// Une méthode d'usine pour créer une instance et un proxy. 
	static BankAdjustmentEnUSGenApiService createProxy(Vertx vertx, String address) {
		return new BankAdjustmentEnUSGenApiServiceVertxEBProxy(vertx, address);
	}

	public void postBankAdjustment(JsonObject body, OperationRequest operationRequest, Handler<AsyncResult<OperationResponse>> eventHandler);
	public void patchBankAdjustment(JsonObject body, OperationRequest operationRequest, Handler<AsyncResult<OperationResponse>> eventHandler);
	public void getBankAdjustment(OperationRequest operationRequest, Handler<AsyncResult<OperationResponse>> eventHandler);
	public void deleteBankAdjustment(OperationRequest operationRequest, Handler<AsyncResult<OperationResponse>> eventHandler);
	public void searchBankAdjustment(OperationRequest operationRequest, Handler<AsyncResult<OperationResponse>> eventHandler);
	public void searchpageBankAdjustmentId(OperationRequest operationRequest, Handler<AsyncResult<OperationResponse>> eventHandler);
	public void searchpageBankAdjustment(OperationRequest operationRequest, Handler<AsyncResult<OperationResponse>> eventHandler);
}
