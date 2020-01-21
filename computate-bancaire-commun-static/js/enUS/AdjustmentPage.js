
// POST //

async function postBankAdjustment($formValues, success, error) {
	var vals = {};
	if(success == null) {
		success = function( data, textStatus, jQxhr ) {
			addGlow($formValues.next('button'));
		};
	}
	if(error == null) {
		error = function( jqXhr, textStatus, errorThrown ) {
			addError($formValues.next('button'));
		};
	}

	var valuePk = $formValues.find('.valuePk').val();
	if(valuePk != null && valuePk !== '')
		vals['pk'] = valuePk;

	var valueCreated = $formValues.find('.valueCreated').val();
	if(valueCreated != null && valueCreated !== '')
		vals['created'] = valueCreated;

	var valueModified = $formValues.find('.valueModified').val();
	if(valueModified != null && valueModified !== '')
		vals['modified'] = valueModified;

	var valueObjectId = $formValues.find('.valueObjectId').val();
	if(valueObjectId != null && valueObjectId !== '')
		vals['objectId'] = valueObjectId;

	var valueAdjustmentId = $formValues.find('.valueAdjustmentId').val();
	if(valueAdjustmentId != null && valueAdjustmentId !== '')
		vals['adjustmentId'] = valueAdjustmentId;

	var valueArchived = $formValues.find('.valueArchived').prop('checked');
	if(valueArchived != null && valueArchived !== '')
		vals['archived'] = valueArchived;

	var valueDeleted = $formValues.find('.valueDeleted').prop('checked');
	if(valueDeleted != null && valueDeleted !== '')
		vals['deleted'] = valueDeleted;

	var valueAccountKey = $formValues.find('.valueAccountKey').val();
	if(valueAccountKey != null && valueAccountKey !== '')
		vals['accountKey'] = valueAccountKey;

	var valueTransactionKey = $formValues.find('.valueTransactionKey').val();
	if(valueTransactionKey != null && valueTransactionKey !== '')
		vals['transactionKey'] = valueTransactionKey;

	var valueAdjustmentDisplayName = $formValues.find('.valueAdjustmentDisplayName').val();
	if(valueAdjustmentDisplayName != null && valueAdjustmentDisplayName !== '')
		vals['adjustmentDisplayName'] = valueAdjustmentDisplayName;

	var valueAgentAreas = $formValues.find('.valueAgentAreas').val();
	if(valueAgentAreas != null && valueAgentAreas !== '')
		vals['agentAreas'] = valueAgentAreas;

	var valueAgentRoles = $formValues.find('.valueAgentRoles').val();
	if(valueAgentRoles != null && valueAgentRoles !== '')
		vals['agentRoles'] = valueAgentRoles;

	var valueAgentOverride = $formValues.find('.valueAgentOverride').prop('checked');
	if(valueAgentOverride != null && valueAgentOverride !== '')
		vals['agentOverride'] = valueAgentOverride;

	var valueEligibleEntitlement = $formValues.find('.valueEligibleEntitlement').prop('checked');
	if(valueEligibleEntitlement != null && valueEligibleEntitlement !== '')
		vals['eligibleEntitlement'] = valueEligibleEntitlement;

	var valuePartnerName = $formValues.find('.valuePartnerName').val();
	if(valuePartnerName != null && valuePartnerName !== '')
		vals['partnerName'] = valuePartnerName;

	var valueAdjustmentCompleteName = $formValues.find('.valueAdjustmentCompleteName').val();
	if(valueAdjustmentCompleteName != null && valueAdjustmentCompleteName !== '')
		vals['adjustmentCompleteName'] = valueAdjustmentCompleteName;

	$.ajax({
		url: '/api/adjustment'
		, dataType: 'json'
		, type: 'POST'
		, contentType: 'application/json; charset=utf-8'
		, data: JSON.stringify(vals)
		, success: success
		, error: error
	});
}

function postBankAdjustmentVals(vals, success, error) {
	$.ajax({
		url: '/api/adjustment'
		, dataType: 'json'
		, type: 'POST'
		, contentType: 'application/json; charset=utf-8'
		, data: JSON.stringify(vals)
		, success: success
		, error: error
	});
}

// PATCH //

async function patchBankAdjustment($formFilters, $formValues, success, error) {
	var filters = patchBankAdjustmentFilters($formFilters);

	var vals = {};

	var removePk = $formFilters.find('.removePk').val() === 'true';
	var setPk = removePk ? null : $formValues.find('.setPk').val();
	if(removePk || setPk != null && setPk !== '')
		vals['setPk'] = setPk;
	var addPk = $formValues.find('.addPk').val();
	if(addPk != null && addPk !== '')
		vals['addPk'] = addPk;
	var removePk = $formValues.find('.removePk').val();
	if(removePk != null && removePk !== '')
		vals['removePk'] = removePk;

	var removeCreated = $formFilters.find('.removeCreated').val() === 'true';
	var setCreated = removeCreated ? null : $formValues.find('.setCreated').val();
	if(removeCreated || setCreated != null && setCreated !== '')
		vals['setCreated'] = setCreated;
	var addCreated = $formValues.find('.addCreated').val();
	if(addCreated != null && addCreated !== '')
		vals['addCreated'] = addCreated;
	var removeCreated = $formValues.find('.removeCreated').val();
	if(removeCreated != null && removeCreated !== '')
		vals['removeCreated'] = removeCreated;

	var removeModified = $formFilters.find('.removeModified').val() === 'true';
	var setModified = removeModified ? null : $formValues.find('.setModified').val();
	if(removeModified || setModified != null && setModified !== '')
		vals['setModified'] = setModified;
	var addModified = $formValues.find('.addModified').val();
	if(addModified != null && addModified !== '')
		vals['addModified'] = addModified;
	var removeModified = $formValues.find('.removeModified').val();
	if(removeModified != null && removeModified !== '')
		vals['removeModified'] = removeModified;

	var removeObjectId = $formFilters.find('.removeObjectId').val() === 'true';
	var setObjectId = removeObjectId ? null : $formValues.find('.setObjectId').val();
	if(removeObjectId || setObjectId != null && setObjectId !== '')
		vals['setObjectId'] = setObjectId;
	var addObjectId = $formValues.find('.addObjectId').val();
	if(addObjectId != null && addObjectId !== '')
		vals['addObjectId'] = addObjectId;
	var removeObjectId = $formValues.find('.removeObjectId').val();
	if(removeObjectId != null && removeObjectId !== '')
		vals['removeObjectId'] = removeObjectId;

	var removeAdjustmentId = $formFilters.find('.removeAdjustmentId').val() === 'true';
	var setAdjustmentId = removeAdjustmentId ? null : $formValues.find('.setAdjustmentId').val();
	if(removeAdjustmentId || setAdjustmentId != null && setAdjustmentId !== '')
		vals['setAdjustmentId'] = setAdjustmentId;
	var addAdjustmentId = $formValues.find('.addAdjustmentId').val();
	if(addAdjustmentId != null && addAdjustmentId !== '')
		vals['addAdjustmentId'] = addAdjustmentId;
	var removeAdjustmentId = $formValues.find('.removeAdjustmentId').val();
	if(removeAdjustmentId != null && removeAdjustmentId !== '')
		vals['removeAdjustmentId'] = removeAdjustmentId;

	var removeArchived = $formFilters.find('.removeArchived').val() === 'true';
	var setArchived = removeArchived ? null : $formValues.find('.setArchived').prop('checked');
	if(removeArchived || setArchived != null && setArchived !== '')
		vals['setArchived'] = setArchived;
	var addArchived = $formValues.find('.addArchived').prop('checked');
	if(addArchived != null && addArchived !== '')
		vals['addArchived'] = addArchived;
	var removeArchived = $formValues.find('.removeArchived').prop('checked');
	if(removeArchived != null && removeArchived !== '')
		vals['removeArchived'] = removeArchived;

	var removeDeleted = $formFilters.find('.removeDeleted').val() === 'true';
	var setDeleted = removeDeleted ? null : $formValues.find('.setDeleted').prop('checked');
	if(removeDeleted || setDeleted != null && setDeleted !== '')
		vals['setDeleted'] = setDeleted;
	var addDeleted = $formValues.find('.addDeleted').prop('checked');
	if(addDeleted != null && addDeleted !== '')
		vals['addDeleted'] = addDeleted;
	var removeDeleted = $formValues.find('.removeDeleted').prop('checked');
	if(removeDeleted != null && removeDeleted !== '')
		vals['removeDeleted'] = removeDeleted;

	var removeAccountKey = $formFilters.find('.removeAccountKey').val() === 'true';
	var setAccountKey = removeAccountKey ? null : $formValues.find('.setAccountKey').val();
	if(removeAccountKey || setAccountKey != null && setAccountKey !== '')
		vals['setAccountKey'] = setAccountKey;
	var addAccountKey = $formValues.find('.addAccountKey').val();
	if(addAccountKey != null && addAccountKey !== '')
		vals['addAccountKey'] = addAccountKey;
	var removeAccountKey = $formValues.find('.removeAccountKey').val();
	if(removeAccountKey != null && removeAccountKey !== '')
		vals['removeAccountKey'] = removeAccountKey;

	var removeTransactionKey = $formFilters.find('.removeTransactionKey').val() === 'true';
	var setTransactionKey = removeTransactionKey ? null : $formValues.find('.setTransactionKey').val();
	if(removeTransactionKey || setTransactionKey != null && setTransactionKey !== '')
		vals['setTransactionKey'] = setTransactionKey;
	var addTransactionKey = $formValues.find('.addTransactionKey').val();
	if(addTransactionKey != null && addTransactionKey !== '')
		vals['addTransactionKey'] = addTransactionKey;
	var removeTransactionKey = $formValues.find('.removeTransactionKey').val();
	if(removeTransactionKey != null && removeTransactionKey !== '')
		vals['removeTransactionKey'] = removeTransactionKey;

	var removeAdjustmentDisplayName = $formFilters.find('.removeAdjustmentDisplayName').val() === 'true';
	var setAdjustmentDisplayName = removeAdjustmentDisplayName ? null : $formValues.find('.setAdjustmentDisplayName').val();
	if(removeAdjustmentDisplayName || setAdjustmentDisplayName != null && setAdjustmentDisplayName !== '')
		vals['setAdjustmentDisplayName'] = setAdjustmentDisplayName;
	var addAdjustmentDisplayName = $formValues.find('.addAdjustmentDisplayName').val();
	if(addAdjustmentDisplayName != null && addAdjustmentDisplayName !== '')
		vals['addAdjustmentDisplayName'] = addAdjustmentDisplayName;
	var removeAdjustmentDisplayName = $formValues.find('.removeAdjustmentDisplayName').val();
	if(removeAdjustmentDisplayName != null && removeAdjustmentDisplayName !== '')
		vals['removeAdjustmentDisplayName'] = removeAdjustmentDisplayName;

	var removeAgentAreas = $formFilters.find('.removeAgentAreas').val() === 'true';
	var setAgentAreas = removeAgentAreas ? null : $formValues.find('.setAgentAreas').val();
	if(removeAgentAreas || setAgentAreas != null && setAgentAreas !== '')
		vals['setAgentAreas'] = setAgentAreas;
	var addAgentAreas = $formValues.find('.addAgentAreas').val();
	if(addAgentAreas != null && addAgentAreas !== '')
		vals['addAgentAreas'] = addAgentAreas;
	var removeAgentAreas = $formValues.find('.removeAgentAreas').val();
	if(removeAgentAreas != null && removeAgentAreas !== '')
		vals['removeAgentAreas'] = removeAgentAreas;

	var removeAgentRoles = $formFilters.find('.removeAgentRoles').val() === 'true';
	var setAgentRoles = removeAgentRoles ? null : $formValues.find('.setAgentRoles').val();
	if(removeAgentRoles || setAgentRoles != null && setAgentRoles !== '')
		vals['setAgentRoles'] = setAgentRoles;
	var addAgentRoles = $formValues.find('.addAgentRoles').val();
	if(addAgentRoles != null && addAgentRoles !== '')
		vals['addAgentRoles'] = addAgentRoles;
	var removeAgentRoles = $formValues.find('.removeAgentRoles').val();
	if(removeAgentRoles != null && removeAgentRoles !== '')
		vals['removeAgentRoles'] = removeAgentRoles;

	var removeAgentOverride = $formFilters.find('.removeAgentOverride').val() === 'true';
	var setAgentOverride = removeAgentOverride ? null : $formValues.find('.setAgentOverride').prop('checked');
	if(removeAgentOverride || setAgentOverride != null && setAgentOverride !== '')
		vals['setAgentOverride'] = setAgentOverride;
	var addAgentOverride = $formValues.find('.addAgentOverride').prop('checked');
	if(addAgentOverride != null && addAgentOverride !== '')
		vals['addAgentOverride'] = addAgentOverride;
	var removeAgentOverride = $formValues.find('.removeAgentOverride').prop('checked');
	if(removeAgentOverride != null && removeAgentOverride !== '')
		vals['removeAgentOverride'] = removeAgentOverride;

	var removeEligibleEntitlement = $formFilters.find('.removeEligibleEntitlement').val() === 'true';
	var setEligibleEntitlement = removeEligibleEntitlement ? null : $formValues.find('.setEligibleEntitlement').prop('checked');
	if(removeEligibleEntitlement || setEligibleEntitlement != null && setEligibleEntitlement !== '')
		vals['setEligibleEntitlement'] = setEligibleEntitlement;
	var addEligibleEntitlement = $formValues.find('.addEligibleEntitlement').prop('checked');
	if(addEligibleEntitlement != null && addEligibleEntitlement !== '')
		vals['addEligibleEntitlement'] = addEligibleEntitlement;
	var removeEligibleEntitlement = $formValues.find('.removeEligibleEntitlement').prop('checked');
	if(removeEligibleEntitlement != null && removeEligibleEntitlement !== '')
		vals['removeEligibleEntitlement'] = removeEligibleEntitlement;

	var removePartnerName = $formFilters.find('.removePartnerName').val() === 'true';
	var setPartnerName = removePartnerName ? null : $formValues.find('.setPartnerName').val();
	if(removePartnerName || setPartnerName != null && setPartnerName !== '')
		vals['setPartnerName'] = setPartnerName;
	var addPartnerName = $formValues.find('.addPartnerName').val();
	if(addPartnerName != null && addPartnerName !== '')
		vals['addPartnerName'] = addPartnerName;
	var removePartnerName = $formValues.find('.removePartnerName').val();
	if(removePartnerName != null && removePartnerName !== '')
		vals['removePartnerName'] = removePartnerName;

	var removeAdjustmentCompleteName = $formFilters.find('.removeAdjustmentCompleteName').val() === 'true';
	var setAdjustmentCompleteName = removeAdjustmentCompleteName ? null : $formValues.find('.setAdjustmentCompleteName').val();
	if(removeAdjustmentCompleteName || setAdjustmentCompleteName != null && setAdjustmentCompleteName !== '')
		vals['setAdjustmentCompleteName'] = setAdjustmentCompleteName;
	var addAdjustmentCompleteName = $formValues.find('.addAdjustmentCompleteName').val();
	if(addAdjustmentCompleteName != null && addAdjustmentCompleteName !== '')
		vals['addAdjustmentCompleteName'] = addAdjustmentCompleteName;
	var removeAdjustmentCompleteName = $formValues.find('.removeAdjustmentCompleteName').val();
	if(removeAdjustmentCompleteName != null && removeAdjustmentCompleteName !== '')
		vals['removeAdjustmentCompleteName'] = removeAdjustmentCompleteName;

	patchBankAdjustmentVals(filters, vals, success, error);
}

function patchBankAdjustmentFilters($formFilters) {
	var filters = [];

	var filterPk = $formFilters.find('.valuePk').val();
	if(filterPk != null && filterPk !== '')
		filters.push({ name: 'fq', value: 'pk:' + filterPk });

	var filterCreated = $formFilters.find('.valueCreated').val();
	if(filterCreated != null && filterCreated !== '')
		filters.push({ name: 'fq', value: 'created:' + filterCreated });

	var filterModified = $formFilters.find('.valueModified').val();
	if(filterModified != null && filterModified !== '')
		filters.push({ name: 'fq', value: 'modified:' + filterModified });

	var filterObjectId = $formFilters.find('.valueObjectId').val();
	if(filterObjectId != null && filterObjectId !== '')
		filters.push({ name: 'fq', value: 'objectId:' + filterObjectId });

	var filterAdjustmentId = $formFilters.find('.valueAdjustmentId').val();
	if(filterAdjustmentId != null && filterAdjustmentId !== '')
		filters.push({ name: 'fq', value: 'adjustmentId:' + filterAdjustmentId });

	var filterArchived = $formFilters.find('.valueArchived').prop('checked');
	if(filterArchived != null && filterArchived === true)
		filters.push({ name: 'fq', value: 'archived:' + filterArchived });

	var filterDeleted = $formFilters.find('.valueDeleted').prop('checked');
	if(filterDeleted != null && filterDeleted === true)
		filters.push({ name: 'fq', value: 'deleted:' + filterDeleted });

	var filterAccountKey = $formFilters.find('.valueAccountKey').val();
	if(filterAccountKey != null && filterAccountKey !== '')
		filters.push({ name: 'fq', value: 'accountKey:' + filterAccountKey });

	var filterTransactionKey = $formFilters.find('.valueTransactionKey').val();
	if(filterTransactionKey != null && filterTransactionKey !== '')
		filters.push({ name: 'fq', value: 'transactionKey:' + filterTransactionKey });

	var filterAdjustmentDisplayName = $formFilters.find('.valueAdjustmentDisplayName').val();
	if(filterAdjustmentDisplayName != null && filterAdjustmentDisplayName !== '')
		filters.push({ name: 'fq', value: 'adjustmentDisplayName:' + filterAdjustmentDisplayName });

	var filterAgentAreas = $formFilters.find('.valueAgentAreas').val();
	if(filterAgentAreas != null && filterAgentAreas !== '')
		filters.push({ name: 'fq', value: 'agentAreas:' + filterAgentAreas });

	var filterAgentRoles = $formFilters.find('.valueAgentRoles').val();
	if(filterAgentRoles != null && filterAgentRoles !== '')
		filters.push({ name: 'fq', value: 'agentRoles:' + filterAgentRoles });

	var filterAgentOverride = $formFilters.find('.valueAgentOverride').prop('checked');
	if(filterAgentOverride != null && filterAgentOverride === true)
		filters.push({ name: 'fq', value: 'agentOverride:' + filterAgentOverride });

	var filterEligibleEntitlement = $formFilters.find('.valueEligibleEntitlement').prop('checked');
	if(filterEligibleEntitlement != null && filterEligibleEntitlement === true)
		filters.push({ name: 'fq', value: 'eligibleEntitlement:' + filterEligibleEntitlement });

	var filterPartnerName = $formFilters.find('.valuePartnerName').val();
	if(filterPartnerName != null && filterPartnerName !== '')
		filters.push({ name: 'fq', value: 'partnerName:' + filterPartnerName });

	var filterId = $formFilters.find('.valueId').val();
	if(filterId != null && filterId !== '')
		filters.push({ name: 'fq', value: 'id:' + filterId });

	var filterClassCanonicalName = $formFilters.find('.valueClassCanonicalName').val();
	if(filterClassCanonicalName != null && filterClassCanonicalName !== '')
		filters.push({ name: 'fq', value: 'classCanonicalName:' + filterClassCanonicalName });

	var filterClassSimpleName = $formFilters.find('.valueClassSimpleName').val();
	if(filterClassSimpleName != null && filterClassSimpleName !== '')
		filters.push({ name: 'fq', value: 'classSimpleName:' + filterClassSimpleName });

	var filterClassCanonicalNames = $formFilters.find('.valueClassCanonicalNames').val();
	if(filterClassCanonicalNames != null && filterClassCanonicalNames !== '')
		filters.push({ name: 'fq', value: 'classCanonicalNames:' + filterClassCanonicalNames });

	var filterObjectTitle = $formFilters.find('.valueObjectTitle').val();
	if(filterObjectTitle != null && filterObjectTitle !== '')
		filters.push({ name: 'fq', value: 'objectTitle:' + filterObjectTitle });

	var filterObjectSuggest = $formFilters.find('.valueObjectSuggest').val();
	if(filterObjectSuggest != null && filterObjectSuggest !== '')
		filters.push({ name: 'q', value: 'objectSuggest:' + filterObjectSuggest });

	var filterPageUrl = $formFilters.find('.valuePageUrl').val();
	if(filterPageUrl != null && filterPageUrl !== '')
		filters.push({ name: 'fq', value: 'pageUrl:' + filterPageUrl });

	var filterAdjustmentKey = $formFilters.find('.valueAdjustmentKey').val();
	if(filterAdjustmentKey != null && filterAdjustmentKey !== '')
		filters.push({ name: 'fq', value: 'adjustmentKey:' + filterAdjustmentKey });

	var filterAccountCompleteName = $formFilters.find('.valueAccountCompleteName').val();
	if(filterAccountCompleteName != null && filterAccountCompleteName !== '')
		filters.push({ name: 'fq', value: 'accountCompleteName:' + filterAccountCompleteName });

	var filterAccountNumber = $formFilters.find('.valueAccountNumber').val();
	if(filterAccountNumber != null && filterAccountNumber !== '')
		filters.push({ name: 'fq', value: 'accountNumber:' + filterAccountNumber });

	var filterTransactionReferenceId = $formFilters.find('.valueTransactionReferenceId').val();
	if(filterTransactionReferenceId != null && filterTransactionReferenceId !== '')
		filters.push({ name: 'fq', value: 'transactionReferenceId:' + filterTransactionReferenceId });

	var filterTransactionCode = $formFilters.find('.valueTransactionCode').val();
	if(filterTransactionCode != null && filterTransactionCode !== '')
		filters.push({ name: 'fq', value: 'transactionCode:' + filterTransactionCode });

	var filterTransactionAmount = $formFilters.find('.valueTransactionAmount').val();
	if(filterTransactionAmount != null && filterTransactionAmount !== '')
		filters.push({ name: 'fq', value: 'transactionAmount:' + filterTransactionAmount });

	var filterTransactionDateTime = $formFilters.find('.valueTransactionDateTime').val();
	if(filterTransactionDateTime != null && filterTransactionDateTime !== '')
		filters.push({ name: 'fq', value: 'transactionDateTime:' + filterTransactionDateTime });

	var filterTransactionDate = $formFilters.find('.valueTransactionDate').val();
	if(filterTransactionDate != null && filterTransactionDate !== '')
		filters.push({ name: 'fq', value: 'transactionDate:' + filterTransactionDate });

	var filterTransactionFee = $formFilters.find('.valueTransactionFee').prop('checked');
	if(filterTransactionFee != null && filterTransactionFee === true)
		filters.push({ name: 'fq', value: 'transactionFee:' + filterTransactionFee });

	var filterAdjustmentCompleteName = $formFilters.find('.valueAdjustmentCompleteName').val();
	if(filterAdjustmentCompleteName != null && filterAdjustmentCompleteName !== '')
		filters.push({ name: 'fq', value: 'adjustmentCompleteName:' + filterAdjustmentCompleteName });

	var filterPageUrl = $formFilters.find('.valuePageUrl').val();
	if(filterPageUrl != null && filterPageUrl !== '')
		filters.push({ name: 'fq', value: 'pageUrl:' + filterPageUrl });

	var filterObjectSuggest = $formFilters.find('.valueObjectSuggest').val();
	if(filterObjectSuggest != null && filterObjectSuggest !== '')
		filters.push({ name: 'q', value: 'objectSuggest:' + filterObjectSuggest });
	return filters;
}

function patchBankAdjustmentVal(filters, v, val, success, error) {
	var vals = {};
	vals[v] = val;
	patchBankAdjustmentVals(filters, vals, success, error);
}

function patchBankAdjustmentVals(filters, vals, success, error) {
	$.ajax({
		url: '/api/adjustment?' + $.param(filters)
		, dataType: 'json'
		, type: 'PATCH'
		, contentType: 'application/json; charset=utf-8'
		, data: JSON.stringify(vals)
		, success: success
		, error: error
	});
}

// GET //

async function getBankAdjustment(pk) {
	$.ajax({
		url: '/api/adjustment/' + id
		, dataType: 'json'
		, type: 'GET'
		, contentType: 'application/json; charset=utf-8'
		, success: success
		, error: error
	});
}

// DELETE //

async function deleteBankAdjustment(pk) {
	$.ajax({
		url: '/api/adjustment/' + id
		, dataType: 'json'
		, type: 'DELETE'
		, contentType: 'application/json; charset=utf-8'
		, data: JSON.stringify(vals)
		, success: success
		, error: error
	});
}

// Search //

async function searchBankAdjustment($formFilters, success, error) {
	var filters = searchBankAdjustmentFilters($formFilters);
	if(success == null)
		success = function( data, textStatus, jQxhr ) {};
	if(error == null)
		error = function( jqXhr, textStatus, errorThrown ) {};

	searchBankAdjustmentVals(filters, success, error);
}

function searchBankAdjustmentFilters($formFilters) {
	var filters = [];

	var filterPk = $formFilters.find('.valuePk').val();
	if(filterPk != null && filterPk !== '')
		filters.push({ name: 'fq', value: 'pk:' + filterPk });

	var filterCreated = $formFilters.find('.valueCreated').val();
	if(filterCreated != null && filterCreated !== '')
		filters.push({ name: 'fq', value: 'created:' + filterCreated });

	var filterModified = $formFilters.find('.valueModified').val();
	if(filterModified != null && filterModified !== '')
		filters.push({ name: 'fq', value: 'modified:' + filterModified });

	var filterObjectId = $formFilters.find('.valueObjectId').val();
	if(filterObjectId != null && filterObjectId !== '')
		filters.push({ name: 'fq', value: 'objectId:' + filterObjectId });

	var filterAdjustmentId = $formFilters.find('.valueAdjustmentId').val();
	if(filterAdjustmentId != null && filterAdjustmentId !== '')
		filters.push({ name: 'fq', value: 'adjustmentId:' + filterAdjustmentId });

	var filterArchived = $formFilters.find('.valueArchived').prop('checked');
	if(filterArchived != null && filterArchived === true)
		filters.push({ name: 'fq', value: 'archived:' + filterArchived });

	var filterDeleted = $formFilters.find('.valueDeleted').prop('checked');
	if(filterDeleted != null && filterDeleted === true)
		filters.push({ name: 'fq', value: 'deleted:' + filterDeleted });

	var filterAccountKey = $formFilters.find('.valueAccountKey').val();
	if(filterAccountKey != null && filterAccountKey !== '')
		filters.push({ name: 'fq', value: 'accountKey:' + filterAccountKey });

	var filterTransactionKey = $formFilters.find('.valueTransactionKey').val();
	if(filterTransactionKey != null && filterTransactionKey !== '')
		filters.push({ name: 'fq', value: 'transactionKey:' + filterTransactionKey });

	var filterAdjustmentDisplayName = $formFilters.find('.valueAdjustmentDisplayName').val();
	if(filterAdjustmentDisplayName != null && filterAdjustmentDisplayName !== '')
		filters.push({ name: 'fq', value: 'adjustmentDisplayName:' + filterAdjustmentDisplayName });

	var filterAgentAreas = $formFilters.find('.valueAgentAreas').val();
	if(filterAgentAreas != null && filterAgentAreas !== '')
		filters.push({ name: 'fq', value: 'agentAreas:' + filterAgentAreas });

	var filterAgentRoles = $formFilters.find('.valueAgentRoles').val();
	if(filterAgentRoles != null && filterAgentRoles !== '')
		filters.push({ name: 'fq', value: 'agentRoles:' + filterAgentRoles });

	var filterAgentOverride = $formFilters.find('.valueAgentOverride').prop('checked');
	if(filterAgentOverride != null && filterAgentOverride === true)
		filters.push({ name: 'fq', value: 'agentOverride:' + filterAgentOverride });

	var filterEligibleEntitlement = $formFilters.find('.valueEligibleEntitlement').prop('checked');
	if(filterEligibleEntitlement != null && filterEligibleEntitlement === true)
		filters.push({ name: 'fq', value: 'eligibleEntitlement:' + filterEligibleEntitlement });

	var filterPartnerName = $formFilters.find('.valuePartnerName').val();
	if(filterPartnerName != null && filterPartnerName !== '')
		filters.push({ name: 'fq', value: 'partnerName:' + filterPartnerName });

	var filterId = $formFilters.find('.valueId').val();
	if(filterId != null && filterId !== '')
		filters.push({ name: 'fq', value: 'id:' + filterId });

	var filterClassCanonicalName = $formFilters.find('.valueClassCanonicalName').val();
	if(filterClassCanonicalName != null && filterClassCanonicalName !== '')
		filters.push({ name: 'fq', value: 'classCanonicalName:' + filterClassCanonicalName });

	var filterClassSimpleName = $formFilters.find('.valueClassSimpleName').val();
	if(filterClassSimpleName != null && filterClassSimpleName !== '')
		filters.push({ name: 'fq', value: 'classSimpleName:' + filterClassSimpleName });

	var filterClassCanonicalNames = $formFilters.find('.valueClassCanonicalNames').val();
	if(filterClassCanonicalNames != null && filterClassCanonicalNames !== '')
		filters.push({ name: 'fq', value: 'classCanonicalNames:' + filterClassCanonicalNames });

	var filterObjectTitle = $formFilters.find('.valueObjectTitle').val();
	if(filterObjectTitle != null && filterObjectTitle !== '')
		filters.push({ name: 'fq', value: 'objectTitle:' + filterObjectTitle });

	var filterObjectSuggest = $formFilters.find('.valueObjectSuggest').val();
	if(filterObjectSuggest != null && filterObjectSuggest !== '')
		filters.push({ name: 'q', value: 'objectSuggest:' + filterObjectSuggest });

	var filterPageUrl = $formFilters.find('.valuePageUrl').val();
	if(filterPageUrl != null && filterPageUrl !== '')
		filters.push({ name: 'fq', value: 'pageUrl:' + filterPageUrl });

	var filterAdjustmentKey = $formFilters.find('.valueAdjustmentKey').val();
	if(filterAdjustmentKey != null && filterAdjustmentKey !== '')
		filters.push({ name: 'fq', value: 'adjustmentKey:' + filterAdjustmentKey });

	var filterAccountCompleteName = $formFilters.find('.valueAccountCompleteName').val();
	if(filterAccountCompleteName != null && filterAccountCompleteName !== '')
		filters.push({ name: 'fq', value: 'accountCompleteName:' + filterAccountCompleteName });

	var filterAccountNumber = $formFilters.find('.valueAccountNumber').val();
	if(filterAccountNumber != null && filterAccountNumber !== '')
		filters.push({ name: 'fq', value: 'accountNumber:' + filterAccountNumber });

	var filterTransactionReferenceId = $formFilters.find('.valueTransactionReferenceId').val();
	if(filterTransactionReferenceId != null && filterTransactionReferenceId !== '')
		filters.push({ name: 'fq', value: 'transactionReferenceId:' + filterTransactionReferenceId });

	var filterTransactionCode = $formFilters.find('.valueTransactionCode').val();
	if(filterTransactionCode != null && filterTransactionCode !== '')
		filters.push({ name: 'fq', value: 'transactionCode:' + filterTransactionCode });

	var filterTransactionAmount = $formFilters.find('.valueTransactionAmount').val();
	if(filterTransactionAmount != null && filterTransactionAmount !== '')
		filters.push({ name: 'fq', value: 'transactionAmount:' + filterTransactionAmount });

	var filterTransactionDateTime = $formFilters.find('.valueTransactionDateTime').val();
	if(filterTransactionDateTime != null && filterTransactionDateTime !== '')
		filters.push({ name: 'fq', value: 'transactionDateTime:' + filterTransactionDateTime });

	var filterTransactionDate = $formFilters.find('.valueTransactionDate').val();
	if(filterTransactionDate != null && filterTransactionDate !== '')
		filters.push({ name: 'fq', value: 'transactionDate:' + filterTransactionDate });

	var filterTransactionFee = $formFilters.find('.valueTransactionFee').prop('checked');
	if(filterTransactionFee != null && filterTransactionFee === true)
		filters.push({ name: 'fq', value: 'transactionFee:' + filterTransactionFee });

	var filterAdjustmentCompleteName = $formFilters.find('.valueAdjustmentCompleteName').val();
	if(filterAdjustmentCompleteName != null && filterAdjustmentCompleteName !== '')
		filters.push({ name: 'fq', value: 'adjustmentCompleteName:' + filterAdjustmentCompleteName });

	var filterPageUrl = $formFilters.find('.valuePageUrl').val();
	if(filterPageUrl != null && filterPageUrl !== '')
		filters.push({ name: 'fq', value: 'pageUrl:' + filterPageUrl });

	var filterObjectSuggest = $formFilters.find('.valueObjectSuggest').val();
	if(filterObjectSuggest != null && filterObjectSuggest !== '')
		filters.push({ name: 'q', value: 'objectSuggest:' + filterObjectSuggest });
	return filters;
}

function searchBankAdjustmentVals(filters, success, error) {
	$.ajax({
		url: '/api/adjustment?' + $.param(filters)
		, dataType: 'json'
		, type: 'GET'
		, contentType: 'application/json; charset=utf-8'
		, success: success
		, error: error
	});
}

function suggestBankAdjustmentObjectSuggest($formFilters, $list) {
	success = function( data, textStatus, jQxhr ) {
		$list.empty();
		$.each(data['list'], function(i, o) {
			var $i = $('<i>').attr('class', 'fad fa-cash-register w3-padding-small ');
			var $span = $('<span>').attr('class', '').text(o['adjustmentCompleteName']);
			var $li = $('<li>');
			var $a = $('<a>').attr('href', o['']);
			$a.append($i);
			$a.append($span);
			$li.append($a);
			$list.append($li);
		});
	};
	error = function( jqXhr, textStatus, errorThrown ) {};
	searchBankAdjustmentVals($formFilters, success, error);
}

function suggestBankAdjustmentObjectSuggest($formFilters, $list) {
	success = function( data, textStatus, jQxhr ) {
		$list.empty();
		$.each(data['list'], function(i, o) {
			var $i = $('<i>').attr('class', 'fad fa-cash-register w3-padding-small ');
			var $span = $('<span>').attr('class', '').text(o['adjustmentCompleteName']);
			var $li = $('<li>');
			var $a = $('<a>').attr('href', o['']);
			$a.append($i);
			$a.append($span);
			$li.append($a);
			$list.append($li);
		});
	};
	error = function( jqXhr, textStatus, errorThrown ) {};
	searchBankAdjustmentVals($formFilters, success, error);
}

async function websocketBankAdjustment(success) {
	window.eventBus.onopen = function () {

		window.eventBus.registerHandler('websocketBankAdjustment', function (error, message) {
			var json = JSON.parse(message['body']);
			var id = json['id'];
			var pk = json['pk'];
			var pks = json['pks'];
			var empty = json['empty'];
			if(!empty) {
				var numFound = json['numFound'];
				var numPATCH = json['numPATCH'];
				var percent = Math.floor( numPATCH / numFound * 100 ) + '%';
				var $box = $('<div>').attr('class', 'w3-display-topright w3-quarter box-' + id + ' ').attr('id', 'box-' + id);
				var $margin = $('<div>').attr('class', 'w3-margin ').attr('id', 'margin-' + id);
				var $card = $('<div>').attr('class', 'w3-card ').attr('id', 'card-' + id);
				var $header = $('<div>').attr('class', 'w3-container fa-yellow ').attr('id', 'header-' + id);
				var $i = $('<i>').attr('class', 'fad fa-cash-register w3-margin-right ').attr('id', 'icon-' + id);
				var $headerSpan = $('<span>').attr('class', '').text('modify adjustments');
				var $x = $('<span>').attr('class', 'w3-button w3-display-topright ').attr('onclick', '$("#card-' + id + '").hide(); ').attr('id', 'x-' + id);
				var $body = $('<div>').attr('class', 'w3-container w3-padding ').attr('id', 'text-' + id);
				var $bar = $('<div>').attr('class', 'w3-light-gray ').attr('id', 'bar-' + id);
				var $progress = $('<div>').attr('class', 'w3-yellow ').attr('style', 'height: 24px; width: ' + percent + '; ').attr('id', 'progress-' + id).text(numPATCH + '/' + numFound);
				$card.append($header);
				$header.append($i);
				$header.append($headerSpan);
				$header.append($x);
				$body.append($bar);
				$bar.append($progress);
				$card.append($body);
				$box.append($margin);
				$margin.append($card);
				$('.box-' + id).remove();
				if(numPATCH < numFound)
				$('.w3-content').append($box);
				if(success)
					success(json);
			}
		});
	}
}
async function websocketBankAdjustmentInner(patchRequest) {
	var pk = patchRequest['pk'];
	var pks = patchRequest['pks'];
	var classes = patchRequest['classes'];
	var vars = patchRequest['vars'];
	var empty = patchRequest['empty'];

	if(pk != null) {
		searchBankAdjustmentVals([ {name: 'fq', value: 'pk:' + pk} ], function( data, textStatus, jQxhr ) {
			var o = data['list'][0];
			if(vars.includes('created')) {
				$('.inputBankAdjustment' + pk + 'Created').val(o['created']);
				$('.varBankAdjustment' + pk + 'Created').text(o['created']);
			}
			if(vars.includes('modified')) {
				$('.inputBankAdjustment' + pk + 'Modified').val(o['modified']);
				$('.varBankAdjustment' + pk + 'Modified').text(o['modified']);
			}
			if(vars.includes('archived')) {
				$('.inputBankAdjustment' + pk + 'Archived').val(o['archived']);
				$('.varBankAdjustment' + pk + 'Archived').text(o['archived']);
			}
			if(vars.includes('deleted')) {
				$('.inputBankAdjustment' + pk + 'Deleted').val(o['deleted']);
				$('.varBankAdjustment' + pk + 'Deleted').text(o['deleted']);
			}
			if(vars.includes('adjustmentDisplayName')) {
				$('.inputBankAdjustment' + pk + 'AdjustmentDisplayName').val(o['adjustmentDisplayName']);
				$('.varBankAdjustment' + pk + 'AdjustmentDisplayName').text(o['adjustmentDisplayName']);
			}
			if(vars.includes('agentAreas')) {
				$('.inputBankAdjustment' + pk + 'AgentAreas').val(o['agentAreas']);
				$('.varBankAdjustment' + pk + 'AgentAreas').text(o['agentAreas']);
			}
			if(vars.includes('agentRoles')) {
				$('.inputBankAdjustment' + pk + 'AgentRoles').val(o['agentRoles']);
				$('.varBankAdjustment' + pk + 'AgentRoles').text(o['agentRoles']);
			}
			if(vars.includes('agentOverride')) {
				$('.inputBankAdjustment' + pk + 'AgentOverride').val(o['agentOverride']);
				$('.varBankAdjustment' + pk + 'AgentOverride').text(o['agentOverride']);
			}
			if(vars.includes('eligibleEntitlement')) {
				$('.inputBankAdjustment' + pk + 'EligibleEntitlement').val(o['eligibleEntitlement']);
				$('.varBankAdjustment' + pk + 'EligibleEntitlement').text(o['eligibleEntitlement']);
			}
			if(vars.includes('partnerName')) {
				$('.inputBankAdjustment' + pk + 'PartnerName').val(o['partnerName']);
				$('.varBankAdjustment' + pk + 'PartnerName').text(o['partnerName']);
			}
		});
	}

	if(!empty) {
		if(pks) {
			for(i=0; i < pks.length; i++) {
				var pk2 = pks[i];
				var c = classes[i];
				await window['patch' + c + 'Vals']( [ {name: 'fq', value: 'pk:' + pk2} ], {});
			}
		}
		await patchBankAdjustmentVals( [ {name: 'fq', value: 'pk:' + pk} ], {});
	}
}
