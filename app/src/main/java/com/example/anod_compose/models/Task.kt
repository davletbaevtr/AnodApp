package com.example.anod_compose.model

import android.graphics.pdf.PdfDocument

data class Task(
    val id: Int,
    val name: String? = null,
    val description: String? = null,
    val filters: HashSet<String> = HashSet(),
    val task_content: PdfDocument,
    val task_solution: PdfDocument? = null
)