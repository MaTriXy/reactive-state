package hu.nemi.costate.notes.model

import hu.nemi.costate.arch.Block

interface NotesApi {
    fun loadNotes()
}

interface Notes : NotesApi, Block<ViewState>

data class ViewState(val notes: List<ListItem>)

sealed class ListItem {
    data class NoteItem(val id: String,
                        val text: String,
                        val delete: () -> Unit,
                        val onClicked: () -> Unit) : ListItem()

    data class EditorItem(val id: String?,
                          val text: String,
                          val error: Throwable?,
                          val isSaving: Boolean,
                          val cancel: () -> Unit,
                          val save: () -> Unit,
                          val setText: (String) -> Unit) : ListItem()

    data class AddItem(val add: () -> Unit): ListItem()
}
