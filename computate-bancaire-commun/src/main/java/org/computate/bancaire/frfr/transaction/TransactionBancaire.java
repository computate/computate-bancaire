package org.computate.bancaire.frfr.transaction;

import java.math.BigDecimal;
import java.text.Normalizer;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.computate.bancaire.frfr.cluster.Cluster;
import org.computate.bancaire.frfr.compte.CompteBancaire;
import org.computate.bancaire.frfr.couverture.Couverture;
import org.computate.bancaire.frfr.recherche.ListeRecherche;

import org.computate.bancaire.frfr.transaction.code.CodeTransaction;

/**    
 * NomCanonique.enUS: org.computate.bancaire.enus.transaction.BankTransaction
 * Modele: true
 * Api: true
 * Indexe: true
 * Sauvegarde: true
 * 
 * ApiTag.frFR: Transaction
 * ApiUri.frFR: /api/transaction
 * 
 * ApiTag.enUS: Transaction
 * ApiUri.enUS: /api/transaction
 * 
 * ApiMethode: POST
 * ApiMethode: PATCH
 * ApiMethode: GET
 * ApiMethode: DELETE
 * ApiMethode.frFR: Recherche
 * ApiMethode.enUS: Search
 * 
 * ApiMethode.frFR: PageRecherche
 * PagePageRecherche.frFR: TransactionPage
 * PageSuperPageRecherche.frFR: ClusterPage
 * ApiUriPageRecherche.frFR: /transaction
 * 
 * ApiMethode.enUS: SearchPage
 * PageSearchPage.enUS: TransactionPage
 * PageSuperSearchPage.enUS: ClusterPage
 * ApiUriSearchPage.enUS: /transaction
 * 
 * UnNom.frFR: une transaction
 * UnNom.enUS: a transaction
 * Couleur: yellow
 * IconeGroupe: duotone
 * IconeNom: cash-register
*/                                     
public class TransactionBancaire extends TransactionBancaireGen<Cluster> {

	/**
	 * {@inheritDoc}
	 * Var.enUS: transactionKey
	 * Indexe: true
	 * Stocke: true
	 * NomAffichage.frFR: clé
	 * NomAffichage.enUS: key
	 */         
	protected void _transactionCle(Couverture<Long> c) {
		c.o(pk);
	}

	/**
	 * {@inheritDoc}
	 * Var.enUS: accountKey
	 * Indexe: true
	 * Stocke: true
	 * Attribuer: CompteBancaire.transactionCles
	 * Attribuer: TransactionCompte.compteCle
	 * HtmlLigne: 3
	 * HtmlCellule: 1
	 * NomAffichage.frFR: compte
	 * NomAffichage.enUS: account
	 */               
	protected void _compteCle(Couverture<Long> c) {
	}

	/**
	 * Var.enUS: accountSearch
	 * r: transactionCles
	 * r.enUS: transactionKeys
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
			l.addFilterQuery("transactionCles_indexed_longs:" + pk);
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
	 * Var.enUS: transactionCode
	 * Indexe: true
	 * Stocke: true
	 * Definir: true
	 * HtmlLigne: 3
	 * HtmlCelulle: 2
	 * NomAffichage.frFR: code de transaction
	 * NomAffichage.enUS: transaction code
	 */                   
	protected void _transactionCode(Couverture<String> c) {
	}

	/**
	 * Var.enUS: transactionCodeSearch
	 * r: codeTransaction
	 * r.enUS: transactionCode
	 * r: CodeTransaction
	 * r.enUS: TransactionCode
	 * r: setStocker
	 * r.enUS: setStore
	 * Ignorer: true
	 */  
	protected void _codeTransactionRecherche(ListeRecherche<CodeTransaction> l) {
		if(transactionCode == null) {
			l.setQuery(null);
		}
		else {
			l.setQuery("*:*");
			l.addFilterQuery("transactionCode_indexed_string:" + transactionCode);
			l.setC(CodeTransaction.class);
			l.setStocker(true);
		}
	}

	/**
	 * {@inheritDoc}
	 * Var.enUS: transactionCodeObject_
	 * r: codeTransactionRecherche
	 * r.enUS: transactionCodeSearch
	 * Ignorer: true
	 */    
	protected void _codeTransactionObjet_(Couverture<CodeTransaction> c) {
		if(codeTransactionRecherche.size() > 0) {
			c.o(codeTransactionRecherche.get(0));
		}
	}

	/**   
	 * {@inheritDoc}
	 * Var.enUS: transactionCodeCompleteName
	 * Indexe: true
	 * Stocke: true
	 * r: CodeTransactionNomAffichage
	 * r.enUS: TransactionCodeDisplayName
	 * r: codeTransactionObjet
	 * r.enUS: transactionCodeObject
	 */                 
	protected void _codeTransactionNomComplet(Couverture<String> c) {
		if(codeTransactionObjet_ != null)
			c.o(codeTransactionObjet_.getCodeTransactionNomAffichage());
	}

	/**
	 * {@inheritDoc}
	 * Var.enUS: transactionReferenceId
	 * Indexe: true
	 * Stocke: true
	 * Definir: true
	 * HtmlLigne: 4
	 * HtmlCelulle: 1
	 * NomAffichage.frFR: ID de référence de transaction
	 * NomAffichage.enUS: transaction reference ID
	 */                   
	protected void _transactionIdReference(Couverture<String> c) {
	}

	/**
	 * {@inheritDoc}
	 * Var.enUS: transactionAmount
	 * Indexe: true
	 * Stocke: true
	 * Definir: true
	 * HtmlLigne: 4
	 * HtmlCelulle: 1
	 * NomAffichage.frFR: date et heure de la transaction
	 * NomAffichage.enUS: date and time of the transaction
	 */                   
	protected void _transactionMontant(Couverture<BigDecimal> c) {
	}

	/**
	 * {@inheritDoc}
	 * Var.enUS: transactionDateTime
	 * Indexe: true
	 * Stocke: true
	 * Definir: true
	 * HtmlLigne: 4
	 * HtmlCelulle: 2
	 * NomAffichage.frFR: date et heure de la transaction
	 * NomAffichage.enUS: date and time of the transaction
	 */                   
	protected void _transactionDateHeure(Couverture<ZonedDateTime> c) {
	}

	/**
	 * {@inheritDoc}
	 * Var.enUS: transactionDate
	 * Indexe: true
	 * Stocke: true
	 * NomAffichage.frFR: date de la transaction
	 * NomAffichage.enUS: date of the transaction
	 * r: transactionDateHeure
	 * r.enUS: transactionDateTime
	 * r: requeteSite
	 * r.enUS: siteRequest
	 * r: ConfigSite
	 * r.enUS: SiteConfig
	 */                   
	protected void _transactionDate(Couverture<LocalDate> c) {
		if(transactionDateHeure != null) {
			c.o(ZonedDateTime.ofInstant(transactionDateHeure.toInstant(), ZoneId.of(requeteSite_.getConfigSite_().getSiteZone())).toLocalDate());
		}
	}

	/**
	 * {@inheritDoc}
	 * Var.enUS: transactionFee
	 * Indexe: true
	 * Stocke: true
	 * Definir: true
	 * HtmlLigne: 3
	 * HtmlCelulle: 2
	 * NomAffichage.frFR: transaction de frais
	 * NomAffichage.enUS: fee transaction
	 */                   
	protected void _transactionFrais(Couverture<Boolean> c) {
		c.o(false);
	}

	/**
	 * {@inheritDoc}
	 * Var.enUS: transactionDisplayName
	 * Indexe: true
	 * Stocke: true
	 * Definir: true
	 * HtmlLigne: 3
	 * HtmlCelulle: 2
	 * NomAffichage.frFR: nom d'affichage
	 * NomAffichage.enUS: display name
	 */                   
	protected void _transactionNomAffichage(Couverture<String> c) {}

	/**   
	 * {@inheritDoc}
	 * Var.enUS: transactionCompleteName
	 * Indexe: true
	 * Stocke: true
	 * VarTitre: true
	 * HtmlColonne: 1
	 * r: "transaction %s du compte %s"
	 * r.enUS: "transaction %s of account %s"
	 * r: "transaction %s %s %s du compte %s"
	 * r.enUS: "transaction %s %s %s of account %s"
	 * r: "transaction de compte %s"
	 * r.enUS: "transaction of account %s"
	 * r: transactionIdReference
	 * r.enUS: transactionReferenceId
	 * r: compteNumero
	 * r.enUS: accountNumber
	 * r: transactionMontant
	 * r.enUS: transactionAmount
	 */                  
	protected void _transactionNomComplet(Couverture<String> c) {
		String o = "transaction";

		if(transactionIdReference != null && compteNumero != null)
			o = String.format("transaction %s du compte %s", transactionIdReference, compteNumero);
		else if(transactionIdReference != null)
			o = String.format("transaction %s", transactionIdReference);
		if(transactionIdReference != null && transactionCode != null && transactionDate != null && transactionMontant != null)
			o = String.format("transaction %s %s %s du compte %s", transactionIdReference, compteNumero);
		if(compteNumero != null)
			o = String.format("transaction de compte %s", compteNumero);

		c.o(o);
	}

	/**   
	 * {@inheritDoc}
	 * Var.enUS: transactionId
	 * Indexe: true
	 * Stocke: true
	 * VarId: true
	 * HtmlLigne: 1
	 * HtmlCelulle: 4
	 * Description.frFR: 
	 * Description.enUS: 
	 * NomAffichage.frFR: ID
	 * NomAffichage.enUS: ID
	 * r: transactionNomComplet
	 * r.enUS: transactionCompleteName
	 */            
	protected void _transactionId(Couverture<String> c) {
		if(transactionNomComplet != null) {
			String s = Normalizer.normalize(transactionNomComplet, Normalizer.Form.NFD);
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
	 * r: transactionId
	 * r.enUS: transactionId
	 * r: /transaction/
	 * r.enUS: /transaction/
	 * r: requeteSite
	 * r.enUS: siteRequest
	 * r: ConfigSite
	 * r.enUS: SiteConfig
	 * r: SiteUrlBase
	 * r.enUS: SiteBaseUrl
	 * **/   
	protected void _pageUrl(Couverture<String> c)  {
		if(transactionId != null) {
			String o = requeteSite_.getConfigSite_().getSiteUrlBase() + "/transaction/" + transactionId;
			c.o(o);
		}
	}

	/**
	 * {@inheritDoc}
	 * Var.enUS: objectSuggest
	 * Suggere: true
	 * r: transactionNomComplet
	 * r.enUS: transactionCompleteName
	 */         
	protected void _objetSuggere(Couverture<String> c) { 
		c.o(transactionNomComplet);
	}

	/**
	 * {@inheritDoc}
	 * Var.enUS: _classCanonicalNames
	 * Indexe: true
	 * Stocke: true
	 * r: CodeTransaction
	 * r.enUS: TransactionCode
	 * r: classeNomsCanoniques
	 * r.enUS: classCanonicalNames
	 **/      
	@Override protected void _classeNomsCanoniques(List<String> l) {
		l.add(CodeTransaction.class.getCanonicalName());
		super._classeNomsCanoniques(l);
	}
}
