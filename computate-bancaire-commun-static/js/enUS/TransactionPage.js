
// POST //

async function postBankTransaction($formValues, success, error) {
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

	var valueTransactionId = $formValues.find('.valueTransactionId').val();
	if(valueTransactionId != null && valueTransactionId !== '')
		vals['transactionId'] = valueTransactionId;

	var valueArchived = $formValues.find('.valueArchived').prop('checked');
	if(valueArchived != null && valueArchived !== '')
		vals['archived'] = valueArchived;

	var valueDeleted = $formValues.find('.valueDeleted').prop('checked');
	if(valueDeleted != null && valueDeleted !== '')
		vals['deleted'] = valueDeleted;

	var valueAccountKey = $formValues.find('.valueAccountKey').val();
	if(valueAccountKey != null && valueAccountKey !== '')
		vals['accountKey'] = valueAccountKey;

	var valueTransactionCode = $formValues.find('.valueTransactionCode').val();
	if(valueTransactionCode != null && valueTransactionCode !== '')
		vals['transactionCode'] = valueTransactionCode;

	var valueTransactionFee = $formValues.find('.valueTransactionFee').prop('checked');
	if(valueTransactionFee != null && valueTransactionFee !== '')
		vals['transactionFee'] = valueTransactionFee;

	var valueTransactionDisplayName = $formValues.find('.valueTransactionDisplayName').val();
	if(valueTransactionDisplayName != null && valueTransactionDisplayName !== '')
		vals['transactionDisplayName'] = valueTransactionDisplayName;

	var valueTransactionReferenceId = $formValues.find('.valueTransactionReferenceId').val();
	if(valueTransactionReferenceId != null && valueTransactionReferenceId !== '')
		vals['transactionReferenceId'] = valueTransactionReferenceId;

	var valueTransactionAmount = $formValues.find('.valueTransactionAmount').val();
	if(valueTransactionAmount != null && valueTransactionAmount !== '')
		vals['transactionAmount'] = valueTransactionAmount;

	var valueTransactionDateTime = $formValues.find('.valueTransactionDateTime').val();
	if(valueTransactionDateTime != null && valueTransactionDateTime !== '')
		vals['transactionDateTime'] = valueTransactionDateTime;

	var valueTransactionCompleteName = $formValues.find('.valueTransactionCompleteName').val();
	if(valueTransactionCompleteName != null && valueTransactionCompleteName !== '')
		vals['transactionCompleteName'] = valueTransactionCompleteName;

	$.ajax({
		url: '/api/transaction'
		, dataType: 'json'
		, type: 'POST'
		, contentType: 'application/json; charset=utf-8'
		, data: JSON.stringify(vals)
		, success: success
		, error: error
	});
}

function postBankTransactionVals(vals, success, error) {
	$.ajax({
		url: '/api/transaction'
		, dataType: 'json'
		, type: 'POST'
		, contentType: 'application/json; charset=utf-8'
		, data: JSON.stringify(vals)
		, success: success
		, error: error
	});
}

// PATCH //

async function patchBankTransaction($formFilters, $formValues, success, error) {
	var filters = patchBankTransactionFilters($formFilters);

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

	var removeTransactionId = $formFilters.find('.removeTransactionId').val() === 'true';
	var setTransactionId = removeTransactionId ? null : $formValues.find('.setTransactionId').val();
	if(removeTransactionId || setTransactionId != null && setTransactionId !== '')
		vals['setTransactionId'] = setTransactionId;
	var addTransactionId = $formValues.find('.addTransactionId').val();
	if(addTransactionId != null && addTransactionId !== '')
		vals['addTransactionId'] = addTransactionId;
	var removeTransactionId = $formValues.find('.removeTransactionId').val();
	if(removeTransactionId != null && removeTransactionId !== '')
		vals['removeTransactionId'] = removeTransactionId;

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

	var removeTransactionCode = $formFilters.find('.removeTransactionCode').val() === 'true';
	var setTransactionCode = removeTransactionCode ? null : $formValues.find('.setTransactionCode').val();
	if(removeTransactionCode || setTransactionCode != null && setTransactionCode !== '')
		vals['setTransactionCode'] = setTransactionCode;
	var addTransactionCode = $formValues.find('.addTransactionCode').val();
	if(addTransactionCode != null && addTransactionCode !== '')
		vals['addTransactionCode'] = addTransactionCode;
	var removeTransactionCode = $formValues.find('.removeTransactionCode').val();
	if(removeTransactionCode != null && removeTransactionCode !== '')
		vals['removeTransactionCode'] = removeTransactionCode;

	var removeTransactionFee = $formFilters.find('.removeTransactionFee').val() === 'true';
	var setTransactionFee = removeTransactionFee ? null : $formValues.find('.setTransactionFee').prop('checked');
	if(removeTransactionFee || setTransactionFee != null && setTransactionFee !== '')
		vals['setTransactionFee'] = setTransactionFee;
	var addTransactionFee = $formValues.find('.addTransactionFee').prop('checked');
	if(addTransactionFee != null && addTransactionFee !== '')
		vals['addTransactionFee'] = addTransactionFee;
	var removeTransactionFee = $formValues.find('.removeTransactionFee').prop('checked');
	if(removeTransactionFee != null && removeTransactionFee !== '')
		vals['removeTransactionFee'] = removeTransactionFee;

	var removeTransactionDisplayName = $formFilters.find('.removeTransactionDisplayName').val() === 'true';
	var setTransactionDisplayName = removeTransactionDisplayName ? null : $formValues.find('.setTransactionDisplayName').val();
	if(removeTransactionDisplayName || setTransactionDisplayName != null && setTransactionDisplayName !== '')
		vals['setTransactionDisplayName'] = setTransactionDisplayName;
	var addTransactionDisplayName = $formValues.find('.addTransactionDisplayName').val();
	if(addTransactionDisplayName != null && addTransactionDisplayName !== '')
		vals['addTransactionDisplayName'] = addTransactionDisplayName;
	var removeTransactionDisplayName = $formValues.find('.removeTransactionDisplayName').val();
	if(removeTransactionDisplayName != null && removeTransactionDisplayName !== '')
		vals['removeTransactionDisplayName'] = removeTransactionDisplayName;

	var removeTransactionReferenceId = $formFilters.find('.removeTransactionReferenceId').val() === 'true';
	var setTransactionReferenceId = removeTransactionReferenceId ? null : $formValues.find('.setTransactionReferenceId').val();
	if(removeTransactionReferenceId || setTransactionReferenceId != null && setTransactionReferenceId !== '')
		vals['setTransactionReferenceId'] = setTransactionReferenceId;
	var addTransactionReferenceId = $formValues.find('.addTransactionReferenceId').val();
	if(addTransactionReferenceId != null && addTransactionReferenceId !== '')
		vals['addTransactionReferenceId'] = addTransactionReferenceId;
	var removeTransactionReferenceId = $formValues.find('.removeTransactionReferenceId').val();
	if(removeTransactionReferenceId != null && removeTransactionReferenceId !== '')
		vals['removeTransactionReferenceId'] = removeTransactionReferenceId;

	var removeTransactionAmount = $formFilters.find('.removeTransactionAmount').val() === 'true';
	var setTransactionAmount = removeTransactionAmount ? null : $formValues.find('.setTransactionAmount').val();
	if(removeTransactionAmount || setTransactionAmount != null && setTransactionAmount !== '')
		vals['setTransactionAmount'] = setTransactionAmount;
	var addTransactionAmount = $formValues.find('.addTransactionAmount').val();
	if(addTransactionAmount != null && addTransactionAmount !== '')
		vals['addTransactionAmount'] = addTransactionAmount;
	var removeTransactionAmount = $formValues.find('.removeTransactionAmount').val();
	if(removeTransactionAmount != null && removeTransactionAmount !== '')
		vals['removeTransactionAmount'] = removeTransactionAmount;

	var removeTransactionDateTime = $formFilters.find('.removeTransactionDateTime').val() === 'true';
	var setTransactionDateTime = removeTransactionDateTime ? null : $formValues.find('.setTransactionDateTime').val();
	if(removeTransactionDateTime || setTransactionDateTime != null && setTransactionDateTime !== '')
		vals['setTransactionDateTime'] = setTransactionDateTime;
	var addTransactionDateTime = $formValues.find('.addTransactionDateTime').val();
	if(addTransactionDateTime != null && addTransactionDateTime !== '')
		vals['addTransactionDateTime'] = addTransactionDateTime;
	var removeTransactionDateTime = $formValues.find('.removeTransactionDateTime').val();
	if(removeTransactionDateTime != null && removeTransactionDateTime !== '')
		vals['removeTransactionDateTime'] = removeTransactionDateTime;

	var removeTransactionCompleteName = $formFilters.find('.removeTransactionCompleteName').val() === 'true';
	var setTransactionCompleteName = removeTransactionCompleteName ? null : $formValues.find('.setTransactionCompleteName').val();
	if(removeTransactionCompleteName || setTransactionCompleteName != null && setTransactionCompleteName !== '')
		vals['setTransactionCompleteName'] = setTransactionCompleteName;
	var addTransactionCompleteName = $formValues.find('.addTransactionCompleteName').val();
	if(addTransactionCompleteName != null && addTransactionCompleteName !== '')
		vals['addTransactionCompleteName'] = addTransactionCompleteName;
	var removeTransactionCompleteName = $formValues.find('.removeTransactionCompleteName').val();
	if(removeTransactionCompleteName != null && removeTransactionCompleteName !== '')
		vals['removeTransactionCompleteName'] = removeTransactionCompleteName;

	patchBankTransactionVals(filters, vals, success, error);
}

function patchBankTransactionFilters($formFilters) {
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

	var filterTransactionId = $formFilters.find('.valueTransactionId').val();
	if(filterTransactionId != null && filterTransactionId !== '')
		filters.push({ name: 'fq', value: 'transactionId:' + filterTransactionId });

	var filterArchived = $formFilters.find('.valueArchived').prop('checked');
	if(filterArchived != null && filterArchived === true)
		filters.push({ name: 'fq', value: 'archived:' + filterArchived });

	var filterDeleted = $formFilters.find('.valueDeleted').prop('checked');
	if(filterDeleted != null && filterDeleted === true)
		filters.push({ name: 'fq', value: 'deleted:' + filterDeleted });

	var filterAccountKey = $formFilters.find('.valueAccountKey').val();
	if(filterAccountKey != null && filterAccountKey !== '')
		filters.push({ name: 'fq', value: 'accountKey:' + filterAccountKey });

	var filterTransactionCode = $formFilters.find('.valueTransactionCode').val();
	if(filterTransactionCode != null && filterTransactionCode !== '')
		filters.push({ name: 'fq', value: 'transactionCode:' + filterTransactionCode });

	var filterTransactionFee = $formFilters.find('.valueTransactionFee').prop('checked');
	if(filterTransactionFee != null && filterTransactionFee === true)
		filters.push({ name: 'fq', value: 'transactionFee:' + filterTransactionFee });

	var filterTransactionDisplayName = $formFilters.find('.valueTransactionDisplayName').val();
	if(filterTransactionDisplayName != null && filterTransactionDisplayName !== '')
		filters.push({ name: 'fq', value: 'transactionDisplayName:' + filterTransactionDisplayName });

	var filterTransactionReferenceId = $formFilters.find('.valueTransactionReferenceId').val();
	if(filterTransactionReferenceId != null && filterTransactionReferenceId !== '')
		filters.push({ name: 'fq', value: 'transactionReferenceId:' + filterTransactionReferenceId });

	var filterTransactionAmount = $formFilters.find('.valueTransactionAmount').val();
	if(filterTransactionAmount != null && filterTransactionAmount !== '')
		filters.push({ name: 'fq', value: 'transactionAmount:' + filterTransactionAmount });

	var filterTransactionDateTime = $formFilters.find('.valueTransactionDateTime').val();
	if(filterTransactionDateTime != null && filterTransactionDateTime !== '')
		filters.push({ name: 'fq', value: 'transactionDateTime:' + filterTransactionDateTime });

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

	var filterTransactionKey = $formFilters.find('.valueTransactionKey').val();
	if(filterTransactionKey != null && filterTransactionKey !== '')
		filters.push({ name: 'fq', value: 'transactionKey:' + filterTransactionKey });

	var filterAccountCompleteName = $formFilters.find('.valueAccountCompleteName').val();
	if(filterAccountCompleteName != null && filterAccountCompleteName !== '')
		filters.push({ name: 'fq', value: 'accountCompleteName:' + filterAccountCompleteName });

	var filterAccountNumber = $formFilters.find('.valueAccountNumber').val();
	if(filterAccountNumber != null && filterAccountNumber !== '')
		filters.push({ name: 'fq', value: 'accountNumber:' + filterAccountNumber });

	var filterTransactionCodeCompleteName = $formFilters.find('.valueTransactionCodeCompleteName').val();
	if(filterTransactionCodeCompleteName != null && filterTransactionCodeCompleteName !== '')
		filters.push({ name: 'fq', value: 'transactionCodeCompleteName:' + filterTransactionCodeCompleteName });

	var filterTransactionDate = $formFilters.find('.valueTransactionDate').val();
	if(filterTransactionDate != null && filterTransactionDate !== '')
		filters.push({ name: 'fq', value: 'transactionDate:' + filterTransactionDate });

	var filterTransactionCompleteName = $formFilters.find('.valueTransactionCompleteName').val();
	if(filterTransactionCompleteName != null && filterTransactionCompleteName !== '')
		filters.push({ name: 'fq', value: 'transactionCompleteName:' + filterTransactionCompleteName });

	var filterPageUrl = $formFilters.find('.valuePageUrl').val();
	if(filterPageUrl != null && filterPageUrl !== '')
		filters.push({ name: 'fq', value: 'pageUrl:' + filterPageUrl });

	var filterObjectSuggest = $formFilters.find('.valueObjectSuggest').val();
	if(filterObjectSuggest != null && filterObjectSuggest !== '')
		filters.push({ name: 'q', value: 'objectSuggest:' + filterObjectSuggest });
	return filters;
}

function patchBankTransactionVal(filters, v, val, success, error) {
	var vals = {};
	vals[v] = val;
	patchBankTransactionVals(filters, vals, success, error);
}

function patchBankTransactionVals(filters, vals, success, error) {
	$.ajax({
		url: '/api/transaction?' + $.param(filters)
		, dataType: 'json'
		, type: 'PATCH'
		, contentType: 'application/json; charset=utf-8'
		, data: JSON.stringify(vals)
		, success: success
		, error: error
	});
}

// GET //

async function getBankTransaction(pk) {
	$.ajax({
		url: '/api/transaction/' + id
		, dataType: 'json'
		, type: 'GET'
		, contentType: 'application/json; charset=utf-8'
		, success: success
		, error: error
	});
}

// DELETE //

async function deleteBankTransaction(pk) {
	$.ajax({
		url: '/api/transaction/' + id
		, dataType: 'json'
		, type: 'DELETE'
		, contentType: 'application/json; charset=utf-8'
		, data: JSON.stringify(vals)
		, success: success
		, error: error
	});
}

// Search //

async function searchBankTransaction($formFilters, success, error) {
	var filters = searchBankTransactionFilters($formFilters);
	if(success == null)
		success = function( data, textStatus, jQxhr ) {};
	if(error == null)
		error = function( jqXhr, textStatus, errorThrown ) {};

	searchBankTransactionVals(filters, success, error);
}

function searchBankTransactionFilters($formFilters) {
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

	var filterTransactionId = $formFilters.find('.valueTransactionId').val();
	if(filterTransactionId != null && filterTransactionId !== '')
		filters.push({ name: 'fq', value: 'transactionId:' + filterTransactionId });

	var filterArchived = $formFilters.find('.valueArchived').prop('checked');
	if(filterArchived != null && filterArchived === true)
		filters.push({ name: 'fq', value: 'archived:' + filterArchived });

	var filterDeleted = $formFilters.find('.valueDeleted').prop('checked');
	if(filterDeleted != null && filterDeleted === true)
		filters.push({ name: 'fq', value: 'deleted:' + filterDeleted });

	var filterAccountKey = $formFilters.find('.valueAccountKey').val();
	if(filterAccountKey != null && filterAccountKey !== '')
		filters.push({ name: 'fq', value: 'accountKey:' + filterAccountKey });

	var filterTransactionCode = $formFilters.find('.valueTransactionCode').val();
	if(filterTransactionCode != null && filterTransactionCode !== '')
		filters.push({ name: 'fq', value: 'transactionCode:' + filterTransactionCode });

	var filterTransactionFee = $formFilters.find('.valueTransactionFee').prop('checked');
	if(filterTransactionFee != null && filterTransactionFee === true)
		filters.push({ name: 'fq', value: 'transactionFee:' + filterTransactionFee });

	var filterTransactionDisplayName = $formFilters.find('.valueTransactionDisplayName').val();
	if(filterTransactionDisplayName != null && filterTransactionDisplayName !== '')
		filters.push({ name: 'fq', value: 'transactionDisplayName:' + filterTransactionDisplayName });

	var filterTransactionReferenceId = $formFilters.find('.valueTransactionReferenceId').val();
	if(filterTransactionReferenceId != null && filterTransactionReferenceId !== '')
		filters.push({ name: 'fq', value: 'transactionReferenceId:' + filterTransactionReferenceId });

	var filterTransactionAmount = $formFilters.find('.valueTransactionAmount').val();
	if(filterTransactionAmount != null && filterTransactionAmount !== '')
		filters.push({ name: 'fq', value: 'transactionAmount:' + filterTransactionAmount });

	var filterTransactionDateTime = $formFilters.find('.valueTransactionDateTime').val();
	if(filterTransactionDateTime != null && filterTransactionDateTime !== '')
		filters.push({ name: 'fq', value: 'transactionDateTime:' + filterTransactionDateTime });

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

	var filterTransactionKey = $formFilters.find('.valueTransactionKey').val();
	if(filterTransactionKey != null && filterTransactionKey !== '')
		filters.push({ name: 'fq', value: 'transactionKey:' + filterTransactionKey });

	var filterAccountCompleteName = $formFilters.find('.valueAccountCompleteName').val();
	if(filterAccountCompleteName != null && filterAccountCompleteName !== '')
		filters.push({ name: 'fq', value: 'accountCompleteName:' + filterAccountCompleteName });

	var filterAccountNumber = $formFilters.find('.valueAccountNumber').val();
	if(filterAccountNumber != null && filterAccountNumber !== '')
		filters.push({ name: 'fq', value: 'accountNumber:' + filterAccountNumber });

	var filterTransactionCodeCompleteName = $formFilters.find('.valueTransactionCodeCompleteName').val();
	if(filterTransactionCodeCompleteName != null && filterTransactionCodeCompleteName !== '')
		filters.push({ name: 'fq', value: 'transactionCodeCompleteName:' + filterTransactionCodeCompleteName });

	var filterTransactionDate = $formFilters.find('.valueTransactionDate').val();
	if(filterTransactionDate != null && filterTransactionDate !== '')
		filters.push({ name: 'fq', value: 'transactionDate:' + filterTransactionDate });

	var filterTransactionCompleteName = $formFilters.find('.valueTransactionCompleteName').val();
	if(filterTransactionCompleteName != null && filterTransactionCompleteName !== '')
		filters.push({ name: 'fq', value: 'transactionCompleteName:' + filterTransactionCompleteName });

	var filterPageUrl = $formFilters.find('.valuePageUrl').val();
	if(filterPageUrl != null && filterPageUrl !== '')
		filters.push({ name: 'fq', value: 'pageUrl:' + filterPageUrl });

	var filterObjectSuggest = $formFilters.find('.valueObjectSuggest').val();
	if(filterObjectSuggest != null && filterObjectSuggest !== '')
		filters.push({ name: 'q', value: 'objectSuggest:' + filterObjectSuggest });
	return filters;
}

function searchBankTransactionVals(filters, success, error) {
	$.ajax({
		url: '/api/transaction?' + $.param(filters)
		, dataType: 'json'
		, type: 'GET'
		, contentType: 'application/json; charset=utf-8'
		, success: success
		, error: error
	});
}

function suggestBankTransactionObjectSuggest($formFilters, $list) {
	success = function( data, textStatus, jQxhr ) {
		$list.empty();
		$.each(data['list'], function(i, o) {
			var $i = $('<i>').attr('class', 'fad fa-cash-register w3-padding-small ');
			var $span = $('<span>').attr('class', '').text(o['transactionCompleteName']);
			var $li = $('<li>');
			var $a = $('<a>').attr('href', o['']);
			$a.append($i);
			$a.append($span);
			$li.append($a);
			$list.append($li);
		});
	};
	error = function( jqXhr, textStatus, errorThrown ) {};
	searchBankTransactionVals($formFilters, success, error);
}

function suggestBankTransactionAccountKey(filters, $list, pk = null) {
	success = function( data, textStatus, jQxhr ) {
		$list.empty();
		$.each(data['list'], function(i, o) {
			var $i = $('<i>').attr('class', 'fa fa-money-check w3-padding-small ');
			var $span = $('<span>').attr('class', '').text(o['accountCompleteName']);
			var $a = $('<span>');
			$a.append($i);
			$a.append($span);
			var val = o['yearKeys'];
			var checked = Array.isArray(val) ? val.includes(pk) : val == pk;
			var $input = $('<input>');
			$input.attr('id', 'GET_accountKey_' + pk + '_yearKeys_' + o['pk']);
			$input.attr('class', 'w3-check ');
			$input.attr('onchange', "var $input = $('#GET_accountKey_" + pk + "_yearKeys_" + o['pk'] + "'); patchBankTransactionVals([{ name: 'fq', value: 'pk:" + pk + "' }], { [($input.prop('checked') ? 'set' : 'remove') + 'AccountKey']: \"" + o['pk'] + "\" } ); ");
			$input.attr('onclick', 'removeGlow($(this)); ');
			$input.attr('type', 'checkbox');
			if(checked)
				$input.attr('checked', 'checked');
			var $li = $('<li>');
			$li.append($input);
			$li.append($a);
			$list.append($li);
		});
		var focusId = $('#BankTransactionForm :input[name="focusId"]').val();
		if(focusId)
			$('#' + focusId).parent().next().find('input').focus();
	};
	error = function( jqXhr, textStatus, errorThrown ) {};
	searchBankAccountVals(filters, success, error);
}

function suggestBankTransactionObjectSuggest($formFilters, $list) {
	success = function( data, textStatus, jQxhr ) {
		$list.empty();
		$.each(data['list'], function(i, o) {
			var $i = $('<i>').attr('class', 'fad fa-cash-register w3-padding-small ');
			var $span = $('<span>').attr('class', '').text(o['transactionCompleteName']);
			var $li = $('<li>');
			var $a = $('<a>').attr('href', o['']);
			$a.append($i);
			$a.append($span);
			$li.append($a);
			$list.append($li);
		});
	};
	error = function( jqXhr, textStatus, errorThrown ) {};
	searchBankTransactionVals($formFilters, success, error);
}

async function websocketBankTransaction(success) {
	window.eventBus.onopen = function () {

		window.eventBus.registerHandler('websocketBankTransaction', function (error, message) {
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
				var $headerSpan = $('<span>').attr('class', '').text('modify transactions');
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

		window.eventBus.registerHandler('websocketBankAccount', function (error, message) {
			$('#Page_accountKey').trigger('oninput');
		});
	}
}
async function websocketBankTransactionInner(patchRequest) {
	var pk = patchRequest['pk'];
	var pks = patchRequest['pks'];
	var classes = patchRequest['classes'];
	var vars = patchRequest['vars'];
	var empty = patchRequest['empty'];

	if(pk != null) {
		searchBankTransactionVals([ {name: 'fq', value: 'pk:' + pk} ], function( data, textStatus, jQxhr ) {
			var o = data['list'][0];
			if(vars.includes('created')) {
				$('.inputBankTransaction' + pk + 'Created').val(o['created']);
				$('.varBankTransaction' + pk + 'Created').text(o['created']);
			}
			if(vars.includes('modified')) {
				$('.inputBankTransaction' + pk + 'Modified').val(o['modified']);
				$('.varBankTransaction' + pk + 'Modified').text(o['modified']);
			}
			if(vars.includes('archived')) {
				$('.inputBankTransaction' + pk + 'Archived').val(o['archived']);
				$('.varBankTransaction' + pk + 'Archived').text(o['archived']);
			}
			if(vars.includes('deleted')) {
				$('.inputBankTransaction' + pk + 'Deleted').val(o['deleted']);
				$('.varBankTransaction' + pk + 'Deleted').text(o['deleted']);
			}
			if(vars.includes('accountKey')) {
				$('.inputBankTransaction' + pk + 'AccountKey').val(o['accountKey']);
				$('.varBankTransaction' + pk + 'AccountKey').text(o['accountKey']);
			}
			if(vars.includes('transactionCode')) {
				$('.inputBankTransaction' + pk + 'TransactionCode').val(o['transactionCode']);
				$('.varBankTransaction' + pk + 'TransactionCode').text(o['transactionCode']);
			}
			if(vars.includes('transactionFee')) {
				$('.inputBankTransaction' + pk + 'TransactionFee').val(o['transactionFee']);
				$('.varBankTransaction' + pk + 'TransactionFee').text(o['transactionFee']);
			}
			if(vars.includes('transactionDisplayName')) {
				$('.inputBankTransaction' + pk + 'TransactionDisplayName').val(o['transactionDisplayName']);
				$('.varBankTransaction' + pk + 'TransactionDisplayName').text(o['transactionDisplayName']);
			}
			if(vars.includes('transactionReferenceId')) {
				$('.inputBankTransaction' + pk + 'TransactionReferenceId').val(o['transactionReferenceId']);
				$('.varBankTransaction' + pk + 'TransactionReferenceId').text(o['transactionReferenceId']);
			}
			if(vars.includes('transactionAmount')) {
				$('.inputBankTransaction' + pk + 'TransactionAmount').val(o['transactionAmount']);
				$('.varBankTransaction' + pk + 'TransactionAmount').text(o['transactionAmount']);
			}
			if(vars.includes('transactionDateTime')) {
				$('.inputBankTransaction' + pk + 'TransactionDateTime').val(o['transactionDateTime']);
				$('.varBankTransaction' + pk + 'TransactionDateTime').text(o['transactionDateTime']);
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
		await patchBankTransactionVals( [ {name: 'fq', value: 'pk:' + pk} ], {});
	}
}
