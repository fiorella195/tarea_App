package com.example.notasapp_sqlite

import android.content.Context
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class NotasAdaptadorTest {

    @Mock
    lateinit var mockContext: Context

    private lateinit var adaptador: NotasAdaptador
    private lateinit var listaNotas: List<Nota>

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        listaNotas = listOf(
            Nota(1, "Título 1", "Descripción 1"),
            Nota(2, "Título 1", "Descripción 1")
        )
        adaptador = NotasAdaptador(listaNotas, mockContext)
    }

    @Test
    fun getItemCount_devuelveTamanoCorrecto() {
        assertEquals(2, adaptador.itemCount)
    }

    @Test
    fun getItemCount_devuelveCeroParaListaVacia() {
        val adaptadorVacio = NotasAdaptador(emptyList(), mockContext)
        assertEquals(0, adaptadorVacio.itemCount)
    }

    @Test
    fun refrescarDatos_actualizaLaLista() {
        val nuevasNotas = listOf(
            Nota(1, "Título 1", "Descripción 1"),
            Nota(2, "Título 1", "Descripción 1"),
            Nota(3, "Título 1", "Descripción 1")
        )
        
        adaptador.refrescarDatos(nuevasNotas)
        assertEquals(3, adaptador.itemCount)
    }
}
