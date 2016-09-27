#!/bin/bash

# list of files (no spaces)
list_of_files="actionExamples.gif
badHilight.gif
badWizardInit.gif
cell1.gif
cell2.gif
cell3.gif
cellTableEditor.gif
ddes_styl_beige.gif
ddes_styl_purple-alt.gif
des_bkgd_color.gif
des_colour_pal.png
des_common_icons.gif
des_common_wiz.gif
des_cons_core-icons.gif
des_cons_core-wiz.gif
des_states_disabled-atn.gif
des_states_enab-disab.gif
des_states_folders.gif
des_states_toggles.gif
des_styl_bg1.gif
des_styl_bg2.gif
des_styl_blueyellow.gif
des_styl_brown.gif
des_styl_char1.gif
des_styl_char2.gif
des_styl_char3.gif
des_styl_create2.gif
des_styl_export.gif
des_styl_green.gif
des_styl_obj-align.gif
des_styl_obj-unalign.gif
des_styl_open.gif
des_styl_pin.gif
des_styl_red.gif
des_styl_runscpt.gif
des_styl_state-start.gif
des_styl_state-stop.gif
des_styl_types_obj.gif
des_styl_types_tool.gif
des_styl_wiz_beige.gif
des_styl_wiz_blueyellow.gif
des_styl_wiz_brown.gif
des_styl_wiz_green.gif
des_styl_wiz_lighting.gif
des_styl_wiz_outline1.gif
des_styl_wiz_outline2.gif
des_styl_wiz_purple.gif
des_styl_wiz_red.gif
des_styl_wiz_shadow1.gif
des_styl_wiz_shadow2.gif
des_styl_wiz_shadow3.gif
des_temp_png_pref.gif
dirtyEditor.gif
editorTitles.gif
errorsInOutline.gif
fileDeletedDialog.gif
folderSelection.gif
goodParentCreation.gif
goodTooltips.gif
goodWizardInit.gif
guidelineIndicator.gif
imp_cut_icons.gif
imp_cut_wizards.gif
imp_folderstruct.gif
imp_folderstruct_tabl.gif
name-conv-tabl.jpg
slushBucket.gif
spec_size_dgm10.gif
spec_size_dgm10samp.gif
spec_size_dgm12.gif
spec_size_dgm12samp.gif
spec_size_dgm16.gif
spec_size_dgm16samp.gif
spec_size_dgm24.gif
spec_size_dgm24samp.gif
spec_size_dgm32.gif
spec_size_dgm32samp.gif
spec_size_obj.gif
spec_size_objsamp.gif
spec_size_ovr-aux.gif
spec_size_ovr-auxsamp.gif
spec_size_ovr-cvs.gif
spec_size_ovr-cvssamp.gif
spec_size_ovr-java.gif
spec_size_ovr-javasamp.gif
spec_size_ovr-mult.gif
spec_size_ovr-multsamp.gif
spec_size_ovr-proj.gif
spec_size_ovr-projsamp.gif
spec_size_ovr-under.gif
spec_size_ovr-undersamp.gif
spec_size_ovr-vers.gif
spec_size_ovr-verssamp.gif
spec_size_ovr.gif
spec_size_pal16.gif
spec_size_pal16samp.gif
spec_size_pal24.gif
spec_size_pal24samp.gif
spec_size_pal32.gif
spec_size_pal32samp.gif
spec_size_persp.gif
spec_size_perspsamp.gif
spec_size_point.gif
spec_size_pointsamp.gif
spec_size_prod16.gif
spec_size_prod16samp.gif
spec_size_prog.gif
spec_size_progsamp.gif
spec_size_table.gif
spec_size_tablesamp.gif
spec_size_tool.gif
spec_size_toolsamp.gif
spec_size_view.gif
spec_size_viewsamp.gif
spec_size_wiz.gif
spec_size_wizsamp.gif
spec_type_cursor_mask.gif
spec_type_diagram.gif
spec_type_fastview.gif
spec_type_icon-ol-edit.gif
spec_type_icon.gif
spec_type_lcltool.gif
spec_type_obj-lg.gif
spec_type_ovr-aux-status.gif
spec_type_ovr-java-att.gif
spec_type_ovr-java-att2.gif
spec_type_ovr-multsamp.gif
spec_type_ovr-proj-type.gif
spec_type_ovr-teamsamp1.gif
spec_type_ovr-teamsamp2.gif
spec_type_ovr-undersamp.gif
spec_type_ovr.gif
spec_type_palette.gif
spec_type_persp.gif
spec_type_prod.gif
spec_type_progress.gif
spec_type_table_op1.gif
spec_type_tool.gif
spec_type_toolwiz.gif
spec_type_view.gif
spec_type_wiz.gif
tooltipCaps.gif
wizardAppearance.gif
wizardErrorMsgs.gif
wizardErrorMsgs2.gif
wizardFieldPopulation.gif
wizardMsgs.gif
workbench_decomposed.gif"

# download each file from Eclipse wiki
for filename in $list_of_files
do
	if [ ! -f $filename ]; then
		api_url="https://wiki.eclipse.org/api.php?action=query&list=allimages&aiprop=url&format=json&aiprefix=$filename"
    echo "Resolving $filename..."
    image_url="$(curl -s "https://wiki.eclipse.org/api.php?action=query&list=allimages&aiprop=url&format=json&aiprefix=$filename" | python3 -c "import sys, json; print(json.load(sys.stdin)['query']['allimages'][0]['url'])")"
    echo "Download $image_url --> $filename..."
    wget "$image_url" -O "$filename"
    echo '--------------------------------- Download Done -----------------------------'
  fi
done

# convert gifs to pngs
for file in *.gif; do
	if [ ! -f ${file%.gif}.png ]; then
		echo "Converting $file --> ${file%.gif}.png..."
  	convert $file ${file%.gif}.png
  fi
done
