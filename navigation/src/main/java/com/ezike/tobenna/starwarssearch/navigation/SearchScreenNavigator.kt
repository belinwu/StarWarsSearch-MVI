package com.ezike.tobenna.starwarssearch.navigation

import androidx.navigation.NavController
import com.ezike.tobenna.starwarssearch.character_detail.model.CharacterDetailModel
import com.ezike.tobenna.starwarssearch.character_search.model.CharacterModel
import com.ezike.tobenna.starwarssearch.character_search.navigation.Navigator
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class SearchScreenNavigator @Inject constructor(
    private val navController: NavController
) : Navigator {

    override fun openCharacterDetail(model: CharacterModel) {
        navController.navigate(
            NavigationRootDirections.openDetail(
                character = model.toDetail()
            )
        )
    }

    private fun CharacterModel.toDetail() =
        CharacterDetailModel(
            name = name,
            birthYear = birthYear,
            heightCm = heightCm,
            url = url
        )
}