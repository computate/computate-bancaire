package org.computate.bancaire.frfr.utilisateur;

import org.computate.bancaire.frfr.config.ConfigSite;
import org.computate.bancaire.frfr.requete.RequeteSiteFrFR;
import org.computate.bancaire.frfr.contexte.SiteContexteFrFR;
import org.computate.bancaire.frfr.utilisateur.UtilisateurSite;
import org.computate.bancaire.frfr.requete.patch.RequetePatch;
import org.computate.bancaire.frfr.recherche.ResultatRecherche;
import io.vertx.core.WorkerExecutor;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import io.vertx.core.json.Json;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrQuery.ORDER;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.util.ClientUtils;
import org.apache.commons.lang3.StringUtils;
import java.security.Principal;
import org.apache.commons.lang3.exception.ExceptionUtils;
import java.io.PrintWriter;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrDocument;
import java.util.Collection;
import java.math.BigDecimal;
import java.util.Date;
import java.time.format.DateTimeFormatter;
import java.time.ZoneId;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import io.vertx.core.Handler;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.Router;
import io.vertx.core.Vertx;
import io.vertx.ext.reactivestreams.ReactiveReadStream;
import io.vertx.ext.reactivestreams.ReactiveWriteStream;
import io.vertx.core.MultiMap;
import io.vertx.ext.auth.oauth2.OAuth2Auth;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.ext.web.api.validation.HTTPRequestValidationHandler;
import io.vertx.ext.web.api.validation.ParameterTypeValidator;
import io.vertx.ext.web.api.validation.ValidationException;
import io.vertx.ext.web.api.contract.openapi3.OpenAPI3RouterFactory;
import io.vertx.ext.sql.SQLClient;
import io.vertx.ext.sql.SQLConnection;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.sql.Timestamp;
import io.vertx.core.Future;
import io.vertx.core.http.CaseInsensitiveHeaders;
import io.vertx.core.AsyncResult;
import io.vertx.core.buffer.Buffer;
import io.vertx.ext.web.api.OperationResponse;
import io.vertx.core.CompositeFuture;
import org.apache.http.client.utils.URLEncodedUtils;
import java.nio.charset.Charset;
import org.apache.http.NameValuePair;
import io.vertx.ext.web.api.OperationRequest;
import io.vertx.ext.auth.oauth2.KeycloakHelper;
import java.util.Optional;
import java.util.stream.Stream;
import java.net.URLDecoder;
import java.time.ZonedDateTime;
import org.apache.solr.common.util.SimpleOrderedMap;
import org.apache.commons.collections.CollectionUtils;
import org.computate.bancaire.frfr.recherche.ListeRecherche;
import org.computate.bancaire.frfr.ecrivain.ToutEcrivain;


/**
 * Traduire: false
 **/
public class UtilisateurSiteFrFRGenApiServiceImpl implements UtilisateurSiteFrFRGenApiService {

	protected static final Logger LOGGER = LoggerFactory.getLogger(UtilisateurSiteFrFRGenApiServiceImpl.class);

	protected static final String SERVICE_ADDRESS = "UtilisateurSiteFrFRApiServiceImpl";

	protected SiteContexteFrFR siteContexte;

	public UtilisateurSiteFrFRGenApiServiceImpl(SiteContexteFrFR siteContexte) {
		this.siteContexte = siteContexte;
		UtilisateurSiteFrFRGenApiService service = UtilisateurSiteFrFRGenApiService.creerProxy(siteContexte.getVertx(), SERVICE_ADDRESS);
	}

	// PATCH //

	@Override
	public void patchUtilisateurSite(JsonObject body, OperationRequest operationRequete, Handler<AsyncResult<OperationResponse>> gestionnaireEvenements) {
		try {
			RequeteSiteFrFR requeteSite = genererRequeteSiteFrFRPourUtilisateurSite(siteContexte, operationRequete, body);
			sqlUtilisateurSite(requeteSite, a -> {
				if(a.succeeded()) {
					utilisateurUtilisateurSite(requeteSite, b -> {
						if(b.succeeded()) {
							SQLConnection connexionSql = requeteSite.getConnexionSql();
							connexionSql.close(c -> {
								if(c.succeeded()) {
									rechercheUtilisateurSite(requeteSite, false, true, null, d -> {
										if(d.succeeded()) {
											ListeRecherche<UtilisateurSite> listeUtilisateurSite = d.result();
											SimpleOrderedMap facets = (SimpleOrderedMap)Optional.ofNullable(listeUtilisateurSite.getQueryResponse()).map(QueryResponse::getResponse).map(r -> r.get("facets")).orElse(null);
											Date date = null;
											if(facets != null)
												date = (Date)facets.get("max_modifie");
											String dt;
											if(date == null)
												dt = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").format(ZonedDateTime.ofInstant(ZonedDateTime.now().toInstant(), ZoneId.of("UTC")).minusNanos(1000));
											else
												dt = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").format(ZonedDateTime.ofInstant(date.toInstant(), ZoneId.of("UTC")));
											listeUtilisateurSite.addFilterQuery(String.format("modifie_indexed_date:[* TO %s]", dt));

											RequetePatch requetePatch = new RequetePatch();
											requetePatch.setRows(listeUtilisateurSite.getRows());
											requetePatch.setNumFound(Optional.ofNullable(listeUtilisateurSite.getQueryResponse()).map(QueryResponse::getResults).map(SolrDocumentList::getNumFound).orElse(new Long(listeUtilisateurSite.size())));
											requetePatch.initLoinRequetePatch(requeteSite);
											requeteSite.setRequetePatch_(requetePatch);
											if(listeUtilisateurSite.size() == 1) {
												UtilisateurSite o = listeUtilisateurSite.get(0);
												requetePatch.setPk(o.getPk());
												requetePatch.setOriginal(o);
												requetePatchUtilisateurSite(o);
											}
											WorkerExecutor executeurTravailleur = siteContexte.getExecuteurTravailleur();
											executeurTravailleur.executeBlocking(
												blockingCodeHandler -> {
													sqlUtilisateurSite(requeteSite, e -> {
														if(e.succeeded()) {
															try {
																listePATCHUtilisateurSite(requetePatch, listeUtilisateurSite, dt, f -> {
																	if(f.succeeded()) {
																		SQLConnection connexionSql2 = requeteSite.getConnexionSql();
																		if(connexionSql2 == null) {
																			blockingCodeHandler.handle(Future.succeededFuture(f.result()));
																		} else {
																			connexionSql2.commit(g -> {
																				if(f.succeeded()) {
																					connexionSql2.close(h -> {
																						if(g.succeeded()) {
																							blockingCodeHandler.handle(Future.succeededFuture(h.result()));
																						} else {
																							blockingCodeHandler.handle(Future.failedFuture(h.cause()));
																						}
																					});
																				} else {
																					blockingCodeHandler.handle(Future.failedFuture(g.cause()));
																				}
																			});
																		}
																	} else {
																		blockingCodeHandler.handle(Future.failedFuture(f.cause()));
																	}
																});
															} catch(Exception ex) {
																blockingCodeHandler.handle(Future.failedFuture(ex));
															}
														} else {
															blockingCodeHandler.handle(Future.failedFuture(e.cause()));
														}
													});
												}, resultHandler -> {
												}
											);
											reponse200PATCHUtilisateurSite(requetePatch, gestionnaireEvenements);
										} else {
											erreurUtilisateurSite(requeteSite, gestionnaireEvenements, c);
										}
									});
								} else {
									erreurUtilisateurSite(requeteSite, gestionnaireEvenements, b);
								}
							});
						} else {
							erreurUtilisateurSite(requeteSite, gestionnaireEvenements, b);
						}
					});
				} else {
					erreurUtilisateurSite(requeteSite, gestionnaireEvenements, a);
				}
			});
		} catch(Exception e) {
			erreurUtilisateurSite(null, gestionnaireEvenements, Future.failedFuture(e));
		}
	}

	public void listePATCHUtilisateurSite(RequetePatch requetePatch, ListeRecherche<UtilisateurSite> listeUtilisateurSite, String dt, Handler<AsyncResult<OperationResponse>> gestionnaireEvenements) {
		List<Future> futures = new ArrayList<>();
		RequeteSiteFrFR requeteSite = listeUtilisateurSite.getRequeteSite_();
		listeUtilisateurSite.getList().forEach(o -> {
			futures.add(
				futurePATCHUtilisateurSite(o, a -> {
					if(a.succeeded()) {
					} else {
						erreurUtilisateurSite(requeteSite, gestionnaireEvenements, a);
					}
				})
			);
		});
		CompositeFuture.all(futures).setHandler( a -> {
			if(a.succeeded()) {
				requetePatch.setNumPATCH(requetePatch.getNumPATCH() + listeUtilisateurSite.size());
				if(listeUtilisateurSite.next(dt)) {
					requeteSite.getVertx().eventBus().publish("websocketUtilisateurSite", JsonObject.mapFrom(requetePatch).toString());
					listePATCHUtilisateurSite(requetePatch, listeUtilisateurSite, dt, gestionnaireEvenements);
				} else {
					reponse200PATCHUtilisateurSite(requetePatch, gestionnaireEvenements);
				}
			} else {
				erreurUtilisateurSite(listeUtilisateurSite.getRequeteSite_(), gestionnaireEvenements, a);
			}
		});
	}

	public void requetePatchUtilisateurSite(UtilisateurSite o) {
		RequetePatch requetePatch = o.getRequeteSite_().getRequetePatch_();
		if(requetePatch != null) {
			List<Long> pks = requetePatch.getPks();
			List<String> classes = requetePatch.getClasses();
		}
	}

	public Future<UtilisateurSite> futurePATCHUtilisateurSite(UtilisateurSite o,  Handler<AsyncResult<OperationResponse>> gestionnaireEvenements) {
		Future<UtilisateurSite> future = Future.future();
		try {
			sqlPATCHUtilisateurSite(o, a -> {
				if(a.succeeded()) {
					UtilisateurSite utilisateurSite = a.result();
					definirUtilisateurSite(utilisateurSite, b -> {
						if(b.succeeded()) {
							attribuerUtilisateurSite(utilisateurSite, c -> {
								if(c.succeeded()) {
									indexerUtilisateurSite(utilisateurSite, d -> {
										if(d.succeeded()) {
											requetePatchUtilisateurSite(utilisateurSite);
											utilisateurSite.requetePatchUtilisateurSite();
											future.complete(o);
											gestionnaireEvenements.handle(Future.succeededFuture(d.result()));
										} else {
											gestionnaireEvenements.handle(Future.failedFuture(d.cause()));
										}
									});
								} else {
									gestionnaireEvenements.handle(Future.failedFuture(c.cause()));
								}
							});
						} else {
							gestionnaireEvenements.handle(Future.failedFuture(b.cause()));
						}
					});
				} else {
					gestionnaireEvenements.handle(Future.failedFuture(a.cause()));
				}
			});
			return future;
		} catch(Exception e) {
			return Future.failedFuture(e);
		}
	}

	public void sqlPATCHUtilisateurSite(UtilisateurSite o, Handler<AsyncResult<UtilisateurSite>> gestionnaireEvenements) {
		try {
			RequeteSiteFrFR requeteSite = o.getRequeteSite_();
			SQLConnection connexionSql = requeteSite.getConnexionSql();
			Long pk = o.getPk();
			JsonObject requeteJson = requeteSite.getObjetJson();
			StringBuilder patchSql = new StringBuilder();
			List<Object> patchSqlParams = new ArrayList<Object>();
			Set<String> methodeNoms = requeteJson.fieldNames();
			UtilisateurSite o2 = new UtilisateurSite();

			patchSql.append(SiteContexteFrFR.SQL_modifier);
			patchSqlParams.addAll(Arrays.asList(pk, "org.computate.bancaire.frfr.utilisateur.UtilisateurSite"));
			for(String methodeNom : methodeNoms) {
				switch(methodeNom) {
					case "setCree":
						if(requeteJson.getString(methodeNom) == null) {
							patchSql.append(SiteContexteFrFR.SQL_removeD);
							patchSqlParams.addAll(Arrays.asList(pk, "cree"));
						} else {
							o2.setCree(requeteJson.getString(methodeNom));
							patchSql.append(SiteContexteFrFR.SQL_setD);
							patchSqlParams.addAll(Arrays.asList("cree", o2.jsonCree(), pk));
						}
						break;
					case "setModifie":
						if(requeteJson.getString(methodeNom) == null) {
							patchSql.append(SiteContexteFrFR.SQL_removeD);
							patchSqlParams.addAll(Arrays.asList(pk, "modifie"));
						} else {
							o2.setModifie(requeteJson.getString(methodeNom));
							patchSql.append(SiteContexteFrFR.SQL_setD);
							patchSqlParams.addAll(Arrays.asList("modifie", o2.jsonModifie(), pk));
						}
						break;
					case "setArchive":
						if(requeteJson.getBoolean(methodeNom) == null) {
							patchSql.append(SiteContexteFrFR.SQL_removeD);
							patchSqlParams.addAll(Arrays.asList(pk, "archive"));
						} else {
							o2.setArchive(requeteJson.getBoolean(methodeNom));
							patchSql.append(SiteContexteFrFR.SQL_setD);
							patchSqlParams.addAll(Arrays.asList("archive", o2.jsonArchive(), pk));
						}
						break;
					case "setSupprime":
						if(requeteJson.getBoolean(methodeNom) == null) {
							patchSql.append(SiteContexteFrFR.SQL_removeD);
							patchSqlParams.addAll(Arrays.asList(pk, "supprime"));
						} else {
							o2.setSupprime(requeteJson.getBoolean(methodeNom));
							patchSql.append(SiteContexteFrFR.SQL_setD);
							patchSqlParams.addAll(Arrays.asList("supprime", o2.jsonSupprime(), pk));
						}
						break;
					case "setUtilisateurRecevoirCourriels":
						if(requeteJson.getBoolean(methodeNom) == null) {
							patchSql.append(SiteContexteFrFR.SQL_removeD);
							patchSqlParams.addAll(Arrays.asList(pk, "utilisateurRecevoirCourriels"));
						} else {
							o2.setUtilisateurRecevoirCourriels(requeteJson.getBoolean(methodeNom));
							patchSql.append(SiteContexteFrFR.SQL_setD);
							patchSqlParams.addAll(Arrays.asList("utilisateurRecevoirCourriels", o2.jsonUtilisateurRecevoirCourriels(), pk));
						}
						break;
					case "setVoirArchive":
						if(requeteJson.getBoolean(methodeNom) == null) {
							patchSql.append(SiteContexteFrFR.SQL_removeD);
							patchSqlParams.addAll(Arrays.asList(pk, "voirArchive"));
						} else {
							o2.setVoirArchive(requeteJson.getBoolean(methodeNom));
							patchSql.append(SiteContexteFrFR.SQL_setD);
							patchSqlParams.addAll(Arrays.asList("voirArchive", o2.jsonVoirArchive(), pk));
						}
						break;
					case "setVoirSupprime":
						if(requeteJson.getBoolean(methodeNom) == null) {
							patchSql.append(SiteContexteFrFR.SQL_removeD);
							patchSqlParams.addAll(Arrays.asList(pk, "voirSupprime"));
						} else {
							o2.setVoirSupprime(requeteJson.getBoolean(methodeNom));
							patchSql.append(SiteContexteFrFR.SQL_setD);
							patchSqlParams.addAll(Arrays.asList("voirSupprime", o2.jsonVoirSupprime(), pk));
						}
						break;
				}
			}
			connexionSql.queryWithParams(
					patchSql.toString()
					, new JsonArray(patchSqlParams)
					, patchAsync
			-> {
				if(patchAsync.succeeded()) {
					UtilisateurSite o3 = new UtilisateurSite();
					o3.setRequeteSite_(o.getRequeteSite_());
					o3.setPk(pk);
					gestionnaireEvenements.handle(Future.succeededFuture(o3));
				} else {
					gestionnaireEvenements.handle(Future.failedFuture(new Exception(patchAsync.cause())));
				}
			});
		} catch(Exception e) {
			gestionnaireEvenements.handle(Future.failedFuture(e));
		}
	}

	public void reponse200PATCHUtilisateurSite(RequetePatch requetePatch, Handler<AsyncResult<OperationResponse>> gestionnaireEvenements) {
		try {
			RequeteSiteFrFR requeteSite = requetePatch.getRequeteSite_();
			JsonObject json = JsonObject.mapFrom(requetePatch);
			gestionnaireEvenements.handle(Future.succeededFuture(OperationResponse.completedWithJson(json)));
		} catch(Exception e) {
			gestionnaireEvenements.handle(Future.failedFuture(e));
		}
	}

	// PageRecherche //

	@Override
	public void pagerechercheUtilisateurSiteId(OperationRequest operationRequete, Handler<AsyncResult<OperationResponse>> gestionnaireEvenements) {
		pagerechercheUtilisateurSite(operationRequete, gestionnaireEvenements);
	}

	@Override
	public void pagerechercheUtilisateurSite(OperationRequest operationRequete, Handler<AsyncResult<OperationResponse>> gestionnaireEvenements) {
		try {
			RequeteSiteFrFR requeteSite = genererRequeteSiteFrFRPourUtilisateurSite(siteContexte, operationRequete);
			sqlUtilisateurSite(requeteSite, a -> {
				if(a.succeeded()) {
					utilisateurUtilisateurSite(requeteSite, b -> {
						if(b.succeeded()) {
							rechercheUtilisateurSite(requeteSite, false, true, "/utilisateur", c -> {
								if(c.succeeded()) {
									ListeRecherche<UtilisateurSite> listeUtilisateurSite = c.result();
									reponse200PageRechercheUtilisateurSite(listeUtilisateurSite, d -> {
										if(d.succeeded()) {
											SQLConnection connexionSql = requeteSite.getConnexionSql();
											if(connexionSql == null) {
												gestionnaireEvenements.handle(Future.succeededFuture(d.result()));
											} else {
												connexionSql.commit(e -> {
													if(e.succeeded()) {
														connexionSql.close(f -> {
															if(f.succeeded()) {
																gestionnaireEvenements.handle(Future.succeededFuture(d.result()));
															} else {
																erreurUtilisateurSite(requeteSite, gestionnaireEvenements, f);
															}
														});
													} else {
														gestionnaireEvenements.handle(Future.succeededFuture(d.result()));
													}
												});
											}
										} else {
											erreurUtilisateurSite(requeteSite, gestionnaireEvenements, d);
										}
									});
								} else {
									erreurUtilisateurSite(requeteSite, gestionnaireEvenements, c);
								}
							});
						} else {
							erreurUtilisateurSite(requeteSite, gestionnaireEvenements, b);
						}
					});
				} else {
					erreurUtilisateurSite(requeteSite, gestionnaireEvenements, a);
				}
			});
		} catch(Exception e) {
			erreurUtilisateurSite(null, gestionnaireEvenements, Future.failedFuture(e));
		}
	}

	public void reponse200PageRechercheUtilisateurSite(ListeRecherche<UtilisateurSite> listeUtilisateurSite, Handler<AsyncResult<OperationResponse>> gestionnaireEvenements) {
		try {
			RequeteSiteFrFR requeteSite = listeUtilisateurSite.getRequeteSite_();
			Buffer buffer = Buffer.buffer();
			ToutEcrivain w = ToutEcrivain.creer(listeUtilisateurSite.getRequeteSite_(), buffer);
			UtilisateurSitePage page = new UtilisateurSitePage();
			SolrDocument pageDocumentSolr = new SolrDocument();
			CaseInsensitiveHeaders requeteEnTetes = new CaseInsensitiveHeaders();
			requeteSite.setRequeteEnTetes(requeteEnTetes);

			pageDocumentSolr.setField("pageUri_frFR_stored_string", "/utilisateur");
			page.setPageDocumentSolr(pageDocumentSolr);
			page.setW(w);
			if(listeUtilisateurSite.size() == 1)
				requeteSite.setRequetePk(listeUtilisateurSite.get(0).getPk());
			requeteSite.setW(w);
			page.setListeUtilisateurSite(listeUtilisateurSite);
			page.setRequeteSite_(requeteSite);
			page.initLoinUtilisateurSitePage(requeteSite);
			page.html();
			gestionnaireEvenements.handle(Future.succeededFuture(new OperationResponse(200, "OK", buffer, requeteEnTetes)));
		} catch(Exception e) {
			gestionnaireEvenements.handle(Future.failedFuture(e));
		}
	}

	// Partagé //

	public void erreurUtilisateurSite(RequeteSiteFrFR requeteSite, Handler<AsyncResult<OperationResponse>> gestionnaireEvenements, AsyncResult<?> resultatAsync) {
		Throwable e = resultatAsync.cause();
		ExceptionUtils.printRootCauseStackTrace(e);
		OperationResponse reponseOperation = new OperationResponse(400, "BAD REQUEST", 
			Buffer.buffer().appendString(
				new JsonObject() {{
					put("erreur", new JsonObject() {{
					put("message", e.getMessage());
					}});
				}}.encodePrettily()
			)
			, new CaseInsensitiveHeaders()
		);
		if(requeteSite != null) {
			SQLConnection connexionSql = requeteSite.getConnexionSql();
			if(connexionSql != null) {
				connexionSql.rollback(a -> {
					if(a.succeeded()) {
						connexionSql.close(b -> {
							if(a.succeeded()) {
								gestionnaireEvenements.handle(Future.succeededFuture(reponseOperation));
							} else {
								gestionnaireEvenements.handle(Future.succeededFuture(reponseOperation));
							}
						});
					} else {
						gestionnaireEvenements.handle(Future.succeededFuture(reponseOperation));
					}
				});
			} else {
				gestionnaireEvenements.handle(Future.succeededFuture(reponseOperation));
			}
		} else {
			gestionnaireEvenements.handle(Future.succeededFuture(reponseOperation));
		}
	}

	public void sqlUtilisateurSite(RequeteSiteFrFR requeteSite, Handler<AsyncResult<OperationResponse>> gestionnaireEvenements) {
		try {
			SQLClient clientSql = requeteSite.getSiteContexte_().getClientSql();

			if(clientSql == null) {
				gestionnaireEvenements.handle(Future.succeededFuture());
			} else {
				clientSql.getConnection(sqlAsync -> {
					if(sqlAsync.succeeded()) {
						SQLConnection connexionSql = sqlAsync.result();
						connexionSql.setAutoCommit(false, a -> {
							if(a.succeeded()) {
								requeteSite.setConnexionSql(connexionSql);
								gestionnaireEvenements.handle(Future.succeededFuture());
							} else {
								gestionnaireEvenements.handle(Future.failedFuture(a.cause()));
							}
						});
					} else {
						gestionnaireEvenements.handle(Future.failedFuture(new Exception(sqlAsync.cause())));
					}
				});
			}
		} catch(Exception e) {
			gestionnaireEvenements.handle(Future.failedFuture(e));
		}
	}

	public RequeteSiteFrFR genererRequeteSiteFrFRPourUtilisateurSite(SiteContexteFrFR siteContexte, OperationRequest operationRequete) {
		return genererRequeteSiteFrFRPourUtilisateurSite(siteContexte, operationRequete, null);
	}

	public RequeteSiteFrFR genererRequeteSiteFrFRPourUtilisateurSite(SiteContexteFrFR siteContexte, OperationRequest operationRequete, JsonObject body) {
		Vertx vertx = siteContexte.getVertx();
		RequeteSiteFrFR requeteSite = new RequeteSiteFrFR();
		requeteSite.setObjetJson(body);
		requeteSite.setVertx(vertx);
		requeteSite.setSiteContexte_(siteContexte);
		requeteSite.setConfigSite_(siteContexte.getConfigSite());
		requeteSite.setOperationRequete(operationRequete);
		requeteSite.initLoinRequeteSiteFrFR(requeteSite);

		return requeteSite;
	}

	public void utilisateurUtilisateurSite(RequeteSiteFrFR requeteSite, Handler<AsyncResult<OperationResponse>> gestionnaireEvenements) {
		try {
			SQLConnection connexionSql = requeteSite.getConnexionSql();
			String utilisateurId = requeteSite.getUtilisateurId();
			if(utilisateurId == null) {
				gestionnaireEvenements.handle(Future.succeededFuture());
			} else {
				connexionSql.queryWithParams(
						SiteContexteFrFR.SQL_selectC
						, new JsonArray(Arrays.asList("org.computate.bancaire.frfr.utilisateur.UtilisateurSite", utilisateurId))
						, selectCAsync
				-> {
					if(selectCAsync.succeeded()) {
						JsonArray utilisateurValeurs = selectCAsync.result().getResults().stream().findFirst().orElse(null);
						if(utilisateurValeurs == null) {
							connexionSql.queryWithParams(
									SiteContexteFrFR.SQL_creer
									, new JsonArray(Arrays.asList("org.computate.bancaire.frfr.utilisateur.UtilisateurSite", utilisateurId))
									, creerAsync
							-> {
								JsonArray creerLigne = creerAsync.result().getResults().stream().findFirst().orElseGet(() -> null);
								Long pkUtilisateur = creerLigne.getLong(0);
								UtilisateurSite utilisateurSite = new UtilisateurSite();
								utilisateurSite.setRequeteSite_(requeteSite);
								utilisateurSite.setPk(pkUtilisateur);

								connexionSql.queryWithParams(
										SiteContexteFrFR.SQL_definir
										, new JsonArray(Arrays.asList(pkUtilisateur, pkUtilisateur, pkUtilisateur))
										, definirAsync
								-> {
									if(definirAsync.succeeded()) {
										try {
											for(JsonArray definition : definirAsync.result().getResults()) {
												utilisateurSite.definirPourClasse(definition.getString(0), definition.getString(1));
											}
											JsonObject utilisateurVertx = requeteSite.getOperationRequete().getUser();
											JsonObject principalJson = KeycloakHelper.parseToken(utilisateurVertx.getString("access_token"));
											utilisateurSite.setUtilisateurNom(principalJson.getString("preferred_username"));
											utilisateurSite.setUtilisateurPrenom(principalJson.getString("given_name"));
											utilisateurSite.setUtilisateurNomFamille(principalJson.getString("family_name"));
											utilisateurSite.setUtilisateurId(principalJson.getString("sub"));
											utilisateurSite.initLoinPourClasse(requeteSite);
											utilisateurSite.indexerPourClasse();
											requeteSite.setUtilisateurSite(utilisateurSite);
											requeteSite.setUtilisateurNom(principalJson.getString("preferred_username"));
											requeteSite.setUtilisateurPrenom(principalJson.getString("given_name"));
											requeteSite.setUtilisateurNomFamille(principalJson.getString("family_name"));
											requeteSite.setUtilisateurId(principalJson.getString("sub"));
											gestionnaireEvenements.handle(Future.succeededFuture());
										} catch(Exception e) {
											gestionnaireEvenements.handle(Future.failedFuture(e));
										}
									} else {
										gestionnaireEvenements.handle(Future.failedFuture(new Exception(definirAsync.cause())));
									}
								});
							});
						} else {
							Long pkUtilisateur = utilisateurValeurs.getLong(0);
							UtilisateurSite utilisateurSite = new UtilisateurSite();
								utilisateurSite.setRequeteSite_(requeteSite);
							utilisateurSite.setPk(pkUtilisateur);

							connexionSql.queryWithParams(
									SiteContexteFrFR.SQL_definir
									, new JsonArray(Arrays.asList(pkUtilisateur, pkUtilisateur, pkUtilisateur))
									, definirAsync
							-> {
								if(definirAsync.succeeded()) {
									for(JsonArray definition : definirAsync.result().getResults()) {
										utilisateurSite.definirPourClasse(definition.getString(0), definition.getString(1));
									}
									JsonObject utilisateurVertx = requeteSite.getOperationRequete().getUser();
									JsonObject principalJson = KeycloakHelper.parseToken(utilisateurVertx.getString("access_token"));
									utilisateurSite.setUtilisateurNom(principalJson.getString("preferred_username"));
									utilisateurSite.setUtilisateurPrenom(principalJson.getString("given_name"));
									utilisateurSite.setUtilisateurNomFamille(principalJson.getString("family_name"));
									utilisateurSite.setUtilisateurId(principalJson.getString("sub"));
									utilisateurSite.initLoinPourClasse(requeteSite);
									utilisateurSite.indexerPourClasse();
									requeteSite.setUtilisateurSite(utilisateurSite);
									requeteSite.setUtilisateurNom(principalJson.getString("preferred_username"));
									requeteSite.setUtilisateurPrenom(principalJson.getString("given_name"));
									requeteSite.setUtilisateurNomFamille(principalJson.getString("family_name"));
									requeteSite.setUtilisateurId(principalJson.getString("sub"));
									gestionnaireEvenements.handle(Future.succeededFuture());
								} else {
									gestionnaireEvenements.handle(Future.failedFuture(new Exception(definirAsync.cause())));
								}
							});
						}
					} else {
						gestionnaireEvenements.handle(Future.failedFuture(new Exception(selectCAsync.cause())));
					}
				});
			}
		} catch(Exception e) {
			gestionnaireEvenements.handle(Future.failedFuture(e));
		}
	}

	public void rechercheUtilisateurSite(RequeteSiteFrFR requeteSite, Boolean peupler, Boolean stocker, String classeApiUriMethode, Handler<AsyncResult<ListeRecherche<UtilisateurSite>>> gestionnaireEvenements) {
		try {
			OperationRequest operationRequete = requeteSite.getOperationRequete();
			String entiteListeStr = requeteSite.getOperationRequete().getParams().getJsonObject("query").getString("fl");
			String[] entiteListe = entiteListeStr == null ? null : entiteListeStr.split(",\\s*");
			ListeRecherche<UtilisateurSite> listeRecherche = new ListeRecherche<UtilisateurSite>();
			listeRecherche.setPeupler(peupler);
			listeRecherche.setStocker(stocker);
			listeRecherche.setQuery("*:*");
			listeRecherche.setC(UtilisateurSite.class);
			if(entiteListe != null)
				listeRecherche.addFields(entiteListe);
			listeRecherche.set("json.facet", "{max_modifie:'max(modifie_indexed_date)'}");

			String id = operationRequete.getParams().getJsonObject("path").getString("id");
			if(id != null) {
				listeRecherche.addFilterQuery("(id:" + ClientUtils.escapeQueryChars(id) + " OR objetId_indexed_string:" + ClientUtils.escapeQueryChars(id) + ")");
			}

			operationRequete.getParams().getJsonObject("query").forEach(paramRequete -> {
				String entiteVar = null;
				String valeurIndexe = null;
				String varIndexe = null;
				String valeurTri = null;
				Integer rechercheDebut = null;
				Integer rechercheNum = null;
				String paramNom = paramRequete.getKey();
				Object paramValeursObjet = paramRequete.getValue();
				JsonArray paramObjets = paramValeursObjet instanceof JsonArray ? (JsonArray)paramValeursObjet : new JsonArray().add(paramValeursObjet);

				try {
					for(Object paramObjet : paramObjets) {
						switch(paramNom) {
							case "q":
								entiteVar = StringUtils.trim(StringUtils.substringBefore((String)paramObjet, ":"));
								varIndexe = "*".equals(entiteVar) ? entiteVar : UtilisateurSite.varRechercheUtilisateurSite(entiteVar);
								valeurIndexe = URLDecoder.decode(StringUtils.trim(StringUtils.substringAfter((String)paramObjet, ":")), "UTF-8");
								valeurIndexe = StringUtils.isEmpty(valeurIndexe) ? "*" : valeurIndexe;
								listeRecherche.setQuery(varIndexe + ":" + ("*".equals(valeurIndexe) ? valeurIndexe : ClientUtils.escapeQueryChars(valeurIndexe)));
								if(!"*".equals(entiteVar)) {
									listeRecherche.setHighlight(true);
									listeRecherche.setHighlightSnippets(3);
									listeRecherche.addHighlightField(varIndexe);
									listeRecherche.setParam("hl.encoder", "html");
								}
								break;
							case "fq":
								entiteVar = StringUtils.trim(StringUtils.substringBefore((String)paramObjet, ":"));
								valeurIndexe = URLDecoder.decode(StringUtils.trim(StringUtils.substringAfter((String)paramObjet, ":")), "UTF-8");
								varIndexe = UtilisateurSite.varIndexeUtilisateurSite(entiteVar);
								listeRecherche.addFilterQuery(varIndexe + ":" + ClientUtils.escapeQueryChars(valeurIndexe));
								break;
							case "sort":
								entiteVar = StringUtils.trim(StringUtils.substringBefore((String)paramObjet, " "));
								valeurTri = StringUtils.trim(StringUtils.substringAfter((String)paramObjet, " "));
								varIndexe = UtilisateurSite.varIndexeUtilisateurSite(entiteVar);
								listeRecherche.addSort(varIndexe, ORDER.valueOf(valeurTri));
								break;
							case "start":
								rechercheDebut = (Integer)paramObjet;
								listeRecherche.setStart(rechercheDebut);
								break;
							case "rows":
								rechercheNum = (Integer)paramObjet;
								listeRecherche.setRows(rechercheNum);
								break;
						}
					}
				} catch(Exception e) {
					gestionnaireEvenements.handle(Future.failedFuture(e));
				}
			});
			if(listeRecherche.getSorts().size() == 0)
				listeRecherche.addSort("cree_indexed_date", ORDER.desc);
			listeRecherche.initLoinPourClasse(requeteSite);
			gestionnaireEvenements.handle(Future.succeededFuture(listeRecherche));
		} catch(Exception e) {
			gestionnaireEvenements.handle(Future.failedFuture(e));
		}
	}

	public void definirUtilisateurSite(UtilisateurSite o, Handler<AsyncResult<OperationResponse>> gestionnaireEvenements) {
		try {
			RequeteSiteFrFR requeteSite = o.getRequeteSite_();
			SQLConnection connexionSql = requeteSite.getConnexionSql();
			Long pk = o.getPk();
			connexionSql.queryWithParams(
					SiteContexteFrFR.SQL_definir
					, new JsonArray(Arrays.asList(pk, pk, pk))
					, definirAsync
			-> {
				if(definirAsync.succeeded()) {
					try {
						for(JsonArray definition : definirAsync.result().getResults()) {
							try {
								o.definirPourClasse(definition.getString(0), definition.getString(1));
							} catch(Exception e) {
								LOGGER.error(e);
							}
						}
						gestionnaireEvenements.handle(Future.succeededFuture());
					} catch(Exception e) {
						gestionnaireEvenements.handle(Future.failedFuture(e));
					}
				} else {
					gestionnaireEvenements.handle(Future.failedFuture(new Exception(definirAsync.cause())));
				}
			});
		} catch(Exception e) {
			gestionnaireEvenements.handle(Future.failedFuture(e));
		}
	}

	public void attribuerUtilisateurSite(UtilisateurSite o, Handler<AsyncResult<OperationResponse>> gestionnaireEvenements) {
		try {
			RequeteSiteFrFR requeteSite = o.getRequeteSite_();
			SQLConnection connexionSql = requeteSite.getConnexionSql();
			Long pk = o.getPk();
			connexionSql.queryWithParams(
					SiteContexteFrFR.SQL_attribuer
					, new JsonArray(Arrays.asList(pk, pk))
					, attribuerAsync
			-> {
				try {
					if(attribuerAsync.succeeded()) {
						if(attribuerAsync.result() != null) {
							for(JsonArray definition : attribuerAsync.result().getResults()) {
								if(pk.equals(definition.getLong(0)))
									o.attribuerPourClasse(definition.getString(2), definition.getLong(1));
								else
									o.attribuerPourClasse(definition.getString(3), definition.getLong(0));
							}
						}
						gestionnaireEvenements.handle(Future.succeededFuture());
					} else {
						gestionnaireEvenements.handle(Future.failedFuture(new Exception(attribuerAsync.cause())));
					}
				} catch(Exception e) {
					gestionnaireEvenements.handle(Future.failedFuture(e));
				}
			});
		} catch(Exception e) {
			gestionnaireEvenements.handle(Future.failedFuture(e));
		}
	}

	public void indexerUtilisateurSite(UtilisateurSite o, Handler<AsyncResult<OperationResponse>> gestionnaireEvenements) {
		RequeteSiteFrFR requeteSite = o.getRequeteSite_();
		try {
			o.initLoinPourClasse(requeteSite);
			o.indexerPourClasse();
			gestionnaireEvenements.handle(Future.succeededFuture());
		} catch(Exception e) {
			gestionnaireEvenements.handle(Future.failedFuture(e));
		}
	}
}
