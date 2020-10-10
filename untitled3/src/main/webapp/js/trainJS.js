delete (e)
{
    var tagName = document.getElementsByTagName("input");
    for (let i = 0; i < tagName.length; i++) {
        if (tagName.item(i).checked) {
            tagName.item(i).checked = false;
        }
    }
}

