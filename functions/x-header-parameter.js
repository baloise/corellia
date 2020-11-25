module.exports = (targetVal, opts) => {
    headers = targetVal.parameters.filter(param => (param.name == "X-Caller-Name" || param.name == "X-Event-ID"));
    if (headers.length != 2) {
      return [
        {
          message: 'Header must have X-Caller-Name and X-Event-Id set in operation: ' + targetVal.operationId,
        },
      ];
    }
};