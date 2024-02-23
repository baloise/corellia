module.exports = (targetVal, opts) => {
    if ((targetVal.parameters.filter(param => param.name == "X-Caller-Name").length == 0)
          || (targetVal.parameters.filter(param => param.name == "X-Event-ID").length == 0)) {
      return [
        {
          message: 'Header must have X-Caller-Name and X-Event-Id set in operation: ' + targetVal.operationId,
        },
      ];
    }
};