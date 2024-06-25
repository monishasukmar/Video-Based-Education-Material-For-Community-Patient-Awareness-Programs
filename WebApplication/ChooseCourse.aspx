<%@ Page Title="" Language="vb" AutoEventWireup="false" MasterPageFile="~/Site2.Master" CodeBehind="ChooseCourse.aspx.vb" Inherits="WebApplication1.WebForm9" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="conMain" runat="server">
    <h2>Choose a course</h2>
    <center>
        <asp:Table Width="80%" ID="Table1" runat="server">
            <asp:TableRow runat="server">
                <asp:TableCell CssClass="th1" runat="server">Sno</asp:TableCell>
                <asp:TableCell CssClass="th1"  runat="server">Course Code</asp:TableCell>
                <asp:TableCell CssClass="th1"  runat="server">Course Name</asp:TableCell>
                <asp:TableCell  CssClass="th1" runat="server">Choose</asp:TableCell>
            </asp:TableRow>
        </asp:Table>
    </center>
</asp:Content>
<asp:Content ID="Content4" ContentPlaceHolderID="ContentPlaceHoldelast" runat="server">
</asp:Content>
