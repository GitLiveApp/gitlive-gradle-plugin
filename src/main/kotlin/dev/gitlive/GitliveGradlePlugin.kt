package dev.gitlive

import org.gradle.api.provider.Provider
import org.jetbrains.kotlin.gradle.plugin.KotlinCompilation
import org.jetbrains.kotlin.gradle.plugin.KotlinCompilerPluginSupportPlugin
import org.jetbrains.kotlin.gradle.plugin.SubpluginArtifact
import org.jetbrains.kotlin.gradle.plugin.SubpluginOption

class GitliveGradlePlugin : KotlinCompilerPluginSupportPlugin {

    override fun applyToCompilation(kotlinCompilation: KotlinCompilation<*>): Provider<List<SubpluginOption>> {
        val project = kotlinCompilation.target.project
        return project.provider { emptyList() }
    }

    override fun getCompilerPluginId(): String = "dev.gitlive.gitlive-gradle-plugin"

    override fun getPluginArtifact(): SubpluginArtifact = SubpluginArtifact(
        "dev.gitlive",
        "gitlive-gradle-plugin",
        "1.0.0"
    )

    override fun isApplicable(kotlinCompilation: KotlinCompilation<*>): Boolean = true
}
