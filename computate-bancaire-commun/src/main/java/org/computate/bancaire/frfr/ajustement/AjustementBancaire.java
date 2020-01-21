package org.computate.bancaire.frfr.ajustement;   

import java.math.BigDecimal;
import java.text.Normalizer;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.computate.bancaire.frfr.cluster.Cluster;
import org.computate.bancaire.frfr.compte.CompteBancaire;
import org.computate.bancaire.frfr.couverture.Couverture;
import org.computate.bancaire.frfr.recherche.ListeRecherche;
import org.computate.bancaire.frfr.transaction.TransactionBancaire;

/**    
 * NomCanonique.enUS: org.computate.bancaire.enus.adjustment.BankAdjustment
 * Modele: true
 * Api: true
 * Indexe: true
 * Sauvegarde: true
 * 
 * ApiTag.frFR: Ajustement
 * ApiUri.frFR: /api/ajustement
 * 
 * ApiTag.enUS: Adjustment
 * ApiUri.enUS: /api/adjustment
 * 
 * ApiMethode: POST
 * ApiMethode: PATCH
 * ApiMethode: GET
 * ApiMethode: DELETE
 * ApiMethode.frFR: Recherche
 * ApiMethode.enUS: Search
 * 
 * ApiMethode.frFR: PageRecherche
 * PagePageRecherche.frFR: AjustementPage
 * PageSuperPageRecherche.frFR: ClusterPage
 * ApiUriPageRecherche.frFR: /ajustement
 * 
 * ApiMethode.enUS: SearchPage
 * PageSearchPage.enUS: AdjustmentPage
 * PageSuperSearchPage.enUS: ClusterPage
 * ApiUriSearchPage.enUS: /ajustement
 * 
 * UnNom.frFR: un ajustement
 * UnNom.enUS: an adjustment
 * Couleur: yellow
 * IconeGroupe: duotone
 * IconeNom: cash-register
*/                              
public class AjustementBancaire extends AjustementBancaireGen<Cluster> {

	/**
	 * {@inheritDoc}
	 * Var.enUS: adjustmentKey
	 * Indexe: true
	 * Stocke: true
	 * NomAffichage.frFR: clé
	 * NomAffichage.enUS: key
	 */         
	protected void _ajustementCle(Couverture<Long> c) {
		c.o(pk);
	}

	/**
	 * {@inheritDoc}
	 * Var.enUS: accountKey
	 * Indexe: true
	 * Stocke: true
	 * Attribuer: CompteBancaire.ajustementCles
	 * Attribuer: AjustementCompte.compteCle
	 * HtmlLigne: 3
	 * HtmlCellule: 1
	 * NomAffichage.frFR: compte
	 * NomAffichage.enUS: account
	 */               
	protected void _compteCle(Couverture<Long> c) {
	}

	/**
	 * Var.enUS: accountSearch
	 * r: ajustementCles
	 * r.enUS: adjustmentKeys
	 * r: CompteBancaire
	 * r.enUS: BankAccount
	 * r: setStocker
	 * r.enUS: setStore
	 * Ignorer: true
	 */  
	protected void _compteRecherche(ListeRecherche<CompteBancaire> l) {
		if(pk == null) {
			l.setQuery(null);
		}
		else {
			l.setQuery("*:*");
			l.addFilterQuery("ajustementCles_indexed_longs:" + pk);
			l.setC(CompteBancaire.class);
			l.setStocker(true);
		}
	}

	/**
	 * {@inheritDoc}
	 * Var.enUS: account_
	 * r: compteRecherche
	 * r.enUS: accountSearch
	 * Ignorer: true
	 */    
	protected void _compte_(Couverture<CompteBancaire> c) {
		if(compteRecherche.size() > 0) {
			c.o(compteRecherche.get(0));
		}
	}

	/**
	 * {@inheritDoc}
	 * Var.enUS: accountCompleteName
	 * Indexe: true
	 * Stocke: true
	 * r: CompteNomComplet
	 * r.enUS: AccountCompleteName
	 * r: compte
	 * r.enUS: account
	 */  
	protected void _compteNomComplet(Couverture<String> c) {
		if(compte_ != null)
			c.o((String)compte_.getCompteNomComplet());
	}

	/**
	 * {@inheritDoc}
	 * Var.enUS: accountNumber
	 * Indexe: true
	 * Stocke: true
	 * r: CompteNumero
	 * r.enUS: AccountNumber
	 * r: compte
	 * r.enUS: account
	 */  
	protected void _compteNumero(Couverture<String> c) {
		if(compte_ != null)
			c.o((String)compte_.getCompteNumero());
	}

	/**
	 * {@inheritDoc}
	 * Var.enUS: transactionKey
	 * Indexe: true
	 * Stocke: true
	 * Attribuer: TransactionBancaire.ajustementCles
	 * Attribuer: AjustementTransaction.transactionCle
	 * HtmlLigne: 3
	 * HtmlCellule: 1
	 * NomAffichage.frFR: transaction
	 * NomAffichage.enUS: transaction
	 */               
	protected void _transactionCle(Couverture<Long> c) {
	}

	/**
	 * Var.enUS: transactionSearch
	 * r: ajustementCles
	 * r.enUS: adjustmentKeys
	 * r: TransactionBancaire
	 * r.enUS: BankTransaction
	 * r: setStocker
	 * r.enUS: setStore
	 * Ignorer: true
	 */  
	protected void _transactionRecherche(ListeRecherche<TransactionBancaire> l) {
		if(pk == null) {
			l.setQuery(null);
		}
		else {
			l.setQuery("*:*");
			l.addFilterQuery("ajustementCles_indexed_longs:" + pk);
			l.setC(TransactionBancaire.class);
			l.setStocker(true);
		}
	}

	/**
	 * {@inheritDoc}
	 * Var.enUS: transaction_
	 * r: transactionRecherche
	 * r.enUS: transactionSearch
	 * Ignorer: true
	 */    
	protected void _transaction_(Couverture<TransactionBancaire> c) {
		if(transactionRecherche.size() > 0) {
			c.o(transactionRecherche.get(0));
		}
	}

	/**
	 * {@inheritDoc}
	 * Var.enUS: transactionReferenceId
	 * Indexe: true
	 * Stocke: true
	 * NomAffichage.frFR: ID de référence de transaction
	 * NomAffichage.enUS: transaction reference ID
	 * r: TransactionIdReference
	 * r.enUS: TransactionReferenceId
	 */                   
	protected void _transactionIdReference(Couverture<String> c) {
		if(transaction_ != null)
			c.o(transaction_.getTransactionIdReference());
	}

	/**
	 * {@inheritDoc}
	 * Var.enUS: transactionCode
	 * Indexe: true
	 * Stocke: true
	 * r: TransactionCode
	 * r.enUS: TransactionCode
	 */                   
	protected void _transactionCode(Couverture<String> c) {
		if(transaction_ != null)
			c.o(transaction_.getTransactionCode());
	}

	/**
	 * {@inheritDoc}
	 * Var.enUS: transactionAmount
	 * Indexe: true
	 * Stocke: true
	 * NomAffichage.frFR: date et heure de la transaction
	 * NomAffichage.enUS: date and time of the transaction
	 * r: TransactionMontant
	 * r.enUS: TransactionAmount
	 */                   
	protected void _transactionMontant(Couverture<BigDecimal> c) {
		if(transaction_ != null)
			c.o(transaction_.getTransactionMontant());
	}

	/**
	 * {@inheritDoc}
	 * Var.enUS: transactionDateTime
	 * Indexe: true
	 * Stocke: true
	 * NomAffichage.frFR: date et heure de la transaction
	 * NomAffichage.enUS: date and time of the transaction
	 * r: TransactionDateHeure
	 * r.enUS: TransactionDateTime
	 */                   
	protected void _transactionDateHeure(Couverture<ZonedDateTime> c) {
		if(transaction_ != null)
			c.o(transaction_.getTransactionDateHeure());
	}

	/**
	 * {@inheritDoc}
	 * Var.enUS: transactionDate
	 * Indexe: true
	 * Stocke: true
	 * NomAffichage.frFR: date de la transaction
	 * NomAffichage.enUS: date of the transaction
	 * r: TransactionDate
	 * r.enUS: TransactionDate
	 */                   
	protected void _transactionDate(Couverture<LocalDate> c) {
		if(transaction_ != null)
			c.o(transaction_.getTransactionDate());
	}

	/**
	 * {@inheritDoc}
	 * Var.enUS: transactionFee
	 * Indexe: true
	 * Stocke: true
	 * NomAffichage.frFR: transaction de frais
	 * NomAffichage.enUS: fee transaction
	 * r: TransactionFrais
	 * r.enUS: TransactionFee
	 */                   
	protected void _transactionFrais(Couverture<Boolean> c) {
		if(transaction_ != null)
			c.o(transaction_.getTransactionFrais());
	}

	/**
	 * {@inheritDoc}
	 * Var.enUS: agentAreas
	 * Indexe: true
	 * Stocke: true
	 * Definir: true
	 * HtmlLigne: 4
	 * HtmlCelulle: 1
	 * NomAffichage.frFR: zones d'agent
	 * NomAffichage.enUS: agent areas
	 */                   
	protected void _agentZones(List<String> l) {
	}

	/**
	 * {@inheritDoc}
	 * Var.enUS: agentRoles
	 * Indexe: true
	 * Stocke: true
	 * Definir: true
	 * HtmlLigne: 4
	 * HtmlCelulle: 2
	 * NomAffichage.frFR: rôles d'agent
	 * NomAffichage.enUS: agent roles
	 */                   
	protected void _agentRoles(List<String> l) {
	}

	/**
	 * {@inheritDoc}
	 * Var.enUS: agentOverride
	 * Indexe: true
	 * Stocke: true
	 * Definir: true
	 * HtmlLigne: 4
	 * HtmlCelulle: 2
	 * NomAffichage.frFR: agent peut passer outre
	 * NomAffichage.enUS: agent can override
	 */                   
	protected void _agentPasserOutre(Couverture<Boolean> c) {
		c.o(false);
	}

	/**
	 * {@inheritDoc}
	 * Var.enUS: eligibleEntitlement
	 * Indexe: true
	 * Stocke: true
	 * Definir: true
	 * HtmlLigne: 4
	 * HtmlCelulle: 2
	 * NomAffichage.frFR: droit éligible
	 * NomAffichage.enUS: eligible entitlement
	 */                   
	protected void _droitEligible(Couverture<Boolean> c) {
		c.o(false);
	}

	/**
	 * {@inheritDoc}
	 * Var.enUS: partnerName
	 * Indexe: true
	 * Stocke: true
	 * Definir: true
	 * HtmlLigne: 4
	 * HtmlCelulle: 3
	 * NomAffichage.frFR: nom de partenaire
	 * NomAffichage.enUS: partner name
	 */                   
	protected void _partenaireNom(Couverture<String> c) {
	}

	/**
	 * {@inheritDoc}
	 * Var.enUS: adjustmentDisplayName
	 * Indexe: true
	 * Stocke: true
	 * Definir: true
	 * HtmlLigne: 3
	 * HtmlCelulle: 2
	 * NomAffichage.frFR: nom d'affichage
	 * NomAffichage.enUS: display name
	 */                   
	protected void _ajustementNomAffichage(Couverture<String> c) {}

	/**   
	 * {@inheritDoc}
	 * Var.enUS: adjustmentCompleteName
	 * Indexe: true
	 * Stocke: true
	 * VarTitre: true
	 * HtmlColonne: 1
	 * r: "ajustement %s du compte %s"
	 * r.enUS: "ajustement %s of account %s"
	 * r: "ajustement %s %s %s du compte %s"
	 * r.enUS: "ajustement %s %s %s of account %s"
	 * r: "ajustement de compte %s"
	 * r.enUS: "ajustement of account %s"
	 * r: transactionIdReference
	 * r.enUS: transactionReferenceId
	 * r: compteNumero
	 * r.enUS: accountNumber
	 * r: transactionMontant
	 * r.enUS: transactionAmount
	 */                  
	protected void _ajustementNomComplet(Couverture<String> c) {
		String o = "ajustement";

		if(transactionIdReference != null && compteNumero != null)
			o = String.format("ajustement %s du compte %s", transactionIdReference, compteNumero);
		else if(transactionIdReference != null)
			o = String.format("ajustement %s", transactionIdReference);
		if(transactionIdReference != null && transactionCode != null && transactionDate != null && transactionMontant != null)
			o = String.format("ajustement %s %s %s du compte %s", transactionIdReference, compteNumero);
		if(compteNumero != null)
			o = String.format("ajustement de compte %s", compteNumero);

		c.o(o);
	}

	/**   
	 * {@inheritDoc}
	 * Var.enUS: adjustmentId
	 * Indexe: true
	 * Stocke: true
	 * VarId: true
	 * HtmlLigne: 1
	 * HtmlCelulle: 4
	 * Description.frFR: 
	 * Description.enUS: 
	 * NomAffichage.frFR: ID
	 * NomAffichage.enUS: ID
	 * r: ajustementNomComplet
	 * r.enUS: adjustmentCompleteName
	 */            
	protected void _ajustementId(Couverture<String> c) {
		if(ajustementNomComplet != null) {
			String s = Normalizer.normalize(ajustementNomComplet, Normalizer.Form.NFD);
			s = StringUtils.lowerCase(s);
			s = StringUtils.trim(s);
			s = StringUtils.replacePattern(s, "\\s{1,}", "-");
			s = StringUtils.replacePattern(s, "[^\\w-]", "");
			s = StringUtils.replacePattern(s, "-{2,}", "-");
			c.o(s);
		}
		else if(pk != null){
			c.o(pk.toString());
		}
	}

	/**	la version plus courte de l'URL qui commence avec « / » 
	 * {@inheritDoc}
	 * Indexe: true
	 * Stocke: true
	 * VarUrl: true
	 * r: ajustementId
	 * r.enUS: adjustmentId
	 * r: /ajustement/
	 * r.enUS: /ajustement/
	 * r: requeteSite
	 * r.enUS: siteRequest
	 * r: ConfigSite
	 * r.enUS: SiteConfig
	 * r: SiteUrlBase
	 * r.enUS: SiteBaseUrl
	 * **/   
	protected void _pageUrl(Couverture<String> c)  {
		if(ajustementId != null) {
			String o = requeteSite_.getConfigSite_().getSiteUrlBase() + "/ajustement/" + ajustementId;
			c.o(o);
		}
	}

	/**
	 * {@inheritDoc}
	 * Var.enUS: objectSuggest
	 * Suggere: true
	 * r: ajustementNomComplet
	 * r.enUS: adjustmentCompleteName
	 */         
	protected void _objetSuggere(Couverture<String> c) { 
		c.o(ajustementNomComplet);
	}

	/**
	 * {@inheritDoc}
	 * Var.enUS: _classCanonicalNames
	 * Indexe: true
	 * Stocke: true
	 * r: AjustementBancaire
	 * r.enUS: BankAdjustment
	 * r: classeNomsCanoniques
	 * r.enUS: classCanonicalNames
	 **/      
	@Override protected void _classeNomsCanoniques(List<String> l) {
		l.add(AjustementBancaire.class.getCanonicalName());
		super._classeNomsCanoniques(l);
	}
}
