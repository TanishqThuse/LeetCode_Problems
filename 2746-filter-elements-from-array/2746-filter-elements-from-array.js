/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var filter = function(arr, fn) {
    let fil=[]
    for(let i=0;i<arr.length;i++){
        if(fn(arr[i],i)){
            fil.push(arr[i]);
        }
    }
    return fil
};

// /**
//  * @param {number[]} arr
//  * @param {Function} fn
//  * @return {number[]}
//  */
// var filter = function(arr, fn) {
//     let n = arr.length
//     let filter = []
//     for(let i = 0; i<n; i++){
//         if(fn(arr,i)){
//             filter.push(arr[i])
//         }
        
//     }
//     return filter
// };