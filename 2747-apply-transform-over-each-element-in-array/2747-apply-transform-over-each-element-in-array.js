/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var map = function(arr, fn) {
    const transForm = []
    let n = arr.length
    for(let i=0; i<n; i++){
        transForm[i] = fn(arr[i] , i)
    }
    return transForm
};