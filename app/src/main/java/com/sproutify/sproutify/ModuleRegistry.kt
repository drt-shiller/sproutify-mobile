package com.sproutify.sproutify

import com.sproutify.module.model.Module

class ModuleRegistry private constructor() {
    private var modules: MutableMap<String, Module> = mutableMapOf()

    class Builder {
        private val registry: ModuleRegistry = ModuleRegistry()

        fun add(module: Module): Builder {
            registry.modules[module.moduleId] = module
            return this
        }

        fun build(): ModuleRegistry {
            return registry
        }
    }

    fun get(moduleId: String): Module? {
        return modules[moduleId]
    }
}