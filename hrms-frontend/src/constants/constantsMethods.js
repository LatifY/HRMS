export const listToSeparatedText = (array) => {
  var text = ""
  var i;
  for(i = 0; i < array.length; i++){
    text += array[i]
    if(i !== array.length - 1){
      text += ", "
    }
  }
  return text
}